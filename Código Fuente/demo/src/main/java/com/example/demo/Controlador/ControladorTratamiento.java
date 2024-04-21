package com.example.demo.Controlador;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entidad.Tratamientos;
import com.example.demo.Servicio.TratamientosService;

import ch.qos.logback.core.model.Model;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorTratamiento {

    @Autowired
    private TratamientosService servicioTratamiento;

    // Endpoint para obtener todos los tratamientos
    @GetMapping("/all")
    public List<Tratamientos> mostrarTratamientos(Model model) {
        return servicioTratamiento.SearchAll();
    }

    // Endpoint para obtener un tratamiento específico por su ID
    @GetMapping("/find/{id}")
    public Tratamientos mostrarInfoTratamiento(@PathVariable("id") Long id) {
        return servicioTratamiento.SearchById(id);
    }

    @GetMapping("/count-ultimo-mes")
    public ResponseEntity<Long> contarTratamientosUltimoMes() {
        Long totalTratamientos = servicioTratamiento.getTotalTratamientosUltimoMes();
        return ResponseEntity.ok(totalTratamientos);
    }

    @GetMapping("/cantidad_tipo")
    @Operation(summary = "Cantidad de tratamientos por tipo de medicamento administrado en el ultimo mes(tabla medicamento-cantidad)")
    public List<Object[]> showTotalTratamientosPorDroga() {
        return servicioTratamiento.countTratamientosPorDroga();
    }
    

    /*

    @GetMapping("/conteo-medicamentos")
    public ResponseEntity<List<Map<String, Long>>> contarTratamientosPorMedicamento(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<Object[]> conteo = servicioTratamiento.getConteoTratamientosPorMedicamento(startDate, endDate);
        List<Map<String, Long>> resultado = conteo.stream()
                .map(obj -> Collections.singletonMap((String) obj[0], (Long) obj[1]))
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultado);
    }
    */

    
}
