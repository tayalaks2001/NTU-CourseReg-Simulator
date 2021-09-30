
import java.util.ArrayList;




/**
 * 
 * The class is used to print functions for the admin users.
 * The admin can choose to print all the students in an index, or all the students in a specific course
 *
 */
public class PrintManager {

	/**
	 * Print out students by Index
	 * @param indexNumber parameter
	 */
    public static void printByIndex(int indexNumber) {
        ArrayList<CourseRegistration> indexes = DataListManager.byIndexNumber(indexNumber); //get All objects in CourseRegistration which have indexNumber
        if(indexes== null){
            System.out.println("No one is registered in this index!");
            return;
        }
        System.out.println("Students who have taken Index Number "+indexNumber);
        for (int i = 0; i < indexes.size(); i++) {
            CourseRegistration cr = indexes.get(i);
            String userName = cr.getUsername();
            Student s = DataListManager.getStudent(userName); 
            String name = s.getFirstName() + " " + s.getLastName();
            String gender = s.getGender();
            String nationality = s.getNationality();
            System.out.println("Name: "+name+"       Gender: "+gender+"       Nationality: "+nationality + "       Status: "+cr.getRegStatus());
        }
    }

    

    /**
     * Print out students by course
     * @param courseCode parameter
     * @return st, the list of all students
     */
    public static ArrayList<String>  printByCourse(String courseCode) {
        ArrayList<CourseRegistration> courses = DataListManager.byCourseCode(courseCode); //get All objects in CourseRegistration which have courseCode
        if(courses == null){
            return null;
        }
        ArrayList<String> st = new ArrayList<>();
        
        for (int i = 0; i < courses.size(); i++) {
            CourseRegistration cr = courses.get(i);
            String userName = cr.getUsername();
            Student s = DataListManager.getStudent(userName); 
            String name = s.getFirstName() + " " + s.getLastName();
            String gender = s.getGender();
            String nationality = s.getNationality();
            st.add("Name: "+name+"       Gender: "+gender+"       Nationality: "+nationality+ "       Status: "+cr.getRegStatus());
        }
        return st;
    }
}