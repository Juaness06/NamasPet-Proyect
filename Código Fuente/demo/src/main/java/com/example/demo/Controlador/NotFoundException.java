package com.example.demo.Controlador;

public class NotFoundException extends RuntimeException {

    private long id;
    private long cedula;

    public NotFoundException(long cedula2){
        this.id = cedula2;
    }


    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }
    public long getCedula() {
        return cedula;
    }
    public void setCedula(long cedula) {
        this.cedula = cedula;
    }
   
    
    

}
