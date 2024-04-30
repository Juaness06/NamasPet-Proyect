package com.example.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;
import com.example.demo.Entidad.Tratamientos;
import com.example.demo.Servicio.ClienteService;
import com.example.demo.Servicio.ServicioPerro;
import com.example.demo.Servicio.TratamientosService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/perro")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorPerro {

    @Autowired
    private ServicioPerro servicioPerro;
    @Autowired
    ClienteService servicioCliente;
    @Autowired
    TratamientosService servicioTratamiento;

    // Shows all dogs
    @GetMapping("/all")
    @Operation(summary = "Muestra todos los perros")
    public List<Perro> mostrarPerros() {
        return servicioPerro.SearchAll();
    }

    // Finds a single dog by ID
    @GetMapping("/find/{id}")
    public ResponseEntity<Perro> mostrarinfoPerro(@PathVariable("id") int id) {
        Perro perro = servicioPerro.SearchById(id);
        if (perro != null) {
            return ResponseEntity.ok(perro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Returns a view name (not typically used in REST APIs)
    @GetMapping("")
    public String index() {
        return "index";
    }

    // Form display for adding a dog (not typically used in REST APIs)
    @GetMapping("/add")
    public String MostrarFormularioAdd(Model model) {
        model.addAttribute("perro", new Perro("", 0, "", "", 0, false, 0.0, 0));
        return "RegistrarPerro";
    }

    // Adds a dog associated with a client ID
    @PostMapping("/agregar/{cedula}")
    public ResponseEntity<Perro> agregarPerro(@RequestBody Perro perro, @PathVariable("cedula") long cedula) {
        Cliente cliente = servicioCliente.SearchById(cedula);
        if (cliente != null) {  
            perro.setCliente(cliente);
            Perro addedPerro = servicioPerro.Add(perro);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedPerro);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Deletes a dog
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> borrarPerro(@PathVariable("id") int id) {
        servicioPerro.UpdateState(id);
        return ResponseEntity.ok().build();
    }

    // Updates a dog
    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> updateCliente(@RequestBody Perro perro, @PathVariable("id") long id) {
        Perro existingPerro = servicioPerro.SearchById(perro.getId());
        Cliente client = servicioCliente.SearchById(id);
        if (existingPerro != null && client != null) {
            perro.setCliente(client);
            servicioPerro.Update(perro);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Adds a treatment to a dog
    @PutMapping("/agregarTratamiento/{id}")
    public ResponseEntity<Void> agregarTratamiento(@RequestBody Perro perro, @PathVariable("id") long id) {
        Perro dog = servicioPerro.SearchById(perro.getId());
        Tratamientos treatment = servicioTratamiento.SearchById(id);
        if (dog != null && treatment != null) {
            dog.getTratamientos().add(treatment);
            servicioPerro.Update(dog);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Gets all dogs belonging to a client
    @GetMapping("/cliente/{id}")
    public List<Perro> Perro(@PathVariable("id") long id) {
        return servicioPerro.findByClienteCedula(id);
    }

    // Counts total dogs
    @GetMapping("/perros")
    public ResponseEntity<Long> contarTotalPerros() {
        Long totalPerros = Long.valueOf(servicioPerro.SearchAll().size());
        return ResponseEntity.ok(totalPerros);
    }

    // Counts active dogs
    @GetMapping("/activos")
    public Long contarMascotasActivas() {
        return servicioPerro.contarMascotasActivas();
    }
}
