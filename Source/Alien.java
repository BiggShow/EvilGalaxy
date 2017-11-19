package space;

import java.util.ArrayList;

public class Alien extends Sprite {

    private final int INITIAL_X = 1024;
    private final int INITIAL_Y = 0;
    private ArrayList<Missile> lasers;

    public Alien(int x, int y) {
        super(x, y);

        initAlien();
        initAmmo();
    }
    
    private void initAmmo(){
    	
    	lasers = new ArrayList<>();
        
    }

    private void initAlien() {

        loadImage("alien.png");
        getImageDimensions();
    }
    
    @SuppressWarnings("rawtypes")
	public ArrayList getLasers() {
        return lasers;
    }
    
    public void fire() {
        lasers.add(new Missile(x + width, y + height / 2));
        //new AePlayWave("laser.wav").start();
    }
    

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }
        
        if (y > 1200) {
            y = INITIAL_Y;
        }
        
        x -= 2;
        y += 2;
 
    }
    
    public void movefaster() {

        if (x < 0) {
            x = INITIAL_X;
        }
        
        if (y < 0) {
            y = INITIAL_Y;
        }
        
        x -= 1.2;
        y -= 1.2;
 
    }
}