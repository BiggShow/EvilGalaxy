package space;

public class Health extends Sprite {

    private final int INITIAL_Y = 0;

    public Health(int x, int y) {
        super(x, y);

        initHealth();
    }

    private void initHealth() {

        loadImage("health.png");
        getImageDimensions();
    }

    public void move() {

   
        if (y > 1200) {
            y = INITIAL_Y;
        }
        
        y += 5;
 
    }
}