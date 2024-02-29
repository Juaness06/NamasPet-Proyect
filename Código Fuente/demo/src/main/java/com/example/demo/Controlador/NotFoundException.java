package com.example.demo.Controlador;

public class NotFoundException extends RuntimeException {

    private int id;
    private int cedula;

    public NotFoundException(int id){
        this.id = id;
    }


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getCedula() {
        return cedula;
    }
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
   
    
    

}
