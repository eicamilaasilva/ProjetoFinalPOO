package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe responsável por iniciar o programa e abrir
 * as telas iniciais do sistema FocusUp.
 *
 * @author Camila
 * @version 1.0
 */
public class FocusUpApp extends Application {

    /**
     * Inicializa a aplicação e apresenta a tela principal.
     *
     * @param stage Janela principal da aplicação JavaFX.
     * @throws Exception Caso ocorra algum erro ao carregar a interface.
     */
    @Override
    public void start(Stage stage) throws Exception {

        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("/view/MainView.fxml")),
                640,
                400
        ));

        stage.setTitle("FocusUp — Organizador de Estudos");
        stage.show();
    }

    /**
     * Método principal responsável por executar a aplicação.
     *
     * @param args Argumentos recebidos na inicialização do programa.
     */
    public static void main(String[] args) {
        launch(args);
    }
}