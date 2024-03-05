package com.example.demo.Entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.Random;
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
         Random rand = new Random();

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

        for (int i = 1; i <= 100; i++) {
            String nombre = nombresClientes[i % nombresClientes.length] + " " + apellidos[i % apellidos.length];
            String email = nombresClientes[i % nombresClientes.length] + apellidos[i % apellidos.length] + i
                    + "@gmail.com";
            long telefono = rand.nextInt(10000000) + 30000000;;
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

        String[] imagenes = {"https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                             "https://www.elespectador.com/resizer/9wg8wmcFdXfCJjTdEiLaBGlYNyI=/910x606/filters:quality(70):format(jpeg)/cloudfront-us-east-1.images.arcpublishing.com/elespectador/B2XZEEBCNFFBBNXJSFH3TO2GBI.jpg",
                             "https://hips.hearstapps.com/hmg-prod/images/beagle-running-on-field-royalty-free-image-1619098658.?crop=1.00xw:0.666xh;0,0.334xh&resize=980:*",
                             "https://heraldodemexico.com.mx/wp-content/uploads/2020/06/caniche-1-1-1200x829.jpg",
                             "https://t2.ea.ltmcdn.com/es/posts/4/3/2/como_educar_un_perro_boxer_20234_600.jpg",
                             "https://www.purina.es/sites/default/files/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-07Dalmatian.jpg?itok=nG-oiSzU",
                             "https://www.aon.es/personales/seguro-perro-gato/wp-content/uploads/sites/2/2021/06/pastor-aleman-3.jpg",
                             "https://www.zooplus.es/magazine/wp-content/uploads/2019/04/golden-retriever-dog-breed-1-768x546.jpg",
                             "https://www.hogarmania.com/archivos/202303/husky-siberiano-416x236x80xX-1.jpg",
                             "https://estaticos-cdn.prensaiberica.es/clip/59ca56ec-1332-4c33-a2eb-6ef863b65a56_alta-libre-aspect-ratio_default_0.jpg"};

        for (int i = 1; i <= 100; i++) {
            String urlImagen = imagenes[i % imagenes.length];
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


       /*
        Cliente asociar = repo.findById(1L).orElse(null);
        if (asociar != null) {
            for (Perro perro : repo2.findAll()) {
                perro.setCliente(asociar);
                repo2.save(perro);
            }
        }
        */

        for(int i = 1;i<= 100;i++){
                Perro m = repo2.findById((long)i).get();
                m.setCliente(repo.findById((long)i).get());
                repo2.save(m);
        }
    }

}
