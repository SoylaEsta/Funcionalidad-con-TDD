package pom.example; 
import org.junit.jupiter.api.Test;
import pom.example.ProductoService;
import pom.example.Producto;
import static org.junit.jupiter.api.Assertions.*;


 // Este método aún NO existe → el test fallará
public class ProductoServiceTest {

   
    @Test
    void testProductoInexistenteDebeFallar() {
        ProductoService service = new ProductoService();

        // No se ha creado este producto, por lo tanto debería ser null
        Producto resultado = service.buscarProductoPorId(99);

        // Este assert va a FALLAR porque estamos forzando una condición falsa
        assertNotNull(resultado);  // ← RED forzado
    }


}