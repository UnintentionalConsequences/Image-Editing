import java.awt.image.BufferedImage;
import java.util.EmptyStackException;

public class BufferedImageStack {
	
	private BufferedImage[] arrayImage;
	private int size = 2;
	
	public BufferedImageStack() {
		arrayImage = new BufferedImage[2];
	}
	
	public void push(BufferedImage someBufferedImage) {
		for(int i = 0; i<arrayImage.length; i++) {
			if(arrayImage[i] == null) {
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
		
		size++;
		System.out.println(size);
	}
	
	public BufferedImage pop() {
		System.out.println(size);
		BufferedImage temp = arrayImage[getSize()-1];
		arrayImage[getSize()-1] = null;
		size--;
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
