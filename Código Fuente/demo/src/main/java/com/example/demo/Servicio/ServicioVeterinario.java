package com.example.demo.Servicio;

import java.util.List;

import com.example.demo.Entidad.Veterinario;

public interface ServicioVeterinario { //servicio de veterinario
    
    //metodos
    public Veterinario SearchById(long id);

    public List<Veterinario> SearchAll();

    public void Add(Veterinario v);

    public void deleteById(Long id);

    public void Update(Veterinario p);

    public Long getVeterinariosActivosCount();

    public Long getVeterinariosInactivosCount();

    public void UpdateState(long id);

    Veterinario findByIdAndContrasena(int id, String contrasena);
    
}
