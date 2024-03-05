package com.example.demo.Repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;

import java.util.Collection;



@Repository
public interface ReporsitorioCliente extends JpaRepository<Cliente, Long> {

       Cliente findByCedula(long cedula);

       
} 
