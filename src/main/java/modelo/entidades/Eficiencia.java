package modelo.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Collection;

@Entity
@Table(name = "eficiencia")
public class Eficiencia implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Lob
    @Column(name = "imagen")
    private Blob imagen;

    @OneToMany(mappedBy = "eficiencia", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Modelo> modelos;

    public Eficiencia() {
    }

    public Eficiencia(String nombre, Blob imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
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

    public Blob getImagen() {
        return imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Eficiencia)) return false;

        Eficiencia that = (Eficiencia) o;

        if (id != that.id) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (imagen != null ? !imagen.equals(that.imagen) : that.imagen != null) return false;
        return modelos != null ? modelos.equals(that.modelos) : that.modelos == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (imagen != null ? imagen.hashCode() : 0);
        result = 31 * result + (modelos != null ? modelos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Eficiencia{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            '}';
    }
}
