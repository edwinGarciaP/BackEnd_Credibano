package com.credibanco.assessment.card.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AnularTransaccionRequestDto {
    @NotNull
    @Size(min = 16, max = 19, message = "Ingresa entre 16 a 19 digitos")
    private String pan;
    @NotNull
    @Size(min = 6, max = 6, message = "Ingresa solo 6 digitos")
    private String numeroreferencia;
    @NotNull
    private Long totalcompra;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getNumeroreferencia() {
        return numeroreferencia;
    }

    public void setNumeroreferencia(String numeroreferencia) {
        this.numeroreferencia = numeroreferencia;
    }

    public Long getTotalcompra() {
        return totalcompra;
    }

    public void setTotalcompra(Long totalcompra) {
        this.totalcompra = totalcompra;
    }
}
