package com.upecinosai.saifu.platform.finantialEducation.interfaces.rest.resources;

public class FinantialEducationResource {

    private Long id;
    private String titulo;
    private Long idRespuesta;
    private Long idPreguntas;

    // Getters y setters

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
