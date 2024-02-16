package com.example.demo.Repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.Entidad.Perro;

@Repository
public class RepositorioPerro {

    private Map<Integer,Perro> data = new HashMap<>();


public RepositorioPerro(){
    data.put(1, new Perro(001,"Salchicha",7,true,2));
    data.put(2, new Perro(002,"Golden Retriver",5,false,1));
}
public Perro findById(int id){
    return data.get(id);
}

public Collection<Perro> findAll(){
    return data.values();
}

}
