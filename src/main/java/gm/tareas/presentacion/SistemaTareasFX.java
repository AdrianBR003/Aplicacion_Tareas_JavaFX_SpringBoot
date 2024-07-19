package gm.tareas.presentacion;

import gm.tareas.TareasApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class SistemaTareasFX extends Application {
//    Metodo Usual (Sin Spring)
//    public static void main(String[] args) {
//        launch(args);
//    }

    private ConfigurableApplicationContext applicationContext;

    @Override // Definido en la clase Application JavaFx
    public void init(){
        this.applicationContext = new SpringApplicationBuilder(TareasApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(TareasApplication.class.getResource("/templates/index.fxml")); // Cargar en memoria la interfaz de JavaFX
        loader.setControllerFactory(applicationContext::getBean); // Integrar las tecnologias de Spring y cargarlos dentro de JavaFx
        Scene escena = new Scene(loader.load());
        stage.setScene(escena);
        stage.show(); // Visualizar la informacion
    }

    public void stop(){
        applicationContext.close(); // Cerrar cualquier conexion como la de BD o Spring
        Platform.exit(); // Cerrar JavaFx
    }

}
