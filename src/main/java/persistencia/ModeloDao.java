package persistencia;

import modelo.entidades.Modelo;

import java.util.List;


public interface ModeloDao{
    List<Modelo> getTodosModelos();
    Modelo getModelo(int id);
    void createModelo(Modelo modelo);
    void actualizarModelo(Modelo modelo);
    void eliminarModelo(Modelo modelo);
}
