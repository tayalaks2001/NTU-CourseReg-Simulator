
import java.util.Calendar;

import jdk.jshell.execution.Util;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * This class is tha manager class that interacts with StudentUI.java
 * Not all methods are accessable by students, some are checker methods used by other methods in the same class
 */
public class StudentCourseManager {
	/**
	 * This method checks if the registration already exists
	 * @param username parameter
	 * @param courseCode parameter
	 * @return boolean for if registration exists
	 */
    private static Boolean isExistingRegistration(String username, String courseCode) {
        CourseRegistration c = DataListManager.getCourseRegistration(username, courseCode);
        if (c == null) {
            return false;
        }
        return true;
    }

	/**
	 * This method checks the number of vacancies in an index
	 * @param indexNumber parameter
	 * @return numVacancies, the number of vacancies
	 */
    private static int getVacancy(int indexNumber) {
        Index i = DataListManager.getIndex(indexNumber);
        return i.getVacancy();

    }

	/**
	 * This method checks if two courses are clashing for a student
	 * @param username parameter
	 * @param courseCode parameter
	 * @param indexNumber parameter
	 * @return boolean for if there is clash
	 */
    private static Boolean checkClash(String username,String courseCode, int indexNumber) {
        Index a = DataListManager.getIndex(indexNumber);
        ArrayList<Integer> checkIDs = a.getLessonIDs();
        ArrayList<Lesson> checkLessons = new ArrayList<>();
        for (Integer lID : checkIDs) {
            Lesson l = DataListManager.getLesson(lID);
            checkLessons.add(l);
        }

        ArrayList<CourseRegistration> cr = DataListManager.getRegisteredCourses(username);
        if (cr == null)
            return false;
        for (CourseRegistration c : cr) {
            if(DataListManager.getCourse(c.getCourseCode()).getExamDate().compareTo(DataListManager.getCourse(courseCode).getExamDate())==0){
                return true;
            }//change
            Index i = DataListManager.getIndex(c.getIndexNumber());
            ArrayList<Integer> lIDs = i.getLessonIDs();
            for (Integer lID : lIDs) {
                Lesson l = DataListManager.getLesson(lID);
                Calendar startTime = l.getStartTime();
                Calendar endTime = l.getEndTime();
                for (Lesson curr : checkLessons) {
                    //alternative condition for time : (curr.getEndTime()).compareTo(startTime) <= 0 || (curr.getStartTime()).compareTo(endTime)>=0)

                    if (((curr.getLessonDay() == l.getLessonDay())
                            && (((curr.getLessonWeeks()).equalsIgnoreCase(l.getLessonWeeks()))||((curr.getLessonWeeks()).equalsIgnoreCase("all"))||l.getLessonWeeks().equalsIgnoreCase("all"))
                            && (((curr.getStartTime()).compareTo(startTime) < 0
                                    && ((curr.getEndTime()).compareTo(startTime) > 0))
                                    || (endTime.compareTo(curr.getStartTime()) > 0
                                            && endTime.compareTo(curr.getEndTime()) < 0))))
                        return true;
                }
            }
        }

        return false;
    }

	/**
	 * This method adds a course for a Student
	 * @param username parameter
	 * @param courseCode parameter
	 * @param indexNumber parameter
	 * @param status parameter
	 * @return booolean for if course is added or not
	 */
    private static Boolean addCourse(String username, String courseCode, int indexNumber, String status) {
        CourseRegistration newCourse = new CourseRegistration(username, courseCode, indexNumber, status);
        FileHandler.addToFile("CourseRegistration.txt", newCourse);
        return true;
    }

	/**
	 * This method removes a course for a Student
	 * @param username parameter
	 * @param courseCode parameter
	 * @return boolean for if course was removed
	 * @throws IOException if there is error in writing to file with FileHandler
	 */
    private static Boolean removeCourse(String username, String courseCode) throws IOException {

        ArrayList<CourseRegistration> db = DataListManager.getAllCourseRegistration();
        for (CourseRegistration c : db) {
            if (c.getUsername().equalsIgnoreCase(username)  && c.getCourseCode().equalsIgnoreCase(courseCode)) {
                db.remove(c);
                break;
            }
        }
        ArrayList<Object> objstud = new ArrayList<>();
        for (CourseRegistration c1 : db) {
            objstud.add(c1);
        }
        FileHandler.writeToFile("CourseRegistration.txt", objstud);

        return true;
    }

	/**
	 * This method adds a Student to a waiting list
	 * @param courseCode parameter
	 * @param indexNumber parameter
	 * @param username parameter
	 * @return boolean for if the course was added to waiting list successfully
	 * @throws IOException if there is error in writing to file with FileHandler
	 */
    private static Boolean addToWaitingList(String courseCode, int indexNumber, String username) throws IOException {
        ArrayList<Index> i = DataListManager.getAllIndex();
        for (Index x : i) {
            if (x.getIndexNumber() == indexNumber) {
                Queue<String> wl = x.getWaitingList();
                wl.add(username);
                x.setWaitingList(wl);
                ArrayList<Object> objstud = new ArrayList<>();
                for (Index c1 : i) {
                    objstud.add(c1);
                }
                FileHandler.writeToFile("Index.txt", objstud);
                return true;
            }
        }
        return false;
    }

	/**
	 * This method removes a Student from the waiting list
	 * @param indexNumber parameter
	 * @param courseCode parameter
	 * @return boolean for if the course was removed from waiting list successfully
	 * @throws IOException if there is error in writing to file with FileHandler
	 */
    private static Boolean removeFromWaitingList(int indexNumber, String courseCode) throws IOException {
        ArrayList<Index> i = DataListManager.getAllIndex();
        String username = null;
        for (Index x : i) {
            if (x.getIndexNumber() == indexNumber) {
                Queue<String> wl = x.getWaitingList();
                username = wl.poll();
                x.setWaitingList(wl);
                //x.setVacancy(x.getVacancy()-1);
                //System.out.println(x.getVacancy());
                ArrayList<Object> objstud = new ArrayList<>();
                for (Index c1 : i) {
                    objstud.add(c1);
                }
                FileHandler.writeToFile("Index.txt", objstud);

                ArrayList<CourseRegistration> cr = DataListManager.getAllCourseRegistration();
                for (CourseRegistration c : cr){
                    if (c.getUsername().equalsIgnoreCase(username) && c.getCourseCode().equalsIgnoreCase(courseCode)){
                        c.setRegStatus("Registered");
                        EmailNotificationManager obj=new EmailNotificationManager();
                        obj.sendNotification(c.getUsername(),c.getCourseCode());
                        //for testing purposes we used recepient email same as the sender which is oodptest@gmail.com
                        break;
                    }
                }
                ArrayList<Object> objstud1 = new ArrayList<>();
                for (CourseRegistration c1 : cr) {
                    objstud1.add(c1);
                }
                FileHandler.writeToFile("CourseRegistration.txt", objstud1);

                return true;
            }
        }
        return false;
    }

	/**
	 * This method registers a student to a course
	 * @param username parameter
	 * @param courseCode parameter
	 * @param indexNumber parameter
	 * @return boolean for if the student was successfully registered to the course
	 * @throws IOException if there is error in writing to file with FileHandler
	 */
    public static Boolean registerCourse(String username, String courseCode, int indexNumber) throws IOException {
        if (isExistingRegistration(username, courseCode) == false) {
            if (ValidationManager.existsIndexNumber(courseCode, indexNumber) == true) {
                if (checkAULimit(username, courseCode)){
                    Boolean checkCourseClash = checkClash(username, courseCode, indexNumber);
                    if (checkCourseClash == true) {
                        System.out.println("Red! Timings clash with course ");
                        return false;
                    }
                    
                    if (getVacancy(indexNumber) > 0) {
                        
                    
                        addCourse(username, courseCode, indexNumber, "Registered");
                        ArrayList<Index> index = DataListManager.getAllIndex();
                        for (Index indexObj : index){
                            if (indexObj.getIndexNumber() == indexNumber){
                                indexObj.setVacancy(indexObj.getVacancy() - 1);
                                break;
                            }
                        }

                        ArrayList<Object> objstud = new ArrayList<>();
                        for (Index c1 : index) {
                            objstud.add(c1);
                        }
                        FileHandler.writeToFile("Index.txt", objstud);
                        return true;
                    }

                    else {
                        addToWaitingList(courseCode, indexNumber, username);
                        addCourse(username, courseCode, indexNumber, "Waiting list");
                        System.out.println("You have been put on the waiting list");
                        return true;
                    }
                }
                else{
                    System.out.println("AU Limit exceeded!");
                    return false;
                }
            } else {
                System.out.println("Wrong input!Index number does not exist");
                return false;
            }
        } else {
            System.out.println("Error! Course is already registered");
            return false;
        }
    }

	/**
	 * This method drops a student from a course
	 * @param username parameter
	 * @param courseCode parameter
	 * @return boolean for if the course was added to dropped successfully
	 * @throws IOException if there is error in writing to file with FileHandler
	 */
    public static Boolean dropCourse(String username, String courseCode) throws IOException {
        if (ValidationManager.existsCourseCode(courseCode) == true) {
            if (isExistingRegistration(username, courseCode) == true) {
                CourseRegistration crobj = DataListManager.getCourseRegistration(username, courseCode);
                ArrayList<Index> index = DataListManager.getAllIndex();
                for (Index indexObj : index){
                    if (indexObj.getIndexNumber() == crobj.getIndexNumber()){
                        String status = crobj.getRegStatus();
                        if (removeCourse(username, courseCode)) {
                            if (!status.equalsIgnoreCase("Registered")){
                                ArrayList<Index> indices = DataListManager.getAllIndex();
                                for (Index i : indices){
                                    if (i.getIndexNumber() == indexObj.getIndexNumber()){
                                        Queue<String> wl = i.getWaitingList();
                                        wl.remove(crobj.getUsername());
                                        break;
                                    }
                                }
                                ArrayList<Object> objstud = new ArrayList<>();
                                for (Index c1 : indices) {
                                    objstud.add(c1);
                                }
                                FileHandler.writeToFile("Index.txt", objstud);

                                return true;
                            }
                            else if (status.equalsIgnoreCase("Registered") && (indexObj.getWaitingList()).size() > 0){
                                removeFromWaitingList(indexObj.getIndexNumber(), courseCode);
                                return true;
                            }
                            indexObj.setVacancy(indexObj.getVacancy() + 1);
                            
                            ArrayList<Object> objstud = new ArrayList<>();
                            for (Index c1 : index) {
                                objstud.add(c1);
                            }
                            FileHandler.writeToFile("Index.txt", objstud);
                            return true;
                        } 
                        else {
                            System.out.println("Error! Could not drop course!");
                            return false;
                        }
                    }
                }
                
            } else {
                System.out.println("The course has not been registered");
                return false;
            }
        } else {
            System.out.println("The course does not exist");
            return false;
        }

        return false;

    }

	/**
	 * This method swaps the index number between students
	 * @param user1 parameter
	 * @param user2 parameter
	 * @param password parameter
	 * @param courseCode parameter
	 * @return boolean for if the index was swapped successfully
	 * @throws IOException if there is error in writing to file with FileHandler
	 * @throws NoSuchAlgorithmException for if Login Manager is unable to find the right algorithm
	 */
    public static Boolean swapIndexNumber(String user1, String user2, String password, String courseCode)
            throws IOException, NoSuchAlgorithmException {
        if(ValidationManager.existsUsername(user1) && ValidationManager.existsUsername(user2)&& ValidationManager.existsCourseCode(courseCode))
        {
            if(isExistingRegistration(user1,courseCode) && isExistingRegistration(user2,courseCode))
            {
                User u = LoginManager.validLogin(user2, password, "Student");
                if (u == null){
                    return false;
                }
                CourseRegistration s1= DataListManager.getCourseRegistration(user1,courseCode);
                CourseRegistration s2= DataListManager.getCourseRegistration(user2,courseCode);
                int index1= s1.getIndexNumber();
                int index2= s2.getIndexNumber();
                s1.setIndexNumber(index2);
                s2.setIndexNumber(index1);
                ArrayList<CourseRegistration> db= DataListManager.getAllCourseRegistration();
                
                
                for (Iterator<CourseRegistration> it = db.iterator(); it.hasNext(); ) {
                    CourseRegistration c = it.next();
                    if(((c.getUsername()).equalsIgnoreCase(user1)|| (c.getUsername()).equalsIgnoreCase(user2)) && ((c.getCourseCode()).equalsIgnoreCase(courseCode))) {
                        it.remove();
                    }
                }


                db.add(s1);
                db.add(s2);
                ArrayList<Object> objstud = new ArrayList<>();
                for (CourseRegistration c1 : db) {
                    objstud.add(c1);
                }
                FileHandler.writeToFile("CourseRegistration.txt", objstud);
                return true;
            }
        }
        return false;
    }


	/**
	 * This method changes the index number of a registered course for a student if vacancies are available
	 * @param username parameter
	 * @param courseCode parameter
	 * @param indexNumber parameter
	 * @return boolean for if the index was changed successfully
	 * @throws IOException if there is error in writing to file with FileHandler
	 */
    //add body of this function
    public static Boolean changeIndexNumber(String username, String courseCode, int indexNumber) throws IOException {
        if (ValidationManager.existsCourseCode(courseCode)){
            if (isExistingRegistration(username, courseCode)){
                if (ValidationManager.existsIndexNumber(courseCode, indexNumber)){
                    if (getVacancy(indexNumber) > 0){
                        dropCourse(username, courseCode);
                        registerCourse(username, courseCode, indexNumber);
                        return true;
                    } 
                    else{
                        System.out.println("New index has no vacancies");
                    }
                }
                else{
                    System.out.println("No such index exists in the system!");
                }
            }
            else{
                System.out.println("You are not registered for this course!");
            }
        }
        else{
            System.out.println("No such course exists!");
        }

        return false;
    }


	/**
	 * This method prints out the vacancies of a student
	 * @param courseCode parameter
	 * @param indexNumber parameter
	 */
    public static void getVacancies(String courseCode, int indexNumber) {
        if(ValidationManager.existsIndexNumber(courseCode,indexNumber)==true) {
            int vacancies;
            int total;
            Index indexObj=DataListManager.getIndex(indexNumber);
            vacancies = indexObj.getVacancy();
            total = indexObj.getTotal();
            System.out.println(vacancies+"/"+total+" seats are available");
        }
        else {
            System.out.println("The index does not exist");
        }
    }

	/**
	 * This method prints out all the courses a student has registered for
	 * @param username parameter
	 */
    public static void printRegisteredCourses(String username) {
        
        ArrayList<CourseRegistration> cr = DataListManager.getRegisteredCourses(username);
        if (cr == null){
            System.out.println("No registered courses!");
            return;
        }
        System.out.println("Course     Index     Registration Status");
        System.out.println("-----------------------------------------");
        for (CourseRegistration c : cr){
            String courseCode = c.getCourseCode();
            int indexNumber = c.getIndexNumber();
            String status = c.getRegStatus();
            System.out.println(courseCode+"   "+indexNumber+"   "+status);
        }
    }

	/**
	 * This method checks if the AU limit of a course has been exceeded
	 * @param username parameter
	 * @param courseID parameter
	 * @return boolean for if the AU limit was exceeded or not
	 */
    public static Boolean checkAULimit(String username, String courseID){
        ArrayList<CourseRegistration> cr = DataListManager.getRegisteredCourses(username);
        int total = 0;

        if (cr == null){
            return true;
        }

        for (CourseRegistration c : cr){
            String courseCode = c.getCourseCode();
            Course x = DataListManager.getCourse(courseCode);
            total += x.getCredit();
        }

        Course x2 = DataListManager.getCourse(courseID);
        total += x2.getCredit();
        if (total > 10){
            System.out.println("Registered AUs : "+(total-x2.getCredit()));
            System.out.println("AU limit : 10");
            return false;
        }
        
        return true;

    }

    /**
     * This method prints the time table for a student
     * @param username parameter
     */
    public static void printTimetable(String username){
        ArrayList<CourseRegistration> cr = DataListManager.getRegisteredCourses(username);
        if (cr == null){
            System.out.println("No registered courses!");
            return;
        }

        System.out.println("-----Timetable-----");

        for (CourseRegistration c : cr){
            String status = c.getRegStatus();
            System.out.println();
            System.out.println("Course code: " + c.getCourseCode() + "\t " + status.toUpperCase());
            Index i = DataListManager.getIndex(c.getIndexNumber());
            System.out.println("Index: " + c.getIndexNumber());
            System.out.println("Lessons :- ");
            String []dayOfWeek = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
            for (int lID : i.getLessonIDs()){
                Lesson l = DataListManager.getLesson(lID);
                System.out.print("Type-"+l.getLessonType()+ "   ");
                System.out.print("Day-"+dayOfWeek[l.getLessonDay()-1]+ "   ");
                System.out.print("Weeks-"+l.getLessonWeeks()+ "   ");
                System.out.print("Venue-"+l.getClassVenue()+ "   ");
                String start = (CalendarManager.calendarToString(l.getStartTime())).substring(11);
                System.out.print("Start time-"+start+ "   ");
                String end = (CalendarManager.calendarToString(l.getEndTime())).substring(11);
                System.out.println("End time-"+end + "   ");
            }
        }
    }

    
}