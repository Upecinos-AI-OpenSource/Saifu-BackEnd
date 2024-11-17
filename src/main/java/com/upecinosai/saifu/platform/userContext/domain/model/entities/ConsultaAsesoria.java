package com.upecinosai.saifu.platform.userContext.domain.model.entities;

import com.upecinosai.saifu.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class ConsultaAsesoria extends AuditableModel {
    @Column(name = "TIPO_CONSULTA", nullable = false)
    private String tipoConsulta;

    @Column(name = "FECHA_CONSULTA", nullable = false)
    private LocalDate fechaConsulta;

    @Column(name = "RESULTADO")
    private String resultado;

    // Getters y Setters
    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
