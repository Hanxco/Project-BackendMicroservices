package com.nachohm.peliculasFrontend.config;

import com.nachohm.peliculasFrontend.models.Rol;
import com.nachohm.peliculasFrontend.models.Usuario;
import com.nachohm.peliculasFrontend.services.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private IUsuariosService usuariosService;

    public CustomAuthenticationProvider() {
        super();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String usuario = authentication.getName();
        final String password = authentication.getCredentials().toString();
        final Usuario usuarioLogueado = usuariosService.login(usuario, password);
        System.out.println("usuarioLogueado => " + usuarioLogueado);
        if (usuarioLogueado != null) {
            final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            System.out.println("usuarioLogueado.getRoles() => " + usuarioLogueado.getRoles());
            for (Rol rol : usuarioLogueado.getRoles()) {
                System.out.println("rol => " + rol.getAuthority());
                grantedAuths.add(new SimpleGrantedAuthority(rol.getAuthority()));
            }
            final UserDetails principal = new User(usuario, password, grantedAuths);
            return new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
        }
        return null;
    }

    @Override
    public boolean supports(final Class authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
