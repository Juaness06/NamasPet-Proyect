package com.example.demo.DTO;

import com.example.demo.Entidad.Cliente;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-19T16:34:16-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDTO convert(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setCedula( cliente.getCedula() );
        clienteDTO.setCelular( cliente.getCelular() );
        clienteDTO.setCorreo( cliente.getCorreo() );
        clienteDTO.setNombre( cliente.getNombre() );
        clienteDTO.setUsuario( cliente.getUsuario() );

        return clienteDTO;
    }

    @Override
    public Cliente convert(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setCedula( clienteDTO.getCedula() );
        cliente.setCelular( clienteDTO.getCelular() );
        cliente.setCorreo( clienteDTO.getCorreo() );
        cliente.setNombre( clienteDTO.getNombre() );
        cliente.setUsuario( clienteDTO.getUsuario() );

        return cliente;
    }
}
