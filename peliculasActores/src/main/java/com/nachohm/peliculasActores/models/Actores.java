package com.nachohm.peliculasActores.models;

import javax.persistence.*;

@Entity
@Table(name = "actores")
public class Actores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idactores", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "nacionalidad", length = 45)
    private String nacionalidad;

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Actores{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}