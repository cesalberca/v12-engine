package modelo.entidades;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Eficiencia {
    private String nombre;
    private byte[] imagen;
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

    @Basic
    @Column(name = "imagen")
    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
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

        Eficiencia that = (Eficiencia) o;

        if (id != that.id) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (!Arrays.equals(imagen, that.imagen)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(imagen);
        result = 31 * result + id;
        return result;
    }

    @OneToMany(mappedBy = "eficienciaByIdEficiencia")
    public Collection<Modelo> getModelosById() {
        return modelosById;
    }

    public void setModelosById(Collection<Modelo> modelosById) {
        this.modelosById = modelosById;
    }
}
