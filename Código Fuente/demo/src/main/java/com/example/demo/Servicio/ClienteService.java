package com.example.demo.Servicio;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;
import java.util.List;

public interface ClienteService {
    Cliente SearchById(Long id);
    List<Cliente> SearchAll();
    Cliente Add(Cliente p);
    void deleteById(Long id);
    Cliente Update(Cliente p);
    Cliente Cuenta(Long cedula);
    List<Perro> PerrosClientePerros(long cedula);
    Cliente findByCorreo(String correo);  // Método para encontrar cliente por correo
}
