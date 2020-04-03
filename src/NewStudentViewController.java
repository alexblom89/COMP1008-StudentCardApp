import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;
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


    /**
     * This method grabs all information from the Create New Student textfields and creates a new student object from said information.
     * The student number textfield text is parsed into an integer.
     * addActivities method is called in order to add the activities to the student object and display.
     * Method is wrapped in a try-catch block that displays an error message from the Student class should one of the set methods
     * display an error.
     */
    public void submitButtonPushed(){
        try{
            //Check if fields are empty, throw error if they are.
            if(firstNameTextField == null || firstNameTextField.getText().trim().isEmpty()){
                throw new IllegalArgumentException("First name field cannot be empty.");
            }
            else if(lastNameTextField == null || lastNameTextField.getText().trim().isEmpty()){
                throw new IllegalArgumentException(("Last name field cannot be empty"));
            }
            else if(studentNumberTextField == null || studentNumberTextField.getText().trim().isEmpty()){
                throw new IllegalArgumentException("Student Number field cannot be empty.");
            }

            int studentNum = Integer.parseInt(studentNumberTextField.getText());

            Student student = new Student(firstNameTextField.getText(), lastNameTextField.getText(), studentNum);
            // Clear all text fields
            firstNameTextField.clear();
            lastNameTextField.clear();
            studentNumberTextField.clear();
            System.out.println(student);
            addActivities(student);
            addBirthday(student);
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

    private void addBirthday(Student student){

        final DatePicker datePicker = new DatePicker();
        LocalDate date = datePicker.getValue();
        student.setBirthday(date);
        System.out.println("Birthday: " + date);
    }


}
