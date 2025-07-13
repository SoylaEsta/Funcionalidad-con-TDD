package pom.example;

import com.google.firebase.database.DatabaseReference;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class ProductoServiceMockTest {

    @Test
    void testSetValueAsync_esLlamado() {
        // 1. Crear un producto de prueba
        Producto producto = new Producto(107, "Cargador portátil", 15990.0);

        // 2. Mockear DatabaseReference
        DatabaseReference refMock = mock(DatabaseReference.class);

        // 3. Simular que se llama a setValueAsync
        refMock.setValueAsync(producto);

        // 4. Verificar que se llamo una vez
        verify(refMock, times(1)).setValueAsync(producto);
    }
}
