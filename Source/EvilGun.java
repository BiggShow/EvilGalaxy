package items;

import frames.Sprite;

public class EvilGun extends Sprite {

    private final int EVILGUN_SPEED = 9;
    private final double EVILGUN_SPEED_2 = 2.5;

    public EvilGun(int x, int y) {
        super(x, y);

        initEvilGun();
    }
    
    private void initEvilGun() {
        
        loadImage("fireball.png");
        getImageDimensions();        
    }

    public void moveevilmis() {
        
        x -= EVILGUN_SPEED;
        
    }
    
    public void moveevildiag() {
        
    	x -= EVILGUN_SPEED;
    	y -= EVILGUN_SPEED_2;
        
    }
    
    public void moveevildiag_down() {
        
    	x -= EVILGUN_SPEED;
    	y += EVILGUN_SPEED_2;
        
    }
    
    public void moveevil_down() {
        
    	y += EVILGUN_SPEED_2;
        
    }
}