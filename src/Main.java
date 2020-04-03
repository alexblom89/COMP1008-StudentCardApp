import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.time.LocalDate;
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
        Parent root = FXMLLoader.load(getClass().getResource("NewStudentView.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("Create New Student");
        stage.setScene(scene);
        stage.show();

        Image image = new Image("/img/avatar.png");
        ImageView studentPic = new ImageView();
        studentPic.setImage(image);

    }
}
