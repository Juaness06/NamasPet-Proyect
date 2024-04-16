package com.example.demo.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;
import com.example.demo.Servicio.ClienteService;

@RequestMapping("/cliente") // url para acceder a esta clase
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorCliente {

    @Autowired
    private ClienteService servicioCliente;

    // http://localhost:8090/cliente/all
    @GetMapping("/all")
    public List<Cliente> MostrarClientes(Model model) {
        /*
         * model.addAttribute("cliente", servicioCliente.SearchAll());
         * return "ListaClientes";
         */
        return servicioCliente.SearchAll();
    }

    // http://localhost:8090/cliente/find/1
    @GetMapping("/find/{cedula}")
    public Cliente MostrarInfoClientes(@PathVariable("cedula") long cedula) {

        Cliente cliente = servicioCliente.SearchById(cedula);

        return cliente;
    }

    // http://localhost:8090/cliente/add
    @PostMapping("/add")
    public void RegistrarCliente(@RequestBody Cliente cliente) {
        servicioCliente.Add(cliente);
    }

    @DeleteMapping("/delete/{cedula}")
    public void BorrarCliente(@PathVariable("cedula") long id) {
        {
            servicioCliente.deleteById(id);
        }

    }

    // http://localhost:8090/cliente/edit/{cedula}
    @PutMapping("/edit/{cedula}") // editar cliente con este id para post
    public void UpdateCliente(@RequestBody Cliente cliente,@PathVariable("cedula") long id) {
        
        servicioCliente.Update(cliente);
    }

    // http://localhost:8090/cliente/{cedula}/mascotas
    @GetMapping("/{cedula}/mascotas") // mostrar los perros del cliente
    public List<Perro> obtenerPerrosDelCliente(@PathVariable("cedula") long cedula) {
        return servicioCliente.PerrosClientePerros(cedula);
    }

}
