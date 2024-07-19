package gm.tareas.controlador;


import gm.tareas.modelo.Tarea;
import gm.tareas.servicio.TareaServicio;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.net.URL;
import java.util.ResourceBundle;

@Component
public class IndexControlador implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class); // Mandar informacion de esta clase a consola

    @Autowired
    private TareaServicio tareaServicio;

    // Elementos de la Tabla
    @FXML
    private TableView<Tarea> tareaTabla; // Importar de JavaFX

    @FXML // Mapeamos las columnas
    private TableColumn<Tarea, Integer> idTareaColumna; // Integer -> Columna ID

    @FXML
    private TableColumn<Tarea, String> nombreTareaColumna;

    @FXML
    private TableColumn<Tarea, String> responsableTareaColumna;

    @FXML
    private TableColumn<Tarea, String> estatusTareaColumna;

    // Base de Datos
    private final ObservableList<Tarea> tareasList = FXCollections.observableArrayList(); // Lista Observable, si se modifica se quedara reflejado

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tareaTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // Solo selecciona un elemento de la tabla, sobre todo para modificar y eliminar solo uno
        configurarColumnas();
    }

    private void configurarColumnas(){
        idTareaColumna.setCellValueFactory(new PropertyValueFactory<>("idTarea")); // Proporcionar el nombre del Atributo de Modelo > Tarea
        nombreTareaColumna.setCellValueFactory(new PropertyValueFactory<>("nombreTarea"));
        responsableTareaColumna.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        estatusTareaColumna.setCellValueFactory(new PropertyValueFactory<>("estatus"));
    }
}
