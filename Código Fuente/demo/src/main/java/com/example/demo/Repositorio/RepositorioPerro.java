package com.example.demo.Repositorio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;

@Repository
public class RepositorioPerro {

    private Map<Integer, Perro> data = new HashMap<>();

    public RepositorioPerro() {
        data.put(1, new Perro("https://media.istockphoto.com/id/175221593/es/foto/linda-poco-perro-tejonero.jpg?s=1024x1024&w=is&k=20&c=wf0sWuGn-m4UugX5wouI4CA52XQLz3WkeCN1_Q69QBI=", "Firuslai", 001, "Salchicha", 7, true, 9.2, 2, new Cliente(1,"Jairo","jairo.man@gamilcom",32416391,"jairo.man","123")));
        data.put(2, new Perro("https://media.istockphoto.com/id/509052128/es/foto/oro-retriever-sentado-en-frente-de-un-fondo-blanco.jpg?s=1024x1024&w=is&k=20&c=C4xUiJIirtS9I8fjkLjub7TSKv1wx1n2vYauNQ6JzZ4=", "Buddy", 002, "Golden Retriever", 5, false, 30.0, 1,new Cliente(2,"Esteban","esteban.granada@gmail.com",35687654,"Grandala","222")));
        data.put(3, new Perro("https://media.istockphoto.com/id/803358028/es/foto/husky-siberiano-sonriente-y-jadeante-en-verano-los-ojos-medio-cerrados.jpg?s=1024x1024&w=is&k=20&c=A-4n6kpFHDN1s3tyepgKSyRlC6ATVwfvHOeVgn6qh4M=", "Snow", 003, "Husky", 10, true, 25.0, 2,new Cliente(3,"Santiago", "sanatigo.paez@gmail.com",32176545,"Killercoolyeah","444")));
        data.put(4, new Perro("https://media.istockphoto.com/id/168620477/es/foto/retrato-de-un-bulldog-ingl%C3%A9s.jpg?s=1024x1024&w=is&k=20&c=4hilsmilH3RfZ3iAokkbvPwBE8CC30KlW_6dPMWyY6M=", "Rocky", 004, "Bulldog", 8, true, 23.5, 5,new Cliente(1,"Jairo","jairo.man@gamilcom",32416391,"jairo.man","123")));
        data.put(5, new Perro("https://www.dailypaws.com/thmb/ZBHY6XQwtFPrrYGMG2wA4JZLKgg=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/american-bulldog-running-177755054-2000-6243a6aadc4b47c0bb892363976310ce.jpg", "Max", 005, "American-Bulldog", 4, true, 15.0, 5,new Cliente(2,"Esteban","esteban.granada@gmail.com",35687654,"Grandala","222")));
        data.put(6, new Perro("https://media.istockphoto.com/id/950511940/es/foto/shisu-perro-sobre-fondo-blanco.jpg?s=1024x1024&w=is&k=20&c=wGzFvjZo2YtpfPLOsl3wR4fj9auZ0YzvStwdJ23nwXc=", "Milo", 006, "Shi Tzu", 7, true, 7.2, 2,new Cliente(2,"Esteban","esteban.granada@gmail.com",35687654,"Grandala","222")));
        data.put(7, new Perro("https://media.istockphoto.com/id/167229347/es/foto/cachorro.jpg?s=1024x1024&w=is&k=20&c=q-GTm-vPtKo1RYlUebwIxrLdeyHYRWnoHLGUgpt79zg=", "Bella", 007, "Pomeranian", 5, false, 3.5, 1,new Cliente(4,"Juana","juana.suaracost@gmail.com",35687654,"Suaracost","555")));
        data.put(8, new Perro("https://media.istockphoto.com/id/500851439/es/foto/d%C3%A1lmata-aislado-en-blanco.jpg?s=1024x1024&w=is&k=20&c=GR_6JtLDwT7XOtr6q_H4fvdqyNC_zN9P57AM9UcQpUc=", "Spot", 010, "Dalmatian", 7, true, 25.0, 2,new Cliente(1,"Jairo","jairo.man@gamilcom",32416391,"jairo.man","123")));
        
    }

    public Perro findById(int id) {
        return data.get(id);
    }

    public Collection<Perro> findAll() {
        return data.values();
    }

    public void Add(Perro p) {
        int tam= data.size();
        int lastId = data.get(tam).getId();
        p.setId(lastId+1);
        data.put(p.getId(), p);
    }

    public void DeleteByID(int id) {
        data.remove(id);
    }

    public void Update(Perro p) {
        data.put(p.getId(), p);
    }
    

    public List<Perro> PerrosClientePerros(int cedula) {
        List<Perro> perros = new ArrayList<>();
        for (Perro perro : data.values()) {
            if (perro.getCliente().getCedula() == cedula) {
                perros.add(perro);
            }
        }
        return perros;
    }

   
}
