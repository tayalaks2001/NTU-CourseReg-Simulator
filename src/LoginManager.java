
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

public class LoginManager{
	Byte[] hashBytes;

	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static User validLogin(String username, String passwordToHash, String acctType)
			throws NoSuchAlgorithmException {
		Boolean passwordCorrect = compareUserPassword(username, passwordToHash, acctType);
		ArrayList<Student> studentList = DataListManager.getAllStudent();
		ArrayList<Staff> staffList = DataListManager.getAllStaff();
		if (passwordCorrect){
			if (acctType.equalsIgnoreCase("Student")   && isValidAccessTime(username)){
				for (Student s : studentList){
					if ((s.getUsername()).equalsIgnoreCase(username))
						return s;
				}
			}
			else if (acctType.equalsIgnoreCase("Staff") ){
				for (Staff s : staffList){
				if ((s.getUsername()).equalsIgnoreCase(username))
					return s;
				}
			}
			else
				return null;
			
		}
		else{
			return null;
		}
		return null;
	}

	private static Boolean compareUserPassword(String username, String passwordToHash, String acctType)
			throws NoSuchAlgorithmException {
		byte[] salt;
		String hashed;
		ArrayList<Student> studentList = DataListManager.getAllStudent();
		ArrayList<Staff> staffList = DataListManager.getAllStaff();
		if (acctType.equalsIgnoreCase("Student") ){
			for (Student s : studentList){
				if ((s.getUsername()).equalsIgnoreCase(username)){
					salt = s.getSalt();
					hashed = generateHash(passwordToHash, salt);
					if (hashed.equalsIgnoreCase(s.getPassword())){
						return true;
					}
					else{
						System.out.println("Incorrect password!");
						return false;
					}
				}
			}
			System.out.println("Username not found!");
			return false;
		}
		else{
			for (Staff s : staffList){
				if ((s.getUsername()).equalsIgnoreCase(username)){
					salt = s.getSalt();
					hashed = generateHash(passwordToHash, salt);
					if (hashed.equalsIgnoreCase(s.getPassword())){
						return true;
					}
					else{
						System.out.println("Incorrect password!");
						return false;
					}
				}
			}
			System.out.println("Username not found!");
			return false;
		}

	}

	private static Boolean isValidAccessTime(String username){
		ArrayList<Student> studentList = DataListManager.getAllStudent();
		for (Student s : studentList){
			if ((s.getUsername()).equalsIgnoreCase(username)){
				Calendar now = Calendar.getInstance();
				if (now.compareTo((s.getStartAccess()))>0 && now.compareTo((s.getEndAccess()))<0){
					System.out.println("Successfully logged in - Time valid!");
					return true;
				}
				else{
					System.out.println("Not allowed access at this time!");
					return false;
				}
			}
		}

		return false;
	}


	public static String bytestoStringHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte[] generateSalt() {
        byte[] salt_bytes = new byte[10];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt_bytes);
        return salt_bytes;
    }


    public static String generateHash(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.reset();
        digest.update(salt);
        byte[] hash = digest.digest(password.getBytes());
        return bytestoStringHex(hash);
    }
}