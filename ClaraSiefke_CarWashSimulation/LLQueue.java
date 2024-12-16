//Import modules
import java.util.LinkedList;


/**
 * This class contains a constructor and methods for a Queue object which 
 * holds a list where elements are entered into the back and removed from the 
 * front.
 *
 * @author Clara Siefke with assistance from Dr. Tasnim
 * @version 10/22/24
 */
public class LLQueue<T> implements KQueue<T>
    {
    // instance variables
    private LinkedList<T> queue;
    private int size;
    
    //Other variables
    private T removedItem;
    private String queueString;

    /**
     * Constructor for objects of class LLQueue
     */
    public LLQueue()
        {
        // initialise instance variables
        this.queue = new LinkedList<T>();
        this.size = 0;
        
        }
    
    /** Returns <code>true</code> if this queue is empty;
     *  <code>false</code> otherwise.
     **/
    public boolean isEmpty()
        {
        
        return this.queue.isEmpty();
        
        }

    /** Adds a specified object to the "back" of this queue.
     *    @param item - the object to add to the queue
     **/
    public void enqueue(T item)
        {
        
        this.queue.addFirst(item);
        this.size++;
        
        }

    /** Removes the element at the "front" of this queue and returns it.
     * 
     * @returns the removed element
     * @throws NoSuchElementException if the queue is empty
     **/
    public T dequeue()
        {
        
        this.size--;
        return this.queue.pollLast();
        
        }

    /** Returns the element at the "front" of this queue, without
     *  modifying the queue.
     *    @returns the element at the front of the queue
     *    @throws NoSuchElementException if the queue is empty
     **/
    public T peekFront()
        {
        
        return this.queue.peekLast();
        
        }
    
    /**
     * Gets the size of the queue
     * 
     */
    public int getSize()
        {
        
        return this.size;
        
        }
    
    /**
     * Returns information about the queue in the form of a string
     * 
     */
    public String toString()
        {
        
        //Add initial formatting to the string
        queueString = "Queue Contents: ";
        
        for(int i = 0; i < this.size; i++)
            {
            
            removedItem = this.dequeue();
            queueString += "[" + removedItem + "]";
            this.enqueue(removedItem);
            
            }
        
        
        return queueString;
        
        }
    }
