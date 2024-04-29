package com.example.demo.service;

import static org.mockito.Mockito.when;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.Entidad.Perro;
import com.example.demo.Repositorio.RepositorioPerro;
import com.example.demo.Servicio.PerroServicempl;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ServicioPerroTest {


@Mock
private RepositorioPerro repocitorioPerro;


@InjectMocks
private PerroServicempl perroServicempl;

@BeforeEach
    public void init(){
        
    }

    @Test
    public void add(){

        //arange

        Perro perro = new Perro("lalala", "Cocco", 1, "Border Collie", 5, true, 5.5, 1);

        when(repocitorioPerro.save(perro)).thenReturn(perro);

        //act
        Perro newperro = perroServicempl.Add(perro);


        //assert
        Assertions.assertThat(newperro).isNotNull();
    
    }

    @Test
    public void findAll() {
        //arange
        when(repocitorioPerro.findAll()).thenReturn(
            List.of(
                new Perro("lalala", "Cocco", 1, "Border Collie", 5, true, 5.5, 1),
                new Perro( "becky", "becky", 1, "pug", 5, true, 5.5, 1)
            )
        );

        List <Perro> perros = perroServicempl.SearchAll();


        //assert
        Assertions.assertThat(perros).isNotNull();
        Assertions.assertThat(perros.size()).isEqualTo(2);

    }

    @Test
    public void findById() {
        // Arrange
        long id = 1;
        Perro expectedPerro = new Perro("lalala", "Cocco", 1, "Border Collie", 5, true, 5.5, 1);
        when(repocitorioPerro.findById(id)).thenReturn(Optional.of(expectedPerro));

        // Act
        Perro foundPerro = perroServicempl.SearchById(id);

        // Assert
        Assertions.assertThat(foundPerro).isNotNull();
        Assertions.assertThat(foundPerro.getId()).isEqualTo(id);
        Assertions.assertThat(foundPerro.getNombre()).isEqualTo("Cocco");
    }
    
}
