package items;

import frames.Sprite;

public class LifePack extends Sprite {

    private final int INITIAL_X = 600;
    private final int INITIAL_Y = 600;

    public LifePack(int x, int y) {
        super(x, y);

        initLifePack();
    }

    private void initLifePack() {

        loadImage("lifebar.png");
        getImageDimensions();
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }
        
        if (y < 0) {
            y = INITIAL_Y;
        }
        
        x -= 1;
        y -= 1;
 
    }
}