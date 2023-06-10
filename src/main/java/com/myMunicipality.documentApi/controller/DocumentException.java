package com.myMunicipality.documentController;


class DocumentNotFoundException extends RuntimeException{


    public DocumentNotFoundException(Long id) {
            super("Could not find employee " + id);
        }
}
