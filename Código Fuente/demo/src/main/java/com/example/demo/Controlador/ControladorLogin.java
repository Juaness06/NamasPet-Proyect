package com.example.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;
import com.example.demo.Servicio.ClienteService;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/login")
@Controller
public class ControladorLogin {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/cliente")
    public String Login() {
        return "LogIn";
    }

    @PostMapping("/cliente")
    public String Login(
            @RequestParam("Usuario") String Usuario,
            @RequestParam("Contrasena") String contrasena) {
        Cliente a = clienteService.Cuenta(Usuario, contrasena);
        if (a != null) {
            return "redirect:/perro/search/" + a.getCedula();
        } else {
            throw new NotFoundException(Usuario, contrasena);   
        }
    }

}
