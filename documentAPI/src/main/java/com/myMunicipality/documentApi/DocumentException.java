package com.myMunicipality.documentApi;


class DocumentNotFoundException extends RuntimeException{


    public DocumentNotFoundException(Long id) {
            super("Could not find employee " + id);
        }
}
