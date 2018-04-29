package edu.gcccd.csis;


import org.junit.*;
import static org.junit.Assert.*;

public class GenericQueueTest
{
    private GenericQueue<Integer> integerQueue;
    private GenericQueue<Double> doubleQueue;
    private int capacity;

    // runs before each testMethod
    @Before
    public void setUp() throws Exception {
        System.out.println("Setting up...");
        /*
         * Set up a Queue of Integers
         */
        capacity = 100;
        integerQueue = new GenericQueue<>(capacity);
        for(int index = 1; index <= capacity; index++) {
            integerQueue.enqueue(index); // fill Queue with Integers 1-100
        }

        /*
         * Set up a queue of Doubles
         */
        doubleQueue = new GenericQueue<>(10);
        doubleQueue.enqueue(-99.9);

        System.out.print("integerQueue: ");
        System.out.println(integerQueue);
        System.out.print("doubleQueue: ");
        System.out.println(doubleQueue);
        System.out.println("Done setting up.");
        System.out.println("-------------------");
        System.out.println();
    }


    @Test
    public void dequeue() throws Exception {
        System.out.println("TEST DEQUEUE");
        // dequeue first element and test length()
        integerQueue.dequeue();
        assertEquals(integerQueue.length(), 99);

        /*
         * Remove all elements except the last three (should be 99, 98, and 100)
         */
        capacity = integerQueue.length();
        for (int index = capacity; index > 3; index--) {
            integerQueue.dequeue();
        }
        capacity = integerQueue.length();

        assertEquals(integerQueue.toString(), "98 99 100 ");
        System.out.print("integerQueue after dequeing all elements but last three: ");
        System.out.println(integerQueue);


        /*
         * Remove the rest of the elements and then try to dequeue empty Queue
         * Should throw an exception
         */
        capacity = integerQueue.length();
        for (int index = 0; index < capacity; index++) {
            integerQueue.dequeue();  // remove the rest
        }
        capacity = integerQueue.length();

        boolean thrown = false;
        try {
            integerQueue.dequeue();
            fail();
        }
        catch(java.util.NoSuchElementException e){
            thrown = true;
        }

        assertTrue(thrown);

        System.out.print("integerQueue after dequeing all elements: ");
        System.out.println(integerQueue);
        System.out.println("Done testing Dequeue()");
        System.out.println("-------------------");
        System.out.println();
    }

    @Test
    public void enqueue() throws Exception {

        System.out.println("TEST ENQUEUE");
        doubleQueue.enqueue(6.5); // should be placed at end of Queue
        assertEquals(doubleQueue.length(), 2);


        assertEquals(doubleQueue.toString(), "-99.9 6.5 ");

        System.out.print("doubleQueue after queueing value 6.5: ");
        System.out.println(doubleQueue);
        System.out.println("Done testing Enqueue()");
        System.out.println("-------------------");
        System.out.println();
    }


}


