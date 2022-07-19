package com.lgcsantos.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lgcsantos.workshopmongo.domain.User;

@Repository
public interface UserRepositoy extends MongoRepository<User, String> {

	
}
