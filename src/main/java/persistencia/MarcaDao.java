package persistencia;

import modelo.entidades.Marca;

import java.util.List;

public interface MarcaDao {
    List<Marca> getTodasMarcas();
    Marca getMarca(int id);
    void crearMarca(Marca marca);
    void actualizarMarca(Marca marca);
    void eliminarMarca(Marca marca);
}
