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

    
    // ----------- LISTAR PRODUCTO -----------

    @Test
    void testListarProductos_inicialmenteVacio() {
    assertTrue(service.listarProductos().isEmpty());
    }

    @Test
    void testListarProductos_conProductos() {
    service.crearProducto(new Producto(1, "Teclado", 19990.0));
    service.crearProducto(new Producto(2, "Mouse", 9990.0));

    assertEquals(2, service.listarProductos().size());
    }

    // ----------- BUSCAR PRODUCTO -----------
    @Test
    void testBuscarProducto_noExistente() {
    Producto resultado = service.buscarProductoPorId(500);
    assertNull(resultado);
    }


    // ----------- EXISTE PRODUCTO -----------
    @Test
    void testExisteProducto_trueYFalse() {
    Producto p = new Producto(88, "Power Bank", 25990.0);
    service.crearProducto(p);

    assertTrue(service.existeProducto(88));
    assertFalse(service.existeProducto(999)); // no existe
    }


    // ----------- INICIAR FIREBASE -----------
    @Test
    void testInicializarFirebase_noLanzaError() {
    assertDoesNotThrow(() -> FirebaseConfig.inicializarFirebase());
    }

    // ----------- CREAR PRODUCTO FIREBASE -----------
    @Test
    void testCrearProductoFirebase_valido() {
    Producto producto = new Producto(108, "Mouse inalámbrico", 15990.0);
    assertDoesNotThrow(() -> {
        service.crearProductoFirebase(producto);
    });
    }

    // ----------- GETTERS & SETTERS -----------
    @Test
    void testGettersYSetters() {
    Producto p = new Producto(1, "Producto", 1000.0);
    p.setId(2);
    p.setNombre("Nuevo");
    p.setPrecio(2000.0);

    assertEquals(2, p.getId());
    assertEquals("Nuevo", p.getNombre());
    assertEquals(2000.0, p.getPrecio());
}


}

