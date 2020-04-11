import javafx.scene.image.Image;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Student {

    private String firstName, lastName;
    private String trueStudentNum;
    public static int studentNum = 100000000;
    private ArrayList activities = new ArrayList(); //IDE says this is redundant but removing it breaks the code.
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
        setStudentNum();
    }

    /**
     * Returns the student object's birthday.
     * @return LocalDate birthday
     */
    public LocalDate getBirthday(){
        return this.birthday;
    }

    /**
     * This method sets the student object's birthday and validates that it is more than 10 years old (and less than 120 years old).
     * Instead of validated the year, this method uses Period.between to calculate the time between the birthday and the current date,
     * ensuring that the student is over 10 years old to the day.
     * @param birthday
     */
    public void setBirthday(LocalDate birthday) {
        int age = Period.between(birthday, LocalDate.now()).getYears();

        if(age > 10 && age < 120)
            this.birthday = birthday;
        else
            throw new IllegalArgumentException("Student must be between the ages of 10 and 120");
    }

    /**
     * Returns student's first name.
     * @return String firstName
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
     * returns the String trueStudentNum, the variable for student number tied to each student object.
     * @return String trueStudentNum
     */
    public String getStudentNum(){
        return trueStudentNum;
    }

    /**
     * This method increments studentNum global static variable, which is converted to a String and stored in this.trueStudentNum.
     */
    public void setStudentNum() {
        studentNum++;
        this.trueStudentNum = Integer.toString(studentNum);
    }

    /**
     * returns the list of activities.
     * @return ObservableList activities
     */
    public ArrayList getActivities() {
        return activities;
    }

    /**
     * This method adds activities to the ArrayList.
     */
    public void setActivities(String activity) {

        activities.add(activity);
    }

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
        return String.format("%s %s student #: %s", firstName, lastName, trueStudentNum);
    }
}

