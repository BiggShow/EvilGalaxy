package items;

import game_engine.SpritePattern;

public class CanonBall extends SpritePattern {

    private final int CANON_SPEED = 8;

    public CanonBall(int x, int y) {
        super(x, y);

        initCanon();
    }
    
    private void initCanon() {
        
        loadImage("images/canon.png");
        getImageDimensions();        
    }

    public void moveCanon() {
        
        x -= CANON_SPEED;
        
    }
}