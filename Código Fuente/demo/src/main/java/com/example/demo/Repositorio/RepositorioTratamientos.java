package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entidad.Tratamientos;

@Repository
public interface RepositorioTratamientos extends JpaRepository<Tratamientos, Long> {

    Tratamientos findByCedula(long cedula);

}
