package pom.example;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.FileInputStream;

public class FirebaseConfig {

    public static void inicializarFirebase() {
        try {
            FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/firebase-Key.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://funcionalidad-con-tdd-default-rtdb.firebaseio.com/") 
                .build();

            FirebaseApp.initializeApp(options);
            System.out.println("🔥 Firebase conectado con éxito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
