public class Student {

    private String firstName, lastName;
    private int studentNum;

    public Student (String firstName, String lastName, int studentNum){
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNum(studentNum);
    }

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

        if (firstName.length() > 1)
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("First name must have more than one character.");
    }

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

        if (lastName.length() > 1)
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("Last name must have more than one character.");
    }

    public int getStudentNum() {
        return studentNum;
    }

    /**
     * Sets student number and validates that it is between 100000 and 9999999 (requirements stated lower bound of 1000000, but Lakehead
     * student numbers can be 6 digits).
     * @param studentNum
     */
    public void setStudentNum(int studentNum) {
        if (studentNum >= 100000 && studentNum < 9999999)
            this.studentNum = studentNum;
        else
            throw new IllegalArgumentException("Student Number must be between 100000 and 9999999");
    }

    /**
     * toString method to display student information.
     * @return
     */
    public String toString() {
        return String.format("%s %s student #: %d", firstName, lastName, studentNum);
    }
}

