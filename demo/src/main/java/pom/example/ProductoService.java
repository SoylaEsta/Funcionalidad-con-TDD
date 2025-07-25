package pom.example;

import java.util.*;
import com.google.firebase.database.*;

public class ProductoService {
    private Map<Integer, Producto> repositorio = new HashMap<>();

    // -------------------- CRUD LOCAL --------------------

    public void crearProducto(Producto producto) {
        validarIdUnico(producto.getId());
        repositorio.put(producto.getId(), producto);
    }

    private void validarIdUnico(int id) {
        if (repositorio.containsKey(id)) {
            throw new IllegalArgumentException("ID duplicado");
        }
    }

    public Producto buscarProductoPorId(int id) {
        return repositorio.get(id);
    }

    public void actualizarProducto(Producto producto) {
        validarExistencia(producto.getId());
        repositorio.put(producto.getId(), producto);
    }

    private void validarExistencia(int id) {
        if (!repositorio.containsKey(id)) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
    }

    public void eliminarProducto(int id) {
        if (!repositorio.containsKey(id)) {
            System.out.println(" Producto con ID " + id + " no existe.");
        }
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
        if (producto == null || producto.getId() == 0 || producto.getNombre() == null) {
            throw new IllegalArgumentException("Producto inválido");
        }

        FirebaseUtil.inicializarUnaVez();

        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference("productos")
                .child(String.valueOf(producto.getId()));

        ref.setValueAsync(producto);
    }

    public void buscarProductoPorIdFirebase(int id) {
        FirebaseUtil.inicializarUnaVez();

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
        FirebaseUtil.inicializarUnaVez();

        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference("productos")
                .child(String.valueOf(id));

        ref.removeValueAsync();
        System.out.println("Producto eliminado de Firebase.");
    }
}
