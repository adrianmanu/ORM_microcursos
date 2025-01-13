# Proyecto Micro-Cursos

## Descripción
Este proyecto es un sistema de gestión de cursos y estudiantes desarrollado en Spring Boot con una base de datos MySQL, utilizando Docker para la implementación de contenedores.

---

## Requisitos previos
Asegúrate de tener instalados los siguientes programas en tu sistema:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/)

---

## Instalación
Sigue los pasos para configurar y ejecutar el proyecto:

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/tu-repo/micro-cursos.git
   cd micro-cursos

# Instrucciones para ejecutar el proyecto
## Construir el proyecto

Ejecuta el siguiente comando en la raíz del proyecto para compilar y empaquetar:
## Configurar contenedores con Docker Compose

Construye y levanta los contenedores ejecutando los siguientes comandos:

```bash
    mvn clean package
```

```bash
    docker-compose build
    docker-compose up
```
---

## Acceso a la aplicación

Una vez que los contenedores estén levantados, la aplicación estará disponible en:

```plaintext
http://localhost:8002
```

---

## Endpoints y pruebas con Postman

### 1. Cursos

#### Crear Curso

- POST /api/cursos:
```json
Body:
{
  "nombre": "Curso de Matemáticas",
  "descripcion": "Aprende álgebra y geometría",
  "duracion": 30
}
```
```
Resultado:
Se crea un curso con los datos proporcionados.
```
#### Listar Cursos
- GET /api/cursos

```
Resultado:
Devuelve la lista de todos los cursos.
```

#### Listar Curso por ID
- GET /api/cursos/{id}
```
Resultado:
Devuelve los detalles de un curso específico.
```

#### Actualizar Curso por ID
- PUT /api/cursos/{id}
```json
Body:
{
  "nombre": "Curso de Física",
  "descripcion": "Aprende mecánica y óptica",
  "duracion": 40
}
```
Resultado:
Actualiza los datos del curso con el ID especificado.

#### Eliminar Curso por ID
- DELETE /api/cursos/{id}
```
Resultado:
Elimina el curso con el ID especificado.
```

---
### 2. Estudiantes

#### Crear Estudiante
- POST /api/estudiantes
```json
Body:
{
  "nombre": "Juan Pérez",
  "correo": "juan.perez@gmail.com",
  "edad": 25
}
```
Resultado:
Se crea un estudiante con los datos proporcionados.

#### Listar Estudiantes
- GET /api/estudiantes
```
Resultado:
Devuelve la lista de todos los estudiantes.
```
#### Listar Estudiante por ID
- GET /api/estudiantes/{id}
```
Resultado:
Devuelve los detalles de un estudiante específico.
```
#### Actualizar Estudiante por ID
- PUT /api/estudiantes/{id}
```json
Body:
{
  "nombre": "Luis Ramírez",
  "correo": "luis.ramirez@gmail.com",
  "edad": 28
}
```
```
Resultado:
Actualiza los datos del estudiante con el ID especificado.
```
#### Eliminar Estudiante por ID
- DELETE /api/estudiantes/{id}
```
Resultado:
Elimina el estudiante con el ID especificado.
```

---
### Verificación de contenedores

Para asegurarte de que los contenedores están en ejecución, utiliza el siguiente comando:

```bash
    docker ps
```

Ejemplo de salida esperada:
```plaintext
                        CONTAINER ID   IMAGE               PORTS                  NAMES
                        abc123456789   micro-cursos:1.0   0.0.0.0:8002->8002/tcp micro-cursos-container
                        def123456789   mysql:8.0          0.0.0.0:3307->3306/tcp mysql-container
```