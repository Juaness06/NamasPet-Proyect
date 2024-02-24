package com.example.demo.Repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;

@Repository
public class ReporsitorioCliente {
    private Map<Integer, Cliente> data = new HashMap<>();

    public ReporsitorioCliente() {
        data.put(1, new Cliente(1,"Jairo","jairo man","123"));
        data.put(2, new Cliente(2,"Esteban","Grandala","222") );
        data.put(3, new Cliente(3,"Santiago","Killercoolyeah","444"));
        data.put(4, new Cliente(5,"Juana","Suaracost","555"));

    }
    public Cliente findById(int id) {
        return data.get(id);
    }

    public Collection<Cliente> findAll() {
        return data.values();
    }
    public void Add(Cliente p) {
        int tam= data.size();
        int lastId = data.get(tam).getCedula();
        p.setCedula(lastId+1);
        data.put(p.getCedula(), p);
    }

    public void DeleteByID(int id) {
        data.remove(id);
    }

    public void Update(Cliente p) {
        data.put(p.getCedula(), p);
    }
    
}
