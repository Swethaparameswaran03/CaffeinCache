package com.roms.auth.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.roms.auth.model.ResponseDTO;
import com.roms.auth.model.User;

public interface UserService {
User saveUser(User user);

    ResponseDTO getUser(String id);

    User update(String id,User user) ;

   List<User> pagination(int offset,int pageSize);

   Page<User> paginationwithSorting(int offset,int pageSize,String field);

}
