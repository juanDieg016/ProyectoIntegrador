# Proyecto Integrador - Ecuador Comparte

Aplicación web desarrollada para gestionar y publicar información de manera organizada e interactiva.

El sistema permite a los usuarios visualizar noticias, conocer información de la organización, enviar solicitudes de contacto y consultar testimonios publicados dentro de la plataforma. Además, cuenta con un panel administrativo para gestionar noticias, testimonios y solicitudes de contacto.

## Repositorio

[Repositorio en GitHub](https://github.com/juanDieg016/ProyectoIntegrador.git)

---

## Descripción del proyecto

Este proyecto busca centralizar la comunicación y la gestión de contenido en un solo sistema web, facilitando tanto la interacción de los usuarios como la administración de la información por parte del personal encargado.

La aplicación está dirigida principalmente a:

- Usuarios que desean consultar contenido informativo.
- Administradores responsables de actualizar y controlar los datos de la plataforma.

Entre sus funcionalidades principales se encuentran:

- Visualización de noticias.
- Consulta de testimonios.
- Página de información institucional.
- Formulario de contacto.
- Panel administrativo.
- Gestión de noticias.
- Gestión de testimonios.
- Gestión de solicitudes de contacto.
- Sistema de autenticación con roles de usuario y administrador.

---

## Tecnologías utilizadas

El proyecto fue desarrollado utilizando tecnologías enfocadas en el desarrollo web backend, manejo de base de datos y construcción de interfaces dinámicas.

| Tecnología | Descripción |
|---|---|
| Java 21 | Lenguaje de programación principal utilizado para desarrollar la lógica del sistema. |
| Spring Boot | Framework principal para construir la aplicación web. |
| Spring Security | Implementación de autenticación y control de acceso por roles. |
| Spring Data JPA | Persistencia de datos y comunicación con PostgreSQL mediante entidades y repositorios. |
| PostgreSQL | Base de datos relacional para almacenar usuarios, noticias, testimonios y contactos. |
| Thymeleaf | Motor de plantillas para construir vistas dinámicas. |
| HTML | Estructura principal de las páginas web. |
| CSS | Diseño visual y estilos de la interfaz. |
| JavaScript | Funcionalidades dinámicas en la interfaz de usuario. |
| Gradle | Herramienta para gestión de dependencias, compilación y ejecución del proyecto. |
| Tomcat embebido | Servidor integrado en Spring Boot para ejecutar la aplicación sin instalar un servidor externo. |

---

## Herramientas de desarrollo

- IntelliJ IDEA
- Visual Studio Code
- Spring Tool Suite
- PostgreSQL
- GitHub

---

## Requisitos previos

Antes de ejecutar el proyecto, se debe tener instalado:

- Java JDK 21
- PostgreSQL
- Gradle, opcional porque el proyecto incluye Gradle Wrapper.
- Un IDE recomendado:
  - IntelliJ IDEA
  - Visual Studio Code
  - Spring Tool Suite

---

## Configuración de la base de datos

El proyecto utiliza PostgreSQL como sistema de gestión de base de datos.

Antes de ejecutar la aplicación, se debe crear la base de datos con el siguiente nombre:

```sql
CREATE DATABASE "ecuador-comparte-db";
```

### Configuración local recomendada

| Parámetro | Valor |
|---|---|
| Motor de base de datos | PostgreSQL |
| Puerto | 5432 |
| Base de datos | ecuador-comparte-db |
| Usuario | postgres |
| Contraseña | 123456789 |

---

## Archivo `application.properties`

La configuración principal se encuentra en:

```text
src/main/resources/application.properties
```

Configuración recomendada:

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

> Nota: Si el usuario o la contraseña de PostgreSQL son diferentes en el equipo local, se deben modificar estos valores en el archivo `application.properties`.

---

## Credenciales de prueba

El sistema tiene usuarios configurados en memoria para iniciar sesión.

### Administrador

```text
Usuario: admin
Contraseña: admin123
```



## Instalación y ejecución del proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/juanDieg016/ProyectoIntegrador.git
```

### 2. Entrar a la carpeta del proyecto

```bash
cd ProyectoIntegrador
```

### 3. Verificar la versión de Java

```bash
java -version
```

El proyecto requiere Java 21.

### 4. Compilar el proyecto

En Windows:

```bash
gradlew build
```

En Linux o macOS:

```bash
./gradlew build
```

### 5. Ejecutar la aplicación

En Windows:

```bash
gradlew bootRun
```

En Linux o macOS:

```bash
./gradlew bootRun
```

---

## Abrir el proyecto en IntelliJ IDEA

1. Abrir IntelliJ IDEA.
2. Seleccionar la opción **Open Project**.
3. Elegir la carpeta del proyecto.
4. Esperar a que Gradle descargue las dependencias.
5. Ejecutar la clase principal del proyecto:

```text
ProyectoIntegradorApplication.java
```

---

## Acceso al sistema

Una vez iniciado el proyecto, abrir el navegador y acceder a:

```text
http://localhost:8080
```

Panel administrativo:

```text
http://localhost:8080/admin
```

---

## Endpoints principales

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
| Dashboard administrativo | `/admin` | GET |

---

## Estructura del proyecto

```text
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
│       ├── templates/
│       │   ├── admin/
│       │   ├── auth/
│       │   ├── news/
│       │   └── fragments/
│       ├── application.properties
│       └── data.sql
│
└── test/
```

---

## Capturas UI/UX

En esta sección se pueden agregar capturas de pantalla del sistema.

### Página principal

```md
![Página principal](ruta/de/la/imagen.png)
```

### Noticias

```md
![Noticias](ruta/de/la/imagen.png)
```

### Testimonios

```md
![Testimonios](ruta/de/la/imagen.png)
```

### Contacto

```md
![Contacto](ruta/de/la/imagen.png)
```

### Dashboard administrativo

```md
![Dashboard administrativo](ruta/de/la/imagen.png)
```

### Gestión de noticias

```md
![Gestión de noticias](ruta/de/la/imagen.png)
```

### Gestión de testimonios

```md
![Gestión de testimonios](ruta/de/la/imagen.png)
```

### Gestión de contactos

```md
![Gestión de contactos](ruta/de/la/imagen.png)
```

---

## Configuraciones adicionales para evitar errores comunes

### 1. Verificar que PostgreSQL esté activo

Antes de ejecutar el proyecto, el servicio de PostgreSQL debe estar iniciado.

Si PostgreSQL está apagado, la aplicación no podrá conectarse a la base de datos y mostrará errores de conexión.

### 2. Confirmar la existencia de la base de datos

La base de datos debe existir previamente con el nombre:

```text
ecuador-comparte-db
```

Si no existe, debe crearse manualmente desde PostgreSQL.

### 3. Revisar usuario y contraseña de PostgreSQL

En el archivo `application.properties`, las credenciales deben coincidir con las configuradas en el equipo local:

```properties
spring.datasource.username=postgres
spring.datasource.password=123456789
```

### 4. Esperar la descarga de dependencias

La primera vez que se ejecuta el proyecto, Gradle descargará automáticamente las dependencias desde internet.

Este proceso puede tardar algunos minutos dependiendo de la conexión.

### 5. Verificar el puerto 8080

El puerto 8080 debe estar libre.

Si otra aplicación lo está utilizando, Spring Boot no podrá iniciar correctamente.

En ese caso, se puede cambiar el puerto agregando esta línea en `application.properties`:

```properties
server.port=8081
```

Luego se accede desde:

```text
http://localhost:8081
```

### 6. Actualizar dependencias del proyecto

Si el IDE presenta errores al importar librerías, se puede ejecutar:

```bash
gradlew clean build
```

También se puede usar la opción:

```text
Reload Gradle Project
```

desde IntelliJ IDEA.

### 7. Verificar versión de Java

El proyecto requiere Java 21.

Para comprobar la versión instalada, ejecutar:

```bash
java -version
```

Si la versión es inferior, pueden aparecer errores de compatibilidad al compilar o ejecutar la aplicación.

### 8. Ejecutar el proyecto desde la carpeta correcta

Los comandos deben ejecutarse desde la raíz del proyecto, donde se encuentran:

```text
build.gradle
gradlew
src/
```

De lo contrario, Gradle no reconocerá el proyecto.

---

## ¿Cómo detener la aplicación?

Para detener la aplicación desde la terminal:

```bash
Ctrl + C
```

---

## Análisis personal

Uno de los retos más grandes durante el desarrollo del proyecto fue integrar correctamente todas las tecnologías utilizadas, especialmente la conexión entre el backend, la base de datos y las vistas del sistema.

Aunque al inicio parecía sencillo crear funcionalidades básicas, durante el desarrollo surgieron problemas relacionados con la configuración de Spring Boot, errores de dependencias, autenticación de usuarios y manejo de datos en PostgreSQL.

También fue un desafío comprender cómo organizar correctamente la arquitectura del proyecto. Además, solucionar errores de ejecución permitió fortalecer habilidades importantes como:

- Resolución de problemas.
- Trabajo en equipo.
- Investigación autónoma.
- Comprensión de tecnologías backend y frontend.
- Manejo de bases de datos.
- Organización de proyectos web.

Este proyecto permitió aplicar conocimientos de desarrollo de software en un sistema real, integrando seguridad, persistencia de datos, controladores, servicios, vistas y administración de contenido.

---

## Autor

Proyecto desarrollado como parte del Proyecto Integrador.
