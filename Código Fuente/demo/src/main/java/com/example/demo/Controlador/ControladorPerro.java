package com.example.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entidad.Perro;
import com.example.demo.Servicio.ServicioPerro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping("/perro")
@Controller
public class ControladorPerro {

    @Autowired
    private ServicioPerro servicioPerro;

    @GetMapping("/all")
    public String mostrarPerros(Model model) {
        model.addAttribute("perros", servicioPerro.SearchAll());
        return "MostrarPerros.html";
    }


    @GetMapping("/find/{id}")
    public String mostrarinfoPerro(Model model, @PathVariable("id") int id){

        model.addAttribute("perro", servicioPerro.SearchById(id));
        return "MostrarPerro";
    }


    
    
}
