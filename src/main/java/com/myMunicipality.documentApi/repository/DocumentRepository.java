package com.myMunicipality.documentApi.repository;

import com.myMunicipality.documentApi.model.Document;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DocumentRepository extends MongoRepository<Document, String> {

}
