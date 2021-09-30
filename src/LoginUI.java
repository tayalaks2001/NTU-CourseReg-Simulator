
import java.io.Console;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * This class runs the login manager and is called at the start of the program to get the user credentials
 */
public class LoginUI {
	/*
	 * public static void showUI(){ do{ System.out.println("Choose:");
	 * System.out.println("1.Login \n 2.Quit"); Scanner sc = new Scanner(System.in);
	 * int ch = sc.nextInt(); switch(ch){ case 1: Sys } } while(); }
	 */
	
	/**
	 * 
	 * @param cons parameter
	 * @param msg parameter
	 * @return maskedPassword in string format
	 */
	public static String getPasswordMasked(Console cons, String msg){
		char[] password;
		password = cons.readPassword("%s", msg);
		if (password != null){
			if (password.length > 0)
				return new String(password);
			
		}

		return null;
		
	} 
	
	/**
	 * 
	 * @return User object containing all the credentials
	 * @throws NoSuchAlgorithmException for if Validation Manager is unable to find hashing algorithm
	 */
	static User getCredentials() throws NoSuchAlgorithmException {
		String domain="", username, password;
		Scanner sc = new Scanner(System.in);
		int ch, chh;
		do{
			System.out.print("Enter choice: (1)Login\t(2)Quit:  ");
			chh = sc.nextInt(); sc.nextLine();
			if(chh ==1){
				do{
					System.out.print("Enter domain: (1) for Student, (2) for Staff:  ");
					ch = sc.nextInt();
					switch(ch){
						case 1: domain = "Student";
						break; 	
						case 2: domain = "Staff";
						break;
						default: System.out.println("Incorrect input! Enter again!");
					}	
				} while (ch != 1 && ch != 2);
				
				int choice;
				do{
					System.out.print("Enter choice: (1)Enter details\t(2)Back:  ");	
					choice = sc.nextInt();sc.nextLine();
					if(choice==1){
						System.out.print("Enter username: ");
						username = sc.nextLine();
						String msg ="Enter password: ";
						Console cons = System.console();
						password = getPasswordMasked(cons, msg);
						User u = LoginManager.validLogin(username, password, domain);
						if(u==null){
							continue;
						}
						else{
							return u;
						}
					}
				}while(choice!=2);
			}
		}while(chh!=2);
			
		System.out.println("Exiting..");
		System.exit(0);
		return null;
	}
}