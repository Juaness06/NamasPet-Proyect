package com.example.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entidad.Administrador;
import com.example.demo.Servicio.AdministradorService;

@RequestMapping("/administrador")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorAdministrador {

    @Autowired
    private AdministradorService servicioAdministrador;

    @GetMapping("/find/{id}")
    public Administrador BuscarAdministrador(@PathVariable("id") int id) {

        Administrador admin = servicioAdministrador.SearchById(id);

        return admin;
    }

}
