package space;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Craft extends Sprite {

	    private double dx;
	    private double dy;
	    private ArrayList<Missile> missiles;
	    private ArrayList<Rocket> rockets;
	    private ArrayList<CanonBall> canons;

	    public Craft(int x, int y) {
	        super(x, y);

	        initCraft();
	        initAmmo();
	    }

	    private void initCraft() {
	        
	        loadImage("craft.png");
	        getImageDimensions();
	    }
	    
	    private void initAmmo(){
	    	
	    	missiles = new ArrayList<>();
	        rockets = new ArrayList<>();
	        canons = new ArrayList<>(); 
	        
	    }
	    
	    private void initFuel() {
	        
	        loadImage("newship.png");
	        getImageDimensions();
	    }
	    
	   
	    void shakeCraft() {
	        
	        loadImage("alien.gif");
	        getImageDimensions();
	    }

	    void godMode() {
	        
	        loadImage("alien2.gif");
	        getImageDimensions();
	    }
	    
	    
	    void escapeForbidden() {
	        
	        loadImage("alien3.gif");
	        getImageDimensions();
	    }
	    
	    void hitCraft() {
	        
	        loadImage("hitcraft.gif");
	        getImageDimensions();
	    }
	    
	    public void dragonShake() {
	    	
	    	x += dx;
	        y += dy;

	        if (x < 1) {
	            x = 1;
	            
	        }
	        
	        if (y < 1) {
	            y = 1;
	        }
	        
	        x -= 1;
	        
	        
	        if(x < 100){
	        	dx += 0.3;
	        	
	        }
	        
	        y-= 1;
	        if(y == 0){
	        	x += 0.3;
	        	
        	}
	        
	        if(x > 200){
	        	
	        	dx-= 0.3;
	        	dy+= 0.3;   
	        	
	        }
	        
	        if(y > 50){
	        	dy-=0.3;
        	}
	        
	    }

	    public void move() {

	        x += dx;
	        y += dy;

	        if (x < 1) {
	            x = 1;
	            escapeForbidden();
	        }

	        else if (x > 900) {
	            x = 900;
	            escapeForbidden();
	        }
	        
	        if (y < 0) {
	            y = 0;
	            escapeForbidden();
	        }
	        
	        else if(y > 700){
	        	
	        	y = 700;
	        	escapeForbidden();
	        }
	    }

	    @SuppressWarnings("rawtypes")
		public ArrayList getMissiles() {
	        return missiles;
	    }
	    
	    @SuppressWarnings("rawtypes")
		public ArrayList getRockets() {
	        return rockets;
	    }
	    
	    @SuppressWarnings("rawtypes")
		public ArrayList getCanon() {
	        return canons;
	    }
	    

	    public void keyPressed(KeyEvent e) {

	        int key = e.getKeyCode();

	        /*if (key == KeyEvent.VK_SPACE) {
	            fire();
	        }*/
	        
	        	       
	        if (key == KeyEvent.VK_LEFT) {
	            dx = -5.5;
	            initFuel();
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	            dx = 5.5;
	            initFuel();
	        }

	        if (key == KeyEvent.VK_UP) {
	            dy = -5.5;
	            initFuel();
	        }

	        if (key == KeyEvent.VK_DOWN) {
	            dy = 5.5;
	            initFuel();
	        }
	    }

	    public void fire() {
	        missiles.add(new Missile(x + width, y + height / 2));
	        new AePlayWave("laser.wav").start();
	    }
	    
	    public void spechit() {
	    	rockets.add(new Rocket(x + width, y + height / 2));
	        new AePlayWave("rocket.wav").start();
	    }
	    
	   
	    public void gunempty() {
	        new AePlayWave("denied.wav").start();
	    }
	    
	    public void keyReleased(KeyEvent e) {

	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT) {
	            dx = 0;
	            initCraft();
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	            dx = 0;
	            initCraft();
	        }

	        if (key == KeyEvent.VK_UP) {
	            dy = 0;
	            initCraft();
	        }

	        if (key == KeyEvent.VK_DOWN) {
	            dy = 0;
	            initCraft();
	        }
	        
	    }
}