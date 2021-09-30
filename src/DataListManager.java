
import java.util.*;

/**
 * This class is used to take in input from the FileHandler and then turn it into processable data that can be used by all the other classes
 */
public class DataListManager{
	
	/**
	 * 
	 * @return studentArray, the arraylist of all Student objects
	 */
	static ArrayList<Student> getAllStudent(){

		ArrayList<Object> arr = FileHandler.readFromFile("Students.txt");
		ArrayList<Student> studentArray = new ArrayList<>();
		for (Object o: arr ){
			Student s = (Student) o;
			studentArray.add((s));
		}
		return studentArray;
	}

	/**
	 * 
	 * @return staffArray, the arraylist of all Staff objects
	 */
	static ArrayList<Staff> getAllStaff(){
		ArrayList<Object> arr = FileHandler.readFromFile("Staffs.txt");
		ArrayList<Staff> staffArray = new ArrayList<>();
		for (Object o: arr ){
			staffArray.add((Staff) o);
		}
		return staffArray;
	}

	/**
	 * 
	 * @return courseArray, the arraylist of all Course objects
	 */
	static ArrayList<Course> getAllCourse(){
		ArrayList<Object> arr = FileHandler.readFromFile("Courses.txt");
		ArrayList<Course> courseArray = new ArrayList<>();
		for (Object o: arr ){
			courseArray.add((Course) o);
		}
		return courseArray;
	}

	/**
	 * 
	 * @return indexArray, the arraylist of all Index objects
	 */
	static ArrayList<Index> getAllIndex(){
		ArrayList<Object> arr = FileHandler.readFromFile("Index.txt");
		ArrayList<Index> indexArray = new ArrayList<>();
		for (Object o: arr ){
			indexArray.add((Index) o);
		}
		return indexArray;
	}

	/**
	 * 
	 * @return courseRegArray, the arraylist of all CourseRegistration objects
	 */
	static ArrayList<CourseRegistration> getAllCourseRegistration(){
		ArrayList<Object> arr = FileHandler.readFromFile("CourseRegistration.txt");
		ArrayList<CourseRegistration> courseRegArray = new ArrayList<>();
		for (Object o: arr ){
			courseRegArray.add((CourseRegistration) o);
		}
		return courseRegArray;
	}

	/**
	 * 
	 * @return lessonArray, the arraylist of all Lesson objects
	 */
	static ArrayList<Lesson> getAllLesson(){
		ArrayList<Object> arr = FileHandler.readFromFile("Lessons.txt");
		ArrayList<Lesson> lessonArray = new ArrayList<>();
		for (Object o: arr ){
			lessonArray.add((Lesson) o);
		}
		return lessonArray;
	}

	/**
	 * 
	 * @param username parameter
	 * @return s, the student object of the username
	 */
	static Student getStudent(String username){
		ArrayList<Student> allStudents = getAllStudent();
		for (Student s: allStudents){
			if((s.getUsername()).equalsIgnoreCase(username)){
				return s;
			}
		}
		return null;	
	}

	/**
	 * 
	 * @param username parameter
	 * @return s, the staff object of the username
	 */
	static Staff getStaff(String username){
		ArrayList<Staff> allStaff = getAllStaff();
		for (Staff s: allStaff){
			if((s.getUsername()).equalsIgnoreCase(username)){
				return s;
			}
		}
		return null;	
	}

	/**
	 * 
	 * @param courseCode parameter
	 * @return c, the Course Object object of the courseCode
	 */
	static Course getCourse(String courseCode){
		ArrayList<Course> allCourses = getAllCourse();
		for (Course c: allCourses){
			if((c.getCourseCode()).equalsIgnoreCase(courseCode)){
				return c;
			}
		}
		return null;	
	}

	/**
	 * 
	 * @param indexNumber parameter
	 * @return i, the Index object of the indexNumber
	 */
	static Index getIndex(int indexNumber){
		ArrayList<Index> allIndex = getAllIndex();
		for (Index i: allIndex){
			if(i.getIndexNumber() == indexNumber){
				
				return i;
			}
		}
		return null;	
	}
    
	/**
	 * 
	 * @param username parameter
	 * @param courseCode parameter
	 * @return cr, the Course Registration Object of the username, courseCode combination
	 */
	static CourseRegistration getCourseRegistration(String username, String courseCode){
		ArrayList<CourseRegistration> allCourseReg = getAllCourseRegistration();
		for (CourseRegistration cr: allCourseReg){
			if((cr.getUsername()).equalsIgnoreCase(username) && (cr.getCourseCode()).equalsIgnoreCase(courseCode)){
				return cr;
			}
		}
		return null;	
	}

	/**
	 * 
	 * @param indexNumber parameter
	 * @return registeredCourses, the Course Registration objects of the indexNumber
	 */
	//Return course registration array from index number
	static ArrayList<CourseRegistration> byIndexNumber(int indexNumber){
		ArrayList<CourseRegistration> allCourseReg = getAllCourseRegistration();
		ArrayList<CourseRegistration> registeredCourses = new ArrayList<>();

		for (CourseRegistration cr: allCourseReg){
			if((cr.getIndexNumber()) == indexNumber ){
				registeredCourses.add(cr);
			}
		}

		if (registeredCourses.size() > 0)
				return registeredCourses;

		return null;
	}

	//Return course registration array from course code

	/**
	 * 
	 * @param courseCode parameter
	 * @return registeredCourses, the Course Registration objects of the courseCode
	 */
	static ArrayList<CourseRegistration> byCourseCode(String courseCode){
		ArrayList<CourseRegistration> allCourseReg = getAllCourseRegistration();
		ArrayList<CourseRegistration> registeredCourses = new ArrayList<>();

		for (CourseRegistration cr: allCourseReg){
			if((cr.getCourseCode()).equalsIgnoreCase(courseCode) ){
				registeredCourses.add(cr);
			}
		}

		if (registeredCourses.size() > 0)
				return registeredCourses;

		return null;
	}

	/**
	 * 
	 * @param username
	 * @return registeredCourses, the Course Registration objects of the username
	 */
	static ArrayList<CourseRegistration> getRegisteredCourses(String username){
		ArrayList<CourseRegistration> allCourseReg = getAllCourseRegistration();
		ArrayList<CourseRegistration> registeredCourses = new ArrayList<>();

		for (CourseRegistration cr: allCourseReg){
			if((cr.getUsername()).equalsIgnoreCase(username) ){
				registeredCourses.add(cr);
			}
		}

		if (registeredCourses.size() > 0)
				return registeredCourses;

		return null;
	}

	/**
	 * 
	 * @param lessonID parameter
	 * @return l, all lessons in that lessonID
	 */
	static Lesson getLesson(int lessonID){
		ArrayList<Lesson> allLessons = getAllLesson();
		for (Lesson l: allLessons){
			if(l.getLessonID() == lessonID){
				return l;
			}
		}
		return null;	
	}
    


}