package com.example.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Servicio.ClienteService;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/login")
@Controller
public class ControladorLogin {

    @Autowired
    ClienteService clienteService;

    // http://localhost:8090/login
    @GetMapping("/cliente")
    public String Login() {
        return "LogIn";
    }

    // http://localhost:8090/login
    @PostMapping("/cliente") //post para enviar los datos a buscar al cliente
    public String Login( 
            @RequestParam("cedula") long cedula) {
        Cliente a = clienteService.Cuenta(cedula);
        if (a != null) {
            return "redirect:/cliente/" + a.getCedula() + "/mascotas";
        } else {
            throw new NotFoundException(cedula);
        }
    }

}
