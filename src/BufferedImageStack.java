import java.awt.image.BufferedImage;
import java.util.EmptyStackException;

public class BufferedImageStack {
	
	private BufferedImage[] arrayImage;
	
	public BufferedImageStack() {
		arrayImage = new BufferedImage[2];
	}
	
	public void push(BufferedImage someBufferedImage) {
		for(int i = 0; i<arrayImage.length; i++) {
			if(arrayImage[i]==null) {
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
		if(arrayImage[0]==null) {
			throw new EmptyStackException();
		}
		for(int i = arrayImage.length-1; i>=0; i++) {
			if(arrayImage[i]!=null) {
				BufferedImage temp = arrayImage[i];
				arrayImage[i] = null;
				return temp;
			}
		}
		return null;
	}
	
	public boolean isEmpty() {
		return arrayImage[0]==null;
	}
	
}
