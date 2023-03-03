package com.roms.auth.repository;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.roms.auth.model.User;

@Repository
public interface UserRepository extends CosmosRepository<User,String>{

//	public User findById(String id);

}
