package space;

import java.util.ArrayList;

public class EnemyShip extends Sprite{
	

		    private double dx;
		    private double dy;
		    private ArrayList<EvilGun> fireball;
		    private ArrayList<CanonBall> canons;

		    public EnemyShip(int x, int y) {
		        super(x, y);

		        initEnemy();
		        initAmmo();
		    }

		    private void initEnemy() {
		        
		        loadImage("evilhead.png");
		        getImageDimensions();
		    }
		    
		    private void initAmmo(){
		    	
		    	fireball = new ArrayList<>();
		        canons = new ArrayList<>();
		        
		    }
		       
		    

		    public void move() {
		    	
		    	x += dx;
		        y += dy;

		        if (x < 1) {
		            x = 1;
		            
		        }
		        
		        if (y < 1) {
		            y = 1;
		        }
		        
		        x -= 1;
		        if(x == 600){
		        	fire();
		        	strikeHead();
		        }
		        
		        
		        if(x < 500){
		        	dx += 1.2;
		        	initEnemy();
		        	
		        }
		        
		        y-= 1;
		        if(y == 0){
		        	x += 1.2;
		        	initEnemy();
	        		
	        	}
		        
		        if(x > 800){
		        	
		        	dx-= 1.2;
		        	dy+= 1.2;   
		        	initEnemy();
		        	
		        }
		        
		        if(y > 500){
		        	dy-=1;
		        	initEnemy();
	        	}
		        
		    }

		    public void moveclean() {
		    	
		    	x += dx;
		        y += dy;

		        if (x < 1) {
		            x = 1;
		            
		        }
		        
		        if (y < 1) {
		            y = 1;
		        }
		        
		        x -= 1;
		        if(x == 600 || x == 575 || x == 550 || x == 525 || x == 500){
		        	fire2();
		        	strikeHead();
		        }
		        
		        
		        if(x < 500){
		        	dx += 1.2;
		        	initEnemy();
		        	
		        }
		        
		        y-= 1;
		        if(y == 0){
		        	x += 1.2;
		        	initEnemy();
	        		
	        	}
		        
		        if(x > 800){
		        	
		        	dx-= 1.2;
		        	dy+= 1.2;   
		        	initEnemy();
		        	
		        }
		        
		        if(y > 500){
		        	dy-=1;
		        	initEnemy();
	        	}
		        
		    }

		    @SuppressWarnings("rawtypes")
			public ArrayList getEvilMissiles() {
		        return fireball;
		    }
		    
		    @SuppressWarnings("rawtypes")
			public ArrayList getCanons() {
		        return canons;
		    }
		    
		  
		    public void fire2() {
		        fireball.add(new EvilGun(x + width, y + height / 2));
		        new AePlayWave("boing.wav").start();
		    }
	
		    public void fire() {
		        canons.add(new CanonBall(x + width, y + height / 2));
		        new AePlayWave("boing.wav").start();
		    }
			    	    
		    public void strikeHead() {
		        
		        loadImage("strikehead.png");
		        getImageDimensions();
		    }
		    
	}