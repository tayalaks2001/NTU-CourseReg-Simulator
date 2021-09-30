// package Entity;
import java.io.*;
import java.util.*;
/**
* Entity class for Students, which inherits from the abstract class of User
*/
public class Student extends User implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String matricNo;
	private int modeOfNotification;
	private Calendar startAccess;
	private Calendar endAccess;
	
	public Student() {
	}
	
	/**
	 * Constructor for Student Class
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
	 * @param matricNo parameter
	 * @param modeOfNotification parameter
	 * @param startAccess parameter
	 * @param endAccess parameter
	 */
	public Student(String username, String domain, String firstName, String lastName, String gender, String nationality, int mobileNo, String email, byte[] salt, String password, String matricNo, int modeOfNotification, Calendar startAccess, Calendar endAccess){
		super(username,domain,firstName,lastName,gender,nationality,mobileNo,email,salt, password);
		this.matricNo = matricNo;
		this.modeOfNotification = modeOfNotification;
		this.startAccess = startAccess;
		this.endAccess = endAccess;
	}

    /**
     * 
     * @return matricNo parameter for getter function
     */
	public String getMatricNo() {
        return matricNo;
    }

    /**
     * 
     * @return modeOfNotification parameter for getter function
     */
    public int getModeOfNotification() {
        return modeOfNotification;
    }

    /**
     * 
     * @return startAccess parameter for getter function
     */
    public Calendar getStartAccess() {
        return startAccess;
    }

    /**
     * 
     * @return endAccess parameter for getter function
     */
    public Calendar getEndAccess() {
        return endAccess;
    }

    /**
     * 
     * @param accessStart parameter for setter function
     */
    public void setStartAccess(Calendar accessStart) {
		this.startAccess = accessStart;
	}

    /**
     * 
     * @param endAccess parameter for setter function
     */
	public void setEndAccess(Calendar endAccess) {
		this.endAccess = endAccess;
	}

	/**
	 * 
	 * @param notiMode parameter for setter function
	 */
	public void setModeOfNotification(int notiMode) {
		this.modeOfNotification = notiMode;
	}

	/**
	 * 
	 * @param matricNo parameter for setter function
	 */
	public void setMatricNo(String matricNo) {
        this.matricNo = matricNo;
    }
}