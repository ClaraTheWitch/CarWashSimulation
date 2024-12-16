//Import modules
import java.util.Random;
import java.util.ArrayList;

/**
 * This class contains a constructor and methods for a simulation object that 
 * can run each step of the program.
 *
 * @author Clara Siefke
 * @version 11/15/24
 */
public class CarWashSimulation
    {
    // instance variables
    private LLQueue<Car> washLine; //List of cars in line waiting to be washed
    private Bay washBay; //An object representing the bay where a car is washed
    private ArrayList<Car> servicedCars; //List of cars that have been washed
    
    //Other variables
    private Random randNumGen = new Random(); //random number generator
    private int servicedCount = 0; //counts the number of serviced cars
    private int totalWait = 0; //counts the total time cars waited
    
    /**
     * Constructor for objects of class CarWashSimulation
     * 
     * @param  q  the queue of the cars waiting
     * @param  b  the bay where the cars are washed
     * @param  s  the list of serviced cars
     */
    public CarWashSimulation(LLQueue<Car> q, Bay b, ArrayList<Car> s)
        {
        // initialise instance variables
        this.washLine = q;
        this.washBay = b;
        this.servicedCars = s;
        }
    
    /**
     * Runs a single minute of the simulation
     * 
     * @param  min  the current time step
     */
    public void step(int min)
        {
        
        //Randomly determine whether a car arrives
        if(randNumGen.nextInt(4) == 0)
                {
            if(!washLine.isEmpty() && washBay.getTimeLeft() == 0)
                {
                
                //Adds the newly arrived car to the queue
                washLine.enqueue(new Car(min, 
                washLine.getSize()*washBay.getWashLength()));
                
                //Add the car entering the bay to the list of serviced cars
                servicedCars.add(washLine.dequeue());
                
                //Add the new car's wait to the total time waited by all cars
                totalWait += washLine.getSize()*washBay.getWashLength();
                
                //Enter the next car into the bay
                washBay.loadBay();
                
                //Incriment the count of cars serviced
                servicedCount++;
                
                //Display the current status
                // System.out.println("time step " + min + 
                // ": A car arrived. Bay available in " + 
                // washBay.getTimeLeft() + " minutes.");
                    
                }
            else
                {
                
                //Adds the newly arrived car to the queue
                washLine.enqueue(new Car(min, washBay.getTimeLeft() + 
                washLine.getSize()*washBay.getWashLength()));
                
                //Add the new car's wait to the total time waited by all cars
                totalWait += washBay.getTimeLeft() + 
                washLine.getSize()*washBay.getWashLength();
                
                //lower the current wait to enter to the bay
                washBay.advanceTime();
                
                //Display the current status
                // System.out.println("time step " + min + 
                // ": A car arrived. Bay available in " + 
                // washBay.getTimeLeft() + " minutes.");
                    
                }
            }
        else
            {
            if(!washLine.isEmpty() && washBay.getTimeLeft() == 0)
                {
                
                //Add the car entering the bay to the list of serviced cars
                servicedCars.add(washLine.dequeue());
                
                //Enter the next car into the bay
                washBay.loadBay();
                
                //Incriment the count of cars serviced
                servicedCount++;
                
                //Display the current status
                // System.out.println("time step " + min + 
                // ": No car arrived. Bay available in " + 
                // washBay.getTimeLeft() + " minutes.");
                    
                }
            else
                {
                
                //lower the current wait to enter to the bay
                washBay.advanceTime();
                
                //Display the current status
                // System.out.println("time step " + min + 
                // ": No car arrived. Bay available in " + 
                // washBay.getTimeLeft() + " minutes.");
                    
                }
            }
        }
    
    /**
     * Runs a single minute of the simulation
     * 
     * @param  min  the current time step
     * @param  carArrives  whether a car arrived at the car wash
     */
    public void step(int min, boolean carArrives)
        {
        
        //Check whether a car arrived
        if(carArrives == true)
                {
            if(!washLine.isEmpty() && washBay.getTimeLeft() == 0)
                {
                
                //Adds the newly arrived car to the queue
                washLine.enqueue(new Car(min, 
                washLine.getSize()*washBay.getWashLength()));
                
                //Add the car entering the bay to the list of serviced cars
                servicedCars.add(washLine.dequeue());
                
                //Add the new car's wait to the total time waited by all cars
                totalWait += washLine.getSize()*washBay.getWashLength();
                
                //Enter the next car into the bay
                washBay.loadBay();
                
                //Incriment the count of cars serviced
                servicedCount++;
                
                //Display the current status
                // System.out.println("time step " + min + 
                // ": A car arrived. Bay available in " + 
                // washBay.getTimeLeft() + " minutes.");
                    
                }
            else
                {
                
                //Adds the newly arrived car to the queue
                washLine.enqueue(new Car(min, washBay.getTimeLeft() + 
                washLine.getSize()*washBay.getWashLength()));
                
                //Add the new car's wait to the total time waited by all cars
                totalWait += washBay.getTimeLeft() + 
                washLine.getSize()*washBay.getWashLength();

                //lower the current wait to enter to the bay
                washBay.advanceTime();
                
                //Display the current status
                // System.out.println("time step " + min + 
                // ": A car arrived. Bay available in " + 
                // washBay.getTimeLeft() + " minutes.");
                    
                }
            }
        else
            {
            if(!washLine.isEmpty() && washBay.getTimeLeft() == 0)
                {
                
                //Add the car entering the bay to the list of serviced cars
                servicedCars.add(washLine.dequeue());
                
                //Enter the next car into the bay
                washBay.loadBay();
                
                //Incriment the count of cars serviced
                servicedCount++;
                
                //Display the current status
                // System.out.println("time step " + min + 
                // ": No car arrived. Bay available in " + 
                // washBay.getTimeLeft() + " minutes.");
                    
                }
            else
                {
                
                //lower the current wait to enter to the bay
                washBay.advanceTime();
                
                //Display the current status
                // System.out.println("time step " + min + 
                // ": No car arrived. Bay available in " + 
                // washBay.getTimeLeft() + " minutes.");
                    
                }
            }
        
        }    
    
    /**
     * Gets the total number of cars serviced
     * 
     * @return  the number of cars serviced
     */
    public int getNumServiced()
        {
        
        return servicedCount;
        
        }
    
    /**
     * Gets the total time all cars waited
     * 
     * @return  the total time all cars waited
     */
    public int getTotalWait()
        {
        
        return totalWait;
        
        }
    
    /**
     * Gets the average wait for each car
     * 
     * @return  the average wait for each car
     */
    public int getAvgWait()
        {
        
        return totalWait/servicedCount;
        
        }
    
    }
