import org.junit.jupiter.api.Test;

import pom.example.ProductoService;
import pom.example.Producto;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoServiceTest {

    @Test
    void testCrearProducto() {
        ProductoService service = new ProductoService();
        Producto producto = new Producto(1, "Teclado", 19990.0);
        service.crearProducto(producto);

        Producto resultado = service.buscarProductoPorId(1);
        assertNotNull(resultado);
        assertEquals("Teclado", resultado.getNombre());
    }
}