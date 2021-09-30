
import java.io.*;
import java.util.*;

/**
 * This is an entity class for all indexes
 *
 */
public class Index implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private int indexNumber;
    private String group;
    private int vacancy;
    private int total;
    private ArrayList<Integer> lessonIDs;
    private Queue<String> waitingList;

    /**
     * Constructor for class
     * @param indexNumber parameter
     * @param group parameter
     * @param vacancy parameter
     * @param total parameter
     * @param lessonIDs parameter
     * @param waitingList parameter
     */
    public Index(int indexNumber, String group, int vacancy, int total, ArrayList<Integer> lessonIDs, Queue<String> waitingList) {
        this.indexNumber = indexNumber;
        this.group = group;
        this.vacancy = vacancy;
        this.total = total;
        this.lessonIDs = lessonIDs;
        this.waitingList = waitingList;
    }

    /**
     * 
     * @return indexNumber parameter for getter function
     */
    public int getIndexNumber() {
        return indexNumber;
    }

    /**
     * 
     * @return group parameter for getter function
     */
    public String getGroup() {
        return group;
    }

    /**
     * 
     * @return vacancy parameter for getter function
     */
    public int getVacancy() {
        return vacancy;

    }

    /**
     * 
     * @return lessonIDs parameter for getter function
     */
    public ArrayList<Integer> getLessonIDs() {
        return lessonIDs;
    }

    /**
     * 
     * @return waitingList parameter for getter function
     */
    public Queue<String> getWaitingList() {
        return waitingList;
    }

    /**
     * 
     * @return total parameter for getter function
     */
    public int getTotal() {
        return total;
    }

    /**
     * 
     * @param indexNumber parameter for setter function
     */
    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    /**
     * 
     * @param group parameter for setter function
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * 
     * @param vacancy parameter for setter function
     */
    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    /**
     * 
     * @param total parameter for setter function
     */
    public void setTotal(int total){
        this.total = total;
    }

    /**
     * 
     * @param lessonIDs parameter for setter function
     */
    public void setLessonIDs(ArrayList<Integer> lessonIDs) {
        this.lessonIDs = lessonIDs;
    }

    /**
     * 
     * @param waitingList parameter for setter function
     */
    public void setWaitingList(Queue<String> waitingList) {
        this.waitingList = waitingList;
    }
}
