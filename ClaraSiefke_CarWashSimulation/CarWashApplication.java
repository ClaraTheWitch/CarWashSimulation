//Import modules
import java.util.ArrayList;

/**
 * This is the main class for the program.
 *
 * @author Clara Siefke
 * @version 11/15/24
 */
public class CarWashApplication
    {
    //Method variables
    private static LLQueue<Car> washLine; //ArrayList of newly arrived Car objects
    private static Car removedCar; //variable to hold a dequeued car
    private static Bay washBay; //object for the bay area
    private static ArrayList<Car> servicedCars; //list of cars that have been serviced
    private static CarWashSimulation simulator; //object to simulate the timesteps
    private static int longWaitCount; //variable to count cars with wait times of 10 minutes or more
    
    /**
     * The main method for the program
     * 
     */
    public static void main (String[] args)
        {
        //Initialize variable to hold number of time steps
        int timeSteps = 600;
        
        //Simulate the 7 days for a 4 minute bay
        for(int i = 0; i < 7; i++)
            {
            System.out.println("*****Results for Day " + i + 
            " with 4 minute Bay*****");
            
            CarWashApplication.simulateDay(timeSteps, 4);
            
            System.out.println("\n");
            }
        
        //Simulate the 7 days for a 3 minute bay
        for(int i = 0; i < 7; i++)
            {
            System.out.println("*****Results for Day " + i + 
            " with 3 minute Bay*****");
            
            CarWashApplication.simulateDay(timeSteps, 3);
            
            System.out.println("\n");
            }
        
        }
    
    /**
     * Simulates an entire day at the car wash
     * 
     * @param  steps  the number of timesteps in a day
     * @param  wait  how long it takes for a car to pass through the bay
     */
    public static void simulateDay(int steps, int wait)
        {
        
        //Initialize an ArrayList of newly arrived Car objects
        washLine = new LLQueue<Car>();
        
        //Initialize an object for the bay area
        washBay = new Bay(wait);
        
        //Initialize list of cars that have been serviced
        servicedCars = new ArrayList<Car>();
        
        //Initialize the simulator
        simulator = new CarWashSimulation(washLine, washBay, servicedCars);
        
        //Initialize variable to count cars with wait times of 10 minutes or more
        longWaitCount = 0;
        
        //Run through the time steps
        for(int i = 0; i < steps; i++)
            {
            //Run one minute
            simulator.step(i);
            }
        
        //Run through the remaining cars in the queue
        for(int i = steps; !washLine.isEmpty(); i++)
            {
            simulator.step(i, false);
            }
        
        //Show all the cars in the queue and their arrival times
        //Wash all remaining cars
        //System.out.println("Cars in queue:");
        for(int i = 0; i < washLine.getSize(); i++)
            {
            
            removedCar = washLine.dequeue();
            // System.out.println("Car arrived at time step " + 
            // removedCar.getArrival());
            washLine.enqueue(removedCar);
            
            }
        
        //Show all the serviced cars with their arrival times and wait times
        //System.out.println("Cars that have been serviced:");
        for(int i = 0; i < servicedCars.size(); i++)
            {
            
            // System.out.println("Car " + i + " arrived at minute " + 
            // servicedCars.get(i).getArrival() + " and waited " + 
            // servicedCars.get(i).getWait() + " minutes.");
            
            if(servicedCars.get(i).getWait() >= 10)
                {
                
                longWaitCount++;
                
                }
            
            }
        
        //Display stats
        System.out.println("Total Cars Serviced: " + 
        simulator.getNumServiced());
        System.out.println("Total Wait: " + simulator.getTotalWait());
        System.out.println("Average Wait: " + simulator.getAvgWait());
        System.out.println(longWaitCount + " cars waited 10 minutes or more.");
        
        }
    
    }
