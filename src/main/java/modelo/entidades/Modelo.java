package modelo.entidades;

import lombok.Data;

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

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "consumo")
    private int consumo;

    @Column(name = "emisiones")
    private int emisiones;

    @ManyToOne
    @JoinColumn(name = "id_marca", referencedColumnName = "id", nullable = false)
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_eficiencia", referencedColumnName = "id", nullable = false)
    private Eficiencia eficiencia;
}
