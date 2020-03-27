import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

//Begin JavaFX integration.
public class Main extends Application {
    public static void main (String[] args){
//        Student student = new Student("Alex","Blom",867295);
//        System.out.println(student);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("StudentView.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("Student Card");
        stage.setScene(scene);
        stage.show();
    }
}
