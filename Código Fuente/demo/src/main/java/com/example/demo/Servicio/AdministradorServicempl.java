package com.example.demo.Servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Administrador;
import com.example.demo.Repositorio.ReporsitorioAdministrador;

@Service
public class AdministradorServicempl implements AdministradorService { //implementa el servicio de administrador
    
    @Autowired
    ReporsitorioAdministrador repo;

    @Override
    public Administrador SearchById(int id) {
        return repo.findById(id).get();
    }

    @Override
    public Collection<Administrador> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void Add(Administrador d) {
        repo.save(d);
    }

      @Override
    public void DeleteByID(int id) {
        repo.deleteById(id);
    }

    @Override
    public void Update(Administrador p) {
        repo.save(p);
    }
}
