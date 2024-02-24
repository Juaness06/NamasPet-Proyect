package com.example.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.demo.Entidad.Perro;
import com.example.demo.Servicio.ServicioPerro;




import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/perro")
@Controller
public class ControladorPerro {

    @Autowired
    private ServicioPerro servicioPerro;

    // http://localhost:8090/perro/all
    @GetMapping("/all")
    public String mostrarPerros(Model model) {
        model.addAttribute("perros", servicioPerro.SearchAll());
        return "ListaPerros";
    }

    // http://localhost:8090/perro/find/1
    @GetMapping("/find/{id}")
    public String mostrarinfoPerro(Model model, @PathVariable("id") int id) {

        model.addAttribute("perro", servicioPerro.SearchById(id));
        return "MostrarPerro";
    }

    // http://localhost:8090/perro/targeton
    @GetMapping("/targeton")
    public String TmostrarPerros(Model model) {
        model.addAttribute("perros", servicioPerro.SearchAll());
        return "MostrarPerros";
    }

    // http://localhost:8090/perro/index
    @GetMapping("/index")
    public String index() {
        return "LandingPage";	
    }

    // http://localhost:8090/perro/add
    @GetMapping("/add")
    public String MostrarFormularioAdd(Model model) {
        Perro perro = new Perro("",0,"","",0,false,0.0,0);
        model.addAttribute("perro", perro);


        return "AddPerro"; //esto se debe cambiar dependiendo como granni llame la pagina paa crear
    }
    
    @PostMapping("/agregar")
    public String AgregarPerro(@ModelAttribute("perro") Perro perro) {
    

        servicioPerro.Add(perro);
        return "Redirect:/perro/all"; //mirar bien esto
    }
    
    @GetMapping("/delete/{id}")
    public String BorrarPerro(@PathVariable("id") int id){ {
        servicioPerro.DeleteByID(id);
        return "Redirect:/perro/all";
    }
    
    }

    @GetMapping("/update/{id}")
    public String UpdatePerro(@PathVariable("id") int id, @ModelAttribute("perro") Perro perro) {
        servicioPerro.Update(perro);
        return "Redirect:/perro/all";
    }
}
