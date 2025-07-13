
# 🧪 Funcionalidad con TDD – Proyecto ABP. Java + Maven + JUnit

Este proyecto consiste en la implementación de una funcionalidad CRUD para una clase `Producto`, aplicando el enfoque **Desarrollo Guiado por Pruebas (TDD)** en Java. Es parte del módulo *Automatización de Pruebas*.

---

## 📌 Objetivo

Desarrollar un módulo funcional con operaciones básicas (Crear, Leer, Actualizar y Eliminar) aplicando correctamente el ciclo:

🔴 Red → 🟢 Green → ♻️ Refactor

Se utiliza el patrón de diseño basado en principios **SOLID**, y pruebas unitarias con **JUnit 5** para asegurar el comportamiento esperado del sistema.

---

## Funcionalidades Implementadas (CRUD)

- `crearProducto(Producto producto)`  
- `buscarProductoPorId(int id)`  
- `actualizarProducto(Producto producto)`  
- `eliminarProducto(int id)`  
- `listarProductos(): List<Producto>`

Incluye versiones locales (Map) y remotas con **Firebase Realtime Database**.

---

## Pruebas Unitarias

Se implementaron pruebas usando **JUnit 5** y **Mockito** para validar el comportamiento esperado de cada operación.

### Cobertura de pruebas:
- ✅ Crear un producto válido y con ID duplicado
- ✅ Eliminar producto existente e inexistente
- ✅ Actualizar producto con datos válidos e inválidos
- ✅ Validar comportamiento de Firebase (crear, actualizar, eliminar, buscar)
- ✅ Validación de getters/setters del modelo

---

##  Progreso por Lecciones

### Lección 1 – Introducción al TDD  
- ✅ Se comprendió y aplicó el ciclo Red → Green → Refactor  
- ✅ Se configuró el entorno con Maven, JUnit y JaCoCo  
- ✅ Se creó la clase `Producto` como base del modelo

---

### Lección 2 – Implementación de operaciones CRUD con TDD  
- ✅ Se implementaron las 4 operaciones CRUD con mínimo 3 ciclos TDD por operación  
- ✅ Se desarrollaron más de 12 pruebas unitarias  
- ✅ Se validaron entradas (IDs duplicados, campos nulos)  
- ✅ Se obtuvo cobertura con JaCoCo durante cada ciclo

---

### Lección 3 – Integración con Firebase  
- ✅ Se integró correctamente Firebase Realtime Database  
- ✅ Se implementaron operaciones CRUD remotas (crear, buscar, actualizar, eliminar)  
- ✅ Se utilizó `setValueAsync()` para persistencia en tiempo real  
- ✅ Se excluyeron correctamente archivos `FirebaseTest` y `FirebaseCrudTest` del reporte JaCoCo

---

### Lección 4 – Pruebas Unitarias y Mocking  
- ✅ Se crearon pruebas automatizadas para el CRUD local y Firebase  
- ✅ Se superó el mínimo de 8 pruebas unitarias exigidas  
- ✅ Se simuló una dependencia con Mockito  
- ✅ Se organizaron las pruebas en clases separadas

---

### Lección 5 – Cobertura de Código con JaCoCo  
- ✅ Se configuró correctamente JaCoCo en el `pom.xml`  
- ✅ Se generó el reporte HTML en `/target/site/jacoco/index.html`  
- ✅ Se logró más del **90% de cobertura de código**

---

### Lección 6 – Refactorización y principios de diseño  
El código fue optimizado aplicando principios **SOLID**, **DRY** y **KISS**:

- ✅ Se extrajo la clase `FirebaseUtil` para inicialización única  
- ✅ Se centralizó la validación de ID duplicado y existencia  
- ✅ Se redujo código duplicado y se mejoró la legibilidad general  
- ✅ Se reorganizó el código para separar responsabilidades

---




## 📂 Estructura del Proyecto

Funcionalidad-con-TDD/
├── pom.xml
├── .gitignore
├── README.md
├── src
│   ├── main
│   │   └── java/pom/example/
│   │       ├── Producto.java
│   │       ├── ProductoService.java
│   │       ├── FirebaseConfig.java
│   │       ├── FirebaseUtil.java
│   │       ├── FirebaseCrudTest.java
│   │       └── FirebaseTest.java
│   └── test
│       └── java/pom/example/
│           ├── ProductoServiceTest.java
│           ├── ProductoServiceMockTest.java
│           └── ProductoServiceFirebaseTest.java
└── target/


---

## ⚙️ Tecnologías y Herramientas

- 💻 Java 17  
- 🧪 JUnit 5  
- 📦 Maven  
- 🧰 Mockito  
- 📊 JaCoCo  
- ☁️ Firebase Realtime Database  
- 👩‍💻 Visual Studio Code  
- 🐙 Git + GitHub 
 
---

## 🚀 ¿Cómo clonar y configurar el proyecto?

1. Clona el repositorio:

```bash
git clone https://github.com/SoylaEsta/Funcionalidad-con-TDD.git
cd Funcionalidad-con-TDD



## Proyecto realizado por Gabriela Sepúlveda - @SoylaEsta 