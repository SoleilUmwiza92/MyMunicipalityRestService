package com.myMunicipality.documentApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(DocumentRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Document("Gemeente Belasting", "20-12-2022")));
            log.info("Preloading " + repository.save(new Document("Frodo Baggins", "30-01-2023")));
        };
    }
}
