// package UI;
// import Entity.*;
// import Manager.*;
import java.io.Console;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

// import Manager.StudentCourseManager;

/**
* Student UI is the UI provided if the credentials match with the credentials in Student entity
*/
public class StudentUI {
	/**
	 * 
	 * @param username parameter
	 * @return boolean for if a valid option was chosen
	 * @throws IOException for if the FileManager is unable to write to file
	 * @throws NoSuchAlgorithmException for if Validation Manager is unable to find hashing algorithm
	 */
    public static Boolean showStudentOptions(String username) throws IOException, NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----------Welcome to Student panel--------------");
        System.out.println("1. Register Course");
        System.out.println("2. Drop Course");
        System.out.println("3. Check/Print Courses Registered ");
        System.out.println("4. Check Vacancies Available");
        System.out.println("5. Change Index Number of Course ");
        System.out.println("6. Swop Index Number with Another Student");
        System.out.println("7. Logout");
        System.out.print("Select your option: ");

        int i = sc.nextInt();

        switch (i) {
            case 1:
                //registerCourse(username);
                if( registerCourse(username))
                    System.out.println("Successfully registered course");
                return true;
            case 2:
                if( dropCourse(username))
                    System.out.println("Successfully dropped course");
                return true;
            case 3:
                printRegisteredCourses(username);
                return true;
            case 4:
                printVacancies();
                return true;
            case 5:
                if( changeIndexNumber(username))
                System.out.println("Successfully changed index number");
                else
                    System.out.println("Not success");
                return true;
            case 6:
                if( swapIndexNumber(username))
                System.out.println("Successfully swapped index number");
                else
                    System.out.println("Not success");
                return true;
            case 7:
                return false;
            default:
                System.out.println("Please select a valid option");
                return true;
        }
    }

    /**
     * 
     * @param username parameter
     * @return boolean for if the course was registered
     * @throws IOException for if the FileManager is unable to write to file
     */
    public static Boolean registerCourse(String username) throws IOException {
        Scanner sc = new Scanner(System.in);
        String courseCode;
        int indexNumber;

        System.out.print("Enter Course ID to register: ");
        courseCode = sc.nextLine();

        while (true) {
            try {
                System.out.print("Enter Index Number: ");
                indexNumber = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter valid integer Index Number");
            }
        }

        return StudentCourseManager.registerCourse(username, courseCode, indexNumber);
    }

    /**
     * 
     * @param username parameter
     * @return boolean for ifthe course was dropped
     * @throws IOException for if the FileManager is unable to write to file
     */
    public static Boolean dropCourse(String username) throws IOException {
        Scanner sc = new Scanner(System.in);
        String courseCode;

        System.out.print("Enter Course ID to drop: ");
        courseCode = sc.nextLine();

        return StudentCourseManager.dropCourse(username, courseCode);
    }

    /**
     * 
     * @param username parameter
     * @return boolean for if a index was swapped
     * @throws NoSuchAlgorithmException for if Validation Manager is unable to find hashing algorithm
     * @throws IOException for if the FileManager is unable to write to file
     */
    public static Boolean swapIndexNumber(String username) throws NoSuchAlgorithmException, IOException {
        Scanner sc = new Scanner(System.in);
        String courseCode;
        String user1 = username;
        String user2;
        String pass2;


        System.out.print("Enter Username of student to swap course with: ");
        user2 = sc.nextLine();
        String msg ="Enter your password "+user2+": ";
        Console cons = System.console();
        pass2 = LoginUI.getPasswordMasked(cons, msg);
        
        System.out.print("Enter Course ID to swap: ");
        courseCode = sc.nextLine();

        return StudentCourseManager.swapIndexNumber(user1, user2, pass2, courseCode);
    }

    /**
     * 
     * @param username parameter
     * @return boolean for if the index number was changed
     * @throws IOException for if the FileManager is unable to write to file
     */
    public static Boolean changeIndexNumber(String username) throws IOException {
        Scanner sc = new Scanner(System.in);
        String courseCode;
        int indexNumber2;

        System.out.print("Enter Course ID to change: ");
        courseCode = sc.nextLine();

        

        while (true) {
            try {
                System.out.print("Enter new Index Number: ");
                indexNumber2 = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter valid integer Index Number");
            }
        }

        return StudentCourseManager.changeIndexNumber(username, courseCode,  indexNumber2);
    }

    /**
     *  Prints all vacancies
     */
    public static void printVacancies() {
        Scanner sc = new Scanner(System.in);
        String courseCode;
        int indexNumber;

        System.out.print("Enter Course ID check vacancies: ");
        courseCode = sc.nextLine();

        while (true) {
            try {
                System.out.print("Enter Index Number: ");
                indexNumber = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter valid integer Index Number");
            }
        }

        StudentCourseManager.getVacancies(courseCode, indexNumber);
    }

    /**
     * Prints all Courses a student has registered to
     * @param username parameter
     */
    public static void printRegisteredCourses(String username) {
        StudentCourseManager.printRegisteredCourses(username);
    }
}