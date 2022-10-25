package com.credibanco.assessment.card.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TARJETAS")

public class TarjetasEntity {


    @Id
    private String pan;
    private int numerovalidacion;

    private String estado;

    private String nombre;
    private String cedula;
    private String tipo;
    private String telefono;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
