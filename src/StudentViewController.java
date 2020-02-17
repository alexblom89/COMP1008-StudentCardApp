import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {

    private Student student;
    private ArrayList<String> activities;
    @FXML private ImageView studentImageView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Student student = new Student("Alex", "Blom", 867295, activities, studentImageView);

        activities =
        studentImageView.setImage(student.getStudentPic());
    }
}
