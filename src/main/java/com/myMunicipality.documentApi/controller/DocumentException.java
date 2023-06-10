package com.myMunicipality.documentApi.controller;


class DocumentNotFoundException extends RuntimeException{


    public DocumentNotFoundException(String id) {
            super("Could not find document " + id);
        }
}
