package com.myMunicipality.documentApi;

    import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class DocumentController {

        private final DocumentRepository repository;

        DocumentController(DocumentRepository repository) {
            this.repository = repository;
        }


        // Aggregate root
        // tag::get-aggregate-root[]
        @GetMapping("/document")
        List<Document> all() {
            return repository.findAll();
        }
        // end::get-aggregate-root[]

        @PostMapping("/document")
        Document addDocument(@RequestBody Document newdocument) {
            return repository.save(newdocument);
        }

        // Single item

        @GetMapping("/documents/{id}")
        Document one(@PathVariable Long id) {

            return repository.findById(id)
                    .orElseThrow(() -> new DocumentNotFoundException(id));
        }

        @PutMapping("/documents/{id}")
        Document replaceEmployee(@RequestBody Document newDoc, @PathVariable Long id) {

            return repository.findById(id)
                    .map(document -> {
                        document.setName(newDoc.getName());
                        document.setCreationDate(newDoc.getCreationDate());
                        return repository.save(document);
                    })
                    .orElseGet(() -> {
                        newDoc.setId(id);
                        return repository.save(newDoc);
                    });
        }

        @DeleteMapping("/documents/{id}")
        void deleteDocument(@PathVariable Long id) {
            repository.deleteById(id);
        }
}
