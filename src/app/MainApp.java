package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Abre o Dashboard unificado com as abas de Matérias, Tarefas e Avaliações
        new MainDashboardFX().start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}