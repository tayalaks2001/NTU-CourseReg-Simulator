
import java.io.*;
import java.util.*;

/**
 * This class is the entity class for course
 */
public class Course implements java.io.Serializable{
    public Course(){}
    private static final long serialVersionUID = 1L;
    private String courseCode;
    private String courseName;
    private int credit;
    private String school;
    private String typeOfCourse;
    private Calendar examDate;
    private ArrayList<Integer> indexNumList;
    
    /**
     * Constructor for Class
     * @param courseCode parameter
     * @param courseName parameter
     * @param credit parameter
     * @param school parameter
     * @param typeOfCourse parameter
     * @param examDate parameter
     * @param indexNumList parameter
     */
    public Course(String courseCode, String courseName, int credit, String school, String typeOfCourse, Calendar examDate, ArrayList<Integer> indexNumList) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credit = credit;
        this.school = school;
        this.typeOfCourse = typeOfCourse;
        this.examDate = examDate;
        this.indexNumList = indexNumList;
    }

    /**
     * 
     * @return courseCode is the getter function for courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }
    
    /**
     * 
     * @return courseName is the getter function for courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 
     * @return credit is the getter function for credit
     */
    public int getCredit() {
        return credit;
    }

    /**
     * 
     * @return school is the getter function for school
     */
    public String getSchool() {
        return school;
    }

    /**
     * 
     * @return typeOfCourse is the getter function for typeOfCourse
     */
    public String getTypeOfCourse() {
        return typeOfCourse;
    }

    /**
     * 
     * @return examDate is the getter function for examDate
     */
    public Calendar getExamDate() {
        return examDate;
    }

    /**
     * 
     * @return indexNumList is the getter function for indexNumList
     */
    public ArrayList<Integer> getIndexNumList() {
        return indexNumList;
    }

    /**
     * 
     * @param courseCode parameter to set the Course Code
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * 
     * @param courseName parameter to set the Course Name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * 
     * @param credit parameter to set the Course Credits
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }

    /**
     * 
     * @param school parameter to set the School
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 
     * @param typeOfCourse parameter to set the Course Type
     */
    public void setTypeOfCourse(String typeOfCourse) {
        this.typeOfCourse = typeOfCourse;
    }

    /**
     * 
     * @param examDate parameter to set the Exam Date
     */
    public void setExamDate(Calendar examDate) {
        this.examDate = examDate;
    }

    /**
     * 
     * @param indexNumList parameter to set the Index List Numbers
     */
    public void setIndexNumList(ArrayList<Integer> indexNumList) {
        this.indexNumList = indexNumList;
    }
}
