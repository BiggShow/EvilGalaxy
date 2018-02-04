package items;

import frames.SpritePattern;

public class Gold extends SpritePattern {

    private final int INITIAL_Y = 1200;

    public Gold(int x, int y) {
        super(x, y);

        initGifts();
    }

    private void initGifts() {

        loadImage("images/gold.png");
        getImageDimensions();
    }

    public void move() {
       
        if (y < 0) {
            y = INITIAL_Y;
        }
        
        y -= 1;
 
    }
}