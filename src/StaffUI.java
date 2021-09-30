
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.*;

/**
 * StaffUI is used to display all the options available to staff users.
 * This UI is only presented in the MainUI if the entered credentials match the staff credentials.
 */
public class StaffUI {
    static int displayOptions() throws IOException, NoSuchAlgorithmException, ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----------Welcome to Staff panel--------------");
        System.out.println("Choose from the following:");
        System.out.println("1. Edit student access period for all students");
        System.out.println("2. Edit student access period for a particular student");
        System.out.println("3. Add a student");
        System.out.println("4. Add a course");
        System.out.println("5. Update a course");
        System.out.println("6. Check availibility for index in a course");
        System.out.println("7. Print student list by index number");
        System.out.println("8. Print student list by course");
        System.out.println("9. Logout");
        System.out.print("Select your option: ");

        int ch = sc.nextInt();sc.nextLine();
        switch(ch){
            case 1:
                int choice;
                do{
                    System.out.print("Enter choice: (1)Enter details\t(2)Back:  ");
                    choice = sc.nextInt();sc.nextLine();
                    if(choice == 1){
                        
                        System.out.print("Enter new access start time in \"DD/MM/YYYY HH:MM\" format:   ");
                        String starttime = sc.nextLine();
                        if(! ValidationManager.checkValidTime(starttime)){
                            System.out.println("Invalid time, try again!");
                            continue;
                        }
                        Calendar st = CalendarManager.stringToCalendar(starttime);
                        System.out.print("Enter new access end time in \"DD/MM/YYYY HH:MM\" format:  ");
                        String endtime = sc.nextLine();
                        if(! ValidationManager.checkValidTime(endtime)){
                            System.out.println("Invalid time, try again!");
                            continue;
                        }
                        Calendar et = CalendarManager.stringToCalendar(endtime);
                        StudentStaffManager.updateAccessTime(st,et);
                        System.out.println("Successfully updated!");
                        break;
                    }
                }while(choice != 2);
                return 0;
                

            case 2:
                do{
                    System.out.print("Enter choice: (1)Enter details\t(2)Back:  ");
                    choice = sc.nextInt();sc.nextLine();
                    if(choice == 1){
                        System.out.print("Enter student's username:  ");
                        String username = sc.nextLine();
                        if(! ValidationManager.existsUsername(username)){
                            System.out.println("Invalid Username, try again!");
                            continue;
                        }
                        System.out.print("Enter new access start time in \"DD/MM/YYYY HH:MM\" format:  ");
                        String starttime = sc.nextLine();
                        if(! ValidationManager.checkValidTime(starttime)){
                            System.out.println("Invalid time, try again!");
                            continue;
                        }
                        Calendar st = CalendarManager.stringToCalendar(starttime);
                        System.out.print("Enter new access end time in \"DD/MM/YYYY HH:MM\" format:  ");
                        String endtime = sc.nextLine();
                        if(! ValidationManager.checkValidTime(endtime)){
                            System.out.println("Invalid time, try again!");
                            continue;
                        }
                        Calendar et = CalendarManager.stringToCalendar(endtime);
                        StudentStaffManager.updateAccessTime(username, st, et);
                        System.out.println("Successfully updated!");                  
                        break;
                    }
                }while(choice != 2);
                return 0;
            

            case 3: 
                do{
                    System.out.print("Enter choice: (1)Enter details\t(2)Back:  ");
                    choice = sc.nextInt();
                    sc.nextLine();
                    if(choice == 1){
                        System.out.print("Enter student's username: ");
                        String username = sc.nextLine();
                        if(ValidationManager.existsUsername(username)){
                            System.out.println("Invalid Username, try again!");
                            continue;
                        }
                        System.out.print("Enter student's firstname:  ");
                        String firstname = sc.nextLine();
                        System.out.print("Enter student's lastname:  ");
                        String lastname = sc.nextLine();
                        System.out.print("Enter student's matric number:  ");
                        String matricNumber = sc.nextLine();
                        System.out.print("Enter student's gender:  ");
                        String gender = sc.nextLine();
                        System.out.print("Enter student's nationality:  ");
                        String nationality = sc.nextLine();
                        System.out.print("Enter student's email:  ");
                        String email = sc.nextLine();
                        System.out.print("Enter student's mobileNo:  ");
                        int mobileNo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new access start time in \"DD/MM/YYYY HH:MM\" format:  ");
                        String starttime = sc.nextLine();
                        if(! ValidationManager.checkValidTime(starttime)){
                            System.out.println("Invalid time, try again!");
                            continue;
                        }
                        
                        System.out.print("Enter new access end time in \"DD/MM/YYYY HH:MM\" format:  ");
                        String endtime = sc.nextLine();
                        if(! ValidationManager.checkValidTime(endtime)){
                            System.out.println("Invalid time, try again!");
                            continue;
                        }
                        Calendar st = CalendarManager.stringToCalendar(starttime);
                        Calendar et = CalendarManager.stringToCalendar(endtime);
                        System.out.print("Enter Mode of Notificaiton: ");
                        int notiMode = sc.nextInt();
                        sc.nextLine(); // provide options later
                        StudentStaffManager.addStudent(username, firstname, lastname, matricNumber, gender, nationality, mobileNo, email , st, et, notiMode);
                        System.out.println("Successfully updated!");
                        break;
                    }
                }while(choice != 2);
                return 0;


            case 4:
            int chh, chhh;
                do{
                    System.out.print("Enter choice: (1)Enter details\t(2)Back:  ");
                    choice = sc.nextInt();
                    sc.nextLine();
                    if(choice == 1){
                        System.out.print("Enter new course code:  ");
                        String courseCode = sc.nextLine();
                        if(ValidationManager.existsCourseCode(courseCode)){
                            System.out.println("Invalid courseCode, try again!");
                            continue;
                        }
                        System.out.print("Enter course name:  ");
                        String courseName = sc.nextLine();
                        System.out.print("Enter course credit:  ");
                        int credit = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter course school:  ");
                        String school = sc.nextLine();
                        System.out.print("Enter course type:  ");
                        String type = sc.nextLine();
                        System.out.print("Enter course exam date in \"DD/MM/YYYY HH:MM\" format:  ");
                        String examDate = sc.nextLine();
                        if(! ValidationManager.checkValidTime(examDate)){
                            System.out.println("Invalid time, try again!");
                            continue;
                        }
                        Calendar examdate = CalendarManager.stringToCalendar(examDate);
                        ArrayList<Integer> indices= new ArrayList<>();

                        do{
                            
                            System.out.print("Enter choice: (1)Add index\t(2)Back:  ");
                            chh = sc.nextInt();
                            sc.nextLine();
                            if(chh == 1){
                                System.out.print("Enter a new index number for " + courseCode+" :  ");
                                int newIndex = sc.nextInt();
                                sc.nextLine();
                                if( ValidationManager.checkIndexPresent(newIndex)){
                                    System.out.println("Index Already present");
                                    continue;
                                }
                                else{
                                    indices.add(newIndex);
                                }
                                //check if newindex alr present
                                System.out.print("Enter a group for " + newIndex+" :  ");
                                String group = sc.nextLine();
                                System.out.print("Enter number of vacancies in " + newIndex+" :  ");
                                int vacancy = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Enter total seats:  ");
                                int total = sc.nextInt();
                                sc.nextLine();
                                Queue<String> waitingList = new LinkedList<>();
                                ArrayList<Integer> lessons = new ArrayList<>();
                                do{
                                    System.out.print("Enter choice: (1)Add lesson\t(2)Back:  ");
                                    chhh = sc.nextInt();
                                    sc.nextLine();
                                    if(chhh == 1){
                                        System.out.print("Enter LessonID:  ");
                                        int lessonID = sc.nextInt();
                                        sc.nextLine();
                                        if(ValidationManager.checkLessonPresent(lessonID)){
                                            System.out.println("Lesson Already present");
                                            continue;
                                        }
                                        else{
                                            lessons.add(lessonID);
                                        }
                                        System.out.print("Enter lesson type:  ");
                                        String lessontype = sc.nextLine();
                                        System.out.print("Enter Day of this lesson:  ");
                                        int day =sc.nextInt();sc.nextLine();
                                        System.out.print("Enter lesson weeks:  ");
                                        String weeks = sc.nextLine();
                                        System.out.print("Enter lesson Venue:  ");
                                        String venue = sc.nextLine();
                                        System.out.print("Enter lesson startTime in \"HH:MM\" format:  ");
                                        String startTime = sc.nextLine();
                                        if(!ValidationManager.checkOnlyTime(startTime)){
                                            System.out.println("Invalid time");
                                            continue;
                                        }

                                        System.out.print("Enter lesson endTime in \"HH:MM\" format:  ");
                                        String endTime = sc.nextLine();
                                        if(!ValidationManager.checkOnlyTime(endTime)){
                                            System.out.println("Invalid time");
                                            continue;
                                        }
                                        Calendar st = CalendarManager.getOnlyTime(startTime);
                                        Calendar et = CalendarManager.getOnlyTime(endTime);
                        
                                        StaffCourseManager.addLesson(lessonID, lessontype, day, weeks, venue, st, et);
                                    }
                                    
                                }while(chhh!=2);
                                StaffCourseManager.addIndex(courseCode, newIndex, group, vacancy,total, lessons,waitingList);
                            }
                        }while(chh !=2);
                    
                    StaffCourseManager.addCourse(courseCode, courseName, credit, school,type, examdate, indices);
                }
                }while(choice != 2);
                return 0;

            case 5:
                infloop: 
                while(true){
                    System.out.println("What do you want to update?");
                    System.out.println("1. Course Code");
                    System.out.println("2. School");
                    System.out.println("3. Add Index Numbers");
                    System.out.println("4. Update Index Numbers");
                    System.out.println("5. Number of vacancies");
                    System.out.println("6. Back");
                    System.out.print("Enter your choice:  ");
                    chh = sc.nextInt();sc.nextLine();
                    switch (chh) {
                        case 1:
                        do{
                            System.out.print("Enter choice: (1)Enter details\t(2)Back:  ");
                            choice = sc.nextInt();sc.nextLine();
                            if(choice == 1){
                                System.out.print("Enter old courseCode:  ");
                                String oldcode = sc.nextLine();
                                if(! ValidationManager.existsCourseCode(oldcode)){
                                    System.out.println("Invalid courseCode");
                                    continue;
                                }
                                System.out.print("Enter new courseCode:  ");
                                String newcode = sc.nextLine();
                                if( ValidationManager.existsCourseCode(newcode)){
                                    System.out.println("Invalid courseCode");
                                    continue;
                                }
                                StaffCourseManager.updateCourse(oldcode, newcode);
                            }
                        }while(choice !=2);   
                        break;
                        
                        case 2:
                        do{
                            System.out.print("Enter choice: (1)Enter details\t(2)Back:  ");
                            choice = sc.nextInt();sc.nextLine();
                            if(choice == 1){
                                System.out.print("Enter courseCode:  ");
                                String oldcode = sc.nextLine();
                                if(! ValidationManager.existsCourseCode(oldcode)){
                                    System.out.println("Invalid courseCode");
                                    continue;
                                }
                                System.out.print("Enter new school:  ");
                                String newSchool = sc.nextLine();
                                StaffCourseManager.updateSchool(oldcode, newSchool);
                            }
                        }while(choice !=2);  
                        
                        case 3:
                            do{
                                
                                System.out.print("Enter choice: (1)Add index\t(2)Back:  ");
                                chh = sc.nextInt();sc.nextLine();
                                if(chh == 1){
                                
                                    System.out.print("Enter course to which you want to add index:  ");
                                    String courseCode = sc.nextLine();
                                    if(!ValidationManager.existsCourseCode(courseCode)){
                                        System.out.println("Invalid courseCode, try again!");
                                        continue;
                                    }                                    
                                    System.out.print("Enter a new index number for " + courseCode + " :  ");
                                    int newIndex = sc.nextInt();sc.nextLine();
                                    if(ValidationManager.checkIndexPresent(newIndex)){
                                        System.out.println("Index Already present");
                                        continue;
                                    }
                                    System.out.print("Enter a group for " + newIndex+" :  ");
                                    String group = sc.nextLine();
                                    System.out.print("Enter number of vacancies in " + newIndex+" :  ");
                                    int vacancy = sc.nextInt();sc.nextLine();
                                    System.out.print("Enter total seats:  ");
                                    int total = sc.nextInt();sc.nextLine();
                                    Queue<String> waitingList = new LinkedList<>();
                                    ArrayList<Integer> lessons = new ArrayList<>();
                                    do{
                                        System.out.print("Enter choice: (1)Add a lesson\t(2)Back:  ");
                                        chhh = sc.nextInt();sc.nextLine();
                                        if(chhh == 1){
                                            System.out.print("Enter LessonID:  ");
                                            int lessonID = sc.nextInt();sc.nextLine();
                                            if(ValidationManager.checkLessonPresent(lessonID)){
                                                System.out.println("Lesson Already present");
                                                continue;
                                            }
                                            else{
                                                lessons.add(lessonID);
                                            }
                                            System.out.print("Enter lesson type:  ");
                                            String lessontype = sc.nextLine();
                                            System.out.print("Enter Day of this lesson:  ");
                                            int day =sc.nextInt();sc.nextLine();
                                            System.out.print("Enter lesson weeks:  ");
                                            String weeks = sc.nextLine();
                                            System.out.print("Enter lesson Venue:  ");
                                            String venue = sc.nextLine();
                                            System.out.print("Enter lesson startTime in \"HH:MM\" format:  ");
                                            String startTime = sc.nextLine();
                                            if(!ValidationManager.checkOnlyTime(startTime)){
                                                System.out.println("Invalid time");
                                                continue;
                                            }

                                            System.out.print("Enter lesson endTime in \"HH:MM\" format:  ");
                                            String endTime = sc.nextLine();
                                            if(!ValidationManager.checkOnlyTime(endTime)){
                                                System.out.println("Invalid time");
                                                continue;
                                            }
                                            Calendar st = CalendarManager.getOnlyTime(startTime);
                                            Calendar et = CalendarManager.getOnlyTime(endTime);
                        
                                            StaffCourseManager.addLesson(lessonID, lessontype, day, weeks, venue, st, et);
                                        }
                                        
                                    }while(chhh!=2);
                                    StaffCourseManager.addIndex(courseCode, newIndex, group, vacancy,total, lessons,waitingList);
                                    
                                }
                            }while(chh !=2); 
                        break;
                        case 4: 
                        do{
                            System.out.print("Enter choice: (1)Enter details\t(2)Back:  ");
                            choice = sc.nextInt();sc.nextLine();
                            if(choice == 1){
                                System.out.print("Enter courseCode:  ");
                                String courseCode = sc.nextLine();
                                if(! ValidationManager.existsCourseCode(courseCode)){
                                    System.out.println("Invalid courseCode");
                                    continue;
                                }
                                System.out.print("Enter old index:  ");
                                int oldIndex = sc.nextInt();sc.nextLine();
                                if(! ValidationManager.existsIndexNumber(courseCode, oldIndex)){
                                    System.out.println("Invalid Index");
                                    continue;
                                }
                                System.out.print("Enter new index:  ");
                                int newIndex = sc.nextInt();sc.nextLine();
                                if(ValidationManager.existsIndexNumber(courseCode, newIndex)){
                                    System.out.println("Invalid Index");
                                    continue;
                                }
                                StaffCourseManager.updateIndex(oldIndex,newIndex);
                                System.out.println("Sucessfully Updated");
                            }
                        }while(choice !=2);  
                        break;
                        case 5:
                        do{
                            System.out.print("Enter choice: (1)Enter details\t(2)Back:  ");
                            choice = sc.nextInt();sc.nextLine();
                            if(choice == 1){
                                System.out.print("Enter courseCode:  ");
                                String courseCode = sc.nextLine();
                                if(! ValidationManager.existsCourseCode(courseCode)){
                                    System.out.println("Invalid courseCode");
                                    continue;
                                }
                                System.out.print("Enter index:  ");
                                int index = sc.nextInt();sc.nextLine();
                                if(! ValidationManager.existsIndexNumber(courseCode, index)){
                                    System.out.println("Invalid Index");
                                    continue;
                                }
                                StudentCourseManager.getVacancies(courseCode, index);
                                System.out.print("Enter number of vacancies:  ");
                                int vacancies = sc.nextInt();sc.nextLine();
                                StaffCourseManager.updateVacancy(index, vacancies);
                            }
                        }while(choice !=2);  
                        break;
                        default:
                            System.out.println("Invalid Input!");
                            break infloop;
                    }
                    
                }
                return 0;

            case 6: 
                do{
                    System.out.print("Enter choice: (1)Enter details\t(2)Back:  ");
                    choice = sc.nextInt();sc.nextLine();
                    if(choice == 1){
                        System.out.print("Enter courseCode:  ");
                        String courseCode = sc.nextLine();
                        if(! ValidationManager.existsCourseCode(courseCode)){
                            System.out.println("Invalid courseCode");
                            continue;
                        }
                        System.out.print("Enter index:  ");
                        int index = sc.nextInt();sc.nextLine();
                        if(! ValidationManager.existsIndexNumber(courseCode, index)){
                            System.out.println("Invalid Index");
                            continue;
                        }
                        
                        StudentCourseManager.getVacancies(courseCode, index);
                        break;
                    }

                }while(choice !=2);  
                return 0;

            case 7:
                do{
                    System.out.print("Enter choice: (1)Enter details\t(2)Back:  ");
                    choice = sc.nextInt();sc.nextLine();
                    if(choice == 1){
                        System.out.print("Enter courseCode:  ");
                        String courseCode = sc.nextLine();
                        if(! ValidationManager.existsCourseCode(courseCode)){
                            System.out.println("Invalid courseCode");
                            continue;
                        }
                        System.out.print("Enter index:  ");
                        int index = sc.nextInt();sc.nextLine();
                        if(! ValidationManager.existsIndexNumber(courseCode, index)){
                            System.out.println("Invalid Index");
                            continue;
                        }
                        PrintManager.printByIndex(index);
                        
                    }

                }while(choice !=2);  
                return 0;

            case 8:
                 do{
                    System.out.print("Enter choice: (1)Enter details\t(2)Back:  ");
                    choice = sc.nextInt();sc.nextLine();
                    if(choice == 1){
                        System.out.print("Enter courseCode:  ");
                        String courseCode = sc.nextLine();
                        if(! ValidationManager.existsCourseCode(courseCode)){
                            System.out.println("Invalid courseCode");
                            continue;
                        }
                        System.out.println("Students who have taken Course Number " + courseCode+" :  ");
                        ArrayList<String> s = PrintManager.printByCourse(courseCode);
                        if(s==null){
                            System.out.println("No one is registered in this course!");
                        }
                        else{
                            for(String st:s){
                                System.out.println(st);
                            }
                        }
                        
                    }}while(choice!=2);
                    return 0;

            case 9:   
                return 1;

            default:
                    System.out.println("Wrong choice");
                    return 2;
        }
    }
}