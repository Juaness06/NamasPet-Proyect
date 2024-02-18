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
    data.put(1, new Perro("https://media.istockphoto.com/id/175221593/es/foto/linda-poco-perro-tejonero.jpg?s=1024x1024&w=is&k=20&c=wf0sWuGn-m4UugX5wouI4CA52XQLz3WkeCN1_Q69QBI=" ,001,"Salchicha",7,true,5.2,2));
    data.put(2, new Perro("https://media.istockphoto.com/id/509052128/es/foto/oro-retriever-sentado-en-frente-de-un-fondo-blanco.jpg?s=1024x1024&w=is&k=20&c=C4xUiJIirtS9I8fjkLjub7TSKv1wx1n2vYauNQ6JzZ4=",002,"Golden Retriver",5,false,5.6,1));
}
public Perro findById(int id){
    return data.get(id);
}

public Collection<Perro> findAll(){
    return data.values();
}

}
