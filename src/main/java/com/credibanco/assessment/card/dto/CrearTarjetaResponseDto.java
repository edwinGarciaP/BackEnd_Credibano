package com.credibanco.assessment.card.dto;

public class CrearTarjetaResponseDto {

    private String codigo;
    private String mensaje;
    private int numerovalidacion;
    private String pan;


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getNumerovalidacion() {
        return numerovalidacion;
    }

    public void setNumerovalidacion(int numerovalidacion) {
        this.numerovalidacion = numerovalidacion;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }


}
