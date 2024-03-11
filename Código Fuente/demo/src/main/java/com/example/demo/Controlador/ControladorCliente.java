package com.example.demo.Controlador;

import java.util.Collection; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;
import com.example.demo.Servicio.ClienteService;

@RequestMapping("/cliente") // url para acceder a esta clase
@Controller
public class ControladorCliente {

    @Autowired
    private ClienteService servicioCliente;

    // http://localhost:8090/cliente/all
    @GetMapping("/all")
    public String MostrarClientes(Model model) {
        model.addAttribute("cliente", servicioCliente.SearchAll());
        return "ListaClientes";
    }

    // http://localhost:8090/cliente/find/1
    @GetMapping("/find/{cedula}")
    public String MostrarInfoClientes(Model model, @PathVariable("cedula") long cedula) {

        Cliente cliente = servicioCliente.SearchById(cedula);

        if (cliente != null) { // si el cliente es diferente de null entonces busque al cliente por su cedula
            model.addAttribute("cliente", servicioCliente.SearchById(cedula));
        }

        return "MostrarPerro";
    }

    // http://localhost:8090/cliente/add
    @GetMapping("/add")
    public String RegistrarCliente(Model model) {
        Cliente cliente = new Cliente("", "", 0, "", ""); // añadir el cliente
        model.addAttribute("cliente", cliente);

        return "RegistrarCliente"; // esto se debe cambiar dependiendo como granni llame la pagina paa crear
    }

    @GetMapping("/delete/{cedula}")
    public String BorrarCliente(@PathVariable("cedula") long id) {
        {
            servicioCliente.deleteById(id);
            return "redirect:/cliente/all";
        }

    }

    // http://localhost:8090/cliente/edit/{cedula}
    @GetMapping("/edit/{cedula}") // editar cliente con este id para get
    public String ModificarCliente(@PathVariable("cedula") long cedula, Model model) {
        model.addAttribute("cliente", servicioCliente.SearchById(cedula));
        return "ModificarCliente";
    }

    @PostMapping("/edit/{cedula}") // editar cliente con este id para post
    public String UpdateCliente(@PathVariable("cedula") long cedula, @ModelAttribute("cliente") Cliente cliente) {
        servicioCliente.Update(cliente);
        return "redirect:/cliente/all";
    }

    // http://localhost:8090/cliente/{cedula}/mascotas
    @GetMapping("/{cedula}/mascotas") //mostrar los perros del cliente
    public String PerrosClientePerros(@PathVariable("cedula") long cedula, Model model) {
        Cliente cliente = servicioCliente.SearchById(cedula);
        if (cliente != null) {
            Collection<Perro> perros = servicioCliente.PerrosClientePerros(cedula);
            model.addAttribute("cliente", cliente);
            model.addAttribute("perros", perros);
        }
        return "MostrarPerrosCliente";
    }

}
