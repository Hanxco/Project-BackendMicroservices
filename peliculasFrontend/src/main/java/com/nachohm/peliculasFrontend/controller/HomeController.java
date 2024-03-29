package com.nachohm.peliculasFrontend.controller;

import com.nachohm.peliculasFrontend.helpers.MethodAuxiliars;
import com.nachohm.peliculasFrontend.models.Criticas;
import com.nachohm.peliculasFrontend.models.Peliculas;
import com.nachohm.peliculasFrontend.models.Usuario;
import com.nachohm.peliculasFrontend.paginator.PageRender;
import com.nachohm.peliculasFrontend.services.IActoresService;
import com.nachohm.peliculasFrontend.services.IPeliculaService;
import com.nachohm.peliculasFrontend.services.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    IPeliculaService peliculaService;
    @Autowired
    IUsuariosService usuariosService;

    @GetMapping(value = {"/", "/home", ""})
    public String home(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final Usuario userLogged = usuariosService.buscarUsuarioPorCorreo(auth.getName());
        final Pageable pageable = PageRequest.of(page, 15);
        final Page<Peliculas> listPeliculas = peliculaService.buscarTodasPeliculas(pageable);
        final List<Peliculas> lstPelisAccion = peliculaService.buscarPeliculaGenero("Acción y Aventuras");
        final List<Peliculas> lstPelis2009 = peliculaService.buscarPeliculaAnio(2009);
        PageRender<Peliculas> pageRender = new PageRender<Peliculas>("/peliculas/listado", listPeliculas);
        model.addAttribute("titulo","Listado de todas las peliculas");
        model.addAttribute("listadoPeliculas",listPeliculas);
        model.addAttribute("lstPelisAccion",lstPelisAccion);
        model.addAttribute("lstPelis2009",lstPelis2009);
        model.addAttribute("userId", userLogged.getId());
        model.addAttribute("setCriticas", MethodAuxiliars.setArrCriticas(userLogged));
        model.addAttribute("page",pageRender);
        return "index";
    }



}
