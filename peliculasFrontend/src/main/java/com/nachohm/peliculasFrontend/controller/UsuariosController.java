package com.nachohm.peliculasFrontend.controller;

import com.nachohm.peliculasFrontend.models.Rol;
import com.nachohm.peliculasFrontend.models.Usuario;
import com.nachohm.peliculasFrontend.paginator.PageRender;
import com.nachohm.peliculasFrontend.services.IRolesService;
import com.nachohm.peliculasFrontend.services.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    IUsuariosService usuariosService;
    @Autowired
    IRolesService rolesService;

    @GetMapping("/listado")
    public String listadoUsuarios(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        System.out.println("listadoUsuarios");
        Pageable pageable = PageRequest.of(page, 5);
        Page<Usuario> listado = usuariosService.buscarTodos(pageable);
        PageRender<Usuario> pageRender = new PageRender<Usuario>("/usuarios/listado", listado);
        model.addAttribute("titulo", "Listado de todos los usuarios");
        model.addAttribute("listadoUsuarios", listado);
        model.addAttribute("page", pageRender);
        return "usuarios/listado";
    }

    @PostMapping("/registrar")
    public String registro(Model model, Usuario usuario, RedirectAttributes attributes) {
        usuario.setEnable(true);
        Rol rol = rolesService.buscarRolPorId(2);
        //usuario.setRoles(Arrays.asList(rol));
        usuariosService.guardarUsuario(usuario);
        attributes.addFlashAttribute("msg", "Los datos del registro fueron guardados!");
        return "redirect:/login";
    }

    @GetMapping("/registrar")
    public String nuevoRegistro(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "registro";
    }
}
