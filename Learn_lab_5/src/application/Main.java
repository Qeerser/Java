package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pane.RootPane;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        RootPane mainpane = new RootPane();
        Scene main = new Scene(mainpane,800,640);
        stage.setScene(main);
        stage.setTitle("SIMPLE(?) TO DO LISTS");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
