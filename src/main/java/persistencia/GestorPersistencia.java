package persistencia;

/**
 * Clase que crea las demás persistencias y contiene una referencia a cada una de ellas
 */
public class GestorPersistencia {
    private EficienciaPersistencia eficienciaPersistencia;
    private MarcaPersistencia marcaPersistencia;
    private ModeloPersistencia modeloPersistencia;

    public GestorPersistencia() {
        this.eficienciaPersistencia = new EficienciaPersistencia();
        this.marcaPersistencia = new MarcaPersistencia();
        this.modeloPersistencia = new ModeloPersistencia();
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
