package com.example.demo.Servicio;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Tratamientos;

import com.example.demo.Repositorio.RepositorioTratamientos;

@Service
public class TratamientosServicempl implements TratamientosService {

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
    public Long getTotalTratamientosUltimoMes() {
        LocalDate endDate = LocalDate.now(); // Fecha actual
        LocalDate startDate = endDate.withDayOfMonth(1).minusMonths(1); // Primer día del mes anterior
        
        return repo.countTratamientosUltimoMes(startDate, endDate);
    }

    public List<Object[]> getConteoTratamientosPorMedicamento(LocalDate startDate, LocalDate endDate) {
        return repo.countTratamientosPorMedicamento(startDate, endDate);
    }

   


    /*
     * @Override
     * public Tratamientos Cuenta(Long cedula) {
     * 
     * return repo.findByCedula(cedula);
     * }
     */

    /*
     * @Override
     * public Collection<Perro> PerrosClientePerros(long cedula) {
     * Cliente cliente = repo.findByCedula(cedula);
     * if (cliente != null) {
     * return cliente.getListaPerros();
     * } else {
     * return new ArrayList<>();
     * }
     * }
     */

}
