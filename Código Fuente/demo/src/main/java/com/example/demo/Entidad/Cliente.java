package com.example.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente") // nombre de la tabla
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id autoincremental
    private long cedula;

    @Column(name = "nombre")
    private String nombre;

    private String correo;
    private long celular;
    private String usuario;
    private String contrasena;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true) // relación uno a muchos
    private List<Perro> listaPerros = new ArrayList<>();

    // Constructor sin la propiedad "cedula"
    public Cliente(String nombre, String correo, long celular, String usuario, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
}
