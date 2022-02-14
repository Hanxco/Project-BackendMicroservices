package com.nachohm.peliculasFrontend.services;

import com.nachohm.peliculasFrontend.models.Rol;

import java.util.List;

public interface IRolesService {

    List<Rol> buscarTodos();

    Rol buscarRolPorId(Integer idRol);

    void guardarRol(Rol rol);

    void eliminarRol(Integer idRol);

}
