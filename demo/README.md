# 🧪 Funcionalidad con TDD – Proyecto ABP. Java + Maven + JUnit

Este proyecto consiste en la implementación de una funcionalidad CRUD para una clase `Producto`, aplicando el enfoque **Desarrollo Guiado por Pruebas (TDD)** en Java. Es parte del módulo "Automatización de Pruebas" de la Fundación.

---

## 📌 Objetivo

Desarrollar un módulo funcional con operaciones básicas (Crear, Leer, Actualizar y Eliminar) aplicando correctamente el ciclo:

- 🔴 Red → 🟢 Green → ♻️ Refactor

Se utiliza el patrón de diseño basado en principios SOLID, y pruebas unitarias con **JUnit 5** para asegurar el comportamiento esperado del sistema.

---
## ✅ Funcionalidades Implementadas (CRUD)

- **crearProducto(Producto producto)**  
- **buscarProductoPorId(int id)**  
- **actualizarProducto(Producto producto)**  
- **eliminarProducto(int id)**  
- **listarProductos(): List<Producto>**

---

## 🧪 Pruebas Unitarias

Se implementaron pruebas usando JUnit 5 para validar el comportamiento de cada funcionalidad.

### 📋 Ejemplos de pruebas:

- Crear un producto y verificar que esté guardado  
- Actualizar un producto existente  
- Eliminar un producto y validar que ya no esté  
- Listar productos y confirmar su contenido  
- Lanzar excepciones en casos inválidos

---

## 📂 Estructura del Proyecto

Funcionalidad-con-TDD/
├── pom.xml
├── src
│ ├── main
│ │ └── java
│ │ └── Producto.java
│ │ └── ProductoService.java
│ └── test
│ └── java
│ └── ProductoServiceTest.java

---

## ⚙️ Tecnologías y Herramientas

- 💻 Java 17  
- 🧪 JUnit 5  
- 📦 Maven  
- 👩‍💻 Visual Studio Code  
- ☁️ GitHub

---

## 🚀 ¿Cómo clonar y configurar el proyecto?

1. Clona el repositorio:

```bash
git clone https://github.com/SoylaEsta/Funcionalidad-con-TDD.git
cd Funcionalidad-con-TDD

## Proyecto realizado por @SoylaEsta 