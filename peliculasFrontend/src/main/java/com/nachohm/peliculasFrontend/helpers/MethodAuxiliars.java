package com.nachohm.peliculasFrontend.helpers;

import com.nachohm.peliculasFrontend.models.Criticas;
import com.nachohm.peliculasFrontend.models.Peliculas;
import com.nachohm.peliculasFrontend.models.Usuario;
import com.nachohm.peliculasFrontend.services.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class MethodAuxiliars {

    @Autowired
    static
    IUsuariosService usuariosService;

    public static String setArrCriticas(Usuario user) {
        List<String> retComma = new ArrayList<>();
        for (Criticas critica : user.getCriticas()) {
            retComma.add(String.valueOf(critica.getPeliculaId()));
        }
        String ret = String.join(",", retComma);
        System.out.println(ret);
        return ret;
    }

    public static String getRolUserLogged() {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final Usuario userLogged = usuariosService.buscarUsuarioPorCorreo(auth.getName());
        return userLogged.getRoles().get(0).getAuthority();
    }

}
