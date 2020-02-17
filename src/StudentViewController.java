import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {

    private Student student;
    private ArrayList<String> activities;
    @FXML private ImageView studentImageView;
    @FXML private Label firstNameVar;
    @FXML private Label lastNameVar;
    @FXML private Label studentNumVar;
    @FXML private ListView favActivitiesListView;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Student student = new Student("Alex", "Blom", 867295);

        studentImageView.setImage(student.getStudentPic());

        firstNameVar.setText(student.getFirstName());

        lastNameVar.setText(student.getLastName());

        studentNumVar.setText(student.getStudentNum());

        favActivitiesListView.setItems(student.getActivities());
    }
}
