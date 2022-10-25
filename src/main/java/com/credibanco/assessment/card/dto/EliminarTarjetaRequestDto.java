package com.credibanco.assessment.card.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EliminarTarjetaRequestDto {
    @NotNull
    @Size(min = 16, max = 19, message = "Ingresa entre 16 a 19 digitos")
    private String pan;
    @Min(value = 1, message = "numerovalidacion should not be less than 1")
    @Max(value = 100, message = "numerovalidacion  should not be greater than 100")
    private int numerovalidacion;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public int getNumerovalidacion() {
        return numerovalidacion;
    }

    public void setNumerovalidacion(int numerovalidacion) {
        this.numerovalidacion = numerovalidacion;
    }
}
