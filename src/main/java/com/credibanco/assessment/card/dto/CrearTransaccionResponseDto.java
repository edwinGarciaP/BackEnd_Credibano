package com.credibanco.assessment.card.dto;

public class CrearTransaccionResponseDto {

    private String codigo;
    private String mensaje;
    private String estadotransaccion;
    private String numeroreferencia;

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

    public String getEstadotransaccion() {
        return estadotransaccion;
    }

    public void setEstadotransaccion(String estadotransaccion) {
        this.estadotransaccion = estadotransaccion;
    }

    public String getNumeroreferencia() {
        return numeroreferencia;
    }

    public void setNumeroreferencia(String numeroreferencia) {
        this.numeroreferencia = numeroreferencia;
    }
}
