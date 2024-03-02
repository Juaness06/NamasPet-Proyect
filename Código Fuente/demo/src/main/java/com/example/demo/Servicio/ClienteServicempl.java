package com.example.demo.Servicio;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;
import com.example.demo.Repositorio.ReporsitorioCliente;

@Service
public class ClienteServicempl implements ClienteService {

    @Autowired
    ReporsitorioCliente repo;

    @Override
    public Cliente SearchById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Collection<Cliente> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void Add(Cliente p) {
        // TODO Auto-generated method stub
        repo.save(p);
    }


    @Override
    public void Update(Cliente p) {
        // TODO Auto-generated method stub
        repo.save(p);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Cliente Cuenta(Long cedula) {
        // TODO Auto-generated method stub
        return repo.findByCedula(cedula);
    }


    @Override
    public Collection<Perro> PerrosClientePerros(long cedula) {
        Cliente cliente = repo.findByCedula(cedula);
        if (cliente != null) {
            return cliente.getListaPerros(); 
        } else {
            return new ArrayList<>();
        }
    }    


}
