package space;
import java.awt.event.KeyEvent;

public class VolButt extends Sprite {
	
	public VolButt(int x, int y) {
        super(x, y);

        initVol();
    }
	
	private void initVol() {
        
        loadImage("volbutt.png");
        getImageDimensions();
    }
	
	private void initMute() {
        
        loadImage("mute.png");
        getImageDimensions();
    }
	
	public void keyPressed(KeyEvent e) {
	
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_S) {
			initMute();
        }
		
		if (key == KeyEvent.VK_A) {
			initVol();
        }
			
	}
		
}
