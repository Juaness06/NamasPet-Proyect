package com.example.demo.service;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.Entidad.Tratamientos;
import com.example.demo.Repositorio.RepositorioTratamientos;
import com.example.demo.Servicio.TratamientosServicempl;

@ExtendWith(MockitoExtension.class)
public class ServicioTratamientosTest {

    @Mock
    private RepositorioTratamientos repositorioTratamientos;

    @InjectMocks
    private TratamientosServicempl tratamientosService;

    @Test
    public void addTratamiento() {
        // Arrange
        Tratamientos tratamiento = new Tratamientos(1L, "Vacuna Rabia", 50.0, LocalDate.now());

        when(repositorioTratamientos.save(tratamiento)).thenReturn(tratamiento);

        // Act
        tratamientosService.Add(tratamiento);

        // Assert
        Assertions.assertThat(tratamiento).isNotNull();
        Assertions.assertThat(tratamiento.getNombreTratamiento()).isEqualTo("Vacuna Rabia");
    }

    @Test
    public void findAllTratamientos() {
        // Arrange
        when(repositorioTratamientos.findAll()).thenReturn(
            List.of(
                new Tratamientos(1L, "Vacuna Rabia", 50.0, LocalDate.now()),
                new Tratamientos(2L, "Vacuna Parvovirus", 60.0, LocalDate.now())
            )
        );

        // Act
        List<Tratamientos> tratamientos = tratamientosService.SearchAll();

        // Assert
        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos.size()).isEqualTo(2);
    }

    @Test
    public void findById() {
        // Arrange
        long id = 1L;
        Tratamientos expectedTratamiento = new Tratamientos(id, "Vacuna Rabia", 50.0, LocalDate.now());
        when(repositorioTratamientos.findById(id)).thenReturn(Optional.of(expectedTratamiento));

        // Act
        Tratamientos foundTratamiento = tratamientosService.SearchById(id);

        // Assert
        Assertions.assertThat(foundTratamiento).isNotNull();
        Assertions.assertThat(foundTratamiento.getId()).isEqualTo(id);
        Assertions.assertThat(foundTratamiento.getNombreTratamiento()).isEqualTo("Vacuna Rabia");
    }
@Test
    public void deleteById() {
        // Arrange
        long id = 1L;

        // Act
        tratamientosService.deleteById(id);

        // Assert
        Mockito.verify(repositorioTratamientos).deleteById(id);
    }

    @Test
    public void getTotalTratamientosUltimoMes() {
        // Arrange
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.withDayOfMonth(1).minusMonths(1);
        Long expectedCount = 10L;
        when(repositorioTratamientos.countTratamientosUltimoMes(startDate, endDate)).thenReturn(expectedCount);

        // Act
        Long count = tratamientosService.getTotalTratamientosUltimoMes();

        // Assert
        Assertions.assertThat(count).isEqualTo(expectedCount);
    }

    @Test
    public void countTratamientosPorDroga() {
        // Arrange
        List<Object[]> expectedList = List.of(
            new Object[]{"Ibuprofeno", 5L},
            new Object[]{"Paracetamol", 3L}
        );
        when(repositorioTratamientos.countTratamientosPorDroga()).thenReturn(expectedList);

        // Act
        List<Object[]> resultList = tratamientosService.countTratamientosPorDroga();

        // Assert
        Assertions.assertThat(resultList).isNotNull();
        Assertions.assertThat(resultList.size()).isEqualTo(2);
    }

    @Test
    public void buscarTratamientosPorIdPerro() {
        // Arrange
        Long perroId = 1L;
        List<Tratamientos> expectedTratamientos = List.of(
            new Tratamientos(1L, "Vacuna Rabia", 50.0, LocalDate.now()),
            new Tratamientos(2L, "Antipulgas", 30.0, LocalDate.now())
        );
        when(repositorioTratamientos.findByPerroId(perroId)).thenReturn(expectedTratamientos);

        // Act
        List<Tratamientos> tratamientos = tratamientosService.buscarTratamientosPorIdPerro(perroId);

        // Assert
        Assertions.assertThat(tratamientos).isNotNull();
        Assertions.assertThat(tratamientos.size()).isEqualTo(2);
    }

    @Test
    public void obtenerGananciasTotales() {
        // Arrange
        Double expectedGanancias = 5000.00;
        when(repositorioTratamientos.calcularGananciasTotales()).thenReturn(expectedGanancias);

        // Act
        Double ganancias = tratamientosService.obtenerGananciasTotales();

        // Assert
        Assertions.assertThat(ganancias).isEqualTo(expectedGanancias);
    }

}
