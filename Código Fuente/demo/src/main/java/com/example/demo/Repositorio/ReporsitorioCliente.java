package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entidad.Cliente;

@Repository
public interface ReporsitorioCliente extends JpaRepository<Cliente, Long> {

       Cliente findByCedula(long cedula);

}
