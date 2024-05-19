package com.example.demo.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.DTO.ClienteDTO;
import com.example.demo.DTO.ClienteMapper;
import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;
import com.example.demo.Entidad.UserEntity;
import com.example.demo.Repositorio.UserRepository;
import com.example.demo.Security.CustomUserDetailService;
import com.example.demo.Servicio.ClienteService;

@RequestMapping("/cliente")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorCliente {

    @Autowired
    private ClienteService servicioCliente;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    // http://localhost:8090/cliente/all
    @GetMapping("/all")
    public  ResponseEntity<List<Cliente>> MostrarClientes() {
        List<Cliente> lista = servicioCliente.SearchAll();

        ResponseEntity<List<Cliente>> response = new ResponseEntity<>(lista, HttpStatus.OK);
        return response;
    }

    // http://localhost:8090/cliente/find/{cedula}
    @GetMapping("/find/{cedula}")
    public ResponseEntity<ClienteDTO> MostrarInfoClientes(@PathVariable("cedula") long cedula) {
        Cliente cliente = servicioCliente.SearchById(cedula);
        if (cliente != null) {
            ClienteDTO clienteDTO = ClienteMapper.INSTANCE.convert(cliente);
            return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // http://localhost:8090/cliente/add
    @PostMapping("/add")
    public ResponseEntity RegistrarCliente(@RequestBody Cliente cliente) {
        if (userRepository.existsByUsername(cliente.getCorreo())) {
            return new ResponseEntity<>("Este usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        UserEntity userEntity = customUserDetailService.saveCliente(cliente);
        cliente.setUser(userEntity);
        Cliente clienteDB = servicioCliente.Add(cliente);
        ClienteDTO newCliente = ClienteMapper.INSTANCE.convert(clienteDB);
        if (newCliente == null) {
            return new ResponseEntity<ClienteDTO>(newCliente,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ClienteDTO>(newCliente, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{cedula}")
    public ResponseEntity<Void> BorrarCliente(@PathVariable("cedula") long id) {
        servicioCliente.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // http://localhost:8090/cliente/edit/{cedula}
    @PutMapping("/edit/{cedula}")
    public ResponseEntity<ClienteDTO> UpdateCliente(@RequestBody ClienteDTO clienteDTO, @PathVariable("cedula") long id) {
        Cliente cliente = ClienteMapper.INSTANCE.convert(clienteDTO);
        cliente.setCedula(id);
        Cliente clienteActualizado = servicioCliente.Update(cliente);
        ClienteDTO clienteActualizadoDTO = ClienteMapper.INSTANCE.convert(clienteActualizado);
        return new ResponseEntity<>(clienteActualizadoDTO, HttpStatus.OK);
    }

    // http://localhost:8090/cliente/{cedula}/mascotas
    @GetMapping("/{cedula}/mascotas")
    public ResponseEntity<List<Perro>> obtenerPerrosDelCliente(@PathVariable("cedula") long cedula) {
        List<Perro> perros = servicioCliente.PerrosClientePerros(cedula);
        return new ResponseEntity<>(perros, HttpStatus.OK);
    }
}
