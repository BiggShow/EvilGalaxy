package items;

import frames.SpritePattern;

public class BalloonPoints extends SpritePattern {
	
    private final int INITIAL_Y = 1200;


	public BalloonPoints(int x, int y) {
		super(x, y);

		initPoints();
	}

	private void initPoints() {
		
		 loadImage("images/balloon.png");
	     getImageDimensions();
		
	}

	public void move() {
	       
        if (y < 0) {
            y = INITIAL_Y;
        }
        
        y -= 1;
 
    }
	
}
