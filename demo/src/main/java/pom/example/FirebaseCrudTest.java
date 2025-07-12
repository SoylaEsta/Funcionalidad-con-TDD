package pom.example;

public class FirebaseCrudTest {
    public static void main(String[] args) {
        // Inicializar conexión
        FirebaseConfig.inicializarFirebase();
        ProductoService service = new ProductoService();

        // 🔁 1. Crear producto
        Producto nuevo = new Producto(101, "Notebook Lenovo", 499990.0);
        service.crearProductoFirebase(nuevo);
        System.out.println(" Producto creado.");

        // 🔍 2. Buscar producto
        service.buscarProductoPorIdFirebase(101);

        // ♻️ 3. Actualizar producto (nuevo precio)
        nuevo.setPrecio(459990.0);
        service.actualizarProductoFirebase(nuevo);

        // 🔍 4. Buscar nuevamente para ver el cambio
        service.buscarProductoPorIdFirebase(101);

        // 🗑️ 5. Eliminar producto
        service.eliminarProductoFirebase(101);

        // ❌ 6. Intentar buscar producto eliminado
        service.buscarProductoPorIdFirebase(101);
    }
}
