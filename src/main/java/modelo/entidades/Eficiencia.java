package modelo.entidades;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@Entity
@Table(name = "eficiencia")
public class Eficiencia implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "imagen")
    private byte[] imagen;

    @OneToMany(mappedBy = "eficiencia", fetch = FetchType.EAGER)
    private Collection<Modelo> modelos;

    public Eficiencia() {
    }

    public Eficiencia(String nombre, byte[] imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Eficiencia(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
