package com.roms.auth.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.azure.spring.data.cosmos.core.query.CosmosPageRequest;
import com.roms.auth.model.EmployeeDTO;
import com.roms.auth.model.ResponseDTO;
import com.roms.auth.model.User;
import com.roms.auth.model.UserDTO;
import com.roms.auth.repository.UserRepository;

@Service
@Component
public class UserServiceImpl implements UserService {

@Autowired
private UserRepository userRepository;

@Autowired
    private RestTemplate restTemplate;
   
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
       
    }

@Override
public ResponseDTO getUser(String id) {
ResponseDTO responseDto = new ResponseDTO();
        User user = userRepository.findById(id).get();
        UserDTO userDto = mapToUser(user);

        ResponseEntity<EmployeeDTO> responseEntity = restTemplate
                .getForEntity("http://localhost:8080/employee/" + user.getId(),
                EmployeeDTO.class);

        EmployeeDTO emp = responseEntity.getBody();

        System.out.println(responseEntity.getStatusCode());

        responseDto.setUser(userDto);
        responseDto.setEmp(emp);

        return responseDto;
    }

private UserDTO mapToUser(User user) {
UserDTO userDto = new UserDTO();
userDto.setId(user.getId());
       userDto.setFirstname(user.getFirstname());
       userDto.setEmail(user.getEmail());
       userDto.setAge(user.getAge());
       return userDto;
}


public User update(String id,User user) {

Optional<User> newUpdate=userRepository.findById(id);
User user1=new User();
       user1.setEmail(user.getEmail());
  user1.setAge(user.getAge());
  user1.setFirstname(user.getFirstname());
  user1.setId(user.getId());
return userRepository.save(user1);
// ResponseDTO responseDto = new ResponseDTO();
//        User user1 = userRepository.findById(id).get();
//        UserDTO userDto = mapToUser(user);
//
//        ResponseEntity<EmployeeDTO> responseEntity = restTemplate
//                .getForEntity("http://localhost:8080/employee/" + user.getId(),
//                 EmployeeDTO.class);
//
//        EmployeeDTO emp = responseEntity.getBody();
//
//        System.out.println(responseEntity.getStatusCode());
//
//        responseDto.setUser(userDto);
//        responseDto.setEmp(emp);
//
//        return responseDto;

}
public List<User> pagination(int offset,int pageSize)
{
// Page<User> user= userRepository.findAll(PageRequest.of(offset, pageSize));
// return user;
// }
final Pageable pageable = new CosmosPageRequest(0,pageSize,null);
        List<User> content = null;

        Page<User> page = userRepository.findAll(pageable);
        if (offset == 0) {
            content = page.getContent();
            for (User user : content) System.out.println(user.toString());
            return content;
        } else {
            Page<User> nextPage = null;
            for (int i = 1; i <= offset; i++) {
                nextPage = userRepository.findAll(page.getPageable());
                /* reset page to nextpage like a linkedlist*/
                page = nextPage;
                content = nextPage.getContent();
                for (User user : content) System.out.println(user.toString());
            }
            return content;
        }
    }
public Page<User> paginationwithSorting(int offset,int pageSize,String field)
{
Page<User> user= userRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,field)));
return user;
}
}
