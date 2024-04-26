package com.example.RestAPI.repository;

import com.example.RestAPI.model.NoticiaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends MongoRepository<NoticiaEntity, String> {

}
