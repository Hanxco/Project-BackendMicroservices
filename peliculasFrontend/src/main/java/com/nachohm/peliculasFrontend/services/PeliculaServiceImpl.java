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

    private static String SERVICE_URL = "http://localhost:8001/peliculas";
    //private static String SERVICE_URL = "http://localhost:8082/api-gateway/";

    @Override
    public Page<Peliculas> buscarTodasPeliculas(Pageable pageable) {
        Peliculas[] peliculas = template.getForObject(SERVICE_URL, Peliculas[].class);
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
        for (Peliculas pelicula : page) {
            System.out.println("peli => " + pelicula);
        }
        return page;
    }

    @Override
    public Peliculas buscarPeliculaPorId(Integer id) {
        Peliculas pelicula = template.getForObject(SERVICE_URL + "/" + id, Peliculas.class);
        return pelicula;
    }

    @Override
    public List<Peliculas> buscarPeliculaGenero(String genero) {
        Peliculas[] peliculas = template.getForObject(SERVICE_URL + "/genero/" + genero, Peliculas[].class);
        List<Peliculas> pelisList = Arrays.asList(peliculas);
        return pelisList;
    }

    @Override
    public List<Peliculas> buscarPeliculaAnio(Integer year) {
        Peliculas[] peliculas = template.getForObject(SERVICE_URL + "/anio/" + year, Peliculas[].class);
        List<Peliculas> pelisList = Arrays.asList(peliculas);
        return pelisList;
    }

    @Override
    public void guardarPelicula(Peliculas pelicula) {
        if (pelicula.getId() != null && pelicula.getId() > 0) {
            template.put(SERVICE_URL, pelicula);
        } else {
            pelicula.setId(0);
            template.postForObject(SERVICE_URL, pelicula, String.class);
        }
    }

    @Override
    public void eliminarPelicula(Integer id) { template.delete(SERVICE_URL + "/" + id); }

}
