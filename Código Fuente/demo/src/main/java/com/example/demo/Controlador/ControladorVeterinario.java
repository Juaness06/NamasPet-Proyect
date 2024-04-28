package com.example.demo.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.example.demo.Entidad.Administrador;
import com.example.demo.Entidad.Veterinario;
import com.example.demo.Servicio.ServicioVeterinario;



@RequestMapping("/veterinario")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorVeterinario {

    @Autowired
    private ServicioVeterinario servicioVeterinario;

    // Endpoint para mostrar todos los veterinarios
    @GetMapping("/all")
    public List<Veterinario> mostrarVeterinarios() {
        return servicioVeterinario.SearchAll();
    }

    // Endpoint para mostrar la información de un veterinario específico por su ID
    @GetMapping("/{id}")
    public Veterinario mostrarInfoVeterinario(@PathVariable("id") long id) {
        return servicioVeterinario.SearchById(id);
    }

    // Endpoint para registrar un nuevo veterinario
    @PostMapping("/add")
    public void registrarVeterinario(@RequestBody Veterinario veterinario) {
        servicioVeterinario.Add(veterinario);
    }

    // Endpoint para borrar un veterinario
    @DeleteMapping("/borrar/{id}")
    public void borrarVeterinario(@PathVariable("id") long id) {
        servicioVeterinario.UpdateState(id);
    }

    // Endpoint para actualizar la información de un veterinario
    @PutMapping("/editar/{id}")
    public void actualizarVeterinario(@RequestBody Veterinario veterinario, @PathVariable("id") long id) {
        servicioVeterinario.Update(veterinario);
    }

    @GetMapping("/activos")
    public ResponseEntity<Long> getVeterinariosActivosCount() {
        Long count = servicioVeterinario.getVeterinariosActivosCount();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/inactivos")
    public ResponseEntity<Long> getVeterinariosInactivosCount() {
        Long count = servicioVeterinario.getVeterinariosInactivosCount();
        return ResponseEntity.ok(count);
    }

    //www.localhost:8090/administrador/findByNombreAndContrasena/1/1234
    @GetMapping("/findByNombreAndContrasena/{id}/{contrasena}")
    public Veterinario findByIdAndContrasena(@PathVariable int id, @PathVariable String contrasena) {
        return servicioVeterinario.findByIdAndContrasena(id, contrasena);
    }

}
