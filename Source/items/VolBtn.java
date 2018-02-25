package items;
import java.awt.event.KeyEvent;

import frames.SpritePattern;

public class VolBtn extends SpritePattern {
	
	public VolBtn(int x, int y) {
        super(x, y);

        initVol();
    }
	
	private void initVol() {
        
        loadImage("images/volbutt.png");
        getImageDimensions();
    }
	
	private void initMute() {
        
        loadImage("images/mute.png");
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
