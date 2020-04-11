import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;

//Begin JavaFX integration.
public class Main extends Application {

    private static ArrayList<Student> students;

    public static void main (String[] args){
        students = new ArrayList<>();
        launch(args);
    }

    public static ArrayList<Student> getStudents(){
        return students;
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
