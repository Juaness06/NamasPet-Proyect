package com.example.demo.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.DTO.VeterinarioDTO;
import com.example.demo.DTO.VeterinarioMapper;
import com.example.demo.Entidad.Veterinario;
import com.example.demo.Entidad.UserEntity;
import com.example.demo.Repositorio.UserRepository;
import com.example.demo.Security.CustomUserDetailService;
import com.example.demo.Security.JWTGenerator;
import com.example.demo.Servicio.ServicioVeterinario;

@RequestMapping("/veterinario")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorVeterinario {

    @Autowired
    private ServicioVeterinario servicioVeterinario;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JWTGenerator jwtGenerator;

    // Endpoint para mostrar todos los veterinarios
    @GetMapping("/all")
    public List<VeterinarioDTO> mostrarVeterinarios() {
        List<Veterinario> veterinarios = servicioVeterinario.SearchAll();
        return veterinarios.stream()
                .map(VeterinarioMapper.INSTANCE::convert)
                .toList();
    }

    // Endpoint para mostrar la información de un veterinario específico por su ID
    @GetMapping("/{id}")
    public ResponseEntity<VeterinarioDTO> mostrarInfoVeterinario(@PathVariable("id") long id) {
        Veterinario veterinario = servicioVeterinario.SearchById(id);
        if (veterinario != null) {
            VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinario);
            return new ResponseEntity<>(veterinarioDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para registrar un nuevo veterinario
    @PostMapping("/add")
    public ResponseEntity<?> registrarVeterinario(@RequestBody Veterinario veterinario) {
        if (userRepository.existsByUsername(veterinario.getNombre())) {
            return new ResponseEntity<>("Este usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        UserEntity userEntity = customUserDetailService.saveVeterinario(veterinario);
        veterinario.setUser(userEntity);
        Veterinario veterinarioDB = servicioVeterinario.Add(veterinario);
        VeterinarioDTO newVeterinario = VeterinarioMapper.INSTANCE.convert(veterinarioDB);
        if (newVeterinario == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newVeterinario, HttpStatus.CREATED);
    }

    // Endpoint para borrar un veterinario
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> borrarVeterinario(@PathVariable("id") long id) {
        servicioVeterinario.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint para actualizar la información de un veterinario
    @PutMapping("/editar/{id}")
    public ResponseEntity<VeterinarioDTO> actualizarVeterinario(@RequestBody VeterinarioDTO veterinarioDTO, @PathVariable("id") long id) {
        Veterinario veterinario = VeterinarioMapper.INSTANCE.convert(veterinarioDTO);
        veterinario.setId(id);
        Veterinario veterinarioActualizado = servicioVeterinario.Update(veterinario);
        VeterinarioDTO veterinarioActualizadoDTO = VeterinarioMapper.INSTANCE.convert(veterinarioActualizado);
        return new ResponseEntity<>(veterinarioActualizadoDTO, HttpStatus.OK);
    }

    @GetMapping("/activos")
    public ResponseEntity<Long> getVeterinariosActivosCount() {
        Long count = servicioVeterinario.getVeterinariosActivosCount();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/inactivos")
    public ResponseEntity<Long> getVeterinariosInactivosCount() {
        Long count = servicioVeterinario.getVeterinariosInactivosCount();
        return ResponseEntity.ok(count);
    }

    // Endpoint de login para el veterinario
    @PostMapping("/login")
    public ResponseEntity<String> loginVeterinario(@RequestBody Veterinario veterinario) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(veterinario.getNombre(), veterinario.getContrasena()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    // Endpoint para buscar veterinario por ID y contraseña
    @GetMapping("/findByIdAndContrasena/{id}/{contrasena}")
    public ResponseEntity<VeterinarioDTO> findByIdAndContrasena(@PathVariable int id, @PathVariable String contrasena) {
        Veterinario veterinario = servicioVeterinario.findByIdAndContrasena(id, contrasena);
        if (veterinario != null) {
            VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinario);
            return new ResponseEntity<>(veterinarioDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
