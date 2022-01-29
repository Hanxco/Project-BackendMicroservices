package com.nachohm.peliculasFrontend.controller;

import com.nachohm.peliculasFrontend.models.Actores;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        Pageable pageable = PageRequest.of(page, 10);
        Page<Peliculas> listPeliculas = peliculaService.buscarTodasPeliculas(pageable);
        PageRender<Peliculas> pageRender = new PageRender<Peliculas>("/peliculas/listado", listPeliculas);
        model.addAttribute("titulo","Listado de todas las peliculas");
        model.addAttribute("listadoPeliculas",listPeliculas);
        model.addAttribute("page",pageRender);
        return"peliculas/listado";
    }

    @GetMapping("/crear")
    public String crearPelicula(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        model.addAttribute("titlePage", "Crear una nueva película");
        model.addAttribute("pelicula", new Peliculas());
        model.addAttribute("methodForm", "POST");
        model.addAttribute("mode", "create");
        return "peliculas/formPelicula";
    }

    @GetMapping("/editar/{id}")
    public String editarPelicula(Model model, @PathVariable("id") Integer id) {
        final Peliculas peli = peliculaService.buscarPeliculaPorId(id);
        final List<Actores> lstActores = actoresService.buscarActoresPorPelicula(id);
        model.addAttribute("titlePage", "Editando película");
        model.addAttribute("pelicula", peli);
        model.addAttribute("lstActores", lstActores);
        model.addAttribute("methodForm", "PUT");
        model.addAttribute("mode", "edit");
        return "peliculas/formPelicula";
    }

    @PostMapping("/guardar")
    public String crearPelicula(Model model, Peliculas peliculaObj, RedirectAttributes attributes) {
        peliculaService.guardarPelicula(peliculaObj);
        attributes.addFlashAttribute("msg", "Los datos del curso fueron guardados!");
        return "redirect:/peliculas/listado";
    }

    @PutMapping("/guardar")
    public String modificarPelicula(Model model, Peliculas pelicula, RedirectAttributes attributes) {
        peliculaService.guardarPelicula(pelicula);
        attributes.addFlashAttribute("msg", "Los datos del curso fueron guardados!");
        return "redirect:/peliculas/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        peliculaService.eliminarPelicula(id);
        attributes.addFlashAttribute("msg", "La pelicula ha sido borrada!");
        return "redirect:/peliculas/listado";
    }


}
