import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {

    private Student student;
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

        //This line is to add the observable list to the view, however observable list was not working so it was converted to arraylist
        //favActivitiesListView.setItems(Student.getActivities());
    }
}
