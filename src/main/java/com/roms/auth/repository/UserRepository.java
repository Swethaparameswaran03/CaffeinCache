package com.roms.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.roms.auth.model.User;

@Repository
public interface UserRepository extends MongoRepository<User,String>{

//	public User findById(String id);

}
