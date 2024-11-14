package com.upecinosai.saifu.platform.finantialEducation.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FinantialEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private Long idRespuesta;
    private Long idPreguntas;

    // Constructor, getters y setters
    public FinantialEducation() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Long idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Long getIdPreguntas() {
        return idPreguntas;
    }

    public void setIdPreguntas(Long idPreguntas) {
        this.idPreguntas = idPreguntas;
    }
}
