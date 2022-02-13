package com.nachohm.usuariosCriticas.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "criticas")
public class Critica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcriticas", nullable = false)
    private Integer id;

    @Column(name = "peliculaId", nullable = false)
    private Integer peliculaId;

    @Column(name = "valoracion", length = 1500)
    private String valoracion;

    @Column(name = "nota", nullable = false)
    private Integer nota;

    @Column(name = "fecha")
    private LocalDate fecha;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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
        return "Critica{" +
                "id=" + id +
                ", peliculaId=" + peliculaId +
                ", valoracion='" + valoracion + '\'' +
                ", nota=" + nota +
                ", fecha=" + fecha +
                '}';
    }
}