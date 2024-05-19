package com.example.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "veterinario")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Veterinario {


    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String nombre;

    private String contrasena;
    private String especialidad;
    private int atenciones;
    private String foto;

    private boolean activo;

    @JsonIgnore
    @OneToMany(mappedBy = "veterinario")
    private List<Tratamientos> tratamientos = new ArrayList<>();

}
