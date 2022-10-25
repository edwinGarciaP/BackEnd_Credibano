package com.credibanco.assessment.card.dto;

public class ConsultarTarjetaResponseDto {

    private String pan;
    private String titular;
    private String cedula;
    private String telefono;
    private String estado;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan.substring(0, 6) + "*********" + pan.substring(pan.length() - 4);
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
