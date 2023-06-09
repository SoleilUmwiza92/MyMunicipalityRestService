package com.myMunicipality.documentApi.controller;

import java.util.List;

import com.myMunicipality.documentApi.repository.DocumentRepository;
import com.myMunicipality.documentApi.model.Document;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

    @RestController
    public class DocumentController {

        private final DocumentRepository repository;


        Logger logger = LogManager.getLogger();

        DocumentController(DocumentRepository repository) {
            this.repository = repository;
        }


        // Aggregate root
        // tag::get-aggregate-root[]
        @GetMapping("/documents")
        @CrossOrigin(origins = "*")
        List<Document> all() {
            logger.info("Getting all document from repo");
            return repository.findAll();
        }


        @PostMapping("/document")
        Document addDocument(@RequestBody Document newdocument) {
            return repository.insert(newdocument);
        }

        // Single item

        @GetMapping("/documents/{id}")
        Document one(@PathVariable String id) {

            return repository.findById(id)
                    .orElseThrow(() -> new DocumentNotFoundException(id));
        }
}
