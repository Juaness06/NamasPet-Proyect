package com.example.demo.Servicio;

import java.util.Collection;


import com.example.demo.Entidad.Tratamientos;


public interface TratamientosService { //servicio de tratamientos
    
    public Tratamientos SearchById(Long id);

    public Collection<Tratamientos> SearchAll();

    public void Add(Tratamientos p);

    public void deleteById(Long id);

    public void Update(Tratamientos p);

   // public Tratamientos Cuenta(Long cedula);
    
    //public Collection<Perro> PerrosClientePerros(long cedula);
    
}
