package persistencia;

import modelo.entidades.Eficiencia;
import modelo.entidades.Modelo;

import java.util.List;

public class GestorPersistencia {

    public GestorPersistencia(){
        EficienciaPersistencia eficienciaPersistencia = new EficienciaPersistencia();

        Eficiencia eficienciaActualiazada = eficienciaPersistencia.getEficiencia(2);
        eficienciaActualiazada.setNombre("Test");
        eficienciaPersistencia.actualizarEficiencia(eficienciaActualiazada);

        ModeloPersistencia modeloPersistencia = new ModeloPersistencia();
        Modelo modelo = modeloPersistencia.getModelo(1);
        //modelo.
        modeloPersistencia.actualizarModelo(modelo);






//        for (Eficiencia eficiencia : eficienciaPersistencia.getTodasEficiencias()) {
//            System.out.println(eficiencia);
//        }

//        System.out.println(eficienciaPersistencia.getEficiencia(2).toString());
//        byte[] myvar = "Any String you want".getBytes();
//
//        eficienciaPersistencia.crearEficiencia(new Eficiencia("Nueva eficiencia", myvar));
    }
}
