package com.example.demo.Repositorio;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.Entidad.Perro;

@Repository
public interface RepositorioPerro extends JpaRepository<Perro, Long > {
    List<Perro> findByClienteCedula(long cedula);
   
}
