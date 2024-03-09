package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entidad.Veterinario;

@Repository
public interface ReporsitorioVeterinario extends JpaRepository<Veterinario, Long> {

       

}