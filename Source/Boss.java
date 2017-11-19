package space;

public class Boss extends Sprite {

    private final int INITIAL_X = 600;

    public Boss(int x, int y) {
        super(x, y);

        initBoss();
    }

    private void initBoss() {

        loadImage("boss.png");
        getImageDimensions();
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }
        
        x -= 3;
       
    }
}