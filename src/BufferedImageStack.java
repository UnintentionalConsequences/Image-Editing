import java.awt.image.BufferedImage;

public class BufferedImageStack {
	
	private BufferedImage[] arrayImage;
	
	public BufferedImageStack() {
		arrayImage = new BufferedImage[2];
	}
	
	public BufferedImage get(int index) {
		if(index >= arrayImage.length || index <= -1) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		} else {
			return arrayImage[index];
		}
	}
	
	public int getSize() {
		int cnt = 0;
		for(int i=0; i<arrayImage.length; i++) {
			if(arrayImage[i] != null) cnt++;
		}
		return cnt;
	}
	
	public int getArraySize() {
		return arrayImage.length;
	}
}
