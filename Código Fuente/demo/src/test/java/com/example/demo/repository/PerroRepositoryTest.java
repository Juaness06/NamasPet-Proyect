package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.DemoApplication; // Asegúrate de que esta importación sea correcta
import com.example.demo.Entidad.Perro;
import com.example.demo.Repositorio.RepositorioPerro;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = DemoApplication.class)
public class PerroRepositoryTest {

    @Autowired
    private RepositorioPerro perroRepository;

    @BeforeEach
    void init() {
        perroRepository.save(new Perro("lalala", 1, "Hermann", "Chiguagua", 5, true, 20.0, 1));
        perroRepository.save(new Perro("lalala", 2, "Chamo", "Pug", 3, false, 10.0, 2));
    }

    @Test
    public void PerroRepository_save_Perro() {

        Perro perro = new Perro("lalala", 2, "Nico", "German Shepherd", 4, true, 30.0, 3);

        Perro savedPerro = perroRepository.save(perro);

        Assertions.assertThat(savedPerro).isNotNull();
    }

    @Test
    public void PerroRepository_FindAll_NotEmptyList() {

        List<Perro> perros = perroRepository.findAll();

        Assertions.assertThat(perros).isNotNull();

        Assertions.assertThat(perros.size()).isGreaterThan(0);
    }

    @Test
    public void delete() {

        // Arrange
        long id = 1;

        // Act
        perroRepository.deleteById(id);

        // Assert
        Assertions.assertThat(perroRepository.findById(id)).isEmpty();
    }

    @Test
    public void update_ByName() {

        // Arrange
        Long id = 1L;
        String nombre = "Alejandro";

        // Act
        Perro perro = perroRepository.findById(id).get();
        perro.setNombre(nombre);
        Perro perroActualizado = perroRepository.save(perro);

        Assertions.assertThat(perro.getNombre()).isEqualTo(nombre);
        Assertions.assertThat(perroActualizado.getNombre()).isEqualTo("Alejandro");

    }

    @Test
    public void PerroRepository_findById_FindWrongIndex() {

        Long index = -1L;

        Optional<Perro> perro = perroRepository.findById(index);

        Assertions.assertThat(perro).isEmpty();
    }

    @Test
    public void PerroRepository_deleteById_EmptyPerro() {

        Long index = 1L;

        perroRepository.deleteById(index);

        Assertions.assertThat(perroRepository.findById(index)).isEmpty();
    }

    // ! Consulta creada por nosotros
    @Test
    public void countMascotasActivas_returnsCorrectCount() {

        Long count = perroRepository.countMascotasActivas();

        Assertions.assertThat(count).isEqualTo(1L);
    }

    // ! Consulta creada por nosotros
    @Test
    public void PerroRepository_sumarVentasDePerrosConTratamientos_returnsCorrectSum() {

        Double sum = perroRepository.sumarVentasDePerrosConTratamientos();

        Assertions.assertThat(sum).isNull();
    }

}
