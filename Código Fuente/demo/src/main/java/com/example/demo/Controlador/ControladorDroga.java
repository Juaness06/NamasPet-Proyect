package com.example.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entidad.Droga;
import com.example.demo.Servicio.ServicioDroga;


import ch.qos.logback.core.model.Model;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/droga")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorDroga {

    @Autowired
    private ServicioDroga drugService;

    // Endpoint to get all drugs
    @GetMapping("/all")
    public List<Droga> mostrartodasDrogas(Model model) {
        return drugService.SearchAll();
    }

    // Endpoint to get a specific drug by its ID
    @GetMapping("/find/{id}")
    public Droga showDrugInfo(@PathVariable("id") Long id) {
        return drugService.SearchById(id);
    }
}
