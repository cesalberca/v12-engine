# V12 Engine

Por Sergio de la Paz, Víctor Allende, César Alberca y Adrián de la Gala

# MVC

## Vista

La Vista no debe tener lógica. Si es necesario conseguir datos de la vista, se hará un getter de ese elemento y se tratará desde el controlador. Por ejemplo, imaginemos que tenemos un `JButton` y queremos hacer un evento cuando pulsemos este botón. Para ello hay que hacer un getter en la vista y retornar el botón entero. Al hacerlo de esta forma nos aseguramos que la vista no tiene conocimiento alguno del controlador, ya que si pusiésemos en la vista la acción que debe hacer el botón ya estaríamos mezclando capas.

Para capturar y añadir un evento desde el controlador es de la siguiente forma:

```java
ActionListener buscarListener = actionEvent -> {
    // Aquí podemos programar las acciones que tiene que hacer la vista y el modelo o la persistencia
    gestorPersistencia.guardarCosas(vista.getCosas());
    vista.cerrarDialogo();
};
// Importante coger el botón de la vista y añadir ese action listener 
vista.getButtonOK().addActionListener(buscarListener);
```

Aquí hay que tener varias cosas en cuenta. El símbolo `->` indica una función lambda, que es algo nuevo de Java 8. Lo que hace es equivalente al siguiente código:

```java
buscarListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        buscar.cerrarDialogo();
    }
};
```

La siguiente cosa a tener en cuenta es `vista.getButtonOk()`. El objeto `vista` es la referencia que hemos pasado al constructor del controlador. 

## Controlador

Recibe una vista y un modelo. En nuestro proyecto en este caso se le pasará al constructor una instancia de `GestorPersistencia`. Es importante que sea el controlador el que gestione los eventos de la vista y las acciones que se deberán ejecutar como se ha visto anteriormente.

```java
public AppControlador(App app, GestorPersistencia gestorPersistencia) {
    this.app = app;
    this.gestorPersistencia = gestorPersistencia;

    // Poner en este método todos los listeners de la vista
    this.iniciarListeners();
}
```

En este caso app es la vista. Cada controlador debe tener asociado una vista y un modelo o gestor de persistencia.

Por convención el controlador no tiene lógica más allá de la validación de datos, éste sirve como nexo entre base de datos / lógica de negocio y la vista y es el que dictamina que cuando ocurre x pasa y.

## Persistencia

### Gestor persistencia

El punto principal de la persistencia es el GestorPersistencia. Este gestor tiene referencias a los demás gestores de persistencias de cada elemento (Marcas, eficiencias y modelos).

Esto quiere decir que __no se debe instanciar__ los demás gestores de persistencia. Para acceder a ellos se usan los getter de GestorPersistencia.

Aquí al arrancar la aplicación se recogerá por defecto todos los datos.

### Daos

En los DAOs se estipulan las acciones que se pueden cometer sobre ese pojo. Por ejemplo en EficienciaDao se estipulan los siguientes métodos.

```java
public interface EficienciaDao {
    List<Eficiencia> getTodasEficiencias();
    Eficiencia getEficiencia(int id);
    void crearEficiencia(Eficiencia eficiencia);
    void actualizarEficiencia(Eficiencia eficiencia);
    void eliminarEficiencia(Eficiencia eficiencia);
}
```

Lo que quiere decir que sobre la tabla Eficiencias se puede crear, actualizar, eliminar y buscar. Si una tabla en particular no se pudiesen crear o eliminar se debería modificar ese Dao.

Este patrón permite ver a golpe de vista qué operaciones son soportadas sobre esa tabla en concreto.

### Clases de Persistencia

Estas clases implementan los datos, y por tanto se programan aquí los métodos de para acceder la base de datos.

## Modelo

Aquí viven los POJOS y las demás clases que representen lógica del proyecto.

## Utils

En este paquete existirá las utilidades generales. Por regla general son métodos estáticos.


### Preguntas examen android

* Estructura de un proyecto android
* Manifiesto
* Componentes: Servicio, activity, fragment, broadcast receiver
* Ciclo de vida y activities
* Eventos
* Diferencias entre layouts
* ActionBar (Proceso de creación)
* __Adaptadores (Data esta base de datos y dado este listview cómo se carga)__
* Toasts y dialogs
* Intents
* Broadcast receiver
* Almacenamiento
* AsyncTask, services e intent services (Preguntar cómo se hace un asynctask)
* Dada una aplicación qué usarías
* Cualquier cosas que hayas hecho en la práctica
