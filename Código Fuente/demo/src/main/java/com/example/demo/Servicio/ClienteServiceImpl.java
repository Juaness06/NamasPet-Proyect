package com.example.demo.Servicio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;
import com.example.demo.Repositorio.RepositorioCliente;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private RepositorioCliente repo;

    @Override
    public Cliente SearchById(Long id) {
        return repo.findById(id).orElse(null);
    }

  
    @Override
    public List<Cliente> SearchAll() {
        return repo.findAll();
    }

    @Override
    public Cliente Add(Cliente p) {
        return repo.save(p);
    }

    @Override
    public Cliente Update(Cliente p) {
        return repo.save(p);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Cliente Cuenta(Long cedula) {
        return repo.findByCedula(cedula);
    }

    @Override
    public List<Perro> PerrosClientePerros(long cedula) {
        Cliente cliente = repo.findByCedula(cedula);
        if (cliente != null) {
            return cliente.getListaPerros(); 
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Cliente findByCorreo(String correo) {
        return repo.findByCorreo(correo);
    }
}
