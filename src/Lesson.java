
import java.io.*;
import java.util.*;

/**
* Entity class which holds Lessons
*/
public class Lesson implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private int lessonID;
    private String lessonType;
    private int lessonDay;
    private String lessonWeeks;
    private String classVenue;
    private Calendar startTime;
    private Calendar endTime;
    
    /**
     * Constructor for Class
     * @param lessonID parameter
     * @param lessonType parameter
     * @param lessonDay parameter
     * @param lessonWeeks parameter
     * @param classVenue parameter
     * @param startTime parameter
     * @param endTime parameter
     */
    public Lesson(int lessonID, String lessonType, int lessonDay, String lessonWeeks, String classVenue, Calendar startTime, Calendar endTime) {
        this.lessonID = lessonID;
        this.lessonType = lessonType;
        this.lessonDay = lessonDay;
        this.lessonWeeks = lessonWeeks;
        this.classVenue = classVenue;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * 
     * @return lessonID parameter for getter function
     */
    public int getLessonID() {
        return lessonID;
    }

    /**
     * 
     * @return lessonType parameter for getter function
     */
    public String getLessonType() {
        return lessonType;
    }

    /**
     * 
     * @return lessonDay parameter for getter function
     */
    public int getLessonDay() {
        return lessonDay;
    }

    /**
     * 
     * @return lessonWeeks parameter for getter function
     */
    public String getLessonWeeks() {
        return lessonWeeks;
    }

    /**
     * 
     * @return classVenue parameter for getter function
     */
    public String getClassVenue() {
        return classVenue;
    }

    /**
     * 
     * @return startTime parameter for getter function, which holds start-time for exam
     */
    public Calendar getStartTime() {
        return startTime;
    }

    /**
     * 
     * @return endTime parameter for getter function, which holds end time for exam
     */
    public Calendar getEndTime() {
        return endTime;
    }

    /**
     * 
     * @param lessonID parameter for setter function
     */
    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    /**
     * 
     * @param lessonType parameter for setter function
     */
    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    /**
     * 
     * @param lessonDay parameter for setter function
     */
    public void setLessonDay(int lessonDay) {
        this.lessonDay = lessonDay;
    }

    /**
     * 
     * @param lessonWeeks parameter for setter function
     */
    public void setLessonWeeks(String lessonWeeks) {
        this.lessonWeeks = lessonWeeks;
    }

    /**
     * 
     * @param classVenue parameter for setter function
     */
    public void setClassVenue(String classVenue) {
        this.classVenue = classVenue;
    }

    /**
     * 
     * @param startTime parameter for setter function
     */
    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    /**
     * 
     * @param endTime parameter for setter function
     */
    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }
}