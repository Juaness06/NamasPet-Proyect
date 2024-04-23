package com.example.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    // http://localhost:8090/perro/all
    @GetMapping("/all")
    @Operation(summary = "Muestra todos los perros")
    public List<Perro> mostrarPerros() {
        /*
         * model.addAttribute("perros", servicioPerro.SearchAll());
         * return "ListaPerros";
         */
        return servicioPerro.SearchAll();
    }

    // http://localhost:8090/perro/find/1
    @GetMapping("/find/{id}")
    public Perro mostrarinfoPerro(@PathVariable("id") int id) {

        Perro perro = servicioPerro.SearchById(id);
        /*
         * if (perro != null) {
         * model.addAttribute("perro", servicioPerro.SearchById(id));
         * } else {
         * throw new NotFoundException(id);
         * }
         * 
         * model.addAttribute("perro", servicioPerro.SearchById(id));
         */

        return perro;
    }

    // http://localhost:8090/perro/targeton
    @GetMapping("/targeton")
    public List<Perro> TmostrarPerros() {
        /*
         * model.addAttribute("perros", servicioPerro.SearchAll());
         * return "MostrarPerros";
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

    @PostMapping("/agregar/{cedula}")
    public void AgregarPerro(@RequestBody Perro perro, @PathVariable("cedula") long cedula) {
        perro.setCliente(servicioCliente.SearchById(cedula));
        servicioPerro.Add(perro);
    }

    @DeleteMapping("/delete/{id}")
    public void BorrarPerro(@PathVariable("id") int id) {
        {
            servicioPerro.DeleteByID(id);
        }

    }

    @PutMapping("/edit/{id}")
    public void UpdateCliente(@RequestBody Perro perro, @PathVariable("id") long id) {

        Perro a = servicioPerro.SearchById(perro.getId());
        Cliente b = servicioCliente.SearchById(id);
        if (a != null && b != null) {
            perro.setCliente(b);
            servicioPerro.Update(perro);
        } else {
            throw new NotFoundException(id);
        }

    }

    @PutMapping("/agregarTratamiento/{id}")
    public void AgregarTratamiento(@RequestBody Perro perro, @PathVariable("id") long id) {
        Perro a = servicioPerro.SearchById(perro.getId());
        Tratamientos b = servicioTratamiento.SearchById(id);
        List<Tratamientos> c = a.getTratamientos();
        c.add(b);
        if (a != null && b != null) {
            perro.setTratamientos(c);
            servicioPerro.Update(perro);
        } else {
            throw new NotFoundException(id);
        }

    }

    // http://localhost:8090/perro/cliente/1
    @GetMapping("/cliente/{id}")
    public List<Perro> Perro(@PathVariable("id") long id) {
        return servicioPerro.findByClienteCedula(id);
    }

    @GetMapping("/perros")
    public ResponseEntity<Long> contarTotalPerros() {
    int totalPerrosInt = servicioPerro.SearchAll().size(); // Obtiene el tamaño como int
    Long totalPerros = Long.valueOf(totalPerrosInt); // Convierte int a Long
    return ResponseEntity.ok(totalPerros);
}

    @GetMapping("/activos")
    public Long contarMascotasActivas() {
        return servicioPerro.contarMascotasActivas();
    }

}
