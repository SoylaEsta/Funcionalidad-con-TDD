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
    // ----------- CREAR PRODUCTO -----------
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
    
    // ----------- ACTUALIZAR PRODUCTO -----------
    @Test
    void testActualizarProducto_inexistente() {
        Producto nuevo = new Producto(5, "SSD 256GB", 39990.0);
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.actualizarProducto(nuevo);
        });
    }

    @Test
    void testActualizarProducto_exitosamente() {
        Producto original = new Producto(6, "Monitor", 99990.0);
        service.crearProducto(original);

        Producto actualizado = new Producto(6, "Monitor 24 pulgadas", 109990.0);
        service.actualizarProducto(actualizado);

        Producto resultado = service.buscarProductoPorId(6);
        assertEquals("Monitor 24 pulgadas", resultado.getNombre());
        assertEquals(109990.0, resultado.getPrecio());
    }


    // ----------- ELIMINAR PRODUCTO -----------
    @Test
    void testEliminarProducto_inexistente() {
    assertDoesNotThrow(() -> {
        service.eliminarProducto(999); // ID no creado
    });
    }

    @Test
    void testEliminarProducto_existente() {
    Producto p = new Producto(20, "Tablet", 79990.0);
    service.crearProducto(p);

    service.eliminarProducto(20);

    assertFalse(service.existeProducto(20)); // el producto ya no debe estar
    }

    
    // ----------- ELIMINAR PRODUCTO -----------

    @Test
    void testListarProductos_inicialmenteVacio() {
    assertTrue(service.listarProductos().isEmpty());
    }

}

