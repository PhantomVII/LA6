/*
 * Author: Steven Hawes
 * Class: CS1120
 * Project: LA6
 * Description: To learn and develop skills relating to past knowledge and 
 * data storage types
 */
package edu.wmich.cs1120.la6.stevenhawes;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinValueStack<T extends Comparable<T>> {

    private Stack<T> stack1;
    private Stack<T> stack2;
    private int size;

    /**
     * A no-arg constructor to initialize class members.
     */
    public MinValueStack(){
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
        size = 0;
    }

    /**
     * Method to push data onto the stack. This method specifically
     * keeps the stack in ascending order: the smallest (minimum value) is stored
     * at the top of the stack so it is the next element to be popped off the stack. 
     * 
     * @param data The data (element) to be added to the stack.
     * @return The data added to the stack
     */
    public T push(T data){
    	// Checks to see if stack1 is empty and then pushes the data
    	if(stack1.isEmpty()) {
    		stack1.push(data);
    		size++;
    		return data;
    	}
    	try {
    		// compares the data of stack1 then pushes to stack2 if greater than that in stack1
    		while(data.compareTo(stack1.peek()) > 0) {
    		stack2.push(stack1.pop());
    		}
    	}
    	catch(EmptyStackException e) {
    		// Prevents program failure
    	}
    	// Pushes the data to stack2
    	stack2.push(data);
    	
    	// Takes the data from stack1 and stack2
    	while(stack1.isEmpty() == false) {
    		stack2.push(stack1.pop());
    	}
    	while(stack2.isEmpty() == false) {
    		stack1.push(stack2.pop());
    	}
    	// Increases the size
    	size++;
    	// Returns the data that was pushed
    	return data;
    }

    /**
     * Method to return the minimum value on the stack, but not remove it.
     * @return The minimum value stored in the stack.
     */
    public T minValue(){
    	// Checks to see if the stack is empty and then throw an exception
    	if(isEmpty()) {
    		throw new EmptyStackException();
    	}
    	// Returns the min value of the ordered stack
    	return stack1.peek();
    }

    /**
     * Method to pop the minimum value off the stack
     * @return The popped data.
     */
    public T pop(){ 
    	// Checks to see if the stack is empty and then throw an exception
    	if (isEmpty()) {
    		throw new EmptyStackException();
    	}
    	// Decreases the size
    	size--;
    	return stack1.pop();
    }

    /**
     * Method to return if the stack is empty or not.
     * @return true if stack is empty, else false.
     */
    public boolean isEmpty(){
    	// Checks to see if the stack is empty and returns true if empty
    	if(getSize() == 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    /**
     * Return the size of the stack (number of elements stored in it)
     * @return  The size of the stack
     */
    public int getSize() {
    	return size;
    }


}

