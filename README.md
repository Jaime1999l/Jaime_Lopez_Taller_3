## LINK: 
https://github.com/Jaime1999l/Jaime_Lopez_Taller_3.git

### JAIME LÓPEZ DÍAZ

# TALLER 3 PROGRAMACIÓN DIRIGIDA POR EVENTOS

## Descripción del Proyecto

La aplicación permite a los usuarios interactuar mediante diferentes actividades, gestionar preferencias de usuario y almacenar datos tanto de forma local como en la nube. Se implementan múltiples tecnologías de almacenamiento, incluyendo `SharedPreferences` para preferencias de usuario, SQLite para almacenamiento interno y Firebase Firestore para almacenamiento externo.

## Características Principales

- **Interfaz de Usuario Dinámica**: Cambia el saludo mostrado según la hora del día.
- **Gestión de Preferencias de Usuario**: Utiliza `SharedPreferences` para almacenar y recuperar preferencias del usuario.
- **Almacenamiento Interno con SQLite**: Guarda información del usuario de manera local en el dispositivo.
- **Almacenamiento Externo con Firebase Firestore**: Sincroniza y almacena datos del usuario en la nube.
- **Configuración de Fondo Personalizado**: Permite al usuario elegir entre diferentes fondos de color o imágenes.
- **Tareas Simuladas de Red**: Realiza operaciones asíncronas para simular la carga de datos desde una red.

## Estructura del Proyecto

### MainActivity

Descripción: Es la actividad principal que muestra un saludo dinámico basado en la hora del día. Permite navegar a otras actividades como RedActivity y ConfiguracionActivity.

- Características:
  
Verificación y actualización del saludo en intervalos específicos.
Aplicación de fondos personalizados mediante BackgroundUtil.
Inicia tareas de red simuladas para obtener datos.

### RedActivity

Descripción: Permite al usuario ingresar y guardar su nombre. Muestra el nombre guardado y realiza tareas de red simuladas.

- Características:
  
Gestión de nombres de usuario utilizando UserViewModel.
Almacenamiento de datos en SharedPreferences, SQLite y Firebase Firestore.
Ejecución de tareas de red simuladas con SimulatedNetworkTask.

### ConfiguracionActivity


Descripción: Permite al usuario configurar el fondo de la aplicación eligiendo entre colores o imágenes.

- Características:
  
Guarda las preferencias de fondo en SharedPreferences.
Aplica el fondo seleccionado utilizando BackgroundUtil.

### UserViewModel

Descripción: Gestiona los datos del usuario y coordina el almacenamiento en SharedPreferences, SQLite y Firebase Firestore.

- Características:
  
Observa y actualiza el nombre del usuario.
Interactúa con UserRepository para manejar operaciones de almacenamiento.

### BackgroundUtil

Descripción: Maneja la aplicación de fondos personalizados en las actividades.

- Características:
  
Recupera las preferencias de fondo desde SharedPreferences.
Aplica el fondo seleccionado (color o imagen) a la interfaz de usuario.

### SimulatedNetworkTask

Descripción: Simula una tarea de red asíncrona para obtener datos.

- Características:
  
Realiza una espera simulada para imitar una llamada HTTP.
Actualiza la interfaz de usuario con los datos simulados.

### FetchGreetingTask

Descripción: Tarea asíncrona que simula la obtención de un saludo desde una fuente externa.

- Características:
  
Muestra un saludo basado en una respuesta JSON simulada.
Actualiza la UI con el saludo obtenido.

### DatabaseHelper

Descripción: Ayuda a gestionar la creación y actualización de la base de datos SQLite.

- Características:
  
Define la estructura de la base de datos y las tablas.
Maneja las operaciones de creación y actualización de la base de datos.

### UserRepository

Descripción: Gestiona las operaciones de almacenamiento de datos del usuario en SQLite y Firebase Firestore.

- Características:
  
Inserta y recupera datos de la base de datos SQLite.
Sincroniza los datos del usuario con Firebase Firestore.

# Uso de SharedPreferences
SharedPreferences se utiliza para almacenar y recuperar las preferencias de usuario, como el tipo y valor del fondo seleccionado. No se modifican otras preferencias de usuario existentes.

# Uso de SQLite
SQLite se emplea para almacenar datos del usuario de forma local en el dispositivo. Se utiliza principalmente para guardar el nombre del usuario.

- Clases Involucradas:

DatabaseHelper: Define la estructura de la base de datos.
UserRepository: Gestiona las operaciones CRUD en SQLite.

# Uso de Firebase Firestore
Firebase Firestore se utiliza para almacenar datos del usuario en la nube, permitiendo la sincronización entre dispositivos y acceso remoto a los datos.

- Clases Involucradas:

UserRepository: Gestiona las operaciones de almacenamiento en Firestore.
