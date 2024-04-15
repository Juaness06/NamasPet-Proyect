package com.example.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entidad.Tratamientos;
import com.example.demo.Servicio.TratamientosService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/tratamiento")
public class ControladorTratamiento {

    @Autowired
    private TratamientosService servicioTratamiento;

    // Endpoint para obtener todos los tratamientos
    @GetMapping("/all")
    @Operation(summary = "Muestra todos los tratamientos")
    public List<Tratamientos> mostrarTratamientos() {
        return servicioTratamiento.SearchAll();
    }

    // Endpoint para obtener un tratamiento específico por su ID
    @GetMapping("/find/{id}")
    public Tratamientos mostrarInfoTratamiento(@PathVariable("id") Long id) {
        return servicioTratamiento.SearchById(id);
    }
}
