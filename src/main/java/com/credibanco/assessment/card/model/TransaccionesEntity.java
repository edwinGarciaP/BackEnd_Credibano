package com.credibanco.assessment.card.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACCIONES")
public class TransaccionesEntity {

    @Id
    private String numeroreferencia;
    private String pan;
    private Long totalcompra;
    private String direccioncompra;
    private String estadotransacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date HoraFechatransaccion;

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

    public String getDireccioncompra() {
        return direccioncompra;
    }

    public void setDireccioncompra(String direccioncompra) {
        this.direccioncompra = direccioncompra;
    }

    public String getEstadotransacion() {
        return estadotransacion;
    }

    public void setEstadotransacion(String estadotransacion) {
        this.estadotransacion = estadotransacion;
    }

    public Date getHoraFechatransaccion() {
        return HoraFechatransaccion;
    }

    public void setHoraFechatransaccion(Date horaFechatransaccion) {
        HoraFechatransaccion = horaFechatransaccion;
    }
}
