package modelo.entidades;

import javax.persistence.*;

@Entity
public class Modelo {
    private String nombre;
    private int consumo;
    private int emisiones;
    private int id;
    private Marca marcaByIdMarca;
    private Eficiencia eficienciaByIdEficiencia;

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

        Modelo modelo = (Modelo) o;

        if (consumo != modelo.consumo) return false;
        if (emisiones != modelo.emisiones) return false;
        if (id != modelo.id) return false;
        if (nombre != null ? !nombre.equals(modelo.nombre) : modelo.nombre != null) return false;
        if (marcaByIdMarca != null ? !marcaByIdMarca.equals(modelo.marcaByIdMarca) : modelo.marcaByIdMarca != null)
            return false;
        return eficienciaByIdEficiencia != null ? eficienciaByIdEficiencia.equals(modelo.eficienciaByIdEficiencia) : modelo.eficienciaByIdEficiencia == null;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + consumo;
        result = 31 * result + emisiones;
        result = 31 * result + id;
        result = 31 * result + (marcaByIdMarca != null ? marcaByIdMarca.hashCode() : 0);
        result = 31 * result + (eficienciaByIdEficiencia != null ? eficienciaByIdEficiencia.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_marca", referencedColumnName = "id", nullable = false)
    public Marca getMarcaByIdMarca() {
        return marcaByIdMarca;
    }

    public void setMarcaByIdMarca(Marca marcaByIdMarca) {
        this.marcaByIdMarca = marcaByIdMarca;
    }

    @ManyToOne
    @JoinColumn(name = "id_eficiencia", referencedColumnName = "id", nullable = false)
    public Eficiencia getEficienciaByIdEficiencia() {
        return eficienciaByIdEficiencia;
    }

    public void setEficienciaByIdEficiencia(Eficiencia eficienciaByIdEficiencia) {
        this.eficienciaByIdEficiencia = eficienciaByIdEficiencia;
    }
}
