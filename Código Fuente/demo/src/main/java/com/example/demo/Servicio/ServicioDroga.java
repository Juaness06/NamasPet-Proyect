package com.example.demo.Servicio;

import java.util.Collection;

import com.example.demo.Entidad.Droga;

public interface ServicioDroga { //servicio de droga

    //metodos del servicio
    public Droga SearchById(long id);

    public Collection<Droga> SearchAll();

    public void Add(Droga d);
    
}
