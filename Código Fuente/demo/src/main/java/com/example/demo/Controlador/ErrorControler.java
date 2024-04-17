package com.example.demo.Controlador;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControler {

    @ExceptionHandler(NotFoundException.class) // manejo de excepciones
    public String error(Model model, NotFoundException ex) {

        model.addAttribute("id", ex.getId());
        // muestra pagina de errror
        return ("ErrorPage");
    }

    public String error2(Model model, NotFoundException ex) { // redirección a la página de error

        model.addAttribute("cedula", ex.getCedula());
        return ("ErrorPage");
    }

}
