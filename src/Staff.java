
import java.io.*;

/**
* Entity class for Staff, which inherits from the abstract class of User
*/
public class Staff extends User implements java.io.Serializable{
	/**
	 * Constructor for Class
	 * @param username parameter
	 * @param domain parameter
	 * @param firstName parameter
	 * @param lastName parameter
	 * @param gender parameter
	 * @param nationality parameter
	 * @param mobileNo parameter
	 * @param email parameter
	 * @param salt parameter
	 * @param password parameter
	 */
    public Staff(String username, String domain, String firstName, String lastName, String gender, String nationality, int mobileNo, String email, byte[] salt, String password) {
        super(username,domain,firstName,lastName,gender,nationality,mobileNo,email,salt, password);
    }
    
}
