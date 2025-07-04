package pom.example;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class ProductoService {
    private Map<Integer, Producto> repositorio = new HashMap<>();

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



}

