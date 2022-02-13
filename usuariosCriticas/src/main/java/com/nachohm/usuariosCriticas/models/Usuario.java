package com.nachohm.usuariosCriticas.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", schema = "usuariosdb")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "correo", nullable = false, length = 45)
    private String correo;

    @Column(name = "enable", nullable = false)
    private Boolean enable = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_has_authorities", joinColumns = {
            @JoinColumn(name = "Users_idUsuario", referencedColumnName = "idUsuario")}, inverseJoinColumns = {
            @JoinColumn(name = "Authorities_idRol", referencedColumnName = "idRol")})
    private List<Rol> roles;

    @OneToMany
    private List<Critica> criticas;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Critica> getCriticas() {
        return criticas;
    }

    public void setCriticas(List<Critica> criticas) {
        this.criticas = criticas;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", correo='" + correo + '\'' +
                ", enable=" + enable +
                ", roles=" + roles +
                '}';
    }
}