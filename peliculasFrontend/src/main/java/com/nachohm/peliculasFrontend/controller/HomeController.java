package com.nachohm.peliculasFrontend.controller;

import com.nachohm.peliculasFrontend.models.Peliculas;
import com.nachohm.peliculasFrontend.paginator.PageRender;
import com.nachohm.peliculasFrontend.services.IActoresService;
import com.nachohm.peliculasFrontend.services.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    IPeliculaService peliculaService;

    @GetMapping(value = {"/", "/home", ""})
    public String home(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        Pageable pageable = PageRequest.of(page, 15);
        Page<Peliculas> listPeliculas = peliculaService.buscarTodasPeliculas(pageable);
        PageRender<Peliculas> pageRender = new PageRender<Peliculas>("/peliculas/listado", listPeliculas);
        model.addAttribute("titulo","Listado de todas las peliculas");
        model.addAttribute("listadoPeliculas",listPeliculas);
        model.addAttribute("page",pageRender);
        return"index";
    }

}
