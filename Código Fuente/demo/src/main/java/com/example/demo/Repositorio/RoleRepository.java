package com.example.demo.Repositorio;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entidad.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
