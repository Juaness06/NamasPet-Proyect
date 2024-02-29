package com.example.demo.Servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Repositorio.ReporsitorioCliente;

@Service
public class ClienteServicempl implements ClienteService {

    @Autowired
    ReporsitorioCliente repo;

    @Override
    public Cliente SearchById(int id) {
        return repo.findById(id);
    }

    @Override
    public Collection<Cliente> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void Add(Cliente p) {
        // TODO Auto-generated method stub
        repo.Add(p);
    }

    @Override
    public void DeleteByID(int id) {
        // TODO Auto-generated method stub
        repo.DeleteByID(id);
    }

    @Override
    public void Update(Cliente p) {
        // TODO Auto-generated method stub
        repo.Update(p);
    }

    public Cliente Cuenta( int cedula) {
        // TODO Auto-generated method stub
        return repo.Cuenta(cedula);
    }

}
