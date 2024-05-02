package com.example.demo.Servicio;

import java.util.List;

import com.example.demo.Entidad.Tratamientos;

public interface TratamientosService { // servicio de tratamientos

    public Tratamientos SearchById(Long id);

    public List<Tratamientos> SearchAll();

    public Tratamientos Add(Tratamientos p);

    public void deleteById(Long id);

    public void Update(Tratamientos p);

    //!Querys
    public Long getTotalTratamientosUltimoMes();

    public List<Object[]> countTratamientosPorDroga();

    public List<Tratamientos> buscarTratamientosPorIdPerro(Long idPerro);

    public Double obtenerGananciasTotales();

}
