package com.myMunicipality.documentApi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@ToString
@Getter
@Setter
@org.springframework.data.mongodb.core.mapping.Document("document")
public class Document {

    private @Id String id;
    private String name;
    private String creationDate;
    private String email;
    private String type;
}
