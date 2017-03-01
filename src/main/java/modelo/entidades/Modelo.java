package modelo.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name = "modelo")
public class Modelo implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "consumo")
    private double consumo;

    @Column(name = "emisiones")
    private double emisiones;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_marca", referencedColumnName = "id", nullable = false)
    private Marca marca;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_eficiencia", referencedColumnName = "id", nullable = false)
    private Eficiencia eficiencia;

    public Modelo() {
    }

    public Modelo(String nombre, double consumo, double emisiones) {
        this.nombre = nombre;
        this.consumo = consumo;
        this.emisiones = emisiones;
    }

    public Modelo(String nombre, double consumo, double emisiones, Marca marca, Eficiencia eficiencia) {
        this.nombre = nombre;
        this.consumo = consumo;
        this.emisiones = emisiones;
        this.marca = marca;
        this.eficiencia = eficiencia;
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

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getEmisiones() {
        return emisiones;
    }

    public void setEmisiones(double emisiones) {
        this.emisiones = emisiones;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Eficiencia getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(Eficiencia eficiencia) {
        this.eficiencia = eficiencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Modelo)) return false;

        Modelo modelo = (Modelo) o;

        if (id != modelo.id) return false;
        if (Double.compare(modelo.consumo, consumo) != 0) return false;
        if (Double.compare(modelo.emisiones, emisiones) != 0) return false;
        if (nombre != null ? !nombre.equals(modelo.nombre) : modelo.nombre != null) return false;
        if (marca != null ? !marca.equals(modelo.marca) : modelo.marca != null) return false;
        return eficiencia != null ? eficiencia.equals(modelo.eficiencia) : modelo.eficiencia == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        temp = Double.doubleToLongBits(consumo);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(emisiones);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (marca != null ? marca.hashCode() : 0);
        result = 31 * result + (eficiencia != null ? eficiencia.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Modelo{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", consumo=" + consumo +
            ", emisiones=" + emisiones +
            ", marca=" + marca +
            ", eficiencia=" + eficiencia +
            '}';
    }
}
