package com.example.demo.DTO;

import com.example.demo.Entidad.Veterinario;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-19T16:34:53-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class VeterinarioMapperImpl implements VeterinarioMapper {

    @Override
    public VeterinarioDTO convert(Veterinario veterinario) {
        if ( veterinario == null ) {
            return null;
        }

        VeterinarioDTO veterinarioDTO = new VeterinarioDTO();

        veterinarioDTO.setActivo( veterinario.isActivo() );
        veterinarioDTO.setAtenciones( veterinario.getAtenciones() );
        veterinarioDTO.setEspecialidad( veterinario.getEspecialidad() );
        veterinarioDTO.setFoto( veterinario.getFoto() );
        veterinarioDTO.setId( veterinario.getId() );
        veterinarioDTO.setNombre( veterinario.getNombre() );

        return veterinarioDTO;
    }

    @Override
    public Veterinario convert(VeterinarioDTO veterinarioDTO) {
        if ( veterinarioDTO == null ) {
            return null;
        }

        Veterinario.VeterinarioBuilder veterinario = Veterinario.builder();

        veterinario.activo( veterinarioDTO.isActivo() );
        veterinario.atenciones( veterinarioDTO.getAtenciones() );
        veterinario.especialidad( veterinarioDTO.getEspecialidad() );
        veterinario.foto( veterinarioDTO.getFoto() );
        veterinario.id( veterinarioDTO.getId() );
        veterinario.nombre( veterinarioDTO.getNombre() );

        return veterinario.build();
    }
}
