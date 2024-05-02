package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.Entidad.Tratamientos;
import com.example.demo.Servicio.TratamientosService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class ServicioTratamientosTestNaive {

    @Autowired
    private TratamientosService servicioTratamiento;

    @BeforeEach
    public void init() {
        Tratamientos tratamiento_1 = new Tratamientos(1L, "Vacuna Rabia", 50.0, LocalDate.now());
        Tratamientos tratamiento_2 = new Tratamientos(2L, "Vacuna Parvovirus", 60.0, LocalDate.now());
        Tratamientos tratamiento_3 = new Tratamientos(3L, "Vacuna Moquillo", 70.0, LocalDate.now());

        servicioTratamiento.Add(tratamiento_1);
        servicioTratamiento.Add(tratamiento_2);
        servicioTratamiento.Add(tratamiento_3);
    }

    @Test
    public void ServicioTratamiento_crear_Tratamiento() {

        Tratamientos tratamiento = new Tratamientos(1L, "Vacuna Rabia", 50.0, LocalDate.now());
        Tratamientos tratamiento2 = new Tratamientos(2L, "Vacuna Parvovirus", 60.0, LocalDate.now());

        Tratamientos nuevoTratamiento = servicioTratamiento.Add(tratamiento);
        nuevoTratamiento = servicioTratamiento.Add(tratamiento2);

        Assertions.assertThat(nuevoTratamiento).isNotNull();

    }

    @Test
    public void ServicioTratamiento_findAll_TratamientosList() {

        List<Tratamientos> tratamientos = servicioTratamiento.SearchAll();

        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos.size()).isEqualTo(3); // *Se esperan 3 por tener 3 tratamientos en el init
                                                                 

    }

    @Test
    public void ServicioTratamiento_findById_Tratamiento() {
        long id = 1L;
        Tratamientos encontrado = servicioTratamiento.SearchById(id);
        Assertions.assertThat(encontrado).isNotNull();
        Assertions.assertThat(encontrado.getId()).isEqualTo(id);
    }

    @Test
    public void ServicioTratamiento_deleteById_Tratamiento() {
        long id = 1L;
        servicioTratamiento.deleteById(id);
        Assertions.assertThatThrownBy(() -> servicioTratamiento.SearchById(id)).isInstanceOf(NoSuchElementException.class); // Asumiendo que lanza esta excepción si no encuentra el
                                                             
    }

    @Test
    public void ServicioTratamiento_update_Tratamiento() {
        Tratamientos actualizado = new Tratamientos(1L, "Vacuna Actualizada", 55.0, LocalDate.now());
        servicioTratamiento.Update(actualizado);
        Tratamientos encontrado = servicioTratamiento.SearchById(1L);
        Assertions.assertThat(encontrado.getNombreTratamiento()).isEqualTo("Vacuna Actualizada");
        Assertions.assertThat(encontrado.getPrecioC()).isEqualTo(55.0);
    }

    /*
     * @Test
     * public void ServicioTratamiento_getTotalTratamientosUltimoMes() {
     * Long total = servicioTratamiento.getTotalTratamientosUltimoMes();
     * Assertions.assertThat(total).isNotNull(); // Asegurarse de que devuelve un
     * resultado
     * }
     * 
     * @Test
     * public void ServicioTratamiento_countTratamientosPorDroga() {
     * List<Object[]> conteo = servicioTratamiento.countTratamientosPorDroga();
     * Assertions.assertThat(conteo).isEmpty();
     * }
     * 
     * @Test
     * public void ServicioTratamiento_buscarTratamientosPorIdPerro() {
     * Long idPerro = 1L;
     * List<Tratamientos> tratamientosPorPerro =
     * servicioTratamiento.buscarTratamientosPorIdPerro(idPerro);
     * Assertions.assertThat(tratamientosPorPerro).isEmpty();
     * }
     * 
     * @Test
     * public void ServicioTratamiento_obtenerGananciasTotales() {
     * Double ganancias = servicioTratamiento.obtenerGananciasTotales();
     * Assertions.assertThat(ganancias).isNotNull();
     * Assertions.assertThat(ganancias).isPositive();
     * }
     */

}