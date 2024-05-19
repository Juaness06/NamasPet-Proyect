package com.example.demo.DTO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.demo.Entidad.Veterinario;

@Mapper
public interface VeterinarioMapper {
    VeterinarioMapper INSTANCE = Mappers.getMapper(VeterinarioMapper.class);

    VeterinarioDTO convert(Veterinario veterinario);
    Veterinario convert(VeterinarioDTO veterinarioDTO);
}
