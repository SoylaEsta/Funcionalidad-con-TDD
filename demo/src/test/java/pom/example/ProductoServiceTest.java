package pom.example; 
import org.junit.jupiter.api.Test;
import pom.example.ProductoService;
import pom.example.Producto;
import static org.junit.jupiter.api.Assertions.*;


 // Este método aún NO existe → el test fallará  → RED
public class ProductoServiceTest {

   
    @Test
    void testCrearProducto_red() {
        ProductoService service = new ProductoService();
        Producto nuevo = new Producto(1, "Teclado", 29990.0);

    
        service.crearProducto(nuevo);

        Producto resultado = service.buscarProductoPorId(1);
        assertNotNull(resultado);
    }


}