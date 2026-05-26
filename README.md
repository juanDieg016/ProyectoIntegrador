# Ecuador Comparte

## URL del repositorio GitHub

https://github.com/juanDieg016/ProyectoIntegrador.git

---

## Descripción del proyecto

El proyecto consiste en una aplicación web desarrollada para gestionar y publicar información de manera organizada e interactiva. El sistema permite a los usuarios visualizar noticias, conocer información de la organización, enviar solicitudes de contacto y consultar testimonios publicados dentro de la plataforma.

Entre sus funcionalidades principales se encuentran la administración de noticias, la gestión de testimonios, el manejo de solicitudes de contacto y un sistema de acceso con roles de usuario y administrador para controlar la información de forma segura.

La aplicación busca solucionar la necesidad de centralizar la comunicación y la gestión de contenido en un solo sistema, facilitando tanto la interacción de los usuarios como la administración de la información por parte del personal encargado. Está dirigida principalmente a usuarios que desean consultar contenido informativo y a administradores responsables de actualizar y controlar los datos de la plataforma.

---

## Pasos para correr el proyecto

Antes de ejecutar el proyecto es necesario tener instalado:

- Java JDK 21
- Gradle  
  Opcional, ya que el proyecto incluye Gradle Wrapper.
- PostgreSQL
- Un IDE recomendado como:
  - IntelliJ IDEA
  - Visual Studio Code
  - Spring Tool Suite

El proyecto utiliza PostgreSQL como sistema de gestión de base de datos.

---

## Configuración de la base de datos

Abrir PostgreSQL y crear la base de datos con el nombre:

```sql
ecuador-comparte-db
```

Archivo de configuración:

```txt
src/main/resources/application.properties
```

Configuración:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecuador-comparte-db
spring.datasource.username=postgres
spring.datasource.password=123456789
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false

spring.sql.init.mode=always
```

---

## Configuración local

```txt
Puerto PostgreSQL: 5432
Usuario por defecto: postgres
Contraseña configurada: 123456789
```

---

## Credenciales de prueba

El sistema tiene usuarios configurados en memoria para iniciar sesión.

### Administrador

```txt
Usuario: admin
Contraseña: admin123
```

### Usuario

```txt
Usuario: user
Contraseña: user123
```

---

## Abrir el proyecto en IDEA

1. Abrir IntelliJ IDEA.
2. Seleccionar Open Project.
3. Elegir la carpeta del proyecto.
4. Ejecutar la clase principal del proyecto.

---

## Instalar dependencias y compilar

### Windows

```bash
gradlew build
```

---

## Acceder al sistema

Una vez iniciado el proyecto, se abre el navegador y se inserta la ruta:

```txt
http://localhost:8080
```

### Panel administrador

```txt
http://localhost:8080/admin
```

---

## Configuraciones adicionales para evitar errores comunes

### 1. Verificar que PostgreSQL esté activo

Antes de ejecutar el proyecto, el servicio de PostgreSQL debe estar iniciado.

Si PostgreSQL está apagado, la aplicación no podrá conectarse a la base de datos y mostrará errores de conexión.

### 2. Confirmar la existencia de la base de datos

La base de datos debe existir previamente con el nombre:

```txt
ecuador-comparte-db
```

Si no existe, crearla manualmente desde PostgreSQL.

### 3. Revisar usuario y contraseña de PostgreSQL

En el archivo:

```txt
application.properties
```

Deben coincidir las credenciales configuradas con las del equipo local:

```properties
spring.datasource.username=postgres
spring.datasource.password=123456789
```

Si las credenciales son diferentes, modificarlas para evitar errores de autenticación.

### 4. Esperar la descarga de dependencias

La primera vez que se ejecuta el proyecto, Gradle descargará automáticamente varias dependencias desde internet.

Este proceso puede tardar algunos minutos dependiendo de la conexión.

### 5. Verificar el puerto 8080

El puerto 8080 debe estar libre.

Si otra aplicación lo está utilizando, Spring Boot no podrá iniciar correctamente.

En ese caso, se debe cambiar el puerto en:

```properties
server.port=8081
```

Y acceder luego desde:

```txt
http://localhost:8081
```

### 6. Actualizar dependencias del proyecto

Si el IDE presenta errores al importar librerías:

En IntelliJ IDEA seleccionar:

```txt
Reload Gradle Project
```

O ejecutar:

```bash
gradlew clean build
```

### 7. Verificar versión de Java

El proyecto requiere Java 21.

Para comprobar la versión instalada ejecutar:

```bash
java -version
```

Si la versión es inferior, pueden aparecer errores de compatibilidad al compilar o ejecutar la aplicación.

### 8. Ejecutar el proyecto desde la carpeta correcta

Los comandos deben ejecutarse en la raíz del proyecto, donde se encuentran:

```txt
build.gradle
gradlew
src/
```

De lo contrario, Gradle no reconocerá el proyecto.

---

## ¿Cómo detener la aplicación?

```bash
Ctrl + C
```

---

## Estructura de carpetas

```txt
src/
├── main/
│   ├── java/dev/juanv/proyectointegrador/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── model/
│   │   │   ├── dto/
│   │   │   ├── entity/
│   │   │   └── constant/
│   │   └── ProyectoIntegradorApplication.java
│   │
│   └── resources/
│       ├── static/
│       │   ├── css/
│       │   ├── images/
│       │   └── js/
│       │
│       ├── templates/
│       │   ├── admin/
│       │   ├── auth/
│       │   ├── news/
│       │   └── fragments/
│       │
│       ├── application.properties
│       └── data.sql
│
└── test/
```

---

## Diagrama de arquitectura

En esta sección se encuentra el diagrama de arquitectura del sistema.

---

## Modelo Entidad/Relación

En esta sección se encuentra el modelo Entidad/Relación de la base de datos.

---

## Endpoints o peticiones disponibles

| Funcionalidad | Ruta | Método |
|---|---|---|
| Home | `/` | GET |
| Noticias | `/news` | GET |
| Crear noticia | `/news/create` | GET |
| Guardar noticia | `/news` | POST |
| Editar noticia | `/news/edit/{id}` | GET |
| Actualizar noticia | `/news/{id}` | PUT |
| Eliminar noticia | `/news/{id}` | DELETE |
| Testimonios | `/testimonials` | GET |
| Contacto | `/contact-request` | GET |
| Dashboard | `/admin` | GET |

---

## Stack de tecnologías

El proyecto fue desarrollado utilizando diferentes tecnologías enfocadas en el desarrollo web backend, manejo de bases de datos y construcción de interfaces dinámicas. Cada tecnología cumple una función específica dentro del sistema para garantizar su correcto funcionamiento.

---

## Tecnologías principales utilizadas

### Java 21

Lenguaje de programación principal utilizado para desarrollar la lógica del sistema, manejo de datos y funcionalidades internas de la aplicación.

### Spring Boot

Framework principal utilizado para construir la aplicación web. Permitió simplificar la configuración del proyecto, crear controladores, servicios y administrar el ciclo de vida de la aplicación.

### Spring Security

Utilizado para implementar autenticación y control de acceso mediante roles de usuario y administrador, brindando mayor seguridad al sistema.

### Spring Data JPA

Tecnologías empleadas para la persistencia de datos y la comunicación con la base de datos PostgreSQL mediante entidades y repositorios.

### PostgreSQL

Sistema de gestión de bases de datos relacional utilizado para almacenar la información del sistema, como usuarios, noticias, testimonios y solicitudes de contacto.

### Thymeleaf

Motor de plantillas utilizado para construir las vistas dinámicas de la aplicación web y conectar el backend con la interfaz visual.

### HTML, CSS y JavaScript

Tecnologías usadas para el diseño y comportamiento de las interfaces del sistema, permitiendo una mejor experiencia de usuario.

### Gradle

Herramienta utilizada para la gestión de dependencias, compilación y ejecución del proyecto.

### Tomcat embebido

Servidor integrado dentro de Spring Boot que permite ejecutar la aplicación sin necesidad de instalar un servidor externo.

---

## Herramientas de desarrollo

### IntelliJ IDEA

IDE recomendado para desarrollar y ejecutar el proyecto.

### PostgreSQL

Herramienta utilizada para administrar la base de datos del sistema.

### GitHub

Utilizado para el control de versiones y manejo del código fuente del proyecto.

---

## Capturas UI/UX

### Página Principal

En esta sección se muestra la página principal del sistema Ecuador Comparte.

### Noticias

En esta sección se muestra la vista de noticias de impacto en Ecuador.

### Testimonios

En esta sección se muestra la vista de testimonios publicados en la plataforma.

### Contacto

En esta sección se muestra el formulario de contacto del sistema.

### Dashboard Administrativo

En esta sección se muestra el panel administrativo del sistema.

### Gestión de Noticias

En esta sección se muestra la administración de noticias.

### Gestión de Testimonios

En esta sección se muestra la administración de testimonios.

### Gestión de Contactos

En esta sección se muestra la administración de solicitudes de contacto.

---

## Análisis personal

Uno de los retos más grandes durante el desarrollo del proyecto fue lograr integrar correctamente todas las tecnologías utilizadas, especialmente la conexión entre el backend, la base de datos y las vistas del sistema.

Aunque al inicio parecía sencillo crear funcionalidades básicas, en la práctica surgieron problemas relacionados con configuraciones de Spring Boot, errores de dependencias, autenticación de usuarios y manejo de datos en PostgreSQL.

También fue complicado comprender cómo organizar correctamente la arquitectura del proyecto.

Otro desafío importante fue solucionar errores que aparecían al ejecutar la aplicación, ya que muchas veces un pequeño error en la configuración impedía que todo el sistema iniciara correctamente.

Temas como seguridad, persistencia de datos, controladores, servicios y manejo de vistas exigieron desarrollar una lógica más analítica y aprender a investigar soluciones de manera autónoma.

Sin embargo, esto también permitió fortalecer habilidades importantes como la resolución de problemas, el trabajo en equipo y la capacidad de entender diferentes tecnologías utilizadas en el desarrollo de software Ecuador Comparte.
