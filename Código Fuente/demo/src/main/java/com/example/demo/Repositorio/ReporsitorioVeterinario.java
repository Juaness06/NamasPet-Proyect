package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entidad.Veterinario;

@Repository
public interface ReporsitorioVeterinario extends JpaRepository<Veterinario, Long> { //repositorios exteinde a JPA para veterinario


    @Query("SELECT COUNT(v) FROM Veterinario v WHERE v.activo = true")
    Long countVeterinariosActivos();

    @Query("SELECT COUNT(v) FROM Veterinario v WHERE v.activo = false")
    Long countVeterinariosInactivos();


}