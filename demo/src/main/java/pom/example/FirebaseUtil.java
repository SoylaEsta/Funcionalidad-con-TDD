package pom.example;

public class FirebaseUtil {
    private static boolean inicializado = false;

    public static void inicializarUnaVez() {
        if (!inicializado) {
            FirebaseConfig.inicializarFirebase();
            inicializado = true;
            System.out.println("Firebase conectado con éxito (una vez).");
        } else {
            System.out.println("Firebase ya estaba conectado.");
        }
    }
}
