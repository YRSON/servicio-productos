# Challenge Backend Java - Servicio de Productos

Este proyecto es el **Microservicio de Productos** como parte de un challenge técnico. Es un servicio reactivo que expone una API REST para gestionar productos.

---

## 🚀 Tecnologías Implementadas

Este proyecto demuestra una arquitectura moderna y reactiva, cubriendo los siguientes puntos:

* **Java 17:** Uso de `Records` para DTOs inmutables.
* **Spring Boot 3:** Framework principal.
* **Spring WebFlux:** Stack 100% reactivo y no bloqueante para los endpoints (Requisito Opcional).
* **Programación Funcional:**
    * Uso de `Mono` y `Flux` (Project Reactor) para manejar flujos de datos asíncronos.
    * Uso de `Streams` y expresiones `Lambda` para la lógica de negocio.
* **Pruebas Unitarias:**
    * **JUnit 5** para la estructura de los tests.
    * **`reactor-test`** (StepVerifier) para probar la lógica de `Mono` y `Flux`.
* **Manejo de Errores:**
    * Implementación de un `GlobalExceptionHandler` (`@RestControllerAdvice`) para centralizar las respuestas de error (Mejora).
    * Excepciones personalizadas (`ProductNotFoundException`).

---

## 📋 Cómo Ejecutar

1.  **Clonar el repositorio:**
    ```bash
    git clone [TU_LINK_DE_GITHUB_AQUI]
    ```
2.  **Navegar al directorio:**
    ```bash
    cd servicio-productos
    ```
3.  **Configuración de Puerto:**
    Este servicio está configurado para correr en el puerto `8081` (definido en `application.properties`).
4.  **Ejecutar el proyecto (requiere Maven):**
    ```bash
    mvn spring-boot:run
    ```
5.  El servicio estará corriendo en `http://localhost:8081`.

---

## 📦 Endpoints de la API

* `GET /products`
    * Devuelve un `Flux` (lista) de todos los productos.
* `GET /products/{id}`
    * Devuelve un `Mono` (un) producto por su ID.
    * Devuelve un JSON de error 404 personalizado si no se encuentra.

### Ejemplos de Prueba (Endpoints)

Asegúrate de que el servicio esté corriendo (`:8081`).

* **Probar `GET /products/{id}` (Éxito):**
    * [http://localhost:8081/products/1](http://localhost:8081/products/1)
* **Probar `GET /products/{id}` (Error 404):**
    * [http://localhost:8081/products/999](http://localhost:8081/products/999)