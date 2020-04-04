import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;

public class NewStudentViewController {

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


    /**
     * This method grabs all information from the Create New Student textfields and creates a new student object from said information.
     * The student number textfield text is parsed into an integer.
     * addActivities method is called in order to add the activities to the student object and display.
     * Method is wrapped in a try-catch block that displays an error message from the Student class should one of the set methods
     * display an error.
     */
    public void submitButtonPushed(){
        try {
            //Check if fields are empty, throw error if they are.
            if (firstNameTextField == null || firstNameTextField.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("First name field cannot be empty.");
            }
        }
        catch(IllegalArgumentException e){
            errorLabel.setText(e.getMessage());
            return;
        }

        try {
            if (lastNameTextField == null || lastNameTextField.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Last name field cannot be empty.");
            }
        }
        catch(IllegalArgumentException e){
            errorLabel.setText(e.getMessage());
            return;
        }

        try {
            if (birthdayDatePicker.getValue() == null){
                throw new IllegalArgumentException("Birthday cannot be empty.");
            }
        }
        catch(IllegalArgumentException e){
            errorLabel.setText(e.getMessage());
            return;
        }

        try {
            LocalDate birthday = birthdayDatePicker.getValue();

            Student student = new Student(firstNameTextField.getText(), lastNameTextField.getText(), birthday);

            studentNumberTextField.setText(student.getStudentNum());


            System.out.printf("%s %s Student Number: %s\n", student.getFirstName(), student.getLastName(), student.getStudentNum());
            System.out.println("Birthday: " + birthday);
            addActivities(student);
        }
        catch(IllegalArgumentException e){
            errorLabel.setText(e.getMessage());
        }
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

        ArrayList interests = student.getActivities();

        //Uses the join() method to display ArrayList elements.
        String joined = String.join(", ", interests);
        System.out.println("Interests: " + joined + ".");


    }

    /**
     * This method calculates the student's age and displays it in a label on the GUI.
     */
   @FXML private void getAge(){
        LocalDate birthday = birthdayDatePicker.getValue();

        //calculate age
        int age = Period.between(birthday, LocalDate.now()).getYears();

        //display age variable in age label
        ageLabel.setText("Age: " + age);
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
