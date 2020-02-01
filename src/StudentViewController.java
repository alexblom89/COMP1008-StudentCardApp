import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {

    private Student student;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Student student = new Student("Alex", "Blom", 867295);
    }
}
