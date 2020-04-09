import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

public class StudentViewController {

    @FXML private ImageView studentImageView;
    @FXML private Label firstNameLabel;
    @FXML private Label lastNameLabel;
    @FXML private Label studentNumLabel;
    @FXML private Label birthdayLabel;
    @FXML private Label ageLabel;
    @FXML private ListView activitiesListView;
    @FXML private ListView<Student> studentListView;
    @FXML private Button newStudentButton;
    private Student selectedStudent;


    public void newStudentButtonPushed(javafx.event.ActionEvent event) throws IOException {
        Parent studentViewParent = FXMLLoader.load(getClass().getResource("NewStudentView.fxml"));
        Scene studentViewScene = new Scene(studentViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(studentViewScene);
        window.show();
    }

    public void initData(Student student){
        selectedStudent = student;
        firstNameLabel.setText(selectedStudent.getFirstName());
        lastNameLabel.setText(selectedStudent.getLastName());
        studentNumLabel.setText(selectedStudent.getStudentNum());
        birthdayLabel.setText(selectedStudent.getBirthday().toString());
        ageLabel.setText(Integer.toString(selectedStudent.getAge()));
        studentImageView.setImage(selectedStudent.getStudentPic());
//        activitiesListView.getItems()
        studentListView.getItems().addAll(Main.getStudents());
    }
}
