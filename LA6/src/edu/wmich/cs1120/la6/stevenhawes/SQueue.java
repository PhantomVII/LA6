package edu.wmich.cs1120.la6.stevenhawes;

import java.util.EmptyStackException;
import java.util.Stack;

public class SQueue<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;
    private int size;

    /**
     * No-arg constructor to initialize members
     */
    public SQueue(){
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
        size = 0;
    }

    /**
     * Add data to the queue.
     * @param data The data to add to the queue.
     * @return The data added to the queue (for simpler print statements)
     */
    public T enqueue(T data){
    	stack1.push(data);
    	size++;
    	return stack1.peek();
    }

    /**
     * Remove the next item from the front of the queue.
     * @return The data in the front of the queue
     */
    public T dequeue(){
    	if(getSize() == 0) {
    		throw new EmptyStackException();
    	}
    	
    	if(stack2.isEmpty()) {
    		while(!stack1.isEmpty()) {
    			stack2.push(stack1.pop());
    		}
    	}
    	
    	size--;
    	return stack2.pop();
    }

    /**
     * Return the size of the queue (number of elements stored in it)
     * @return  The size of the queue
     */
    public int getSize() {
    	return size;
    }
}

