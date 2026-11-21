package app;

import javafx.application.Application;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FocusUpApp extends Application
{
    @Override public void start(Stage stage)throws Exception
    {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MainView.fxml")),640,400));
        stage.setTitle("FocusUp — Organizador de Estudos");
        stage.show();
    }
    public static void main(String[]args)
    {
        launch(args);
    }
}
