package com.upecinosai.saifu.platform.finantialData.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "DATOS_FINANCIEROS")
public class FinantialData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DATO_FINANCIERO")
    private Long idDatoFinanciero;

    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @Column(name = "TIPO_DATO", columnDefinition = "CLOB")
    private String tipoDato;

    @Column(name = "MONTO", precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "DESCRIPCION", columnDefinition = "CLOB")
    private String descripcion;

    // Getters y Setters
}
