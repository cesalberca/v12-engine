package modelo.entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@Table(name = "marca")
public class Marca implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "marca", fetch = FetchType.EAGER)
    private Collection<Modelo> modelos;

    public Marca() {
    }

    public Marca(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
