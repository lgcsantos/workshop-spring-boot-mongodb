package com.lgcsantos.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lgcsantos.workshopmongo.domain.Post;

@Repository
public interface PostRepositoy extends MongoRepository<Post, String> {

	
}
