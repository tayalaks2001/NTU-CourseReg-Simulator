
import java.text.ParseException;
import java.util.*;



/**
 * This class does all the checking to ensure the attributes exist in database
 *
 */
public class ValidationManager {

	/**
	 * 
	 * @param courseCode parameter
	 * @return boolean for if the courseCode exists
	 */
    public static Boolean existsCourseCode(String courseCode) {
        ArrayList<Course> allCourses = DataListManager.getAllCourse();
        if (allCourses == null)
            return false;

        for (Course c : allCourses) {
            if (c.getCourseCode().equalsIgnoreCase(courseCode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param courseCode parameter
     * @param indexNumber parameter
     * @return boolean for if the indexNumber exists in a course
     */
    public static Boolean existsIndexNumber(String courseCode, int indexNumber) {
        ArrayList<Course> allCourses = DataListManager.getAllCourse();
        if (allCourses == null)
            return false;
        for (Course c : allCourses) {
            if (c.getCourseCode().equalsIgnoreCase(courseCode)) {
                ArrayList<Integer> allIndices = c.getIndexNumList();
                for (int i : allIndices) {
                    if (i == indexNumber) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    /**
     * 
     * @param index parameter
     * @return boolean for if the Index exists in general
     */
    public static boolean checkIndexPresent(int index) {
        ArrayList<Index> indices = DataListManager.getAllIndex();
        if (indices == null)
            return false;
        for (Index i : indices) {
            if (i.getIndexNumber() == index) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param indices parameter
     * @param index parameter
     * @return boolean for if the Index exists in an arraylist of indexes
     */
    public static boolean checkIndexPresent(ArrayList<Integer> indices, int index) {

        for (Integer i : indices) {
            if (i == index) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param lessonID parameter
     * @return boolean for if the lessonID exists
     */
    public static boolean checkLessonPresent(int lessonID) {
        ArrayList<Lesson> lessons = DataListManager.getAllLesson();
        if (lessons == null)
            return false;

        for (Lesson i : lessons) {
            if (i.getLessonID() == lessonID) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param lessons parameter
     * @param lessonID parameter
     * @return boolean for if the lessonID exists in an arraylist of lesson
     */
    public static boolean checkLessonPresent(ArrayList<Integer> lessons, int lessonID) {
        for (Integer i : lessons) {
            if (i == lessonID) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param username parameter
     * @return boolean if a student username exists
     */
    public static Boolean existsUsername(String username) {
        ArrayList<Student> allStudents = DataListManager.getAllStudent();
        if (allStudents.size() == 0)
            return false;
        for (Student s : allStudents) {
            System.out.println(s.getUsername());
            if ((s.getUsername()).equals(username)) {
                return true;
            }
        }
        return false;
        // check if the passed username actually exists in the Student database
    }

    /**
     * 
     * @param time parameter
     * @return boolean for if the time in valid format
     */
    public static boolean checkValidTime(String time) {
        Calendar c = CalendarManager.stringToCalendar(time);
        if (c != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @param time parameter
     * @return boolean for if the time is in the right format
     * @throws ParseException for if there is an error in getting Date-Time from Calendar Manager
     */
    public static boolean checkOnlyTime(String time) throws ParseException {
        Calendar c = CalendarManager.getOnlyTime(time);
        if(c!=null){
            return true;
        }
        else {
            return false;
        }
    }
    
}