package persistencia;

import modelo.entidades.Eficiencia;
import modelo.entidades.Marca;
import modelo.entidades.Modelo;
import observador.Observador;
import observador.Sujeto;

import java.util.List;

/**
 * Clase que gestiona toda la persitencia de la aplicación.
 * Tiene referencias actualizadas de los modelos, las eficiencias y las marcas.
 * Es una clase que es sujeto y observadora.
 * Esta clase observa las demás persistencias y éstas notifican los cambios a esta clase.
 * Además esta clase a su vez es sujeto, ya que el controlador mirará cambios sobre esta clase.
 */
public class GestorPersistencia implements Sujeto, Observador {
    private EficienciaPersistencia eficienciaPersistencia;
    private MarcaPersistencia marcaPersistencia;
    private ModeloPersistencia modeloPersistencia;

    private List<Modelo> modelos;
    private List<Eficiencia> eficiencias;
    private List<Marca> marcas;

    public GestorPersistencia() {
        this.eficienciaPersistencia = new EficienciaPersistencia();
        this.marcaPersistencia = new MarcaPersistencia();
        this.modeloPersistencia = new ModeloPersistencia();

        // Registramos como observadores a todas ls persistencias
        eficienciaPersistencia.registrarObservador(this);
        marcaPersistencia.registrarObservador(this);
        modeloPersistencia.registrarObservador(this);

        // Cargamos al iniciar todos los datos
        eficiencias = eficienciaPersistencia.getTodasEficiencias();
        modelos = modeloPersistencia.getTodosModelos();
        marcas = marcaPersistencia.getTodasMarcas();
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

    public List<Modelo> getModelos() {
        return modelos;
    }

    public List<Eficiencia> getEficiencias() {
        return eficiencias;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    @Override
    public void actualizar() {
        //TODO mover esto a cada persistencia
        eficiencias = eficienciaPersistencia.getTodasEficiencias();
        modelos = modeloPersistencia.getTodosModelos();
        marcas = marcaPersistencia.getTodasMarcas();
    }
}
