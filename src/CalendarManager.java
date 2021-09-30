
import java.text.*;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

/**
 * This class is used to get the current time (and date) as Calendar or String objects as per requirement by a class
 */
public class CalendarManager {
	
	static Scanner sc = new Scanner(System.in);
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	/**
	 * 
	 * @param time to get the time input in other format
	 * @return calendar which is only Time in Calendar format
	 * @throws ParseException for input errors
	 */
	public static Calendar getOnlyTime(String time) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date date = sdf.parse(time);

		Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
		calendar.setTime(date);
		return calendar;
	}
	
	/**
	 * 
	 * @return dtf.format(now) which is the current time
	 */
	public static String getCurrentTime(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   		LocalDateTime now = LocalDateTime.now();  
   		return dtf.format(now);
	}

	/**
	 * 
	 * @param cal takes in date in Calendar format
	 * @return string date
	 */
	public static String calendarToString(Calendar cal) {
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		return String.format("%02d/%02d/%4d %02d:%02d", day, month + 1, year, hour, minute);
	}
	/**
	 * 
	 * @param s which is date in string format
	 * @return cal which is date in Calendar format
	 */
	public static Calendar stringToCalendar(String s){
		try{
			Date date = dateFormat.parse(s);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal;
		}
		catch(ParseException e){
			return null;
		}
		
	}

	// public static boolean checkValidTime(String time){
	// 	try{
	// 		hours = Integer.parseInt(s.substring(0,2)) ;
	// 		minutes = Integer.parseInt(s.substring(3,5)) ;
	// 		if(hours>23 or hours < 0 or minutes>59 or minutes<0){
	// 			return false;
	// 		}
	// 		catch(){
	// 			return false;
	// 		}
	// 		return true;
	// }
	
	/**
	 * 
	 * @param mode to get type of input
	 * @return newDate in Calendar format of the VALID reservation date-time
	 */
	public static Calendar getValidDateTime(String mode){
		
		String date = "";

	    Date parsedDate = null;
		boolean validDate = false;		
		Calendar newDate = Calendar.getInstance();
		
		do{
			System.out.print("Enter " + mode + " (dd/MM/yyyy HH:mm): ");
			date  = sc.nextLine();
			dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		    try {
		    	parsedDate = dateFormat.parse(date);
		    	 
		    } catch (ParseException e) {
		        System.out.println("Input is not in the correct format!");
		        continue;
		    }
		    newDate.setTime(parsedDate);

		    validDate = true;

		} while(!validDate);
				
		return newDate;
	}
	

}