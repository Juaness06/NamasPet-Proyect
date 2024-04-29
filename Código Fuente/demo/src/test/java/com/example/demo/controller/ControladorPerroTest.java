package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.demo.Controlador.ControladorPerro;
import com.example.demo.Entidad.Perro;
import com.example.demo.Servicio.ServicioPerro;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@WebMvcTest(ControladorPerro.class)
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ControladorPerroTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicioPerro servicioPerro;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void mostrarPerros_returnsPerrosList() throws Exception {
        when(servicioPerro.SearchAll()).thenReturn(List.of(new Perro("Fido", 1, "Labrador", "Large", 5, true, 20.0, 1)));

        ResultActions response = mockMvc.perform(get("/perro/all"));

        response.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Fido"));
    }

    @Test
    public void mostrarinfoPerro_returnsPerroDetails() throws Exception {
        Perro perro = new Perro("Fido", 1, "Labrador", "Large", 5, true, 20.0, 1);
        when(servicioPerro.SearchById(1)).thenReturn(perro);

        ResultActions response = mockMvc.perform(get("/perro/find/{id}", 1));

        response.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Fido"));
    }

    @Test
    public void AgregarPerro_addsPerroAndReturnsStatus() throws Exception {
        Perro perro = new Perro("Fido", 1, "Labrador", "Large", 5, true, 20.0, 1);
        when(servicioPerro.Add(any(Perro.class))).thenReturn(perro);

        ResultActions response = mockMvc.perform(post("/perro/agregar/{cedula}", 123)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(perro)));

        response.andExpect(status().isOk());
    }

    @Test
    public void BorrarPerro_deletesPerroAndReturnsStatus() throws Exception {
        mockMvc.perform(delete("/perro/delete/{id}", 1))
               .andExpect(status().isOk());
    }
}
