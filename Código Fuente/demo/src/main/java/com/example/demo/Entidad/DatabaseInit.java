package com.example.demo.Entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import java.util.concurrent.ThreadLocalRandom;
import com.example.demo.Repositorio.ReporsitorioCliente;
import com.example.demo.Repositorio.RepositorioPerro;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    ReporsitorioCliente repo;

    @Autowired
    RepositorioPerro repo2;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String[] nombresClientes = { "Ana", "Beatriz", "Carlos", "David", "Elena", "Fernando", "Gabriela", "Héctor",
                "Irene", "Jorge", "Alejandro", "Bruno", "Daniel", "Eduardo", "Francisco",
                "Guillermo", "Hugo", "Íñigo", "Joaquín", "Leonardo",
                "Manuel", "Nicolás", "Óscar", "Pablo", "Quentin",
                "Ricardo", "Sergio", "Tomás", "Víctor", "Xavier", "Alicia", "Beatriz", "Carmen", "Diana", "Estefanía",
                "Fernanda", "Gloria", "Helena", "Isabel", "Julia",
                "Karen", "Laura", "Marta", "Natalia", "Olivia",
                "Patricia", "Raquel", "Sonia", "Teresa", "Úrsula",
                "Valeria", "Wendy", "Ximena", "Yolanda", "Zoe" };

        String[] apellidos = { "González", "Rodríguez", "Martínez", "Sánchez", "Pérez", "López", "García", "Díaz",
                "Vásquez", "Jiménez", "Álvarez", "Benítez", "Camacho", "Domínguez", "Espinoza",
                "Fuentes", "Gutiérrez", "Hernández", "Ibarra", "Juárez",
                "Klein", "Lugo", "Mendoza", "Navarro", "Ochoa",
                "Paredes", "Quiroz", "Reyes", "Soto", "Torres",
                "Ureña", "Varela", "Zamora", "Quiñones", "Yáñez",
                "Zúñiga", "Aguirre", "Barrera", "Casanova", "Díaz", };
        String[] apodos = {
                "Lobo", "Doc", "Chispa", "Roca", "Príncipe", "Reina", "Azul", "Oso", "Halcón",
                "Fantasma", "Tigre", "Blaze", "Ace", "Shadow", "Gadget", "Flash", "Wolf", "Duke",
                "Vikingo", "Pirata", "Ninja", "Samurai", "Wizard", "Spartan", "Phantom", "Ranger",
                "Cazador", "Jazz", "King", "Knight", "Lightning", "Maverick", "Nomad", "Phoenix",
                "Quantum", "Rocket", "Saber", "Tank", "Vortex", "Zen", "Archer", "Bolt", "Cyborg",
                "Drift", "Echo", "Flame", "Glitch", "Hawk", "Iron", "Jester"
        };

        for (int i = 1; i <= 50; i++) {
            String nombre = nombresClientes[i % nombresClientes.length] + " " + apellidos[i % apellidos.length];
            String email = nombresClientes[i % nombresClientes.length] + apellidos[i % apellidos.length] + i
                    + "@gmail.com";
            long telefono = 30000000L + i;
            String usuario = apodos[i % apodos.length] + i;
            String contraseña = "" + i;

            Cliente cliente = new Cliente(nombre, email, telefono, usuario, contraseña);
            repo.save(cliente);
        }

        String[] nombresPerros = {
                "Max", "Bella", "Charlie", "Luna", "Rocky", "Molly", "Toby", "Lucy", "Coco", "Bailey",
                "Daisy", "Oliver", "Sadie", "Maggie", "Buddy", "Oscar", "Lola", "Winston", "Ruby", "Bear",
                "Duke", "Penny", "Zoe", "Jack", "Ellie", "Riley", "Dexter", "Rosie", "Louie", "Mia",
                "Baxter", "Stella", "Gus", "Ivy", "Murphy", "Piper", "Leo", "Lily", "Benny", "Sophie",
                "Harley", "Milo", "Jasper", "Emma", "Tucker", "Ziggy", "Hugo", "Lulu", "Brady", "Lady",
                "Sam", "Fiona", "Otis", "Chloe", "Marley", "Scout", "Gigi", "Ollie", "Gracie", "George"
        };
        
        String[] razas = { "Labrador", "Bulldog", "Beagle", "Poodle", "Boxer", "Dálmata", "Pastor Alemán",
                "Golden Retriever", "Husky Siberiano", "Chihuahua" };

        for (int i = 1; i <= 50; i++) {
            String urlImagen = "URL de imagen genérica aquí";
            String nombre = nombresPerros[i % nombresPerros.length];
            int id = i;
            String raza = razas[i % razas.length];
            int edad = ThreadLocalRandom.current().nextInt(1, 16);
            ;
            boolean sexo = i % 2 == 0;
            double pesoRaw = 5.0 + (40.0 - 5.0) * ThreadLocalRandom.current().nextDouble();
            double peso = Math.round(pesoRaw * 10) / 10.0;
            int energia = (i % 3) + 1;

            Perro perro = new Perro(urlImagen, nombre, id, raza, edad, sexo, peso, energia);
            repo2.save(perro);
        }

        Cliente asociar = repo.findById(1L).orElse(null);
        if (asociar != null) {
            for (Perro perro : repo2.findAll()) {
                perro.setCliente(asociar);
                repo2.save(perro);
            }
        }
    }

}
