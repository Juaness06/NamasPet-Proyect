package com.example.demo.Controlador;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControler {

    @ExceptionHandler(NotFoundException.class)
    public String error(Model model, NotFoundException ex) {
        
        model.addAttribute("id", ex.getId());

        return ("ErrorPage");
    }


    public String error2(Model model, NotFoundException ex) {
        
        model.addAttribute("cedula", ex.getCedula());
        return ("ErrorPage");
    }


}
