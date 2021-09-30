
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * This class is used to allow the Staff to create new student obkects and also modify the access times for students (all students at once or individualy through overloaded function).
 */
public class StudentStaffManager {
	
	/**
	 * Updates access time for all students
	 * @param accessStart parameter
	 * @param accessEnd parameter
	 * @throws IOException for if FileHandler is not able to write to the file
	 */
    public static void updateAccessTime(Calendar accessStart, Calendar accessEnd) throws IOException {
        ArrayList<Student> students = DataListManager.getAllStudent(); // get arraylist of all students from file
                                                                       // handler
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            s.setStartAccess(accessStart); // accessStart are passed into the function as Calendar objects, if they are passed in as strings, need to convert.
            s.setEndAccess(accessEnd);
            students.set(i, s);
        }
        ArrayList<Object> objstud = new ArrayList<>();
        for (Student c1 : students) {
            objstud.add(c1);
        }
        FileHandler.writeToFile("Students.txt", objstud);
    }

    /**
     * Updates access time for a single student
     * @param userName parameter
     * @param accessStart parameter
     * @param accessEnd parameter
     * @throws IOException IOException for if FileHandler is not able to write to the file
     */
    public static void updateAccessTime(String userName, Calendar accessStart, Calendar accessEnd) throws IOException {
        ArrayList<Student> students = DataListManager.getAllStudent(); // get arraylist of all students from file handler
        for (Student s : students) {

            if ((s.getUsername()).equalsIgnoreCase(userName)) {
                s.setStartAccess(accessStart); // accessStart are passed into the function as Calendar objects, if they are passed in as strings, need to convert.
                s.setEndAccess(accessEnd);
                break;
            }
        }
        ArrayList<Object> objstud = new ArrayList<>();
        for (Student c1 : students) {
            objstud.add(c1);
        }
        FileHandler.writeToFile("Students.txt", objstud);
    }

    /**
     * Adds a student entity
     * @param userName parameter
     * @param firstName parameter
     * @param lastName parameter
     * @param matricNumber parameter
     * @param gender parameter
     * @param nationality parameter
     * @param mobileNo parameter
     * @param email parameter
     * @param accessStart parameter
     * @param accessEnd parameter
     * @param notiMode parameter
     * @throws NoSuchAlgorithmException if Login Manager is not able generate salt or hash
     */
    public static void addStudent(String userName, String firstName, String lastName, String matricNumber,
            String gender, String nationality, int mobileNo, String email, Calendar accessStart, Calendar accessEnd,
            int notiMode) throws NoSuchAlgorithmException {
        //add code to generate random salt
        byte[] salt = LoginManager.generateSalt();
        //add code to hash matric number using salt
        String password = LoginManager.generateHash(matricNumber, salt);
        Student s = new Student(userName, "Student", firstName, lastName, gender, nationality, mobileNo, email, salt, password, matricNumber, notiMode, accessStart, accessEnd);

        FileHandler.addToFile("Students.txt", s);

        ArrayList<Student> sList = DataListManager.getAllStudent();
        System.out.println("Students in system: ");
        for (Student sObj : sList){
            System.out.println(sObj.getUsername()+"- "+sObj.getFirstName()+" "+sObj.getLastName());
        }
    }
}
