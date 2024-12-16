
/**
 * This class contains a constructor and methods for a Car object which 
 * represents a car going through the car wash.
 *
 * @author Clara Siefke
 * @version 10/23/24
 */
public class Car
    {
    // instance variables
    private int arrival; //tracks the time step when the car arrived
    private int timeWaited; //the time that the car will wait upon entering the line

    /**
     * Constructor for objects of class Car
     * 
     * @param  time  the time step at which the car arrived
     * @param  wait  the time which the car will wait
     */
    public Car(int time, int wait)
        {
        // initialise instance variables
        this.arrival = time;
        this.timeWaited = wait;
        }
    
    /**
     * Gets the time step at which the car arrived
     * 
     * @return  the time the car arrived
     */
    public int getArrival()
        {
        
        return this.arrival;
        
        }
    
    /**
     * Gets the time that the car waited
     * 
     * @return  the time the car waited
     */
    public int getWait()
        {
        
        return this.timeWaited;
        
        }
    
    }
