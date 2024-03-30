package com.example.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;
import com.example.demo.Servicio.ClienteService;
import com.example.demo.Servicio.ServicioPerro;


@RequestMapping("/perro")
@Controller
public class ControladorPerro {

    @Autowired
    private ServicioPerro servicioPerro;

    @Autowired
    ClienteService servicioCliente;

    // http://localhost:8090/perro/all
    @GetMapping("/all")
    public String mostrarPerros(Model model) {
        model.addAttribute("perros", servicioPerro.SearchAll());
        return "ListaPerros";
    }

    // http://localhost:8090/perro/find/1
    @GetMapping("/find/{id}")
    public String mostrarinfoPerro(Model model, @PathVariable("id") int id) {
        //encuentra el perro y lo muestra en pantalla si no muestra la excepcion
        Perro perro = servicioPerro.SearchById(id);

        if (perro != null) {
            model.addAttribute("perro", servicioPerro.SearchById(id));
        } else {
            throw new NotFoundException(id);
        }

        model.addAttribute("perro", servicioPerro.SearchById(id));
        return "MostrarPerro";
    }

    // http://localhost:8090/perro/targeton
    @GetMapping("/targeton")
    public String TmostrarPerros(Model model) {
        model.addAttribute("perros", servicioPerro.SearchAll());
        return "MostrarPerros";
        //retorna todos los Perros en la base de datos
    }

    // http://localhost:8090/perro/index
    @GetMapping("")
    public String index() {
        return "index";
    }

    // http://localhost:8090/perro/add
    @GetMapping("/add")
    public String MostrarFormularioAdd(Model model) {
        Perro perro = new Perro("", 0, "", "", 0, false, 0.0, 0);
        model.addAttribute("perro", perro);

        return "RegistrarPerro";
    }

    @PostMapping("/agregar")
    public String AgregarPerro(@ModelAttribute("perro") Perro perro) {
        Cliente a = servicioCliente.Cuenta(perro.getCliente().getCedula());
        long id = perro.getCliente().getCedula();
        if (a != null) {
          servicioPerro.Add(perro);
          return "redirect:/perro/all";
      } else {
          throw new NotFoundException(id);   
      }
         
    }
    

    @GetMapping("/delete/{id}")
    public String BorrarPerro(@PathVariable("id") int id) {
        {
            servicioPerro.DeleteByID(id);
            return "redirect:/perro/all";
        }

    }

    @GetMapping("/edit/{id}")
    public String editarPerro(@PathVariable("id") int id, Model model) {
        Perro perro = servicioPerro.SearchById(id);
        if (perro != null) {
            model.addAttribute("perro", perro);
            return "ModificarPerro";
        } else {
            return "redirect:/perro/all";
        }
    }

    @PostMapping("/edit/{id}")
    public String UpdateCliente(@PathVariable("id") int cedula, @ModelAttribute("perro") Perro perro) {
        
      Cliente a = servicioCliente.Cuenta(perro.getCliente().getCedula());
      long id = perro.getCliente().getCedula();
      if (a != null) {
        servicioPerro.Update(perro);
        return "redirect:/perro/all";
    } else {
        throw new NotFoundException(id);   
    }
       
    }

    // http://localhost:8090/perro/search/1

}
