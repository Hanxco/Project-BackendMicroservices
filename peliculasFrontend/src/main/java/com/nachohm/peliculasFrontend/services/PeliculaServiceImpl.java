package com.nachohm.peliculasFrontend.services;

import com.nachohm.peliculasFrontend.models.Peliculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

    @Autowired
    RestTemplate template;

    String url = "http://localhost:8001/peliculas";

    @Override
    public Page<Peliculas> buscarTodasPeliculas(Pageable pageable) {
        Peliculas[] peliculas = template.getForObject(url, Peliculas[].class);
        List<Peliculas> pelisList = Arrays.asList(peliculas);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Peliculas> list;

        if (pelisList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, pelisList.size());
            list = pelisList.subList(startItem, toIndex);
        }

        Page<Peliculas> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), pelisList.size());
        return page;
    }

    @Override
    public Peliculas buscarPeliculaPorId(Integer id) {
        Peliculas pelicula = template.getForObject(url + "/" + id, Peliculas.class);
        return pelicula;
    }

    @Override
    public List<Peliculas> buscarPeliculaGenero(String genero) {
        Peliculas[] peliculas = template.getForObject(url + "/genero/" + genero, Peliculas[].class);
        List<Peliculas> pelisList = Arrays.asList(peliculas);
        return pelisList;
    }

    @Override
    public void guardarPelicula(Peliculas pelicula) {
        if (pelicula.getId() != null && pelicula.getId() > 0) {
            template.put(url, pelicula);
        } else {
            pelicula.setId(0);
            template.postForObject(url, pelicula, String.class);
        }
    }

    @Override
    public void eliminarPelicula(Integer id) { template.delete(url + "/" + id); }

}
