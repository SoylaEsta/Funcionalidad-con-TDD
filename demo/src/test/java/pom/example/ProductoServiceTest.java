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
    //CREAR PRODUCTO
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
    
    //ACTUALIZAR PRODUCTO
    @Test
    void testActualizarProducto_inexistente() {
        Producto nuevo = new Producto(5, "SSD 256GB", 39990.0);
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.actualizarProducto(nuevo);
        });
    }



}

