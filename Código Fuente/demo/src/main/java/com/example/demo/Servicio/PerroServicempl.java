package com.example.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Perro;
import com.example.demo.Repositorio.RepositorioPerro;

@Service
public class PerroServicempl implements ServicioPerro { // implementa el servicio de perro

    @Autowired
    RepositorioPerro repo;

    @Override
    public Perro SearchById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Perro> SearchAll() {
        return repo.findAll();
    }

    @Override
    public Perro Add(Perro p) {
        return repo.save(p);
    }

    @Override
    public void DeleteByID(long id) {
        repo.deleteById(id);
    }

    @Override
    public void Update(Perro p) {
        repo.save(p);
    }

    @Override
    public List<Perro> findByClienteCedula(long id) {
        return repo.findByClienteCedula(id);
    }

    @Override 
    public Long contarMascotasActivas() {
        return repo.countMascotasActivas();
    }

    @Override
    public double calcularVentasDePerrosConTratamientos() {
        Double total = repo.sumarVentasDePerrosConTratamientos();
        return total != null ? total : 0; // Retorna 0 si no hay tratamientos
    }

    @Override
    public void UpdateState(long id) {  
        Perro p = repo.findById(id).orElse(null);
        if (p != null) {
            p.setActividad(!p.isActividad());
            repo.save(p);
        }
    }
}
