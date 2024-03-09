package com.example.demo.Servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Entidad.Veterinario;
import com.example.demo.Repositorio.ReporsitorioVeterinario;

public class VeterianarioServicempl implements ServicioVeterinario  {

    @Autowired
    ReporsitorioVeterinario repo;


    @Override
    public Veterinario SearchById(long id) {
       return repo.findById(id).get();
    }

    @Override
    public Collection<Veterinario> SearchAll() {
       return repo.findAll();
    }

    @Override
    public void Add(Veterinario v) {
        repo.save(v);
    }
    
}
