
import java.io.*;

/**
 * 
 * This class is the entity class for unique records of username ,courseNumber combinations
 */
public class CourseRegistration implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private String username;
    private String courseCode;
    private int indexNumber;
    private String regStatus;

    /**
     * Constructor for Class
     * @param username parameter
     * @param courseCode parameter
     * @param indexNumber parameter
     * @param regStatus parameter
     */
    public CourseRegistration(String username, String courseCode, int indexNumber, String regStatus) {
        this.username = username;
        this.courseCode = courseCode;
        this.indexNumber = indexNumber;
        this.regStatus = regStatus;
    }

    /**
     * 
     * @return username parameter for getter function
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @return courseCode parameter for getter function
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * 
     * @return courseCode parameter for getter function
     */
    public int getIndexNumber() {
        return indexNumber;
    }

    /**
     * 
     * @return courseCode parameter for getter function
     */
    public String getRegStatus() {
        return regStatus;
    }

    /**
     * 
     * @param username is entered to set value
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @param courseCode is entered to set
     */ 
    public void setcourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * 
     * @param indexNumber is entered to set
     */
    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    /**
     * 
     * @param regStatus is entered to set
     */
    public void setRegStatus(String regStatus) {
        this.regStatus = regStatus;
    }
}
