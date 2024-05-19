package com.example.demo.DTO;

import lombok.Data;

@Data
public class VeterinarioDTO {
    private long id;
    private String nombre;
    private String especialidad;
    private int atenciones;
    private String foto;
    private boolean activo;
}
