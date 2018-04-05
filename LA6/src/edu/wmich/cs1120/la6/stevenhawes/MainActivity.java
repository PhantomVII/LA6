/*
 * Author: Steven Hawes
 * Class: CS1120
 * Project: LA6
 * Description: To learn and develop skills relating to past knowledge and 
 * data storage types
 */
package edu.wmich.cs1120.la6.stevenhawes;

import java.io.*;
import java.util.ArrayList;

public class MainActivity {
	/**
	 * Is the main method for the program
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		ArrayList<Short> store = new ArrayList<>();
		Read read = new Read(store);

		QStack<Short> stack = new QStack<>();
		SQueue<Short> queue = new SQueue<>();
		MinValueStack<Short> mVStack = new MinValueStack<>();

		read.readFileInputStream("TestData.dat");
		
		// Prints as well as pushes to the stack
		System.out.println("The values pushed onto the stack are:");
		for(int i = 0; i < store.size(); i++) {
			System.out.print(stack.push(store.get(i)) + " ");
			mVStack.push(store.get(i));
		}
		
		// Prints as well as pops off the stack
		System.out.println("\n\nThe values popped off the stack in order are:");
		while(stack.getSize() > 0) {
			System.out.print(stack.pop() + " ");
		}
		
		// Uses the min method to pop off the minStack and print it
		System.out.println("\n\nThe min value (from the minimum value stack) is:"+ mVStack.minValue());
		
		// Prints as well as pops off the minStack 
		System.out.println("\nThe values popped off the minimum value stack in order are:");
		while(mVStack.getSize() > 0) {
			System.out.print(mVStack.pop() + " ");
		}
		
		// Prints as well as queues from the ArrayList
		System.out.println("\n\nThe values enqueued onto the queue are:");
		for(int i = 0; i < store.size(); i++) {
			System.out.print(queue.enqueue(store.get(i)) + " ");
		}
		
		// Prints as well as dequeues from the queue in the correct order
		System.out.println("\n\nThe values dequeued from the queue in order are:");
		while(queue.getSize() > 0) {
			System.out.print(queue.dequeue() + " ");
		}
	}
}
