package persistencia;

import modelo.entidades.Eficiencia;

import java.util.ArrayList;

public interface EficienciaDao {
    ArrayList<Eficiencia> getTodasEficiencias();
    Eficiencia getEficiencia(int id);
    void crearEficiencia(Eficiencia eficiencia);
    void actualizarEficiencia(Eficiencia eficiencia);
    void eliminarEficiencia(Eficiencia eficiencia);
}
