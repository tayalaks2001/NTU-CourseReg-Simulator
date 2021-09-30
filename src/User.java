
import java.io.Serializable;

/**
 * Abstract parent Class for Student and Staff
 *
 */
public abstract class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private String domain;
    private String username;
    private String firstName; 
	private String lastName;
	private String gender;
	private String nationality; 
	private int mobileNo;
	private String emailID;
	private byte[] salt;
	private String password;
    public User(){}
    
    /**
     * Constructor class for User
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
    public User(String username, String domain, String firstName, String lastName, String gender, String nationality, int mobileNo, String email, byte[] salt, String password) {
        this.username 			= username;
        this.domain      		= domain;
        this.firstName 			= firstName;
		this.lastName 			= lastName;
		this.gender				= gender;
		this.nationality		= nationality;
		this.mobileNo           = mobileNo;
		this.emailID            = email;
		this.salt				= salt;
		this.password			= password;
    }

    /**
     * 
     * @return username parameter for getter function
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @return domain parameter for getter function
     */
    public String getDomain() {
        return domain;
    }

    /**
     * 
     * @return firstName parameter for getter function
     */
    public String getFirstName(){
    	return firstName;
    }

    /**
     * 
     * @return lastName parameter for getter function
     */
    public String getLastName(){
    	return lastName;
    }

    /**
     * 
     * @return gender parameter for getter function
     */
    public String getGender(){
    	return gender;
    }

    /**
     * 
     * @return nationality parameter for getter function
     */
    public String getNationality(){
    	return nationality;
    }

    /**
     * 
     * @return mobileNo parameter for getter function
     */
    public int getMobileNo(){
    	return mobileNo;
    }

    /**
     * 
     * @return emailID parameter for getter function
     */
    public String getEmailID(){
    	return emailID;
    }

    /**
     * 
     * @return salt parameter for getter function
     */
    public byte[] getSalt(){
    	return salt;
    }

    /**
     * 
     * @return password parameter for getter function
     */
    public String getPassword(){
    	return password;
    }

    /**
     * 
     * @param username parameter for setter function
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @param firstName parameter for setter function
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @param lastName parameter for setter function
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * 
     * @param gender parameter for setter function
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @param nationality parameter for setter function
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * 
     * @param mobileNo parameter for setter function
     */ 
    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * 
     * @param emailID parameter for setter function
     */
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    /**
     * 
     * @param salt parameter for setter function
     */
    public void setSalt(byte[] salt){
        this.salt = salt;
    }

    /**
     * 
     * @param password parameter for setter function
     */
    public void setPassword(String password){
        this.password = password;
    }
    
}