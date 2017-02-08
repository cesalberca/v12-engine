package modelo.entidades;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "marca")
public class Marca implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "marca")
    private Collection<Modelo> modelos;
}
