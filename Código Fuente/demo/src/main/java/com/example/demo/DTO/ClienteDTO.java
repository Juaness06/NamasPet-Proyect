package com.example.demo.DTO;

import lombok.Data;

@Data
public class ClienteDTO {
    private long cedula;
    private String nombre;
    private String correo;
    private long celular;
    private String usuario;
}
