
/**
 * This is a class to create an object representing the bay area where the 
 * washing will occur.
 *
 * @author Clara Siefke
 * @version 10/23/24
 */
public class Bay
    {
    // instance variables
    private int duration; //holds how long a wash will take
    private int timeLeft; //holds how much time is left for a wash

    /**
     * Constructor for objects of class Bay
     * 
     * @param  washLength  the time a single wash takes
     */
    public Bay(int washLength)
        {
        // initialise instance variables
        this.duration = washLength;
        this.timeLeft = 0;
        }
    
    /**
     * Gets the number of time steps remaining for a wash
     * 
     */
    public int getTimeLeft()
        {
        
        return this.timeLeft;
        
        }
    
    /**
     * Gets the time a typical wash takes
     * 
     * @return  the time a typical wash takes
     */
    public int getWashLength()
        {
        
        return this.duration;
        
        }
        
    /**
     * Lowers the length of the wash by 1
     * 
     */
    public void advanceTime()
        {
        if(this.timeLeft > 0)
            {
            
            this.timeLeft--;
            
            }
        else
            {
            
            this.timeLeft = 0;
            
            }
        
        }
    
    /**
     * Sets the time remaining to the duration
     * 
     */
    public void loadBay()
        {
        
        this.timeLeft = this.duration;
        
        }
    }
