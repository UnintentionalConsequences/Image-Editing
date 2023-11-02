import java.awt.image.BufferedImage;
import java.util.EmptyStackException;

public class BufferedImageStack {
	
	private BufferedImage[] arrayImage;
	private int size = 0;
	
	public BufferedImageStack() {
		arrayImage = new BufferedImage[2];
	}
	
	public void push(BufferedImage someBufferedImage) {
		size++;
		
		for(int i = 0; i<arrayImage.length; i++) {
			Object check = arrayImage[i];
			if(!(check instanceof BufferedImage)) {
				arrayImage[i] = someBufferedImage;
				return;
			}
		}
		
		BufferedImage[] arrayImage2 = new BufferedImage[arrayImage.length*2];
		
		for(int i = 0; i<arrayImage.length; i++) {
			arrayImage2[i] = arrayImage[i];
		}
		
		arrayImage2[arrayImage.length] = someBufferedImage;
		arrayImage = arrayImage2;
	}
	
	public BufferedImage pop() {
		size--;
		BufferedImage temp = arrayImage[size];
		arrayImage[size] = null;
		return temp;
	}
	
	public boolean isEmpty() {
		return (size==0);
	}
	

	public BufferedImage get(int index) {
		if(index >= arrayImage.length || index <= -1) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		} else {
			return arrayImage[index];
		}
	}
	
	
	
	public int getSize() {
		return size;
	}
	
	public int getArraySize() {
		return arrayImage.length;
	}

}
