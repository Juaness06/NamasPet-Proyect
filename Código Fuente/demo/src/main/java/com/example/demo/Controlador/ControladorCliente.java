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




import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/cliente")
@Controller
public class ControladorCliente {

    @Autowired
    private ClienteService servicioCliente;

    // http://localhost:8090/cliente/all
    @GetMapping("/all")
    public String mostrarPerros(Model model) {
        model.addAttribute("Clientes", servicioCliente.SearchAll());
        return "ListaPerros";
    }

    // http://localhost:8090/cliente/find/1
    @GetMapping("/find/{id}")
    public String mostrarinfoPerro(Model model, @PathVariable("id") int id) {

        model.addAttribute("cliente", servicioCliente.SearchById(id));
        return "MostrarPerro"; //nueva pagina granni
    }

    // http://localhost:8090/cliente/targeton
    @GetMapping("/targeton")
    public String TmostrarPerros(Model model) {
        model.addAttribute("clientes", servicioCliente.SearchAll());
        return "MostrarPerros"; //  nueva pagina de granni
    }

    // http://localhost:8090/cliente/index
    @GetMapping("/index")
    public String index() {
        return "LandingPage";	
    }

    // http://localhost:8090/cliente/add
    @GetMapping("/add")
    public String MostrarFormularioAdd(Model model) {
        Cliente cliente = new Cliente(0,"","","");
        model.addAttribute("cliente", cliente);


        return "AddPerro"; //esto se debe cambiar dependiendo como granni llame la pagina paa crear
    }
    
    @PostMapping("/agregar")
    public String AgregarPerro(@ModelAttribute("cliente") Cliente cliente) {
    

        servicioCliente.Add(cliente);
        return "Redirect:/cliente/all"; //mirar bien esto
    }
    
    @GetMapping("/delete/{id}")
    public String BorrarPerro(@PathVariable("id") int id){ {
        servicioCliente.DeleteByID(id);
        return "Redirect:/cliente/all"; // pagina Faltante
    }
    
    }

    @GetMapping("/update/{id}")
    public String UpdatePerro(@PathVariable("id") int id, @ModelAttribute("cliente") Cliente cliente) {
        servicioCliente.Update(cliente);
        return "Redirect:/cliente/all"; // pagina faltante
    }
}
