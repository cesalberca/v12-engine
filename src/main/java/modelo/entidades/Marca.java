package modelo.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "marca")
public class Marca implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Modelo> modelos;

    public Marca() {
    }

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Marca)) return false;

        Marca marca = (Marca) o;

        if (id != marca.id) return false;
        if (nombre != null ? !nombre.equals(marca.nombre) : marca.nombre != null) return false;
        return modelos != null ? modelos.equals(marca.modelos) : marca.modelos == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (modelos != null ? modelos.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(Collection<Modelo> modelos) {
        this.modelos = modelos;
    }

    @Override
    public String toString() {
        return "Marca{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", modelos=" + modelos +
            '}';
    }
}
