package com.example.demo.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Entidad.Veterinario;
import com.example.demo.Repositorio.ReporsitorioVeterinario;

@DataJpaTest
@RunWith(SpringRunner.class)
public class VeterinarioRepositoryTest {

    @Autowired
    private ReporsitorioVeterinario veterinarioRepository;

    @BeforeEach
    public void init() {
        veterinarioRepository.save(new Veterinario("Juan", "1234", "Dogtor", 10, "lala", true));
        veterinarioRepository.save(new Veterinario("Pedro", "1234", "Dogtor", 10, "lala", false));
    }

    //! Consulta creada por nosotros
    @Test
    public void veterinarioRepository_countVeterinarios_Activos() {

        Long count = veterinarioRepository.countVeterinariosActivos();

        Assertions.assertThat(count).isEqualTo(1L);
        
    }

    //! Consulta creada por nosotros
    @Test
    public void veterinarioRepository_countVeterinarios_Inactivos() {

        Long count = veterinarioRepository.countVeterinariosInactivos();

        Assertions.assertThat(count).isEqualTo(1L);
    }

    //! Consulta creada por nosotros
    @Test
    public void veterinarioRepository_findByIdAndContrasena() {

        String contrasena = "1234";

        Assertions.assertThat(veterinarioRepository.findByIdAndContrasena(1, contrasena)).isNotNull();

    }

}
