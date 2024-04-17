package com.example.demo.Servicio;

import java.util.Collection;

import com.example.demo.Entidad.Veterinario;

public interface ServicioVeterinario { // servicio de veterinario

    // metodos
    public Veterinario SearchById(long id);

    public Collection<Veterinario> SearchAll();

    public void Add(Veterinario v);

}
