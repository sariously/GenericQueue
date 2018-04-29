/*
 * Sara Kazemi
 * 4/29/18
 * Generic Queue uses an ArrayList to queue and dequeue generic elements according to FIFO
 */
package edu.gcccd.csis;
import java.util.ArrayList;

public class GenericQueue<T>
{
    private final ArrayList<T> elements; // Stores elements in the Queue

    // default constructor if no capacity is given
    public GenericQueue()
    {
        this(10); // default capacity
    }

    // one-arg constructor specifying capacity
    public GenericQueue(int capacity)
    {
        int initCapacity = capacity > 0 ? capacity : 10;    // validate that capacity parameter is greater than 0,
                                                            // if not, set to 10
        elements = new ArrayList<T>(initCapacity);          // create an ArrayList with capacity specified
    }

    /*
     * New elements get added to the end of the Queue
     */
    public void enqueue(T queueValue)
    {
        elements.add(queueValue);
    }

    /*
     * Elements at the front of the queue get deque'd first
     */
    public T dequeue()
    {
        if(elements.isEmpty())
        {
            throw new java.util.NoSuchElementException("Queue is empty.");
        }
        return elements.remove(0); // Remove first element -- FIFO
    }

    // current length of the queue
    public int length()
    {
        return elements.size();

    }

    @Override
    public String toString()
    {
        String result = "";
        for (T element : elements)
        {
            result += element + " ";
        }
        return result;
    }
}