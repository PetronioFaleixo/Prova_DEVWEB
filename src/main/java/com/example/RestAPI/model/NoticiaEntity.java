package com.example.RestAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "noticia")
public class NoticiaEntity {

    @Id
    private String id;
    private String texto;

    public NoticiaEntity(String id, String texto) {
        this.id = id;
        this.texto = texto;
    }
    public NoticiaEntity() {

    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }


}
