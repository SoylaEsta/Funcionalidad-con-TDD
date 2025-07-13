package pom.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoServiceTest {

    private ProductoService service;

    @BeforeEach
    void setUp() {
        service = new ProductoService();
    }

    @Test
    void testCrearProducto_conIdDuplicado() {
        Producto p1 = new Producto(105, "Router", 24990.0);
        Producto p2 = new Producto(105, "Router Pro", 34990.0);

        service.crearProducto(p1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.crearProducto(p2);
        });
    }

    @Test
    void testCrearProductoFirebase_productoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.crearProductoFirebase(null);
        });
    }
}
