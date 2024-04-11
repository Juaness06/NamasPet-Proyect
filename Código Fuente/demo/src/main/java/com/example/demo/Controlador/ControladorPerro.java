package com.example.demo.Controlador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;
import com.example.demo.Servicio.ClienteService;
import com.example.demo.Servicio.ServicioPerro;

import io.swagger.v3.oas.annotations.Operation;



@RestController
@RequestMapping("/perro")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorPerro {

    @Autowired
    private ServicioPerro servicioPerro;

    @Autowired
    ClienteService servicioCliente;

    // http://localhost:8090/perro/all
    @GetMapping("/all")
    @Operation(summary = "Muestra todos los perros")
    public List<Perro> mostrarPerros() {
        /*
        model.addAttribute("perros", servicioPerro.SearchAll());
        return "ListaPerros";
        */
        return servicioPerro.SearchAll();
    }

    // http://localhost:8090/perro/find/1
    @GetMapping("/find/{id}")
    public Perro mostrarinfoPerro( @PathVariable("id") int id) {

        Perro perro = servicioPerro.SearchById(id);
 /*
        if (perro != null) {
            model.addAttribute("perro", servicioPerro.SearchById(id));
        } else {
            throw new NotFoundException(id);
        }

        model.addAttribute("perro", servicioPerro.SearchById(id));
        */
    

        return perro;
    }

    // http://localhost:8090/perro/targeton
    @GetMapping("/targeton")
    public List<Perro> TmostrarPerros() {
        /*
        model.addAttribute("perros", servicioPerro.SearchAll());
        return "MostrarPerros";
        */
        return servicioPerro.SearchAll();
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
    public void AgregarPerro(@RequestBody Perro perro) {
        System.out.println(perro);

        Cliente a = servicioCliente.Cuenta(perro.getCliente().getCedula());
        long id = perro.getCliente().getCedula();
        if (a != null) {
          servicioPerro.Add(perro);
          
      } else {
          throw new NotFoundException(id);   
      }
         
    }
    

    @DeleteMapping("/delete/{id}")
    public void BorrarPerro(@PathVariable("id") int id) {
        {
            servicioPerro.DeleteByID(id);
        }

    }

    @GetMapping("/edit/{id}")
    public void editarPerro(@RequestBody Perro perro,@PathVariable("id") int id) {
        servicioPerro.Update(perro);
    }

    @PutMapping("/edit/{id}")
    public void UpdateCliente(@RequestBody Perro perro) {
        
      Cliente a = servicioCliente.Cuenta(perro.getCliente().getCedula());
      long id = perro.getCliente().getCedula();
      if (a != null) {
        servicioPerro.Update(perro);
    } else {
        throw new NotFoundException(id);   
    }
       
    }

    // http://localhost:8090/perro/clienteMascota/1
    @GetMapping("/cliente/{id}")
    public List<Perro> Perro(@PathVariable("id") long id) {
        return servicioPerro.findByClienteCedula(id);
    }
    

    // http://localhost:8090/perro/search/1

}
