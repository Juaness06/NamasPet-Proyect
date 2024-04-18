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
}
