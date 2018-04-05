package edu.wmich.cs1120.la6.stevenhawes;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class QStack<T> {
	private Queue<T> queue1;
	private Queue<T> queue2;
	private int size;

	/**
	 * No-arg constructor to initialize members
	 */
	public QStack() {
		queue1 = new LinkedList<T>();
		queue2 = new LinkedList<T>();
		size = 0;
	}

	/**
	 * Add data to the stack.
	 * 
	 * @param data   The data to add to the stack.
	 * @return The data added to the stack (for simpler print statements)
	 */
	public T push(T data) {
		queue1.add(data);
		size++;
		return data;
	}

	/**
	 * Pop data off the top of the stack
	 * 
	 * @return The popped data
	 */
	public T pop() {
		if(getSize() == 0) {
			throw new EmptyStackException();
		}
		while(queue1.size() > 1) {
			T temp = queue1.poll();
			queue2.add(temp);
		}
		T lastTemp = queue1.poll();
		
		queue1 = queue2;
		
		Queue<T> temp = new LinkedList<T>();
		queue2 = temp;
		
		size--;
		
		return lastTemp;
	}

    /**
     * Return the size of the stack (number of elements stored in it)
     * @return  The size of the stack
     */
    public int getSize() {
    	return size;
    }
}

