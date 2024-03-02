package com.example.demo.Controlador;

import java.util.Collection; // Asegúrate de que esta es la importación que estás usando
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;
import com.example.demo.Servicio.ClienteService;
import com.example.demo.Servicio.ServicioPerro;



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
    public String mostrarinfoPerro(Model model, @PathVariable("cedula")long cedula) {

        Cliente cliente= servicioCliente.SearchById(cedula);

        if (cliente != null) {
            model.addAttribute("cliente", servicioCliente.SearchById(cedula));
        }

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
        Cliente cliente = new Cliente( "", "", 0, "", "");
        model.addAttribute("cliente", cliente);

        return "RegistrarCliente"; // esto se debe cambiar dependiendo como granni llame la pagina paa crear
    }

    @PostMapping("/agregar")
    public String AgregarPerro(@ModelAttribute("cliente") Cliente cliente) {

        servicioCliente.Add(cliente);
        return "redirect:/cliente/all"; // mirar bien esto
    }

    

    @GetMapping("/delete/{cedula}")
    public String BorrarPerro(@PathVariable("cedula") long id) {
        {
            servicioCliente.deleteById(id);
            return "redirect:/cliente/all";
        }

    }

    @GetMapping("/edit/{cedula}")
    public String modificarCliente(@PathVariable("cedula") long cedula, Model model) {
        model.addAttribute("cliente", servicioCliente.SearchById(cedula));
        return "ModificarCliente";
    }

    @PostMapping("/edit/{cedula}")
    public String UpdateCliente(@PathVariable("cedula") long cedula, @ModelAttribute("cliente") Cliente cliente) {
        servicioCliente.Update(cliente);
        return "redirect:/cliente/all";
    }



    
    @GetMapping("/{cedula}/mascotas")
public String PerrosClientePerros(@PathVariable("cedula") long cedula, Model model) {
    Cliente cliente = servicioCliente.SearchById(cedula);
    if (cliente != null) {
        Collection<Perro> perros = servicioCliente.PerrosClientePerros(cedula);
        model.addAttribute("cliente", cliente);
        model.addAttribute("perros", perros);
    }
    return "MostrarPerrosCliente";
}


    // http://localhost:8090/cliente/Login
    


    /*
 @GetMapping("/cliente/{cedula}/perros")
    public String mostrarPerrosDelCliente(@PathVariable("cedula") long cedula, Model model) {
        Collection<Perro> perros = servicioCliente.PerrosClientePerros(cedula);
        model.addAttribute("perros", perros);
        return "lista-perros"; // Nombre de la plantilla HTML que mostrará los perros
    }
    */

}
