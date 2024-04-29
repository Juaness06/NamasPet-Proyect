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
        perroRepository.save(new Perro("Fido", 1, "Labrador", "Large", 5, true, 20.0, 1));
        perroRepository.save(new Perro("Buddy", 2, "Beagle", "Medium", 3, false, 10.0, 2));
    }

    @Test
    public void PerroRepository_save_Perro() {
        // Arrange
        Perro perro = new Perro("Rex", 3, "German Shepherd", "Large", 4, true, 30.0, 3);

        // Act
        Perro savedPerro = perroRepository.save(perro);

        // Assert
        Assertions.assertThat(savedPerro).isNotNull();
    }

    @Test
    public void PerroRepository_FindAll_NotEmptyList() {
        // Act
        List<Perro> perros = perroRepository.findAll();

        // Assert
        Assertions.assertThat(perros).isNotNull();
        Assertions.assertThat(perros.size()).isGreaterThan(0);
    }

    @Test
    public void PerroRepository_findById_FindWrongIndex() {
        // Arrange
        Long index = -1L;

        // Act
        Optional<Perro> perro = perroRepository.findById(index);

        // Assert
        Assertions.assertThat(perro).isEmpty();
    }

    @Test
    public void PerroRepository_deleteById_EmptyPerro() {
        // Arrange
        Long index = 1L;

        // Act
        perroRepository.deleteById(index);

        // Assert
        Assertions.assertThat(perroRepository.findById(index)).isEmpty();
    }

    @Test
    public void countMascotasActivas_returnsCorrectCount() {
        // Act
        Long count = perroRepository.countMascotasActivas();

        // Assert
        Assertions.assertThat(count).isEqualTo(2L);
    }
}
