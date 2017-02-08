package modelo.entidades;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "modelo")
public class Modelo implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "nombre")
    private String nombre;

    @NonNull
    @Column(name = "consumo")
    private int consumo;

    @NonNull
    @Column(name = "emisiones")
    private int emisiones;

    @ManyToOne
    @JoinColumn(name = "id_marca", referencedColumnName = "id", nullable = false)
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_eficiencia", referencedColumnName = "id", nullable = false)
    private Eficiencia eficiencia;

    public Modelo() {
    }
}
