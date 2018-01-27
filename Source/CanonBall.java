package items;

import frames.Sprite;

public class CanonBall extends Sprite {

    private final int CANON_SPEED = 8;

    public CanonBall(int x, int y) {
        super(x, y);

        initCanon();
    }
    
    private void initCanon() {
        
        loadImage("canon.png");
        getImageDimensions();        
    }

    public void movecanon() {
        
        x -= CANON_SPEED;
        
    }
}