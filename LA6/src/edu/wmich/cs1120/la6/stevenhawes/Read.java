package edu.wmich.cs1120.la6.stevenhawes;

import java.io.*;
import java.util.ArrayList;

public class Read {
	
	private ArrayList <Short> store; 
	
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

			while(is.available() > 0) {
				short temp = is.readShort();
				store.add(temp);
			}
			is.close();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	} 
}

