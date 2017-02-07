package modelo.entidades;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Marca {
    private String nombre;
    private int id;
    private Collection<Modelo> modelosById;

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Marca marca = (Marca) o;

        if (id != marca.id) return false;
        if (nombre != null ? !nombre.equals(marca.nombre) : marca.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    @OneToMany(mappedBy = "marcaByIdMarca")
    public Collection<Modelo> getModelosById() {
        return modelosById;
    }

    public void setModelosById(Collection<Modelo> modelosById) {
        this.modelosById = modelosById;
    }
}
