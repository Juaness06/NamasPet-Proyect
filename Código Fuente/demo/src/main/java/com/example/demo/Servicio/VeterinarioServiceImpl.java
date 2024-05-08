package com.example.demo.Servicio;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.Entidad.Veterinario;
import com.example.demo.Repositorio.ReporsitorioVeterinario;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class VeterinarioServiceImpl implements ServicioVeterinario {

    @Autowired
    private ReporsitorioVeterinario repo;

    @Override
    public Veterinario SearchById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Veterinario> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void Add(Veterinario v) {
        repo.save(v);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void Update(Veterinario v) {
        repo.save(v);
    }

    @Override
    public Long getVeterinariosActivosCount() {
        return repo.countVeterinariosActivos();
    }

    @Override
    public Long getVeterinariosInactivosCount() {
        return repo.countVeterinariosInactivos();
    }

    @Override
    public void UpdateState(long id) {  
        Veterinario p = repo.findById(id).get();
        if( p.isActivo()==true)
            p.setActivo(false);
        else
            p.setActivo(true);

        repo.save(p);
    }

    @Override
    public Veterinario findByIdAndContrasena(int id, String contrasena) {
        Veterinario veterinario = repo.findByIdAndContrasena(id, contrasena);
        if (veterinario == null) {
            return null;
        }
        return veterinario;
    }

}
