package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entidad.Administrador;

@Repository
public interface ReporsitorioAdministrador extends JpaRepository<Administrador, Integer> {

       Administrador findById(int id); // busca por id

}