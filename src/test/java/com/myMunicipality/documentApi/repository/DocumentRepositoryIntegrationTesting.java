package com.myMunicipality.documentApi.repository;

import com.myMunicipality.documentApi.model.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DocumentRepositoryIntegrationTest {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    DocumentRepository repository;

    @Test
    void bootstrapTestDataWithMongoTemplate() {
        var doc = new Document("test-id", "Test doc name","abc@example.com","01-01-1800","Test type");
        mongoTemplate.insert(doc);
    }
    @Test
    void findBAllTest() {
        var doc = new Document("id1", "Test doc name","abc@example.com","01-01-1800","Test type");
        var doc1 = new Document("id2", "Test doc name","abc@example.com","01-01-1800","Test type");
        mongoTemplate.insert(doc);
        mongoTemplate.insert(doc1);
        var docs= repository.findAll();
        assertNotNull(docs);
        assertEquals(docs.stream().findFirst().get(), "id1");
    }
    @Test
    void findByIdTest(){
        var doc = new Document("id1", "Test doc name","abc@example.com","01-01-1800","Test type");
        var doc1 = new Document("id2", "Test doc name","abc@example.com","01-01-1800","Test type");
        mongoTemplate.insert(doc);
        mongoTemplate.insert(doc1);
        assertEquals(doc.getName(), repository.findById("id1").get().getName());
    }

    @AfterEach
    void cleanUpDatabase() {
       repository.findAll().forEach(doc -> mongoTemplate.remove(doc));

    }
}
