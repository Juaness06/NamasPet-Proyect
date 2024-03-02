package com.example.demo.Servicio;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;
import com.example.demo.Repositorio.RepositorioPerro;

@Service
public class PerroServicempl implements ServicioPerro {

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
        // TODO Auto-generated method stub
        repo.save(p);
    }

    @Override
    public void DeleteByID(long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
    }

    @Override
    public void Update(Perro p) {
        // TODO Auto-generated method stub
        repo.save(p);
    }

    

}
