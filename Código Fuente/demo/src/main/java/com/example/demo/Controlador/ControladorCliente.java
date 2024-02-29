package com.example.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Servicio.ClienteService;
import com.example.demo.Servicio.ServicioPerro;

import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/cliente")
@Controller
public class ControladorCliente {

    @Autowired
    private ClienteService servicioCliente;
    @Autowired
    private ServicioPerro servicioPerro;

    // http://localhost:8090/cliente/all
    @GetMapping("/all")
    public String mostrarPerros(Model model) {
        model.addAttribute("cliente", servicioCliente.SearchAll());
        return "ListaClientes";
    }

    // http://localhost:8090/cliente/find/1
    @GetMapping("/find/{cedula}")
    public String mostrarinfoPerro(Model model, @PathVariable("cedula") int cedula) {

        model.addAttribute("cliente", servicioCliente.SearchById(cedula));
        return "MostrarPerro"; // nueva pagina granni
    }

    // http://localhost:8090/cliente/targeton
    @GetMapping("/targeton")
    public String TmostrarPerros(Model model) {
        model.addAttribute("cliente", servicioCliente.SearchAll());
        return "MostrarPerros"; // nueva pagina de granni
    }

    // http://localhost:8090/cliente/index
    @GetMapping("/index")
    public String index() {
        return "LandingPage";
    }

    // http://localhost:8090/cliente/add
    @GetMapping("/add")
    public String MostrarFormularioAdd(Model model) {
        Cliente cliente = new Cliente(0, "", "", 0, "", "");
        model.addAttribute("cliente", cliente);

        return "RegistrarCliente"; // esto se debe cambiar dependiendo como granni llame la pagina paa crear
    }

    @PostMapping("/agregar")
    public String AgregarPerro(@ModelAttribute("cliente") Cliente cliente) {

        servicioCliente.Add(cliente);
        return "redirect:/cliente/all"; // mirar bien esto
    }

    @GetMapping("/delete/{cedula}")
    public String BorrarPerro(@PathVariable("cedula") int id) {
        {
            servicioCliente.DeleteByID(id);
            return "redirect:/cliente/all";
        }

    }

    @GetMapping("/edit/{cedula}")
    public String modificarCliente(@PathVariable("cedula") int cedula, Model model) {
        model.addAttribute("cliente", servicioCliente.SearchById(cedula));
        return "ModificarCliente";
    }

    @PostMapping("/edit/{cedula}")
    public String UpdateCliente(@PathVariable("cedula") int cedula, @ModelAttribute("cliente") Cliente cliente) {
        servicioCliente.Update(cliente);
        return "redirect:/cliente/all";
    }
    @GetMapping("/{cedula}/mascotas")
    public String PerrosClientePerros(@PathVariable("cedula") int cedula, Model model) {
        model.addAttribute("cliente", servicioCliente.SearchById(cedula));
        model.addAttribute("perros", servicioPerro.PerrosClientePerros(cedula));
        return "MostrarPerrosCliente";

    }
    // http://localhost:8090/cliente/Login
    


}
