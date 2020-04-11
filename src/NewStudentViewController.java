import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class NewStudentViewController implements Initializable {

    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField studentNumberTextField;
    @FXML private CheckBox runningCheckbox;
    @FXML private CheckBox codingCheckbox;
    @FXML private CheckBox skiingCheckbox;
    @FXML private CheckBox readingCheckbox;
    @FXML private CheckBox hikingCheckbox;
    @FXML private CheckBox travelingCheckbox;
    @FXML private CheckBox photographyCheckbox;
    @FXML private CheckBox gamingCheckbox;
    @FXML private Label errorLabel;
    @FXML private Label ageLabel;
    @FXML private DatePicker birthdayDatePicker;
    @FXML private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Initialize student number textfield to contain the current student's number, without actually affecting the studentNum global static variable.
        int studentNumInt = Student.studentNum + 1;
        String studentNumString = Integer.toString(studentNumInt);
        studentNumberTextField.setText(studentNumString);
    }

    /**
     * When the submit button is pushed, the readyToSubmit method is called, and if this method is passed (returns true) the student object is created,
     * the addActivities method is called to read the selected checkboxes and add the appropriate activities to the student object, the new student object
     * is added to the student ArrayList (to be added to the studentListView), and the scene is changed to the student view scene, with the student object
     * passed into this view for display in the GUI.
     * @param event
     */
    public void submitButtonPushed(ActionEvent event){
        if (readyToSubmit()){
            LocalDate birthday = birthdayDatePicker.getValue();
            try {
                Student student = new Student(firstNameTextField.getText(), lastNameTextField.getText(), birthday, imageView.getImage());
                addActivities(student);
                Main.getStudents().add(student);
                changeSceneToStudentView(event, student);
            }
            catch(IllegalArgumentException | IOException e){
                errorLabel.setText(e.getMessage());
            }
        }
    }

    /**
     * This method changes the scene to the StudentView scene. It also passes the current student object to the scene, and calls a method
     * in the Student View controller that updates the student view GUI.
     * @param event
     * @param student
     * @throws IOException
     */
    public void changeSceneToStudentView(ActionEvent event, Student student) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("StudentView.fxml"));
        Parent studentViewParent = loader.load();
        Scene studentViewScene = new Scene(studentViewParent);

        //access the controller and call methods
        StudentViewController controller = loader.getController();
        controller.selectedStudent(student);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("View Students");
        window.setScene(studentViewScene);
        window.show();
    }

    /**
     * This method checks if the fields are empty, and if any of them are throws an error message. If they are not, it evaluates to true and allows
     * submitButtonPushed method above to run and create a new Student object.
     * @return
     */
    private boolean readyToSubmit() {

        List<TextField> inputFields = Arrays.asList(firstNameTextField, lastNameTextField);

        String error = "The following fields are empty: ";

        for(TextField field: inputFields){
            if(field.getText().isEmpty()){

                error = String.format("%s %s,", error, field.getPromptText());
            }
        }

        if(error.equals("The following fields are empty: ")){
            if(birthdayDatePicker.getValue() == null){
                errorLabel.setText(error + birthdayDatePicker.getPromptText());
                return false;
            }
            else{
                errorLabel.setText("");
                return true;
            }
        }
        else if(birthdayDatePicker.getValue() == null){
            errorLabel.setText(error + " " + birthdayDatePicker.getPromptText());
            return false;
        }
        else
            errorLabel.setText(error.substring(0, error.length()-1));
            return false;
    }

    /**
     * This method creates a string to be added to an arraylist of student interests based on which checkboxes were selected in the GUI.
     * The arraylist contents are displayed using the join() method.
     * @param student
     */
    private void addActivities(Student student) {

        String activity;
        if(runningCheckbox.isSelected()){
            activity = "Running";
            student.setActivities(activity);
        }
        if(codingCheckbox.isSelected()){
            activity = "Coding";
            student.setActivities(activity);
        }
        if(skiingCheckbox.isSelected()){
            activity = "Skiing";
            student.setActivities(activity);
        }
        if(readingCheckbox.isSelected()){
            activity = "Reading";
            student.setActivities(activity);
        }
        if(hikingCheckbox.isSelected()){
            activity = "Hiking";
            student.setActivities(activity);
        }
        if(travelingCheckbox.isSelected()){
            activity = "Traveling";
            student.setActivities(activity);
        }
        if(photographyCheckbox.isSelected()){
            activity = "Photography";
            student.setActivities(activity);
        }
        if(gamingCheckbox.isSelected()){
            activity = "Gaming";
            student.setActivities(activity);
        }
    }

    /**
     * This method calculates the student's age and displays it in a label on the GUI.
     * It does not use student getAge() method as it is meant to be fired when date is picked, not when the submit button is pushed.
     */
   @FXML private void getAge(){
        LocalDate birthday = birthdayDatePicker.getValue();
        //calculate age
        int age = Period.between(birthday, LocalDate.now()).getYears();

        //display age variable in age label
        ageLabel.setText("" + age);
    }

    /**
     * This method fills the textboxes and selects checkboxes with default information.
     */
    @FXML private void loadDefaultStudent(){
       firstNameTextField.setText("Alex");
       lastNameTextField.setText("Blom");
       birthdayDatePicker.setValue(LocalDate.of(1989, 10, 4));
       readingCheckbox.setSelected(true);
       codingCheckbox.setSelected(true);
       gamingCheckbox.setSelected(true);
    }

    /**
     * This method opens a file chooser dialog box when the user clicks the Choose Image button. This file chooser is configured to
     * open the user's Pictures directory by default, and filter for .jpg and .png files. When an image is selected, this image
     * fills the ImageView object in the GUI.
     * @param event
     */
    @FXML private void chooseImageButtonPushed(ActionEvent event){

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        FileChooser fileChooser = new FileChooser(); // create new fileChooser object
        fileChooser.setTitle("Choose Image");

        // filter for .jpg and .png
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(imageFilter);


        File imageFile = fileChooser.showOpenDialog(stage); // open file chooser dialog box

        // set the default directory
        String userDirectoryString = System.getProperty("user.home") + "\\Pictures";
        File userDirectory = new File(userDirectoryString);

        // confirm that the system can reach the directory
        if(!userDirectory.canRead()){
            userDirectory = new File(System.getProperty("user.home"));
        }

        // set the FileChooser to start with userDirectory
        fileChooser.setInitialDirectory(userDirectory);

        if(imageFile != null && imageFile.isFile()){
//            System.out.println(imageFile.getPath());
            imageView.setImage(new Image(imageFile.toURI().toString()));
        }
    }



}
