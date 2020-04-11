import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentViewController {

    @FXML private ImageView studentImageView;
    @FXML private Label firstNameLabel;
    @FXML private Label lastNameLabel;
    @FXML private Label studentNumLabel;
    @FXML private Label birthdayLabel;
    @FXML private Label ageLabel;
    @FXML private ListView activitiesListView;
    @FXML private ListView<Student> studentListView;
    private Student selectedStudent;

    /**
     * When the Create New Student button is pressed in the Student View, the create new student view is opened (with blank text fields)
     * to allow another student to be created.
     * @param event
     * @throws IOException
     */
    public void newStudentButtonPushed(javafx.event.ActionEvent event) throws IOException {
        Parent studentViewParent = FXMLLoader.load(getClass().getResource("NewStudentView.fxml"));
        Scene studentViewScene = new Scene(studentViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(studentViewScene);
        window.show();
    }

    /**
     * This method receives the student object from the create new student view, adds the new student to the studentListView
     * for display in the student view, and updates the student view GUI.
     * @param student
     */
    public void selectedStudent(Student student){
        selectedStudent = student;
        studentListView.getItems().addAll(Main.getStudents());
        updateGUI();
    }

    /**
     * This method updates each field in the student view window with the student's information.
     */
    public void updateGUI(){
        firstNameLabel.setText(selectedStudent.getFirstName());
        lastNameLabel.setText(selectedStudent.getLastName());
        studentNumLabel.setText(selectedStudent.getStudentNum());
        birthdayLabel.setText(selectedStudent.getBirthday().toString());
        ageLabel.setText(Integer.toString(selectedStudent.getAge()));
        studentImageView.setImage(selectedStudent.getStudentPic());
        activitiesListView.getItems().setAll(selectedStudent.getActivities()); // uses setAll method to replace current activities in listview.
    }

    /**
     * When a student is selected in the studentListView, this method calls the updateGUI method to update the gui with the correct information.
     */
    public void selectStudent(){
        selectedStudent = studentListView.getSelectionModel().getSelectedItem();
        updateGUI();
    }
}
