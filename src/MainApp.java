import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

/**
 * 
 * Main app runs the whole program and calls UIs
 */
public class MainApp {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, ParseException {
        int re;
        boolean ret;
        while(true){
            System.out.println();
            System.out.println("\n----------Welcome to STARS--------------");
            User u = LoginUI.getCredentials();
            if(u.getDomain().equalsIgnoreCase("STAFF")){
                re = 0;
                do{
                    re = StaffUI.displayOptions();
                }while(re!=1);
            }
            else{
                ret = true;
                do{
                    ret = StudentUI.showStudentOptions(u.getUsername());
                }while(ret != false);
            }
            System.out.println("Thank you " +u.getUsername() + " for using STARS! Have a nice day :)");
        }
    }
}
    


