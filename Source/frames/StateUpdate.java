package frames;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import entities.Alien;
import entities.Bunker;
import entities.Dragon;
import entities.EvilHead;
import entities.MyShip;
import items.BunkerBullet;
import items.CanonBall;
import items.FireBall;
import items.Gold;
import items.HealthPack;
import items.ShipMissile;
import items.ShipRocket;
import sound_engine.PlayWave1st;
import sound_engine.SoundResources;

public abstract class StateUpdate extends Board {
	
	private static final long serialVersionUID = 1L;

	@Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        updateMyShip();
        updateMyShipMissiles();
        updateEvilHeadMissiles();
        updateEvilHeadCanons();
        updateRockets();
        updateAliens();
        updateEvilHead();
        updateGold();
        updateHealth();
        updateBullets();
        
        Collisions.checkCollisions();

        repaint();
        
    }

    private void inGame() {
        
        if (!ingame) {
            timerEasy.stop();
            timerMedium.stop();
            timerHard.stop();
        }
    }

    private void updateMyShip() {

        if (MyShip.myShip.isVisible()) {
        	MyShip.myShip.move();
        }
    }

    private void updateMyShipMissiles() {

        @SuppressWarnings("unchecked")
		ArrayList<ShipMissile> ms = MyShip.myShip.getMissiles();
        
        
        for (int i = 0; i < ms.size(); i++) {

            ShipMissile m = ms.get(i);
            	            
            if (m.isVisible()) {
                m.move();
            } else {
                ms.remove(i);
            }
        }
        
    }
    
    
    private void updateBullets() {

		@SuppressWarnings("unchecked")
		ArrayList<BunkerBullet> bullets = Bunker.bunkerObj.getBullets();
		@SuppressWarnings("unchecked")
		ArrayList<BunkerBullet> bullets2 = Bunker.bunkerObj.getBullets2();  

		for (int i = 0; i < bullets.size(); i++) {

			BunkerBullet b = bullets.get(i);

			if (b.isVisible()) {
				b.moveDiagLeft();
				if(MyShip.myShip.x > 200){
					b.moveDiagRight();
					b.moveRight();
				}
				
				
				else if(MyShip.myShip.y > 300){
					b.moveDown();
					b.moveLeft();
				}
			}
			
			
			else {
				SoundResources.fuse.stop();
				bullets.remove(i);
			}
		}

		
		for (int i2 = 0; i2 < bullets2.size(); i2++) {

			BunkerBullet b2 = bullets2.get(i2);
			
			if (b2.isVisible()) {
				b2.moveDiagRight();
				if(MyShip.myShip.x > 200){
					b2.moveDiagLeft();
					b2.moveLeft();
				}
				
				else if(MyShip.myShip.y > 300){
					b2.moveDown();
					b2.moveLeft();
				}
			
			}
			
			
			else {
				SoundResources.fuse.stop();
				bullets2.remove(i2);
			}
		}

	
	}
    
    private void updateEvilHeadMissiles(){
    	
    		@SuppressWarnings("unchecked")
			ArrayList<FireBall> fireballs = EvilHead.evilHead.getEvilMissiles();
	        
	        
	        for (int i = 0; i < fireballs.size(); i++) {

	        	FireBall n = fireballs.get(i);
	            
	        	
	        	if (n.isVisible() && dragons.isEmpty() && timerHard.isRunning() == true) {
	                if(goldstack.isEmpty() && lifeMyShip <= 3){
	                	n.evilShotDiagUp();
	                	if(n.y < 0){
	                		n.y = 0;
	                		n.evilShot();
	                	}
	                }
	                if(goldstack.size() > 0 && lifeMyShip <= 3){
	                	n.evilShotDiagDown();
	                	if(n.y > 768){
	                		n.y = 768;
	                		n.evilShot();
	                	}
	                }
	                
	            }
	        	
	            if (n.isVisible()) {
	                n.evilShot();
	            } else {
	            	fireballs.remove(i);
	            }
	        }
        
    }
    
    private void updateEvilHeadCanons(){
    	
        	
        	@SuppressWarnings("unchecked")
			ArrayList<CanonBall> canonballs = EvilHead.evilHead.getCanons();
	        
	        
	        for (int i = 0; i < canonballs.size(); i++) {

	        	CanonBall n = canonballs.get(i);
	            	            
	            if (n.isVisible()) {
	                n.moveCanon();
	            } else {
	            	canonballs.remove(i);
	            }
	        }
    }
    
    private void updateRockets() {

        @SuppressWarnings("unchecked")
		ArrayList<ShipRocket> rocketstack = MyShip.myShip.getRockets();

        for (int i = 0; i < rocketstack.size(); i++) {

            ShipRocket r = rocketstack.get(i);

            if (r.isVisible()) {
                r.move();
            } else {
                rocketstack.remove(i);
            }
        }
    }
    
  
    private void updateAliens() {

    		
	    	for (int i = 0; i < aliens.size(); i++) {

	            Alien a = aliens.get(i);

	            if (a.isVisible() && timerHard.isRunning() == true && !timerEasy.isRunning() && !timerMedium.isRunning()){
	            	a.moveFaster();
	            }
	            
	            if (a.isVisible()) {
	                a.move();
	            }
	            	
	            	else {
	                aliens.remove(i);
	                new PlayWave1st("sounds/bloop.wav").start();
	            }
	        }
    }
    
    
    private void updateEvilHead() {

    		
    	    if (EvilHead.evilHead.isVisible() && timerEasy.isRunning() == true && 
    	    		(aliens.size() > 0 || dragons.size() > 0)) {
                EvilHead.evilHead.AIOnEasy();
            }
    	    
    	    if (EvilHead.evilHead.isVisible() && timerEasy.isRunning() == true && 
    	    		dragons.isEmpty() && goldstack.size() >= 0) {
                EvilHead.evilHead.AIOnEasy();
            }
    	    
    	    if(EvilHead.evilHead.isVisible() && timerMedium.isRunning() == true && 
    	    		dragons.isEmpty() && goldstack.size() >= 0){
    	    	EvilHead.evilHead.AIOnMedium();
    	    }
    	    
    	    
    	    if (EvilHead.evilHead.isVisible() && timerMedium.isRunning() == true && 
    	    		(aliens.size() > 0 || dragons.size() > 0)) {
                EvilHead.evilHead.AIOnMedium();
            } 
    	    
    	    if (EvilHead.evilHead.isVisible() && timerHard.isRunning() == true && 
    	    		(aliens.size() > 0 || dragons.size() > 0)) {
                EvilHead.evilHead.AIOnHard();
            }
    	    
    	    if(EvilHead.evilHead.isVisible() && timerHard.isRunning() == true && 
    	    		dragons.isEmpty() && goldstack.size() >= 0){
    	    	EvilHead.evilHead.AIOnHard();
    	    }
    	    
    }
    
    
    protected static void updateDragons() {
    	
    		
	        for (int i = 0; i < dragons.size(); i++) {

	            Dragon d = dragons.get(i);
	            d.setVisible(true);
	            checkDragonsCollision();
	            if (d.isVisible()) {
	                d.move();
	            } else {
	                dragons.remove(i);
	                new PlayWave1st("sounds/bloop.wav").start();
	            }
	        }

    }
    
    
    private void updateGold() {
    

        for (int i = 0; i < goldstack.size(); i++) {

            Gold b = goldstack.get(i);
            if (b.isVisible()) {
                b.move();
            } else {
            	goldstack.remove(i);
            }
        }
    }
    
    
    private void updateHealth() {
	    

        for (int i = 0; i < healthpack.size(); i++) {

            HealthPack h = healthpack.get(i);
            
            if(healthpack.size() < 5 && lifeMyShip > 3){
            	healthpack.add(i, new HealthPack(EvilHead.evilHead.x, EvilHead.evilHead.y));
            }
            
            if (h.isVisible()) {
                h.move();
            } else {
            	healthpack.remove(i);
            	if(lifeMyShip > 3){
            		lifeMyShip--;
            	}
            }
            
        }
    }
    
    public static void checkDragonsCollision() {
    
    	Rectangle myship = MyShip.myShip.getBounds();
    	
    	for (Dragon dragon : dragons) {
            Rectangle dragonUnit = dragon.getBounds();

            if (myship.intersects(dragonUnit)) {
        		lifeMyShip++;
        		dragon.setVisible(false);
        		new PlayWave1st("sounds/scream.wav").start();
        		MyShip.myShip.hitCraft();
        		MyShip.myShip.shakeCraft();	        		
        	}		
        }
    	
    	@SuppressWarnings("unchecked")
        ArrayList<ShipRocket> rocketstack = MyShip.myShip.getRockets();
        
        for (ShipRocket r : rocketstack) {

            Rectangle rocketUnit = r.getBounds();
            
            for (Dragon dragon : dragons) {

                Rectangle dragonUnit = dragon.getBounds();

                if (rocketUnit.intersects(dragonUnit)) {
                    r.setVisible(false);
                    dragon.setVisible(false);
                }
            }          
           
        }
        
        

    }
    



}
