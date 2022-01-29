package com.nachohm.peliculasFrontend.models;

import java.sql.Date;

public class Actores {

  private Integer id;
  private String nombre;
  private String nacionalidad;
  private Date fechaNacimiento;

  public Integer getId() {
    return id;
  }

  public void setId(Integer idactores) {
    this.id = idactores;
  }


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public String getNacionalidad() {
    return nacionalidad;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }

  @Override
  public String toString() {
    return "Actores{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", nacionalidad='" + nacionalidad + '\'' +
            ", fechaNacimiento=" + fechaNacimiento +
            '}';
  }
}
