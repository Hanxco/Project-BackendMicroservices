package com.nachohm.peliculasFrontend.controller;

import com.nachohm.peliculasFrontend.services.IUsuariosService;
import com.nachohm.peliculasFrontend.types.SystemLabels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

public class MiddlewareSession {

    @Autowired
    IUsuariosService usuariosService;

    private Boolean permission;
    private String uri;
    private String message;
    private Boolean redirect;

    // Constructor by default
    MiddlewareSession() {
        super();
    }

    MiddlewareSession(String rol, String uri) {
        this.uri = uri;
        this.redirect = false;
        getSession(rol);
    }

    // Constructor by default
    MiddlewareSession(String rol, String uri, Boolean redirect) {
        this.uri = uri;
        this.redirect = redirect;
        getSession(rol);
    }

    public void getSession(String rol) {
        final boolean permRole = hasRole(rol);
        this.permission = permRole;
        this.message = permRole ? SystemLabels.session_ok : SystemLabels.session_ko;
        this.uri = permRole ? getUriRedirect() : SystemLabels.uri_error_500;
    }

    private String getUriRedirect() {
        return this.redirect ? "redirect:/" + this.uri : this.uri;
    }

    public boolean hasRole(String role) {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasRole = false;
        for (GrantedAuthority authority : authorities) {
            hasRole = authority.getAuthority().equals(role);
            if (hasRole) {
                break;
            }
        }
        return hasRole;
    }

    public Boolean getPermission() {
        return permission;
    }

    public String getUri() {
        return uri;
    }
}
