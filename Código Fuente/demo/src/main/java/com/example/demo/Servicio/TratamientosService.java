package com.example.demo.Servicio;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.Entidad.Droga;
import com.example.demo.Entidad.Tratamientos;

public interface TratamientosService { // servicio de tratamientos

    public Tratamientos SearchById(Long id);

    public List<Tratamientos> SearchAll();

    public void Add(Tratamientos p);

    public void deleteById(Long id);

    public void Update(Tratamientos p);

    public Long getTotalTratamientosUltimoMes();

    public List<Object[]> countTratamientosPorDroga();

    public List<Tratamientos> buscarTratamientosPorIdPerro(Long idPerro);

    public Double obtenerGananciasTotales();


    // public Tratamientos Cuenta(Long cedula);

    // public Collection<Perro> PerrosClientePerros(long cedula);

}
