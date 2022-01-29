package com.nachohm.peliculasFrontend.services;

import com.nachohm.peliculasFrontend.models.Peliculas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPeliculaService {
    Page<Peliculas> buscarTodasPeliculas(Pageable pageable);

    Peliculas buscarPeliculaPorId(Integer id);

    List<Peliculas> buscarPeliculaGenero(String genero);

    void guardarPelicula(Peliculas pelicula);

    void eliminarPelicula(Integer id);
}
