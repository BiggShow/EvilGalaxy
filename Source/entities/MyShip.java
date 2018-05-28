package entities;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import frames.SpritePattern;
import items.CanonBall;
import items.ShipMissile;
import items.ShipRocket;
import sound_engine.PlayWave1st;


public class MyShip extends SpritePattern {

	    public static MyShip myShip;
		double speedX;
	    double speedY;
	    private ArrayList<ShipMissile> missiles;
	    private ArrayList<ShipRocket> rockets;
	    private ArrayList<CanonBall> canons;

	    public MyShip(int x, int y) {
	        super(x, y);

	        initCraft();
	        initAmmo();
	    }

	    private void initCraft() {
	        
	        loadImage("images/craft.png");
	        getImageDimensions();
	    }
	    
	    private void initAmmo(){
	    	
	    	missiles = new ArrayList<>();
	        rockets = new ArrayList<>();
	        canons = new ArrayList<>(); 
	        
	    }
	    
	    public void initFuel() {
	        
	        loadImage("images/newship.png");
	        getImageDimensions();
	    }
	    
	   
	    public void shakeCraft() {
	        
	        loadImage("images/alien.gif");
	        getImageDimensions();
	    }

	    public void godMode() {
	        
	        loadImage("images/alien2.gif");
	        getImageDimensions();
	    }
	    
	    
	    public void escapeForbidden() {
	        
	        loadImage("images/alien3.gif");
	        getImageDimensions();
	    }
	    
	    public void hitCraft() {
	        
	        loadImage("images/hitcraft.gif");
	        getImageDimensions();
	    }
	    
	    public void dragonShake() {
	    	
	    	x += speedX;
	        y += speedY;

	        if (x < 1) {
	            x = 1;
	            
	        }
	        
	        if (y < 1) {
	            y = 1;
	        }
	        
	        x -= 1;
	        
	        
	        if(x < 100){
	        	speedX += 0.3;
	        	
	        }
	        
	        y-= 1;
	        if(y == 0){
	        	x += 0.3;
	        	
        	}
	        
	        if(x > 200){
	        	
	        	speedX-= 0.3;
	        	speedY+= 0.3;   
	        	
	        }
	        
	        if(y > 50){
	        	speedY-=0.3;
        	}
	        
	    }

	    public void move() {

	        x += speedX;
	        y += speedY;

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
	    
	    
	    public void loadMissiles() {
	        missiles.add(new ShipMissile(x + width, y + height / 2));
	        new PlayWave1st("sounds/laser.wav").start();
	    }
	    
	    public void loadRockets() {
	    	rockets.add(new ShipRocket(x + width, y + height / 2));
	        new PlayWave1st("sounds/rocket.wav").start();
	    }
	    
	   
	    public void gunempty() {
	        new PlayWave1st("sounds/denied.wav").start();
	    }

    

	    public void keyPressed(KeyEvent e) {

	        int key = e.getKeyCode();

	        
	        if (key == KeyEvent.VK_LEFT) {
	            speedX = -5.5;
	            initFuel();
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	            speedX = 5.5;
	            initFuel();
	        }

	        if (key == KeyEvent.VK_UP) {
	            speedY = -5.5;
	            initFuel();
	        }

	        if (key == KeyEvent.VK_DOWN) {
	            speedY = 5.5;
	            initFuel();
	        }
	    }

	    	    
	    public void keyReleased(KeyEvent e) {

	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT) {
	            speedX = 0;
	            initCraft();
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	            speedX = 0;
	            initCraft();
	        }

	        if (key == KeyEvent.VK_UP) {
	            speedY = 0;
	            initCraft();
	        }

	        if (key == KeyEvent.VK_DOWN) {
	            speedY = 0;
	            initCraft();
	        }
	        
	    }
}