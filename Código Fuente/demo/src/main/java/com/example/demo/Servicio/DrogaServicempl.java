package com.example.demo.Servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Droga;
import com.example.demo.Repositorio.ReporsitorioDroga;

@Service
public class DrogaServicempl implements ServicioDroga {
    
    @Autowired
    ReporsitorioDroga repo;

    @Override
    public Droga SearchById(long id) {
        return repo.findById(id).get();
    }

    @Override
    public Collection<Droga> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void Add(Droga d) {
        repo.save(d);
    }

}
