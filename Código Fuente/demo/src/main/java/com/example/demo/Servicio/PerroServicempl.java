package com.example.demo.Servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Perro;
import com.example.demo.Repositorio.RepositorioPerro;

@Service
public class PerroServicempl implements ServicioPerro { //implementa el servicio de perro

    @Autowired
    RepositorioPerro repo;

    @Override
    public Perro SearchById(long id) {
        return repo.findById(id).get();
    }

    @Override
    public Collection<Perro> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void Add(Perro p) {
        repo.save(p);
    }

    @Override
    public void DeleteByID(long id) {
        repo.deleteById(id);
    }

    @Override
    public void Update(Perro p) {
        repo.save(p);
    }

    

}
