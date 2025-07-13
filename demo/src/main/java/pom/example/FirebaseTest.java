package pom.example;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FirebaseTest {
    public static void main(String[] args) {
        FirebaseConfig.inicializarFirebase();

        ProductoService service = new ProductoService();
        Producto producto = new Producto(104, "Audífonos Bluetooth", 35990.0);

        service.crearProductoFirebase(producto);

        System.out.println("Producto guardado correctamente en Firebase.");
    }
}