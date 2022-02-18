package com.nachohm.peliculasFrontend.models;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

public class Criticas {

    private Integer id;
    private Integer peliculaId;
    private String valoracion;
    private Integer nota;
    private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public Integer getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Integer peliculaId) {
        this.peliculaId = peliculaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Criticas{" +
                "id=" + id +
                ", peliculaId=" + peliculaId +
                ", valoracion='" + valoracion + '\'' +
                ", nota=" + nota +
                ", fecha=" + fecha +
                '}';
    }
}