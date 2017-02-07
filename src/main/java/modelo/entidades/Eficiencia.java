package modelo.entidades;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by juanxxiiiTarde on 07/02/2017.
 */
@Entity
public class Eficiencia {
    private int idEficiencia;
    private String nombre;
    private byte[] imagen;
    private Collection<Modelo> modelosByIdEficiencia;

    @Id
    @Column(name = "id_eficiencia")
    public int getIdEficiencia() {
        return idEficiencia;
    }

    public void setIdEficiencia(int idEficiencia) {
        this.idEficiencia = idEficiencia;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Eficiencia that = (Eficiencia) o;

        if (idEficiencia != that.idEficiencia) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (!Arrays.equals(imagen, that.imagen)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEficiencia;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(imagen);
        return result;
    }

    @OneToMany(mappedBy = "eficienciaByIdEficiencia")
    public Collection<Modelo> getModelosByIdEficiencia() {
        return modelosByIdEficiencia;
    }

    public void setModelosByIdEficiencia(Collection<Modelo> modelosByIdEficiencia) {
        this.modelosByIdEficiencia = modelosByIdEficiencia;
    }
}
