package com.example.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Administrador;
import com.example.demo.Repositorio.ReporsitorioAdministrador;

@Service
public class AdministradorServicempl implements AdministradorService { // implementa el servicio de administrador

    @Autowired
    ReporsitorioAdministrador repo;

    @Override
    public Administrador SearchById(int id) {
        return repo.findById(id);
    }

    @Override
    public List<Administrador> SearchAll() {
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

    @Override
    public Administrador findByNombreAndContrasena(String nombre, String contrasena) {
        Administrador administrador = repo.findByNombreAndContrasena(nombre, contrasena);
        if (administrador == null) {
            return null;
        }
        return administrador;
    }
}
