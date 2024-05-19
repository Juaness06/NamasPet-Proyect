package com.example.demo.Security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Administrador;
import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Role;
import com.example.demo.Entidad.UserEntity;
import com.example.demo.Entidad.Veterinario;
import com.example.demo.Repositorio.RoleRepository;
import com.example.demo.Repositorio.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userDB = userRepository.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("User not found")
        );
        return new User(userDB.getUsername(),
                        userDB.getPassword(),
                        mapRolesToAuthorities(userDB.getRoles()));
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());
    }

    public UserEntity saveCliente(Cliente cliente) {
        UserEntity user = new UserEntity();
        user.setUsername(cliente.getCorreo());
        user.setPassword(passwordEncoder.encode("123"));
        Role role = roleRepository.findByName("CLIENTE").get();
        user.setRoles(List.of(role));
        return userRepository.save(user);
    }

    public UserEntity saveVeterinario(Veterinario veterinario) {
        UserEntity user = new UserEntity();
        user.setUsername(veterinario.getNombre());
        user.setPassword(passwordEncoder.encode(veterinario.getContrasena()));
        Role role = roleRepository.findByName("VETERINARIO").get();
        user.setRoles(List.of(role));
        return userRepository.save(user);
    }

    public UserEntity saveAdmin(Administrador administrador) {
        UserEntity user = new UserEntity();
        user.setUsername(administrador.getNombre());
        user.setPassword(passwordEncoder.encode(administrador.getContrasena()));
        Role role = roleRepository.findByName("ADMINISTRADOR").get();
        user.setRoles(List.of(role));
        return userRepository.save(user);
    }
}
