package com.example.demo.Repositorio;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.Entidad.Perro;

@Repository
public interface RepositorioPerro extends JpaRepository<Perro, Long > { //repositorios exteinde a JPA para perro
    
    List<Perro> findByClienteCedula(long cedula); 

    @Query("SELECT COUNT(p) FROM Perro p WHERE p.actividad = true")
    Long countMascotasActivas();

    @Query("SELECT SUM(t.precioC) FROM Perro p JOIN p.tratamientos t")
    Double sumarVentasDePerrosConTratamientos();
   
}
