package com.nachohm.peliculasActores.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pelicula_actor")
public class PeliculaActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pelicula_actor_actoreses",
            joinColumns = @JoinColumn(name = "pelicula_actor_null"),
            inverseJoinColumns = @JoinColumn(name = "actoreses_idactores"))
    private List<Actores> actoreses = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pelicula_actor_peliculas",
            joinColumns = @JoinColumn(name = "pelicula_actor_null"),
            inverseJoinColumns = @JoinColumn(name = "peliculas_id_peliculas"))
    private Set<Pelicula> peliculas = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Set<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public List<Actores> getActoreses() {
        return actoreses;
    }

    public void setActoreses(List<Actores> actoreses) {
        this.actoreses = actoreses;
    }

}