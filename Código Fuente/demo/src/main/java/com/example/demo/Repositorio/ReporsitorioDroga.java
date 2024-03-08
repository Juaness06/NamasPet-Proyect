package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidad.Droga;

public interface ReporsitorioDroga extends JpaRepository<Droga, Long> {
    
}
