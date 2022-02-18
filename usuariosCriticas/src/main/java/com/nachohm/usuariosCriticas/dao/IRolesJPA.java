package com.nachohm.usuariosCriticas.dao;

import com.nachohm.usuariosCriticas.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolesJPA extends JpaRepository<Rol, Integer> {
}
