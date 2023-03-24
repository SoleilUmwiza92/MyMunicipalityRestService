package com.myMunicipality.documentApi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import java.util.Objects;

@Entity
public class Document {

    private @Id @GeneratedValue Long id;
    private String name;
    private String creationDate;

    public Document() {}

    Document(String name, String creationDate) {

        this.name = name;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCreationDate() {
        return this.creationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Document))
            return false;
        Document document = (Document) o;
        return Objects.equals(this.id, document.id) && Objects.equals(this.name, document.name)
                && Objects.equals(this.creationDate, document.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.creationDate);
    }

    @Override
    public String toString() {
        return "Document{" + "id=" + this.id + ", name='" + this.name + '\'' + ", document='" + this.creationDate + '\'' + '}';
    }
}
