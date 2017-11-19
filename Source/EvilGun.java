package space;

public class EvilGun extends Sprite {

    private final int EVILGUN_SPEED = 9;

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
}