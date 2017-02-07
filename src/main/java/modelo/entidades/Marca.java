package modelo.entidades;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by juanxxiiiTarde on 07/02/2017.
 */
@Entity
public class Marca {
    private int idMarca;
    private String nombre;
    private Collection<Modelo> modelosByIdMarca;

    @Id
    @Column(name = "id_marca")
    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Marca marca = (Marca) o;

        if (idMarca != marca.idMarca) return false;
        if (nombre != null ? !nombre.equals(marca.nombre) : marca.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMarca;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "marcaByIdMarca")
    public Collection<Modelo> getModelosByIdMarca() {
        return modelosByIdMarca;
    }

    public void setModelosByIdMarca(Collection<Modelo> modelosByIdMarca) {
        this.modelosByIdMarca = modelosByIdMarca;
    }
}
