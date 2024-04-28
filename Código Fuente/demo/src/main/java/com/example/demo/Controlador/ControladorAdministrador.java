package com.example.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entidad.Administrador;
import com.example.demo.Servicio.AdministradorService;
import com.example.demo.Servicio.ServicioPerro;
import com.example.demo.Servicio.TratamientosService;

@RequestMapping("/administrador")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorAdministrador {

    @Autowired
    private AdministradorService servicioAdministrador;

    @Autowired
    private ServicioPerro servicioPerro;

    @Autowired
    private TratamientosService servicioTratamiento;

    @GetMapping("/find/{id}")
    public Administrador BuscarAdministrador(@PathVariable("id") int id) {

        Administrador admin = servicioAdministrador.SearchById(id);

        return admin;
    }

    //www.localhost:8090/administrador/findByNombreAndContrasena/{nombre}/{contrasena}
    @GetMapping("/findByNombreAndContrasena/{nombre}/{contrasena}")
    public Administrador findByNombreAndContrasena(@PathVariable String nombre, @PathVariable String contrasena) {
        return servicioAdministrador.findByNombreAndContrasena(nombre, contrasena);
    }

    @GetMapping("/venta")
    public double obtenerVentasDePerrosConTratamientos() {
        return servicioPerro.calcularVentasDePerrosConTratamientos();
    }

    @GetMapping("/ganancias")
    public ResponseEntity<Double> obtenerGananciasTotales() {
        Double ganancias = servicioTratamiento.obtenerGananciasTotales();
        if (ganancias == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ganancias);
    }
}
