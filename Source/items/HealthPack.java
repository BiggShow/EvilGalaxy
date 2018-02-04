package items;

import frames.SpritePattern;

public class HealthPack extends SpritePattern {

    private final int INITIAL_Y = 0;

    public HealthPack(int x, int y) {
        super(x, y);

        initHealth();
    }

    private void initHealth() {

        loadImage("images/health.png");
        getImageDimensions();
    }

    public void move() {

   
        if (y > 1200) {
            y = INITIAL_Y;
        }
        
        y += 5;
 
    }
}