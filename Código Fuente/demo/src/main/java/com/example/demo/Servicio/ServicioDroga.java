package com.example.demo.Servicio;

import java.util.List;

import com.example.demo.Entidad.Droga;

public interface ServicioDroga { //servicio de droga

    //metodos del servicio
    public Droga SearchById(long id);

    public List<Droga> SearchAll();

    public void Add(Droga d);
    
}

