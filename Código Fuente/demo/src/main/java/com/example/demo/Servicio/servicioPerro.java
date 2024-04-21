package com.example.demo.Servicio;

import java.util.List;

import com.example.demo.Entidad.Perro;

public interface ServicioPerro { //servicio de perro

    //metodos del servicio
    public Perro SearchById(long id);

    public List<Perro> SearchAll();

    public void Add(Perro p);

    public void DeleteByID(long id);

    public void Update(Perro p);

    public List<Perro> findByClienteCedula(long id);

    public Long contarMascotasActivas();
    
    public double calcularVentasDePerrosConTratamientos();

}
