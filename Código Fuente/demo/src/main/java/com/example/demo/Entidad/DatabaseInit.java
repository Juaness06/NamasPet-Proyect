package com.example.demo.Entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import com.example.demo.Repositorio.*;
import jakarta.transaction.Transactional;

@Controller
@Transactional
@Profile("default")
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    RepositorioCliente clienteR;

    @Autowired
    RepositorioPerro perroR;

    @Autowired
    ReporsitorioAdministrador admin;

    @Autowired
    ReporsitorioVeterinario vet;

    @Autowired
    ReporsitorioDroga drog;

    @Autowired
    RepositorioTratamientos tratamientoR;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Random rand = new Random();

        cargarDatosDesdeExcel();
        roleRepository.save(new Role("VETERINARIO"));
        roleRepository.save(new Role("ADMINISTRADOR"));
        roleRepository.save(new Role("CLIENTE"));

        // Añadir roles y usuarios
        CrearAdministrador();

        // Crear datos de ejemplo para clientes y perros
        crearClientes(rand); // Pasa rand como parámetro
        crearPerros(rand);   // Pasa rand como parámetro

        // Asignar perros a clientes
        asignarPerrosAClientes();

        // Crear veterinarios
        crearVeterinarios(rand); // Pasa rand como parámetro

        // Crear drogas
        crearDrogas();

        // Generar tratamientos
        generarTratamientos();
        asignarTratamientosExistente();
    }

    private void CrearAdministrador() {
        Administrador administrador = new Administrador("nico", passwordEncoder.encode("123456"));
        Administrador administrador2 = new Administrador("grani", passwordEncoder.encode("cafu"));
        UserEntity userEntity1 = saveUserAdmin(administrador);
        UserEntity userEntity2 = saveUserAdmin(administrador2);
        administrador.setUser(userEntity1);
        administrador2.setUser(userEntity2);
        admin.save(administrador);
        admin.save(administrador2);
    }

    private void crearClientes(Random rand) {
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
            long telefono = rand.nextInt(10000000) + 30000000;
            String usuario = apodos[i % apodos.length] + i;
            String contraseña = "" + i;

            Cliente cliente = new Cliente(nombre, email, telefono, usuario, passwordEncoder.encode(contraseña));
            UserEntity userEntity = saveUserClient(cliente);
            cliente.setUser(userEntity);
            clienteR.save(cliente);
        }
    }

    private void crearPerros(Random rand) {
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

        String[] imagenes = {
                "https://labradoresdeabantueso.com/wp-content/uploads/2023/09/Foto-Labrador-1-Guia-min.jpg",
                "https://www.elespectador.com/resizer/9wg8wmcFdXfCJjTdEiLaBGlYNyI=/910x606/filters:quality(70):format(jpeg)/cloudfront-us-east-1.images.arcpublishing.com/elespectador/B2XZEEBCNFFBBNXJSFH3TO2GBI.jpg",
                "https://hips.hearstapps.com/hmg-prod/images/beagle-running-on-field-royalty-free-image-1619098658.?crop=1.00xw:0.666xh;0,0.334xh&resize=980:*",
                "https://heraldodemexico.com.mx/wp-content/uploads/2020/06/caniche-1-1-1200x829.jpg",
                "https://t2.ea.ltmcdn.com/es/posts/4/3/2/como_educar_un_perro_boxer_20234_600.jpg",
                "https://www.purina.es/sites/default/files/2024-02/sitesdefaultfilesstylessquare_medium_440x440public2022-07Dalmatian.jpg?itok=nG-oiSzU",
                "https://www.aon.es/personales/seguro-perro-gato/wp-content/uploads/sites/2/2021/06/pastor-aleman-3.jpg",
                "https://www.zooplus.es/magazine/wp-content/uploads/2019/04/golden-retriever-dog-breed-1-768x546.jpg",
                "https://www.hogarmania.com/archivos/202303/husky-siberiano-416x236x80xX-1.jpg",
                "https://estaticos-cdn.prensaiberica.es/clip/59ca56ec-1332-4c33-a2eb-6ef863b65a56_alta-libre-aspect-ratio_default_0.jpg" };

        for (int i = 1; i <= 100; i++) {
            String urlImagen = imagenes[i % imagenes.length];
            String nombre = nombresPerros[i % nombresPerros.length];
            String raza = razas[i % razas.length];
            int edad = ThreadLocalRandom.current().nextInt(1, 16);
            boolean actividad = true;
            double pesoRaw = 5.0 + (40.0 - 5.0) * ThreadLocalRandom.current().nextDouble();
            double peso = Math.round(pesoRaw * 10) / 10.0;
            int numeroAtenciones = (i % 3) + 1;

            Perro perro = new Perro(urlImagen, nombre, raza, edad, actividad, peso, numeroAtenciones);
            perroR.save(perro);
        }
    }

    private void asignarPerrosAClientes() {
        for (int i = 1; i <= 100; i++) {
            Perro perroCliente = perroR.findById((long) i).orElse(null);
            if (perroCliente != null) {
                perroCliente.setCliente(clienteR.findById((long) i).orElse(null));
                perroR.save(perroCliente);
            }
        }
    }

    private void crearVeterinarios(Random rand) {
        String[] nombresVeterinarios = {
            "Dr. Smith", "Dr. Johnson", "Dr. Davis", "Dra. Anderson", "Dra. Wilson",
            "Dra. Brown", "Dr. Hernandez", "Dr. Shepard", "Dr. Burk", "Dr. Roberts"
        };

        String[] especialidades = {
            "Cirugía", "Dermatología", "Oftalmología", "Oncología", "Cardiología", "Neurología",
            "Endocrinología", "Gastroenterología", "Nefrología", "Hematología"
        };

        String[] fotosVeterinarios = {
            "https://www.shutterstock.com/image-photo/healthcare-medical-staff-concept-portrait-600nw-2281024823.jpg",
            "https://img.freepik.com/foto-gratis/doctor-sonriente-estetoscopio-aislado-gris_651396-974.jpg",
            "https://thumbs.dreamstime.com/z/enfermera-de-sexo-femenino-linda-doctor-trabajador-m%C3%A9dico-1548876.jpg",
            "https://www.shutterstock.com/image-photo/happy-smiling-young-indian-doctor-260nw-2047862279.jpg",
            "https://img.freepik.com/foto-gratis/doctora-vistiendo-bata-laboratorio-estetoscopio-aislado_1303-29791.jpg?size=626&ext=jpg&ga=GA1.1.117944100.1710028800&semt=sph",
            "https://img.freepik.com/foto-gratis/hermosa-joven-doctora-mirando-camara-oficina_1301-7807.jpg",
            "https://img.freepik.com/fotos-premium/joven-medico-hospital-medicina-medica-salud-clinica-oficina-retrato-gafas-hombre-estetoscopio-especialista_772720-5257.jpg?size=626&ext=jpg&ga=GA1.1.117944100.1710028800&semt=sph",
            "https://images.ecestaticos.com/ciN9hN7qsu5JOcrGdMngWhCHs8Y=/0x70:1716x1040/1200x1200/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F8db%2F8b6%2Faa5%2F8db8b6aa54b585253e15f79a68447aeb.jpg",
            "https://img.freepik.com/foto-gratis/joven-medico-apoyando-su-paciente_1098-2237.jpg?size=626&ext=jpg&ga=GA1.1.1700460183.1710028800&semt=sph",
            "https://img.freepik.com/fotos-premium/apuesto-joven-medico-clinica-veterinaria-apuntando-dedo-arriba-sonriendo-impresionado-pie-junto-lindo-perro-pug-negro-blanco_1258-32774.jpg"
        };

        for (int i = 0; i < 10; i++) {
            String nombre = nombresVeterinarios[i % nombresVeterinarios.length];
            String contrasena = passwordEncoder.encode("1234");
            String especialidad = especialidades[i % especialidades.length];
            int atenciones = rand.nextInt(100);
            String foto = fotosVeterinarios[i % fotosVeterinarios.length];
            boolean disponible = true;

            Veterinario veterinario = Veterinario.builder()
                    .nombre(nombre)
                    .contrasena(contrasena)
                    .especialidad(especialidad)
                    .atenciones(atenciones)
                    .foto(foto)
                    .activo(disponible)
                    .build();
            UserEntity userEntity = saveUserVeterinario(veterinario);
            veterinario.setUser(userEntity);
            vet.save(veterinario);
        }
    }

    private void crearDrogas() {
        String[] nombresDroga = { "Bayer", "Beaphar", "Chemie", "Drag Pharma", "Labyes", "Merial Pharma", "Micro", "Msd" };
        Double[] preciosDroga = { 100.0, 200.0, 300.0, 400.0, 500.0, 600.0, 700.0, 800.0 };
        Integer[] unidadesDrogas = { 100, 250, 340, 40, 250, 160, 270, 380 };

        for (int i = 0; i < 8; i++) {
            String nombre = nombresDroga[i % nombresDroga.length];
            Double precioV = preciosDroga[i % preciosDroga.length];
            Double precioC = precioV * 0.8;
            Integer unidadesC = unidadesDrogas[i % unidadesDrogas.length];
            Integer unidadesV = unidadesC / 2;

            Droga droga = new Droga(nombre, precioV, precioC, unidadesC, unidadesV);
            drog.save(droga);
        }
    }

    public void generarTratamientos() {
        String[] nombresTratamientos = {
            "RevitaPelaje", "CaninoLimpio", "RabiaShield", "ParvoPrevención", "PulgaStop", 
            "AntiparasitarioMax", "DentalCare", "VacunaVital", "DigestiPlus", "FelicidadCanina",
            "CalmaTotal", "PataSaludable", "CorazónSeguro", "OídoAlerta", "VisiónClara", 
            "PeloBrillante", "HuesoFuerte", "AlientoFresco", "EnergíaVital", "SeniorVitalidad"
        };
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        Random random = new Random();
    
        for (int i = 0; i < 20; i++) {
            String nombreTratamiento = nombresTratamientos[i % nombresTratamientos.length];
            double precioC = 50000 + random.nextDouble() * 1150000;
            int mes = random.nextInt(12) + 1;
            int dia = random.nextInt(28) + 1;
            String fecha = dia + "-" + mes + "-2024";
    
            LocalDate fechaLocalDate = LocalDate.parse(fecha, formatter);
            Tratamientos tratamiento = new Tratamientos(nombreTratamiento, precioC, fechaLocalDate);
    
            tratamientoR.save(tratamiento);
        }
    
        System.out.println("Todos los tratamientos han sido generados y guardados correctamente.");
    }

    private void cargarDatosDesdeExcel() {
        System.out.println("Iniciando carga de datos...");
        try {
            System.out.println("Abriendo archivo Excel...");
            FileInputStream file = new FileInputStream(new File("Código Fuente/demo/src/main/java/com/example/demo/Entidad/MEDICAMENTOS_VETERINARIA.xlsx"));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            if (rows.hasNext()) {
                Row headerRow = rows.next(); // Salta el encabezado
                System.out.println("Encabezado omitido: " + headerRow.getCell(0).getStringCellValue()); // Esto imprimirá la primera celda del encabezado
            }
            System.out.println("Procesando filas del archivo Excel...");
            while (rows.hasNext()) {
                Row row = rows.next();
                String nombre = row.getCell(0).getStringCellValue();
                double precioVenta = row.getCell(1).getNumericCellValue();
                double precioCompra = row.getCell(2).getNumericCellValue();
                int unidadesDisponibles = (int) row.getCell(3).getNumericCellValue();
                int unidadesVendidas = (int) row.getCell(4).getNumericCellValue();

                Droga droga = new Droga(nombre, precioVenta, precioCompra, unidadesDisponibles, unidadesVendidas);
                drog.save(droga);
            }
            workbook.close();
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo Excel. Asegúrate de que la ruta es correcta.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo Excel.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error procesando el archivo Excel:");
            e.printStackTrace();
        }
    }

    public void asignarTratamientosExistente() {
        List<Perro> perros = perroR.findAll();
        List<Veterinario> veterinarios = vet.findAll();
        List<Droga> drogas = drog.findAll();
        List<Tratamientos> tratamientos = tratamientoR.findAll();
    
        Random rand = new Random();
        int totalPerros = perros.size();
        int totalVeterinarios = veterinarios.size();
        int totalDrogas = drogas.size();
    
        for (Tratamientos tratamiento : tratamientos) {
            Perro perroAleatorio = perros.get(rand.nextInt(totalPerros));
            Veterinario veterinarioAleatorio = veterinarios.get(rand.nextInt(totalVeterinarios));
            Droga drogaAleatoria = drogas.get(rand.nextInt(totalDrogas));
    
            tratamiento.setPerro(perroAleatorio);
            tratamiento.setVeterinario(veterinarioAleatorio);
            tratamiento.setDroga(drogaAleatoria);
            tratamiento.setPrecioC(drogaAleatoria.getPrecioC() * drogaAleatoria.getUnidades_C() + 50000);
            
            tratamientoR.save(tratamiento);
        }
    
        System.out.println("Todos los tratamientos han sido actualizados correctamente con perros, veterinarios y drogas.");
    }

    private UserEntity saveUserClient(Cliente cliente) {
        UserEntity user = new UserEntity();
        user.setUsername(cliente.getCorreo());
        user.setPassword(passwordEncoder.encode("123"));
        Role roles = roleRepository.findByName("CLIENTE").get();
        user.setRoles(List.of(roles));
        return userRepository.save(user);
    }

    private UserEntity saveUserVeterinario(Veterinario veterinario) {
        UserEntity user = new UserEntity();
        user.setUsername(veterinario.getNombre());
        user.setPassword(passwordEncoder.encode(veterinario.getContrasena()));
        Role roles = roleRepository.findByName("VETERINARIO").get();
        user.setRoles(List.of(roles));
        return userRepository.save(user);
    }
    private UserEntity saveUserAdmin(Administrador admin) {
        UserEntity user = new UserEntity();
        user.setUsername(admin.getNombre());
        user.setPassword(passwordEncoder.encode(admin.getContrasena()));
        Role roles = roleRepository.findByName("ADMINISTRADOR").get();
        user.setRoles(List.of(roles));
        return userRepository.save(user);
    }
}
