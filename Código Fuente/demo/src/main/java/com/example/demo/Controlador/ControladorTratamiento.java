package com.example.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entidad.Tratamientos;
import com.example.demo.Servicio.TratamientosService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorTratamiento {

    @Autowired
    private TratamientosService servicioTratamiento;

    // Endpoint para obtener todos los tratamientos
    @GetMapping("/all")
    public List<Tratamientos> mostrarTratamientos(Model model) {
        return servicioTratamiento.SearchAll();
    }

    // Endpoint para obtener un tratamiento específico por su ID
    @GetMapping("/find/{id}")
    public Tratamientos mostrarInfoTratamiento(@PathVariable("id") Long id) {
        return servicioTratamiento.SearchById(id);
    }
}
