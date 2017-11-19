package space;
public class Gifts extends Sprite {

    private final int INITIAL_Y = 1200;

    public Gifts(int x, int y) {
        super(x, y);

        initGifts();
    }

    private void initGifts() {

        loadImage("gold.png");
        getImageDimensions();
    }

    public void move() {
       
        if (y < 0) {
            y = INITIAL_Y;
        }
        
        y -= 1;
 
    }
}