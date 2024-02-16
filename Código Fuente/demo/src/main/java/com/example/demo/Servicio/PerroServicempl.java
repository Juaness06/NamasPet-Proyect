package com.example.demo.Servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Perro;
import com.example.demo.Repositorio.RepositorioPerro;

@Service
public class PerroServicempl implements ServicioPerro {

    @Autowired
    RepositorioPerro repo;

    @Override
    public Perro SearchById(int id) {
        return repo.findById(id);
    }

    @Override
    public Collection<Perro> SearchAll() {
        return repo.findAll();
    }
}
