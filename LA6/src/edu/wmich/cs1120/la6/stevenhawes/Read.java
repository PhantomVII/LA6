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

public class Read {
	
	private ArrayList <Short> store; 
	
	/**
	 * Is the read constructor
	 * @param store ArrayList from main
	 */
	public Read(ArrayList<Short> store) {
		this.store = store;
	}
	
	/**
	 * read the data and save them into an ArrayList.
	 * @param filename
	 */
	public void readFileInputStream(String filename) {
		try (InputStream inputStream = new FileInputStream(filename);) {

			DataInputStream is = new DataInputStream(new BufferedInputStream(inputStream));
			
			// loops while the steam is available
			while(is.available() > 0) {
				short temp = is.readShort();
				store.add(temp);
			}
			//Closes the stream
			is.close();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	} 
}

