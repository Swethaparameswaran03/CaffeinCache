package com.roms.auth.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roms.auth.model.ResponseDTO;
import com.roms.auth.model.User;
import com.roms.auth.service.UserService;

@RestController
@CacheConfig(cacheNames={"Consumers"})
public class ConsumerController {

@Autowired
    private UserService userService;


    @PostMapping("/users")
    public ResponseEntity<User> savedUser(@RequestBody User user){
      User abc=userService.saveUser(user);

        return new ResponseEntity<>(abc,HttpStatus.CREATED);
    }

@GetMapping("/users/{id}")
@Cacheable(key="#id")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") String id){
        ResponseDTO responseDto = userService.getUser(id);
        return ResponseEntity.ok(responseDto);
    }

@PutMapping("/users/{id}")
@CachePut(key="#id")
public ResponseEntity<User> updateName(@PathVariable String id,@RequestBody User user){
User responseDto = userService.update(id, user);
        return ResponseEntity.ok(responseDto);
// return new ResponseEntity<>(userService.update(id, user),HttpStatus.ACCEPTED);

}
 
@GetMapping("/pagination/{offset}/{pageSize}")
public List<User> pagination(@PathVariable int offset,@PathVariable int pageSize)
{
List<User> a=userService.pagination(offset, pageSize);
    return a;

}

@GetMapping("/pagination/{offset}/{pageSize}/{field}")
public Page<User> paginationwithSort(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
{
Page<User> a=userService.paginationwithSorting(offset, pageSize,field);
    return a;

}
}
