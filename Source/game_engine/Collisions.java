package game_engine;

import java.awt.Rectangle;
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
import sound_engine.LoadSounds;

public abstract class Collisions extends UpdateObjects {
	
	private static final long serialVersionUID = 1L;

	public static void checkCollisions() {

        Rectangle myship = MyShip.myShip.getBounds();
        
        Rectangle evilhead = EvilHead.evilHead.getBounds();
        
        Rectangle bunker = Bunker.bunkerObj.getBounds();
        
        if(myship.intersects(evilhead)){
        	
    			new PlayWave1st("sounds/scream.wav").start();
    			MyShip.myShip.setVisible(false);
    			EvilHead.evilHead.setVisible(false);
    			lifeMyShip = 7;
		        return;
        	}
        
    if(Alien.aliens.isEmpty() && Dragon.dragons.isEmpty() && lifeBunker < 50){
    	
    	if(myship.intersects(bunker)){
        	
			new PlayWave1st("sounds/scream.wav").start();
			new PlayWave1st("sounds/explosion.wav").start();
			MyShip.myShip.setVisible(false);
			Bunker.bunkerObj.setVisible(false);
			lifeMyShip = 7;
	        return;
    	}
    }
        
        
        for (Alien alien : Alien.aliens) {
        	
	        	        	
            Rectangle alienUnit = alien.getBounds();
 
            	if (myship.intersects(alienUnit)) {
	        		lifeMyShip++;
	        		alien.setVisible(false);
	        		new PlayWave1st("sounds/scream.wav").start();
	        		MyShip.myShip.hitCraft();
	        		MyShip.myShip.shipShake();
            	}		
	        			
		     }
	        		
	        				        
        for (Gold gold : Gold.goldstack) {
        	Rectangle goldUnit = gold.getBounds();

            if (myship.intersects(goldUnit)) {
                gold.setVisible(false);
                new PlayWave1st("sounds/collect.wav").start();
            }
        }
        
        for (HealthPack health : HealthPack.healthpack) {
        	Rectangle healthUnit = health.getBounds();

            if (myship.intersects(healthUnit)) {
                health.setVisible(false);
                LoadSounds.gotHealthPack.play();
            }
        }

        @SuppressWarnings("unchecked")
		ArrayList<ShipMissile> missiles = MyShip.myShip.getMissiles();
       
        for (ShipMissile m : missiles) {

            Rectangle missileUnit = m.getBounds();
            

            for (Alien alien : Alien.aliens) {

                Rectangle alienUnit = alien.getBounds();

                if (missileUnit.intersects(alienUnit)) {
                    m.setVisible(false);
                    alien.setVisible(false);
                }
            }

            if(Alien.aliens.isEmpty() && Dragon.dragons.isEmpty() && lifeBunker < 50){
            	if(missileUnit.intersects(bunker)){
            		Bunker.bunkerObj.initBunkerHit();
            		Bunker.bunkerObj.loadBullet();
            		Bunker.bunkerObj.loadBullet2();
            		m.setVisible(false);
            		new PlayWave1st("sounds/bloop.wav").start();
            		LoadSounds.fuse.play();
            		lifeBunker++;
            	}
            	
            	else{
            			Bunker.bunkerObj.initBunker();
        			}
            	
            }
            	
            
            if(Alien.aliens.isEmpty() && 
            		Dragon.dragons.isEmpty() && Gold.goldstack.isEmpty() && lifeBunker >= 50){
            	if(missileUnit.intersects(evilhead)){
            		m.setVisible(false);
            		if(timerHard.isRunning() == true){
            			EvilHead.evilHead.throwFireballs();
            		}
            		else{
            			EvilHead.evilHead.throwCanons();
            		}
	            	EvilHead.evilHead.strikeHead();
	            	lifeEvilHead++;
            	}
            	
            }
            
            	            	            
        }
        
        
        @SuppressWarnings("unchecked")
		ArrayList<FireBall> fireballs = EvilHead.evilHead.getEvilMissiles();
       
        for (FireBall n : fireballs) {

            	Rectangle fireballUnit = n.getBounds();
            	            
                Rectangle ship = MyShip.myShip.getBounds();

                if (fireballUnit.intersects(ship)) {
	        		lifeMyShip++;
	        		n.setVisible(false);
	        		new PlayWave1st("sounds/scream.wav").start();
	        		MyShip.myShip.hitCraft();
	        		MyShip.myShip.shipShake();
            	}	
        }
        
        @SuppressWarnings("unchecked")
		ArrayList<BunkerBullet> bullets = Bunker.bunkerObj.getBullets();
        
       
        for (BunkerBullet n : bullets) {

            	Rectangle bulletUnit = n.getBounds();
            	            
                Rectangle ship = MyShip.myShip.getBounds();
                
                if (bulletUnit.intersects(ship)) {
	        		lifeMyShip++;
	        		n.setVisible(false);
	        		new PlayWave1st("sounds/scream.wav").start();
	        		new PlayWave1st("sounds/explosion.wav").start();
	        		MyShip.myShip.hitCraft();
	        		MyShip.myShip.shipShake();
            	}
                
        }

        @SuppressWarnings("unchecked")
		ArrayList<BunkerBullet> bullets2 = Bunker.bunkerObj.getBullets2();
      
        
        for (BunkerBullet n : bullets2) {
        
            	Rectangle bulletUnit2 = n.getBounds();
            	            
                Rectangle ship = MyShip.myShip.getBounds();

                if (bulletUnit2.intersects(ship)) {
	        		lifeMyShip++;
	        		n.setVisible(false);
	        		new PlayWave1st("sounds/scream.wav").start();
	        		new PlayWave1st("sounds/explosion.wav").start();
	        		MyShip.myShip.hitCraft();
	        		MyShip.myShip.shipShake();
            	}
                	
        }

        @SuppressWarnings("unchecked")
		ArrayList<CanonBall> can = EvilHead.evilHead.getCanons();
       
        for (CanonBall n : can) {

            	Rectangle r1 = n.getBounds();
            	            
              
                if (r1.intersects(myship)) {
	        		lifeMyShip++;
	        		n.setVisible(false);
	        		new PlayWave1st("sounds/burned.wav").start();
	        		MyShip.myShip.hitCraft();
	        		MyShip.myShip.shipShake();
            	}	
        }
        

        
        @SuppressWarnings("unchecked")
        ArrayList<ShipRocket> rs = MyShip.myShip.getRockets();
        
        for (ShipRocket r : rs) {

            Rectangle rocketUnit = r.getBounds();

            for (Alien alien : Alien.aliens) {

                Rectangle alienUnit = alien.getBounds();

                if (rocketUnit.intersects(alienUnit)) {
                    r.setVisible(false);
                    alien.setVisible(false);
                    new PlayWave1st("sounds/scream.wav").start();
                }
            }
            
            
            if(Alien.aliens.isEmpty() && 
            		Dragon.dragons.isEmpty() && Gold.goldstack.isEmpty() && lifeBunker >= 50){
            	if(rocketUnit.intersects(evilhead)){
            		r.setVisible(false);
            		if(timerHard.isRunning() == true){
            			EvilHead.evilHead.throwFireballs();
            		}
            		else{
            			EvilHead.evilHead.throwCanons();
            		}
	            	EvilHead.evilHead.strikeHead();
	            	lifeEvilHead++;
            	}
            }
            
            if(Alien.aliens.isEmpty() && Dragon.dragons.isEmpty() && lifeBunker < 50){
            		if(rocketUnit.intersects(bunker)){
            			Bunker.bunkerObj.initBunkerHit();
            			Bunker.bunkerObj.loadBullet();
            			Bunker.bunkerObj.loadBullet2();
	    				r.setVisible(false);
	    				new PlayWave1st("sounds/scream.wav").start();
	    				LoadSounds.fuse.play();
	            		lifeBunker++;
	            	}
            		
            		
            	else{
            			
            			Bunker.bunkerObj.initBunker();
            		}
            		
            	}
            	
            
        }
        
      
    }
}