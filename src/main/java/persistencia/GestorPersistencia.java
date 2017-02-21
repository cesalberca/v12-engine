package persistencia;

import modelo.entidades.Eficiencia;
import modelo.entidades.Marca;
import modelo.entidades.Modelo;

public class GestorPersistencia {
    private EficienciaPersistencia eficienciaPersistencia;
    private MarcaPersistencia marcaPersistencia;
    private ModeloPersistencia modeloPersistencia;

    public GestorPersistencia() {
        this.eficienciaPersistencia = new EficienciaPersistencia();
        this.marcaPersistencia = new MarcaPersistencia();
        this.modeloPersistencia = new ModeloPersistencia();

//        Eficiencia eficiencia = new Eficiencia("nuevo","Any String you want".getBytes());
//        Marca marca = new Marca("Ferrari");
//        ModeloPersistencia modeloPersistencia = new ModeloPersistencia();
//        Modelo m = new Modelo("308",10,20, marca, eficiencia);
//        modeloPersistencia.crearModelo(m);
    }

    public EficienciaPersistencia getEficienciaPersistencia() {
        return eficienciaPersistencia;
    }

    public MarcaPersistencia getMarcaPersistencia() {
        return marcaPersistencia;
    }

    public ModeloPersistencia getModeloPersistencia() {
        return modeloPersistencia;
    }
}
