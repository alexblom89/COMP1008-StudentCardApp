import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

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

    public void submitButtonPushed(){
        if(runningCheckbox.isSelected()){

        }
    }
}
