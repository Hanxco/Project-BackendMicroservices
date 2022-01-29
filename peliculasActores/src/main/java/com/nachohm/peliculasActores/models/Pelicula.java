package com.nachohm.peliculasActores.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPeliculas", nullable = false)
    private Integer idPeliculas;

    @Column(name = "titulo", length = 250)
    private String titulo;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "duracion")
    private Integer duracion;

    @Column(name = "pais", length = 45)
    private String pais;

    @Column(name = "direccion", length = 45)
    private String direccion;

    @Column(name = "sinopsis", length = 2500)
    private String sinopsis;

    @Column(name = "genero", length = 250)
    private String genero;

    @Column(name = "image")
    private String image;

    @ManyToMany
    @JoinTable(name = "peliculas_actor",
            joinColumns = @JoinColumn(name = "pelicula_id_peliculas"),
            inverseJoinColumns = @JoinColumn(name = "actoreses_idactores"))
    private List<Actores> actoreses = new ArrayList<>();

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getId() {
        return idPeliculas;
    }

    public void setId(Integer id) {
        this.idPeliculas = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(idPeliculas, pelicula.idPeliculas) && Objects.equals(titulo, pelicula.titulo) && Objects.equals(anio, pelicula.anio) && Objects.equals(duracion, pelicula.duracion) && Objects.equals(pais, pelicula.pais) && Objects.equals(direccion, pelicula.direccion) && Objects.equals(sinopsis, pelicula.sinopsis) && Objects.equals(genero, pelicula.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPeliculas, titulo, anio, duracion, pais, direccion, sinopsis, genero);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "idPeliculas=" + idPeliculas +
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