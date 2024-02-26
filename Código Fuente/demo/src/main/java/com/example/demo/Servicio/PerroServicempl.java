package com.example.demo.Servicio;

import java.security.PublicKey;
import java.util.Collection;
import java.util.List;

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

    @Override
    public void Add(Perro p) {
        // TODO Auto-generated method stub
        repo.Add(p);
    }

    @Override
    public void DeleteByID(int id) {
        // TODO Auto-generated method stub
        repo.DeleteByID(id);
    }

    @Override
    public void Update(Perro p) {
        // TODO Auto-generated method stub
        repo.Update(p);
    }

    @Override
    public Collection<Perro> PerrosClientePerros(int cedula) {
        return repo.PerrosClientePerros(cedula);
    }

}
