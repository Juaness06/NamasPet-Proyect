package com.example.demo.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "administrador") // nombre de la tabla
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrador {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    @Column(name = "NAME")
    private String nombre;
    private String contrasena;

    // Constructor sin la propiedad "id"
    public Administrador(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
}
