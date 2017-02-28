package modelo;


public class CocheInicio {
    private int id;
    private int id_marca;
    private String nombre;
    private int consumo;
    private int emisiones;
    private int id_eficiendia;

    public CocheInicio(int id_marca, String nombre, int consumo, int emisiones, int id_eficiendia) {
        this.id_marca = id_marca;
        this.nombre = nombre;
        this.consumo = consumo;
        this.emisiones = emisiones;
        this.id_eficiendia = id_eficiendia;
    }

    public CocheInicio(int id, int id_marca, String nombre, int consumo, int emisiones, int id_eficiendia) {
        this.id = id;
        this.id_marca = id_marca;
        this.nombre = nombre;
        this.consumo = consumo;
        this.emisiones = emisiones;
        this.id_eficiendia = id_eficiendia;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public int getEmisiones() {
        return emisiones;
    }

    public void setEmisiones(int emisiones) {
        this.emisiones = emisiones;
    }

    public int getId_eficiendia() {
        return id_eficiendia;
    }

    public void setId_eficiendia(int id_eficiendia) {
        this.id_eficiendia = id_eficiendia;
    }
}
