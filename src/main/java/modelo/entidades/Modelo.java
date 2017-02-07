package modelo.entidades;

import javax.persistence.*;

/**
 * Created by juanxxiiiTarde on 07/02/2017.
 */
@Entity
public class Modelo {
    private int idModelo;
    private int idMarca;
    private String nombre;
    private int consumo;
    private int emisiones;
    private int idEficiencia;
    private Marca marcaByIdMarca;
    private Eficiencia eficienciaByIdEficiencia;

    @Id
    @Column(name = "id_modelo")
    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    @Basic
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

    @Basic
    @Column(name = "consumo")
    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    @Basic
    @Column(name = "emisiones")
    public int getEmisiones() {
        return emisiones;
    }

    public void setEmisiones(int emisiones) {
        this.emisiones = emisiones;
    }

    @Basic
    @Column(name = "id_eficiencia")
    public int getIdEficiencia() {
        return idEficiencia;
    }

    public void setIdEficiencia(int idEficiencia) {
        this.idEficiencia = idEficiencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Modelo modelo = (Modelo) o;

        if (idModelo != modelo.idModelo) return false;
        if (idMarca != modelo.idMarca) return false;
        if (consumo != modelo.consumo) return false;
        if (emisiones != modelo.emisiones) return false;
        if (idEficiencia != modelo.idEficiencia) return false;
        if (nombre != null ? !nombre.equals(modelo.nombre) : modelo.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idModelo;
        result = 31 * result + idMarca;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + consumo;
        result = 31 * result + emisiones;
        result = 31 * result + idEficiencia;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca", nullable = false)
    public Marca getMarcaByIdMarca() {
        return marcaByIdMarca;
    }

    public void setMarcaByIdMarca(Marca marcaByIdMarca) {
        this.marcaByIdMarca = marcaByIdMarca;
    }

    @ManyToOne
    @JoinColumn(name = "id_eficiencia", referencedColumnName = "id_eficiencia", nullable = false)
    public Eficiencia getEficienciaByIdEficiencia() {
        return eficienciaByIdEficiencia;
    }

    public void setEficienciaByIdEficiencia(Eficiencia eficienciaByIdEficiencia) {
        this.eficienciaByIdEficiencia = eficienciaByIdEficiencia;
    }
}
