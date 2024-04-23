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

    @Query(value = "SELECT d.NAME, COUNT(*) FROM Tratamientos t INNER JOIN droga d ON t.droga_id = d.codigo WHERE MONTH(t.fecha) = MONTH(CURRENT_DATE()) AND YEAR(t.fecha) = YEAR(CURRENT_DATE()) GROUP BY d.NAME", nativeQuery = true)
    List<Object[]> countTratamientosPorDroga();
    //Dashboard - 2: Cantidad de tratamientos por tipo de medicamento administrado en el ultimo mes (tabla medicamento-cantidad)

    List<Tratamientos> findByPerroId(Long idPerro);
}

   

