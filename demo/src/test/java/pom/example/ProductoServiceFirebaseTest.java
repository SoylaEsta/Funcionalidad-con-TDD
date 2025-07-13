package pom.example;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoServiceFirebaseTest {

    private ProductoService service;

    @BeforeEach
    void setUp() {
        service = new ProductoService(); // ✅ Esto inicializa el objeto
    }

    
    
    // ----------- CREAR PRODUCTO -----------
    @Test
    void testCrearProductoFirebase_valido() {
    Producto producto = new Producto(301, "Impresora", 45990.0);
    assertDoesNotThrow(() -> {
        service.crearProductoFirebase(producto);
    });
    }

    @Test
    void testCrearProductoFirebase_null() {
    assertThrows(IllegalArgumentException.class, () -> {
        service.crearProductoFirebase(null);
    });
    }

    // -----------  ELIMMINAR PRODUCTO -----------
    @Test
    void testEliminarProductoFirebase_noLanzaExcepcion() {
    assertDoesNotThrow(() -> {
        service.eliminarProductoFirebase(9999); 
    });
    }

    // ----------- ACTUALIZAR PRODUCTO -----------
    @Test
    void testActualizarProductoFirebase_valido() {
    Producto producto = new Producto(302, "Scanner", 19990.0);
    assertDoesNotThrow(() -> {
        service.actualizarProductoFirebase(producto);
    });
    }

    // ----------- BUSCAR X ID PRODUCTO EXISTENTE -----------
    @Test
    void testBuscarProductoPorIdFirebase_existente() throws InterruptedException {
    Producto producto = new Producto(501, "Tablet", 89990.0);
    service.crearProductoFirebase(producto);

    // Espera breve para permitir que Firebase guarde antes de leer
    Thread.sleep(2000);

    assertDoesNotThrow(() -> {
        service.buscarProductoPorIdFirebase(501);
    });

    // Aquí no podemos capturar directamente el resultado, pero al menos verificamos que no lanza error
    }

    // ----------- BUSCAR X ID PRODUCTO INEXISTENTE -----------

    @Test
    void testBuscarProductoPorIdFirebase_inexistente() {
    assertDoesNotThrow(() -> {
        service.buscarProductoPorIdFirebase(9999);
    });
}



}
