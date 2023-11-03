/* 
 * Names: Chris Mathews & Henry Zhang
 * Period: 4th
 * Date: 11/3/2023
 * Purpose: To create a system of undo and redo for an image editing program and to learn about stacks
*/

import java.awt.image.BufferedImage;
import java.util.EmptyStackException;

public class BufferedImageStack {
	
	// Creating Instance Variables
	private BufferedImage[] arrayImage; // used as a stack of images
	private int size = 0; // number of elements that are images
	
	public BufferedImageStack() {
		arrayImage = new BufferedImage[2];
	}
	
	public void push(BufferedImage someBufferedImage) {
		size++; // since we're adding an image, we're increasing the size
		
		// going through the loop and checking to see if there is a null spot
		for(int i = 0; i<arrayImage.length; i++) {
			Object check = arrayImage[i];
			if(!(check instanceof BufferedImage)) {
				arrayImage[i] = someBufferedImage;
				return;
			}
		}
		
		// if there aren't any null spots, then the array is doubled			
		BufferedImage[] arrayImage2 = new BufferedImage[arrayImage.length*2];
		
		// going through the new loop and adding the original images
		for(int i = 0; i<arrayImage.length; i++) {
			arrayImage2[i] = arrayImage[i];
		}
		
		// adding the new image into the new array
		arrayImage2[arrayImage.length] = someBufferedImage;
		arrayImage = arrayImage2; // setting the new array(double size) as the image stack
	}
	
	public BufferedImage pop() {
		size--; // decreasing by 1, because one of the images is pop (deleted) from the stack
		BufferedImage temp = arrayImage[size]; // storing the removed image
		arrayImage[size] = null; // setting the location to be null
		return temp; // returns the removed image
	}
	
	public boolean isEmpty() {
		return (size==0); //checking if there are any images
	}
	

	public BufferedImage get(int index) {
		if(index >= arrayImage.length || index <= -1) {
			throw new IndexOutOfBoundsException("Index is out of bounds"); //throwing an exception if the index is out of bounds
		} else {
			return arrayImage[index]; // returns the index
		}
	}
		
	public int getSize() {
		return size; // returns the number of images
	}
	
	public int getArraySize() {
		return arrayImage.length; // returns the length of the array stack
	}

}
