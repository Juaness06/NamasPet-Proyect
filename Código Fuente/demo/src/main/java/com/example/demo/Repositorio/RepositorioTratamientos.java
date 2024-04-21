package com.example.demo.Repositorio;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entidad.Tratamientos;

@Repository
public interface RepositorioTratamientos extends JpaRepository<Tratamientos, Long> { //repositorios exteinde a JPA para tratamientos

    @Query("SELECT COUNT(t) FROM Tratamientos t WHERE t.fecha BETWEEN :startDate AND :endDate")
    Long countTratamientosUltimoMes(LocalDate startDate, LocalDate endDate);

    @Query("SELECT d.nombre, COUNT(t) FROM Tratamientos t JOIN t.droga d WHERE t.fecha BETWEEN :startDate AND :endDate GROUP BY d.nombre")
    List<Object[]> countTratamientosPorMedicamento(LocalDate startDate, LocalDate endDate);
    

}
