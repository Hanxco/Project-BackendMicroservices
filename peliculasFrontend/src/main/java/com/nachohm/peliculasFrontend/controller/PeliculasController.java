package com.nachohm.peliculasFrontend.controller;

import com.nachohm.peliculasFrontend.models.Actores;
import com.nachohm.peliculasFrontend.models.Peliculas;
import com.nachohm.peliculasFrontend.paginator.PageRender;
import com.nachohm.peliculasFrontend.services.IActoresService;
import com.nachohm.peliculasFrontend.services.IPeliculaService;
import com.nachohm.peliculasFrontend.types.SystemLabels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

    @Autowired
    IPeliculaService peliculaService;
    @Autowired
    IActoresService actoresService;

    @GetMapping("/listado")
    public String listadoPeliculas(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<Peliculas> listPeliculas = peliculaService.buscarTodasPeliculas(pageable);
        PageRender<Peliculas> pageRender = new PageRender<Peliculas>("/peliculas/listado", listPeliculas);
        model.addAttribute("titulo","Listado de todas las peliculas");
        model.addAttribute("listadoPeliculas",listPeliculas);
        model.addAttribute("page",pageRender);
        return SystemLabels.PeliculasListado;
    }

    @GetMapping("/crear")
    public String crearPelicula(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        final MiddlewareSession session = new MiddlewareSession(SystemLabels.ROLE_ADMIN, SystemLabels.FormPeliculas);
        if (session.getPermission()) {
            model.addAttribute("titlePage", "Crear una nueva película");
            model.addAttribute("pelicula", new Peliculas());
            model.addAttribute("methodForm", "POST");
            model.addAttribute("mode", "create");
        }
        return session.getUri();
    }

    @GetMapping("/editar/{id}")
    public String editarPelicula(Model model, @PathVariable("id") Integer id) {
        MiddlewareSession session = new MiddlewareSession();
        final String title = session.hasRole(SystemLabels.ROLE_ADMIN) ? "Editando película" : "Ficha de la película";
        final Peliculas peli = peliculaService.buscarPeliculaPorId(id);
        final List<Actores> todosActores = actoresService.buscarListaActores();
        final List<Actores> lstActores = actoresService.buscarActoresPorPelicula(id);
        List<Integer> idsActorSel = new ArrayList<>();
        List<Actores> lstActorSearch = new ArrayList<Actores>();
        for (Actores actor : lstActores) {
            idsActorSel.add(actor.getId());
        }
        for (Actores actor : todosActores) {
            if (!idsActorSel.contains(actor.getId())) {
                lstActorSearch.add(actor);
            }
        }
        model.addAttribute("titlePage", title);
        model.addAttribute("pelicula", peli);
        model.addAttribute("lstActores", lstActores);
        model.addAttribute("todosActores", lstActorSearch);
        model.addAttribute("methodForm", "PUT");
        model.addAttribute("mode", "edit");
        return SystemLabels.FormPeliculas;
    }

    @PostMapping("/guardar")
    public String crearPelicula(Model model, Peliculas peliculaObj, RedirectAttributes attributes) {
        final MiddlewareSession session = new MiddlewareSession(SystemLabels.ROLE_ADMIN, SystemLabels.PeliculasListado, true);
        if (session.getPermission()) {
            peliculaService.guardarPelicula(peliculaObj);
            attributes.addFlashAttribute("msg", "Los datos del curso fueron guardados!");
        }
        return session.getUri();
    }

    @PutMapping("/guardar")
    public String modificarPelicula(Model model, Peliculas pelicula, RedirectAttributes attributes) {
        final MiddlewareSession session = new MiddlewareSession(SystemLabels.ROLE_ADMIN, SystemLabels.PeliculasListado, true);
        if (session.getPermission()) {
            peliculaService.guardarPelicula(pelicula);
            attributes.addFlashAttribute("msg", "Los datos del curso fueron guardados!");
        }
        return session.getUri();
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        final MiddlewareSession session = new MiddlewareSession(SystemLabels.ROLE_ADMIN, SystemLabels.PeliculasListado, true);
        if (session.getPermission()) {
            peliculaService.eliminarPelicula(id);
            attributes.addFlashAttribute("msg", "La pelicula ha sido borrada!");
        }
        return session.getUri();
    }


}
