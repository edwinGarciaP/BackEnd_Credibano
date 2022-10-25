package com.credibanco.assessment.card.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CrearTarjetaRequestDto {
    @NotNull
    @Size(min = 16, max = 19, message = "Ingresa entre 16 a 19 digitos")
    private String pan;
    @NotNull
    private String titular;
    @NotNull
    @Size(min = 10, max = 15, message
            = "Ingresa entre 10 a 15 digitos")
    private String cedula;
    @NotNull
    private String tipo;
    @NotNull
    @Size(min = 10, max = 10, message
            = "Ingresa solo 10 digitos")
    @NotNull
    private String telefono;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Creartarjetarequestdto{" +
                "pan=" + pan +
                ", titular='" + titular + '\'' +
                ",cedula=" + cedula +
                ",tipo='" + tipo + '\'' +
                "telefono=" + telefono +
                '}';
    }

}

