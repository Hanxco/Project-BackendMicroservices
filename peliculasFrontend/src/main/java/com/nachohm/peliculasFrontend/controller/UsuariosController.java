package com.nachohm.peliculasFrontend.controller;

import com.nachohm.peliculasFrontend.models.Actores;
import com.nachohm.peliculasFrontend.models.Peliculas;
import com.nachohm.peliculasFrontend.models.Rol;
import com.nachohm.peliculasFrontend.models.Usuario;
import com.nachohm.peliculasFrontend.paginator.PageRender;
import com.nachohm.peliculasFrontend.services.IRolesService;
import com.nachohm.peliculasFrontend.services.IUsuariosService;
import com.nachohm.peliculasFrontend.types.SystemLabels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    IUsuariosService usuariosService;
    @Autowired
    IRolesService rolesService;

    @PostMapping("/registrar")
    public String registro(Model model, Usuario usuario, RedirectAttributes attributes) {
        usuario.setEnable(true);
        Rol rol = rolesService.buscarRolPorId(2);
        //usuario.setRoles(Arrays.asList(rol));
        usuariosService.guardarUsuario(usuario);
        attributes.addFlashAttribute("msg", "Los datos del registro fueron guardados!");
        return SystemLabels.Login;
    }

    @GetMapping("/registrar")
    public String nuevoRegistro(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return SystemLabels.Registro;
    }

    @GetMapping("/listado")
    public String listadoUsuarios(Model model, @RequestParam(name="page", defaultValue="0") int page) {
        final MiddlewareSession session = new MiddlewareSession(SystemLabels.ROLE_ADMIN, SystemLabels.UsuariosListado);
        if (session.getPermission()) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<Usuario> listado = usuariosService.buscarTodos(pageable);
            for (Usuario user : listado) {
                System.out.println("listado");
                System.out.println(user);
            }
            PageRender<Usuario> pageRender = new PageRender<Usuario>("/usuarios/listado", listado);
            model.addAttribute("titulo", "Listado de todos los usuarios");
            model.addAttribute("listadoUsuarios", listado);
            model.addAttribute("page", pageRender);
        }
        return session.getUri();
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(Model model, @PathVariable("id") Integer id) {
        final MiddlewareSession session = new MiddlewareSession(SystemLabels.ROLE_ADMIN, SystemLabels.FormUsuario);
        if (session.getPermission()) {
            final Usuario usuario = usuariosService.buscarUsuarioPorId(id);
            model.addAttribute("titlePage", "Editando usuario");
            model.addAttribute("usuario", usuario);
            model.addAttribute("mode", "edit");
        }
        return session.getUri();
    }

    @PostMapping("/guardar")
    public String actualizarUsuario(Model model, Usuario usuario, RedirectAttributes attributes) {
        final MiddlewareSession session = new MiddlewareSession(SystemLabels.ROLE_ADMIN, SystemLabels.UsuariosListado, true);
        if (session.getPermission()) {
            usuariosService.guardarUsuario(usuario);
            attributes.addFlashAttribute("msg", "Los datos del curso fueron guardados!");
        }
        return session.getUri();
    }
}
