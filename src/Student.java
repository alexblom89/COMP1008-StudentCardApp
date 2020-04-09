import javafx.scene.image.Image;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Student {

    private String firstName, lastName;
    public static String studentNum = "100000000";
    private ArrayList activities = new ArrayList<>();
    private Image studentPic;
    private LocalDate birthday;

    /**
     * This constructor sets the activity list, sets the student picture, and accepts arguments for firstName, lastName, and studentNum.
     * Each property of the student object is instantiated through their respective set method.
     * @param firstName
     * @param lastName
     * @param birthday
     */
    public Student(String firstName, String lastName, LocalDate birthday, Image studentPic){
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
        setStudentPic(studentPic);
        activities = getActivities();
        studentNum = getStudentNum();
    }


    public LocalDate getBirthday(){
        return this.birthday;
    }

    public void setBirthday(LocalDate birthday) {
        int age = Period.between(birthday, LocalDate.now()).getYears();

        if(age > 10 && age < 120)
            this.birthday = birthday;
        else
            throw new IllegalArgumentException("Student must be between the ages of 10 and 120");
    }

    /**
     * Returns student's first name.
     * @return firstName String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets the student's first name,
     * validates that the first letter is a capital,
     * and that there is more than one letter.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();

        if (firstName.length() >= 2){
            this.firstName = firstName;
        }
        else
            throw new IllegalArgumentException("First name must have more than one character.");
    }

    /**
     * Returns student's last name.
     * @return String lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the student's last name,
     * validates that the first letter is a capital (and each subsequent letter is lower case)
     * and that there is more than one letter.
     * @param lastName
     */
    public void setLastName(String lastName) {
        lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();

        if (lastName.length() >= 2){
            this.lastName = lastName;
        }
        else
            throw new IllegalArgumentException("Last name must have more than one character.");
    }

    /**
     * This method parses the studentNum string into an int, increments that int, converts that int back into a string and returns it.
     * @return
     */
    public String getStudentNum() {

        int sNum = Integer.parseInt(studentNum);

        sNum++;

        return Integer.toString(sNum);
//        return String.format("%d", studentNum);
    }

//    /**
//     * Sets student number and validates that it is between 100000 and 9999999 (requirements stated lower bound of 1000000, but Lakehead
//     * student numbers can be 6 digits).
//     * @param studentNum
//     */
//    public void setStudentNum(int studentNum) {
//            if (studentNum >= 100000000 && studentNum <= 999999999)
//                this.studentNum = studentNum;
//            else
//                throw new IllegalArgumentException("Student Number must be between 100000 and 999999999");
//    }

    /**
     * returns the list of activities.
     * @return ObservableList activities
     */
    public ArrayList getActivities() {
        return activities;
    }

    /**
     * This method adds activities to the ObservableList (ArrayList).
     */
    public void setActivities(String activity) {

        activities.add(activity);
    }

//    public String inputActivities(){
//        Scanner kb = new Scanner(System.in);
//        System.out.println("Please enter a favourite activity: ");
//        return kb.nextLine();
//    }

    /**
     * This method returns the image stored in studentPic Image variable
     * @return Image studentPic
     */
    public Image getStudentPic() {
        return studentPic;
    }

    /**
     * Sets the student picture to a new Image object located at the source indicated.
     */
    public void setStudentPic(Image studentPic) {
        this.studentPic = studentPic;
    }


    /**
     * Calculates student's age.
     * @return
     */
    public int getAge(){
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    /**
     * toString method to display student information.
     * @return
     */
    public String toString() {
        return String.format("%s %s student #: %s", firstName, lastName, studentNum);
    }
}

