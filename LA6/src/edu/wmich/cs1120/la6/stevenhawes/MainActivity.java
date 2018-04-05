package edu.wmich.cs1120.la6.stevenhawes;

import java.io.*;
import java.util.ArrayList;

public class MainActivity {
	public static void main(String[] args) throws IOException {
		
		ArrayList<Short> store = new ArrayList<>();
		Read read = new Read(store);

		QStack<Short> stack = new QStack<>();
		SQueue<Short> queue = new SQueue<>();
		MinValueStack<Short> mVStack = new MinValueStack<>();

		read.readFileInputStream("TestData.dat");

		System.out.println("The values pushed onto the stack are:");
		for(int i = 0; i < store.size(); i++) {
			System.out.print(stack.push(store.get(i)) + " ");
			mVStack.push(store.get(i));
		}
		
		System.out.println("\n\nThe values popped off the stack in order are:");
		while(stack.getSize() > 0) {
			System.out.print(stack.pop() + " ");
		}
		
		System.out.println("\n\nThe min value (from the minimum value stack) is:"+ mVStack.minValue());
		
		System.out.println("\nThe values popped off the minimum value stack in order are:");
		while(mVStack.getSize() > 0) {
			System.out.print(mVStack.pop() + " ");
		}
		
		System.out.println("\n\nThe values enqueued onto the queue are:");
		for(int i = 0; i < store.size(); i++) {
			System.out.print(queue.enqueue(store.get(i)) + " ");
		}
		
		System.out.println("\n\nThe values dequeued from the queue in order are:");
		while(queue.getSize() > 0) {
			System.out.print(queue.dequeue() + " ");
		}
	}
}
