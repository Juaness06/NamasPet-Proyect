package com.example.demo.Servicio;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Tratamientos;

import com.example.demo.Repositorio.RepositorioTratamientos;

@Service
public class TratamientosServicempl implements TratamientosService{ 

    @Autowired
    RepositorioTratamientos repo;

    @Override
    public Tratamientos SearchById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Tratamientos> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void Add(Tratamientos p) {
        
        repo.save(p);
    }


    @Override
    public void Update(Tratamientos p) {
        
        repo.save(p);
    }

    @Override
    public void deleteById(Long id) {
        
        repo.deleteById(id);
    }



    /* 
    @Override
    public Tratamientos Cuenta(Long cedula) {
        
        return repo.findByCedula(cedula);
    }
*/

   
    /*
    @Override
    public Collection<Perro> PerrosClientePerros(long cedula) {
        Cliente cliente = repo.findByCedula(cedula);
        if (cliente != null) {
            return cliente.getListaPerros(); 
        } else {
            return new ArrayList<>();
        }
    }   
    */ 
    


}
