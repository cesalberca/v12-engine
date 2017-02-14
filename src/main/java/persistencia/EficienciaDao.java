package persistencia;

import modelo.entidades.Eficiencia;

import java.util.List;

public interface EficienciaDao {
    List<Eficiencia> getTodasEficiencias();
    Eficiencia getEficiencia(int id);
    void crearEficiencia(Eficiencia eficiencia);
    void actualizarEficiencia(Eficiencia eficiencia);
    void eliminarEficiencia(Eficiencia eficiencia);
}
