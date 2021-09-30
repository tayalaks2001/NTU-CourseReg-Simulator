
import java.io.*;
import java.util.*;



/**
 * This class does the I/O and Serialises and Deserialises the data. It is generalised to read in all object types and write in all object types.
 */
public class FileHandler {
	// static String currentDir = "C:\\Users\\user\\OneDrive\\Desktop\\oodp - Copy\\";
	static String currentDir = System.getProperty("user.dir") + "\\Database\\";
	
	/**
	 * 
	 * @param filename parameter
	 * @return Arraylist of objects from file
	 */
	public static ArrayList<Object> readFromFile(String filename){

	    ArrayList<Object> returnArray = new ArrayList<>();
	         
	        try
	        {
	            FileInputStream fis = new FileInputStream(currentDir + filename);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	 
	            while (true){
	            	try{
	            		Object o = ois.readObject();
						returnArray.add(o);
	            	}
	            	catch (EOFException e) {
			            // If there are no more objects to read, return what we have.
			            ois.close();
			    		fis.close();
			            return returnArray;
			        } 
			    }
	        } 
	        catch (IOException ioe) 
	        {
				ioe.printStackTrace();
				System.out.println("IOException");
	            return null;
	        } 
	        catch (ClassNotFoundException c) 
	        {
	            System.out.println("Class not found");
	            c.printStackTrace();
	            return null;
	        }
	}

	/**
	 * 
	 * @param filename parameter
	 * @param arr parameter for arraylist of objects to write to file
	 * @throws IOException for if the FileHandler is unable to write to file
	 */
	public static void writeToFile(String filename, ArrayList<Object> arr) throws IOException{

		try{ 
			FileOutputStream file = new FileOutputStream(currentDir + filename); 
        	ObjectOutputStream out = new ObjectOutputStream(file);

	        for (Object o : arr){
	        	out.writeObject(o);
	        }

	        out.close(); 
	        file.close();

        }
        catch(IOException ex) { 
            System.out.println("IOException is caught"); 
        }
	}

	
	/**
	 * 
	 * @param filename parameter
	 * @param obj parameter of object to write to start of file
	 */
	static void writeFirstToFile(String filename, Object obj){
		try
        {  
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(currentDir + filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(obj); 
              
            out.close(); 
            file.close(); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
	}

	/**
	 * 
	 * @param filename parameter
	 * @param obj parameter of object to write to end of file
	 */
	public static void addToFile(String filename, Object obj){
		File f = new File(filename);
		boolean empty = !f.exists() || f.length() == 0;
		if (empty){
			writeFirstToFile(filename, obj);
			return;
		}

		try
	    {  
	        //Saving of object in a file 
	        FileOutputStream file = new FileOutputStream(currentDir + filename, true); 
	        ObjectOutputStream out = new ObjectOutputStream(file) {
	            protected void writeStreamHeader() throws IOException {
	                reset();
	            }
	        }; 
	          
	        // Method for serialization of object 
	        out.writeObject(obj); 
	          
	        out.close(); 
	        file.close();  

	    } 
	      
	    catch(IOException ex) 
	    { 
	        System.out.println("IOException is caught"); 
	    } 
	}

}

