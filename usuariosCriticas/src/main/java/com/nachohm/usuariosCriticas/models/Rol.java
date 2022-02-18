package com.nachohm.usuariosCriticas.models;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol", nullable = false)
    private Integer id;

    @Column(name = "authority", nullable = false, length = 45)
    private String authority;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }
}