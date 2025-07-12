package pom.example;

import java.util.*;
import com.google.firebase.database.*;

public class ProductoService {
    private Map<Integer, Producto> repositorio = new HashMap<>();

    // -------------------- CRUD LOCAL --------------------

    public void crearProducto(Producto producto) {
        repositorio.put(producto.getId(), producto);
    }

    public Producto buscarProductoPorId(int id) {
        return repositorio.get(id);
    }

    public void actualizarProducto(Producto producto) {
        if (!repositorio.containsKey(producto.getId())) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
        repositorio.put(producto.getId(), producto);
    }

    public void eliminarProducto(int id) {
        repositorio.remove(id);
    }

    public List<Producto> listarProductos() {
        return new ArrayList<>(repositorio.values());
    }

    public boolean existeProducto(int id) {
        return repositorio.containsKey(id);
    }

    // -------------------- CRUD FIREBASE --------------------

    public void crearProductoFirebase(Producto producto) {
        FirebaseConfig.inicializarFirebase();
        DatabaseReference ref = FirebaseDatabase.getInstance()
            .getReference("productos")
            .child(String.valueOf(producto.getId()));
        ref.setValueAsync(producto);
    }

    public void buscarProductoPorIdFirebase(int id) {
        FirebaseConfig.inicializarFirebase();
        DatabaseReference ref = FirebaseDatabase.getInstance()
            .getReference("productos")
            .child(String.valueOf(id));

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Producto producto = snapshot.getValue(Producto.class);
                    System.out.println("Producto encontrado: " + producto.getNombre() + " ($" + producto.getPrecio() + ")");
                } else {
                    System.out.println("Producto con ID " + id + " no encontrado.");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.err.println("Error al leer: " + error.getMessage());
            }
        });
    }

    public void actualizarProductoFirebase(Producto producto) {
        crearProductoFirebase(producto); // Sobrescribe el mismo nodo
        System.out.println("Producto actualizado en Firebase.");
    }

    public void eliminarProductoFirebase(int id) {
        FirebaseConfig.inicializarFirebase();
        DatabaseReference ref = FirebaseDatabase.getInstance()
            .getReference("productos")
            .child(String.valueOf(id));
        ref.removeValueAsync();
        System.out.println("Producto eliminado de Firebase.");
    }
}

