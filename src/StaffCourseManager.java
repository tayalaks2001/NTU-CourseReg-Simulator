
import java.util.ArrayList;

import java.io.IOException;
import java.util.*;

/**
 * This class provides he ability for Staff to alter courses and indexes
 *
 */
public class StaffCourseManager {
    public static void addCourse(String courseCode, String courseName, int credit, String school, String typeOfCourse,
            Calendar examDate, ArrayList<Integer> indexNumList) {
        // have to write into Course, Index and Lesson and do validation for all of them in STAFFUI
        Course c = new Course(courseCode, courseName, credit, school, typeOfCourse, examDate, indexNumList); 
        FileHandler.addToFile("Courses.txt", c);

        ArrayList<Course> cList = DataListManager.getAllCourse();
        System.out.println("Courses in system: ");
        for (Course cObj : cList){
            System.out.println((cObj.getCourseCode()).toUpperCase()+" - "+cObj.getCourseName());
        }
    }

    /**
     * Adds index
     * @param courseCode parameter
     * @param indexNumber parameter
     * @param group parameter
     * @param vacancy parameter
     * @param total parameter
     * @param lessonIDs parameter
     * @param waitingList parameter
     * @throws IOException if FileHandler is unable to write
     */
    public static void addIndex(String courseCode, int indexNumber, String group, int vacancy, int total,
            ArrayList<Integer> lessonIDs, Queue<String> waitingList) throws IOException {
        
        Boolean existing = ValidationManager.existsIndexNumber(courseCode, indexNumber);
        
        if (!existing){
            ArrayList<Course> arr = DataListManager.getAllCourse();
            for (Course c : arr){
                if (c.getCourseCode().equalsIgnoreCase(courseCode)){
                    ArrayList<Integer> arr1= c.getIndexNumList();
                    arr1.add(indexNumber);
                    c.setIndexNumList(arr1);
                    break;
                }
            }
            ArrayList<Object> objstud = new ArrayList<>();
            for (Course c1 : arr) {
                objstud.add(c1);
            }
            FileHandler.writeToFile("Courses.txt", objstud);
        }


        Index i = new Index(indexNumber, group, vacancy, total, lessonIDs, waitingList); //read index object here

        //code to append index object to file.
        FileHandler.addToFile("Index.txt", i);
    }

    /**
     * Adds Lesson
     * @param lessonID parameter
     * @param lessonType parameter
     * @param lessonDay parameter
     * @param lessonWeeks parameter
     * @param classVenue parameter
     * @param startTime parameter
     * @param endTime parameter
     */
    public static void addLesson(int lessonID, String lessonType, int lessonDay, String lessonWeeks, String classVenue, Calendar startTime, Calendar endTime) {
        
        //no need to update index file because only new lesson can not be added
        Lesson l = new Lesson(lessonID, lessonType, lessonDay, lessonWeeks, classVenue, startTime, endTime);
        
        //code to append index object to file.
        FileHandler.addToFile("Lessons.txt", l);
        
    }

    /**
     * Updates School
     * @param courseCode parameter
     * @param school parameter
     * @throws IOException if FileHandler is unable to write
     */
    public static void updateSchool (String courseCode, String school) throws IOException {
        ArrayList<Course> c = DataListManager.getAllCourse(); //read course object here
        for (Course i : c){
            if ((i.getCourseCode()).equalsIgnoreCase(courseCode)){
                i.setSchool(school);
                break;
            }
        }
        ArrayList<Object> objstud = new ArrayList<>();
            for (Course c1 : c) {
                objstud.add(c1);
            }
        FileHandler.writeToFile("Courses.txt", objstud);
        //write out course object here
    }

    /**
     * updates Course
     * @param courseCode parameter
     * @param newID parameter
     * @throws IOException if FileHandler is unable to write
     */
    public static void updateCourse(String courseCode, String newID) throws IOException {
        ArrayList<Course> c = DataListManager.getAllCourse(); //read course object here
        for (Course i : c){
            if (i.getCourseCode().equalsIgnoreCase(courseCode)){
                i.setCourseCode(newID);
                break;
            }
        }
        ArrayList<Object> objstud = new ArrayList<>();
            for (Course c1 : c) {
                objstud.add(c1);
            }
        FileHandler.writeToFile("Courses.txt", objstud);
    }

    /**
     * updates Vacancies
     * @param indexNumber parameter
     * @param newVacancies parameter
     * @throws IOException if FileHandler is unable to write
     */
    public static void updateVacancy (int indexNumber, int newVacancies) throws IOException {
        ArrayList<Index> i = DataListManager.getAllIndex(); //read course object here
        for (Index c : i){
            if (c.getIndexNumber() == indexNumber){
                c.setVacancy(c.getVacancy()+newVacancies);
                c.setTotal(c.getTotal()+newVacancies);
                break;
            }
        }
    
        ArrayList<Object> objstud = new ArrayList<>();
            for (Index c1 : i) {
                objstud.add(c1);
            }
        FileHandler.writeToFile("Index.txt", objstud);
    }

    /**
     * updates Index
     * @param indexNumber parameter
     * @param newIndexNumber parameter
     * @throws IOException if FileHandler is unable to write
     */
    public static void updateIndex (int indexNumber, int newIndexNumber) throws IOException {
        ArrayList<Course> c = DataListManager.getAllCourse(); //read course object here
        
        domainLoop:
        for (Course i : c) {
            ArrayList<Integer> numList = i.getIndexNumList();
            for (int x=0; x<numList.size(); x++){
                if (numList.get(x) == indexNumber){
                    numList.set(x, newIndexNumber);
                    break domainLoop;
                }
            }
        }
        ArrayList<Object> objstud = new ArrayList<>();
            for (Course c1 : c) {
                objstud.add(c1);
            }
        FileHandler.writeToFile("Courses.txt", objstud);
        //write course object to file 

        ArrayList<Index> i = DataListManager.getAllIndex(); //read index object here
        for (Index x : i){
            if (x.getIndexNumber() == indexNumber){
                x.setIndexNumber(newIndexNumber);
                break;
            }
        }
        ArrayList<Object> objstud1 = new ArrayList<>();
            for (Index c1 : i) {
                objstud1.add(c1);
            }
        FileHandler.writeToFile("Index.txt", objstud1);
        //code to append index object to file.
    }

}
