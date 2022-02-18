package com.nachohm.peliculasFrontend.models;

import java.util.List;

public class Peliculas {

  private Integer id;
  private String titulo;
  private long anio;
  private long duracion;
  private String pais;
  private String direccion;
  private String sinopsis;
  private String genero;
  private String image;
  private List<Actores> actoreses;

  public Integer getId() {
    return id;
  }

  public void setId(Integer idPeliculas) {
    this.id = idPeliculas;
  }


  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }


  public long getAnio() {
    return anio;
  }

  public void setAnio(long anio) {
    this.anio = anio;
  }


  public long getDuracion() {
    return duracion;
  }

  public void setDuracion(long duracion) {
    this.duracion = duracion;
  }


  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }


  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }


  public String getSinopsis() {
    return sinopsis;
  }

  public void setSinopsis(String sinopsis) {
    this.sinopsis = sinopsis;
  }


  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public List<Actores> getActoreses() {
    return actoreses;
  }

  public void setActoreses(List<Actores> actoreses) {
    this.actoreses = actoreses;
  }

  @Override
  public String toString() {
    return "Peliculas{" +
            "id=" + id +
            ", titulo='" + titulo + '\'' +
            ", anio=" + anio +
            ", duracion=" + duracion +
            ", pais='" + pais + '\'' +
            ", direccion='" + direccion + '\'' +
            ", sinopsis='" + sinopsis + '\'' +
            ", genero='" + genero + '\'' +
            ", image='" + image + '\'' +
            ", actoreses=" + actoreses +
            '}';
  }
}
