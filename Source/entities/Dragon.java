package entities;

import frames.SpritePattern;

public class Dragon extends SpritePattern {

    private final int INITIAL_X = 600;

    public Dragon(int x, int y) {
        super(x, y);

        initBoss();
    }

    private void initBoss() {

        loadImage("images/boss.png");
        getImageDimensions();
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }
        
        x -= 3;
       
    }
}