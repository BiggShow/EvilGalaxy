package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
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
import items.VolBtn;
import sound_engine.SoundResources;

public class DrawScene extends StateUpdate {

	private String unicode;
	private String checkMark;
    
	private static final long serialVersionUID = 1L;

	
	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        

        if (ingame && aliens.size() > 0) {

        	drawObjects(g);
        	
            
        }
        
        if(aliens.isEmpty() && !timerMedium.isRunning() && 
        		timerHard.isRunning() == true){
        	
        	drawObjects2(g);
        	
        	if(dragons.size() > 0){
        		g.drawString("Dragonzz: " + dragons.size(), 5, 15);
        		g.drawString("Level: " + 2, 230, 15);
        		g.drawString("Missiles: Locked", 320, 15);
        		g.drawString("Rockets: Unlocked", 480, 15);
        		g.drawString("Difficulty: Hard", 650, 15);
        		drawOuttaControl(g);
        		MyShip.myShip.dragonShake();
        		
        		
        	}
        	StateUpdate.updateDragons();
        	SoundResources.roar.loop();
        	if(dragons.isEmpty() && lifeBunker < 50){
        		g.drawString("Dragonzz: " + checkMark, 5, 15);
        		g.drawString("Level: " + 3, 230, 15);
        		g.drawString("Missiles: Unlocked", 320, 15);
        		g.drawString("Rockets: Unlocked", 490, 15);
        		g.drawString("Difficulty: Hard", 670, 15);
        	}
        	
        	if(lifeBunker == 50){
        		g.drawString("Dragonzz: " + checkMark, 5, 15);
        		g.drawString("Level: " + 4, 230, 15);
        		g.drawString("Missiles: Unlocked", 320, 15);
        		g.drawString("Rockets: Unlocked", 490, 15);
        		g.drawString("Difficulty: Hard", 670, 15);
        	}
        	
        }

        
        
        if(aliens.isEmpty() && !timerMedium.isRunning() && !timerHard.isRunning()){
        	
        	drawObjects2(g);
        	
        	if(dragons.size() > 0){
        		g.drawString("Dragonzz: " + dragons.size(), 5, 15);
        		g.drawString("Level: " + 2, 230, 15);
        		g.drawString("Missiles: Locked", 320, 15);
        		g.drawString("Rockets: Unlocked", 480, 15);
        		g.drawString("Difficulty: Easy", 650, 15);
        	}
        	StateUpdate.updateDragons();
        	SoundResources.roar.loop();
        	if(dragons.isEmpty() && lifeBunker < 50){
        		g.drawString("Dragonzz: " + checkMark, 5, 15);
        		g.drawString("Level: " + 3, 230, 15);
        		g.drawString("Missiles: Unlocked", 320, 15);
        		g.drawString("Rockets: Unlocked", 490, 15);
        		g.drawString("Difficulty: Easy", 670, 15);
        	}
        	
        	if(lifeBunker == 50){
        		g.drawString("Dragonzz: " + checkMark, 5, 15);
        		g.drawString("Level: " + 4, 230, 15);
        		g.drawString("Missiles: Unlocked", 320, 15);
        		g.drawString("Rockets: Unlocked", 490, 15);
        		g.drawString("Difficulty: Hard", 670, 15);
        	}
        	
        }
        
        if(aliens.isEmpty() && timerMedium.isRunning() == true && !timerHard.isRunning()){
        	
        	drawObjects2(g);
        	
        	if(dragons.size() > 0){
        		g.drawString("Dragonzz: " + dragons.size(), 5, 15);
        		g.drawString("Level: " + 2, 230, 15);
        		g.drawString("Missiles: Locked", 320, 15);
        		g.drawString("Rockets: Unlocked", 480, 15);
        		g.drawString("Difficulty: Medium", 650, 15);
        	}
        	StateUpdate.updateDragons();
        	SoundResources.roar.loop();
        	if(dragons.isEmpty() && lifeBunker < 50){
        		g.drawString("Dragonzz: " + checkMark, 5, 15);
        		g.drawString("Level: " + 3, 230, 15);
        		g.drawString("Missiles: Unlocked", 320, 15);
        		g.drawString("Rockets: Unlocked", 490, 15);
        		g.drawString("Difficulty: Medium", 670, 15);
        	}
        	
        	if(lifeBunker == 50){
        		g.drawString("Dragonzz: " + checkMark, 5, 15);
        		g.drawString("Level: " + 4, 230, 15);
        		g.drawString("Missiles: Unlocked", 320, 15);
        		g.drawString("Rockets: Unlocked", 490, 15);
        		g.drawString("Difficulty: Hard", 670, 15);
        	}
        	
        }

        if(lifeMyShip < 3){
        	
        	g.drawString("GODMODE!", MyShip.myShip.x, MyShip.myShip.y);
        	MyShip.myShip.godMode();
        	
        }        

        if(lifeMyShip == 3){
        	
        	g.drawString("Health: 100%", MyShip.myShip.x, MyShip.myShip.y);
        	
        }
        
        if(lifeMyShip == 4){
        	
        	g.drawString("Health: 75%", MyShip.myShip.x, MyShip.myShip.y);
        	
        }
       
        if(lifeMyShip == 5){
        	
        	g.drawString("Health: 50%", MyShip.myShip.x, MyShip.myShip.y);
        	
        }
       
        if(lifeMyShip == 6){
        	
        	g.drawString("Health: 25%", MyShip.myShip.x, MyShip.myShip.y);
        	
        }
        
		if(lifeMyShip > 6){
			        	
			ingame = false;
        	
        }
        
       	
        
        if(dragons.isEmpty()){
        	
        	drawObjects3(g);
        	SoundResources.roar.stop();
        }
        
        if(dragons.isEmpty() && lifeBunker == 50 && goldstack.size() > 0 && timerHard.isRunning() == true){
        	
        	drawCollect(g);
        	g.drawString("Missiles: Locked", 320, 15);
    		g.drawString("Rockets: Locked", 480, 15);
    		g.drawString("Difficulty: Hard", 640, 15);
        	
        }
        
        if(dragons.isEmpty() && lifeBunker == 50 && goldstack.size() > 0 && !timerHard.isRunning() && timerMedium.isRunning() == true){
        	
        	drawCollect(g);
        	g.drawString("Missiles: Locked", 320, 15);
    		g.drawString("Rockets: Locked", 480, 15);
    		g.drawString("Difficulty: Medium", 640, 15);
        	
        }

        
        if(dragons.isEmpty() && lifeBunker == 50 && goldstack.size() > 0 && 
        		!timerHard.isRunning() && !timerMedium.isRunning()){
        	
        	drawCollect(g);
        	g.drawString("Missiles: Locked", 320, 15);
    		g.drawString("Rockets: Locked", 480, 15);
    		g.drawString("Difficulty: Easy", 640, 15);
        	
        }
        
        
        if(dragons.isEmpty() && lifeBunker < 50 &&
        		timerHard.isRunning() == true){
        	
        	drawKillTheBunker(g);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Unlocked", 490, 15);	
        	g.drawString("Difficulty: Hard", 670, 15);
        }
        
        if(dragons.isEmpty() && lifeBunker < 50 &&
        		!timerHard.isRunning() && timerMedium.isRunning() == true){
        	
        	drawKillTheBunker(g);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Unlocked", 490, 15);	
        	g.drawString("Difficulty: Medium", 670, 15);
        }
        
        
        
        if(dragons.isEmpty() && lifeBunker < 50 &&
        		!timerHard.isRunning() && !timerMedium.isRunning()){
        	
        	drawKillTheBunker(g);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Unlocked", 490, 15);	
        	g.drawString("Difficulty: Easy", 670, 15);
        }
        
        if(dragons.isEmpty() && goldstack.isEmpty() && lifeBunker == 50 && 
        		timerHard.isRunning() == true){
        	
        	drawKillTheHead(g);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Unlocked", 490, 15);	
        	g.drawString("Difficulty: Hard", 670, 15);
        }
        
        if(dragons.isEmpty() && goldstack.isEmpty() && lifeBunker == 50 && 
        		!timerHard.isRunning() && timerMedium.isRunning() == true){
        	
        	drawKillTheHead(g);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Unlocked", 490, 15);	
        	g.drawString("Difficulty: Medium", 670, 15);
        }
        
        
        
        if(dragons.isEmpty() && goldstack.isEmpty() && lifeBunker == 50 && 
        		!timerHard.isRunning() && !timerMedium.isRunning()){
        	
        	drawKillTheHead(g);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Unlocked", 490, 15);	
        	g.drawString("Difficulty: Easy", 670, 15);
        }
        
        
        if(dragons.isEmpty() && goldstack.isEmpty() && lifeBunker == 50 
        		&& EvilHead.evilHead.x - MyShip.myShip.x == 400 && timerEasy.isRunning() == true){
        	EvilHead.evilHead.throwCanons();
        	EvilHead.evilHead.strikeHead();
        }
        
        	        	        
        if(dragons.isEmpty() && goldstack.isEmpty() && lifeBunker == 50 
        		&& EvilHead.evilHead.x - MyShip.myShip.x == 400 && timerMedium.isRunning() == true){
        	EvilHead.evilHead.throwFireballs();
        	EvilHead.evilHead.strikeHead();
        }
        
        if(dragons.isEmpty() && goldstack.size() >= 0 && lifeBunker == 50 
        		&& EvilHead.evilHead.x - MyShip.myShip.x == 400 && timerHard.isRunning() == true){
        	EvilHead.evilHead.throwFireballs();
        	EvilHead.evilHead.strikeHead();
        }
        
        if(EvilHead.evilHead.x - MyShip.myShip.x > 800 && dragons.isEmpty() && goldstack.isEmpty()
        		&& lifeBunker == 50){
        	MyShip.myShip.dragonShake();
        	MyShip.myShip.y = EvilHead.evilHead.y + 70;
    	}
        
        
        if(dragons.isEmpty() && lifeBunker < 10 && goldstack.size() > 0){
        	g.drawString("EvilHead is waiting...", EvilHead.evilHead.x, EvilHead.evilHead.y);
        	g.drawString("Health: 100%", Bunker.bunkerObj.x, Bunker.bunkerObj.y);
        }
        
        
        if(lifeBunker >= 10 && lifeBunker < 20 && goldstack.size() > 0){
        	g.drawString("EvilHead is waiting...", EvilHead.evilHead.x, EvilHead.evilHead.y);
        	g.drawString("Health: 80%", Bunker.bunkerObj.x, Bunker.bunkerObj.y);
        	
        }
        
        
        if(lifeBunker >= 20 && lifeBunker < 30 && goldstack.size() > 0){
        	g.drawString("EvilHead is waiting...", EvilHead.evilHead.x, EvilHead.evilHead.y);
        	g.drawString("Health: 60%", Bunker.bunkerObj.x, Bunker.bunkerObj.y);
        }
        
        if(lifeBunker >= 30 && lifeBunker < 35){
        	SoundResources.roar.loop();
        }
        
        if(lifeBunker >= 35){
        	SoundResources.roar.stop();
        }
        
        if(lifeBunker >= 30 && lifeBunker < 40 && goldstack.size() > 0){
        	g.drawString("EvilHead is waiting...", EvilHead.evilHead.x, EvilHead.evilHead.y);
        	g.drawString("Health: 40%", Bunker.bunkerObj.x, Bunker.bunkerObj.y);
        }
        
        if(lifeBunker >= 40 && lifeBunker < 45){
        	SoundResources.roar.loop();
        }
        
        if(lifeBunker >= 45){
        	SoundResources.roar.stop();
        }
        
        if(lifeBunker >= 40 && lifeBunker < 50 && goldstack.size() > 0){
        	g.drawString("EvilHead is waiting...", EvilHead.evilHead.x, EvilHead.evilHead.y);
        	g.drawString("Health: 20%", Bunker.bunkerObj.x, Bunker.bunkerObj.y);
        }
       	
        if(lifeBunker == 50){
        	if(goldstack.size() > 0){
        		g.drawString("EvilHead is waiting...", EvilHead.evilHead.x, EvilHead.evilHead.y);
        	}
        	g.drawString("Bunker destroyed!", Bunker.bunkerObj.x, Bunker.bunkerObj.y);
        	Bunker.bunkerObj.initBunkerHit();
        }
        
        if(dragons.isEmpty() && goldstack.isEmpty() && lifeBunker == 50
        		&& lifeEvilHead < 10){
        	g.drawString("Health: 100%", EvilHead.evilHead.x, EvilHead.evilHead.y);
        }
        
        
        if(lifeEvilHead >= 10 && lifeEvilHead < 20){
        	g.drawString("Health: 80%", EvilHead.evilHead.x, EvilHead.evilHead.y);
        	
        }
        
        
        if(lifeEvilHead >= 20 && lifeEvilHead < 30){
        	g.drawString("Health: 60%", EvilHead.evilHead.x, EvilHead.evilHead.y);
        }
        
        if(lifeEvilHead >= 30 && lifeEvilHead < 35){
        	SoundResources.roar.loop();
        }
        
        if(lifeEvilHead >= 35){
        	SoundResources.roar.stop();
        }
        
        if(lifeEvilHead >= 30 && lifeEvilHead < 40){
        	g.drawString("Health: 40%", EvilHead.evilHead.x, EvilHead.evilHead.y);
        }
        
        if(lifeEvilHead >= 40 && lifeEvilHead < 45){
        	SoundResources.roar.loop();
        }
        
        if(lifeEvilHead >= 45){
        	SoundResources.roar.stop();
        }
        
        if(lifeEvilHead >= 40 && lifeEvilHead < 50){
        	g.drawString("Health: 20%", EvilHead.evilHead.x, EvilHead.evilHead.y);
        }
       	        
        if(lifeEvilHead == 50){
        	
        	SoundResources.gameWon.play();
        	ingame = false;
	        g.drawImage(bg1, 0, 0, null);
            drawYouWon(g);
        	g.drawString("Monsters: Killed!", 5, 15);
	        g.drawString("Gold: Collected!", 165, 15);
	        SoundResources.bgMusic.stop();
	        return;
        }
        
        
        if (!ingame) {

        	SoundResources.gameLost.play();
	    	g.drawImage(bg1, 0, 0, null);
            drawGameOver(g);
            SoundResources.bgMusic.stop();
            SoundResources.roar.stop();
            god = false;
            g.drawString("Monsters left: " + 0, 5, 15);
	        g.drawString("Gold: " + 0, 150, 15);
	        g.drawString("Health: 0%", 230, 15);
	        timerEasy.stop();
	        timerMedium.stop();
	        timerHard.stop();
	        SoundResources.fuse.stop();
	        return;
        }

        Toolkit.getDefaultToolkit().sync();
    }
    
    


	private void drawObjects(Graphics g) {

        if (EvilHead.evilHead.isVisible() && MyShip.myShip.isVisible() && VolBtn.volButt.isVisible() 
        		&& Bunker.bunkerObj.isVisible() && g.drawImage(bg1, 0, 0, null)) {
            g.drawImage(MyShip.myShip.getImage(), MyShip.myShip.getX(), MyShip.myShip.getY(),
                    this);
            g.drawImage(EvilHead.evilHead.getImage(), EvilHead.evilHead.getX(), EvilHead.evilHead.getY(),
                    this);
            g.drawImage(VolBtn.volButt.getImage(), VolBtn.volButt.getX(), VolBtn.volButt.getY(),
                    this);
            g.drawImage(Bunker.bunkerObj.getImage(), Bunker.bunkerObj.getX(), Bunker.bunkerObj.getY(), this);
        }
        
        

        @SuppressWarnings("unchecked")
		ArrayList<ShipMissile> ms = MyShip.myShip.getMissiles();
     
        for (ShipMissile m : ms) {
        	
            if (m.isVisible()) {
                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }
        }
        
        @SuppressWarnings("unchecked")
        ArrayList<ShipRocket> rs = MyShip.myShip.getRockets();

        for (ShipRocket r : rs) {
            if (r.isVisible()) {
                g.drawImage(r.getImage(), r.getX(), r.getY(), this);
            }
        }
        
        
        
        @SuppressWarnings("unchecked")
		ArrayList<FireBall> guner = EvilHead.evilHead.getEvilMissiles();
     
        for (FireBall n : guner) {
        	
            if (n.isVisible()) {
                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
            }
        }
        
        @SuppressWarnings("unchecked")
		ArrayList<CanonBall> can = EvilHead.evilHead.getCanons();
     
        for (CanonBall n : can) {
        	
            if (n.isVisible()) {
                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
            }
        }
        
        
        @SuppressWarnings("unchecked")
		ArrayList<BunkerBullet> bull = Bunker.bunkerObj.getBullets();

		for (BunkerBullet n : bull) {

			if (n.isVisible()) {
				g.drawImage(n.getImage(), n.getX(), n.getY(), this);
			}
		}
        
		
		@SuppressWarnings("unchecked")
		ArrayList<BunkerBullet> bull2 = Bunker.bunkerObj.getBullets2();

		for (BunkerBullet n : bull2) {

			if (n.isVisible()) {
				g.drawImage(n.getImage(), n.getX(), n.getY(), this);
			}
		}


        for (Alien alien : aliens) {
            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }
        }
        
       for (Dragon dragon : dragons) {
            if (dragon.isVisible()) {
                g.drawImage(dragon.getImage(), dragon.getX(), dragon.getY(), this);
            }
        } 
        
        
        for (Gold gold : goldstack) {
            if (gold.isVisible()) {
                g.drawImage(gold.getImage(), gold.getX(), gold.getY(), this);
            }
        }
        
        for (HealthPack health : healthpack) {
            if (health.isVisible()) {
                g.drawImage(health.getImage(), health.getX(), health.getY(), this);
            }
        }
        
        
        Font small = new Font("Helvetica", Font.BOLD, 17);
        g.setColor(Color.WHITE);
        g.setFont(small);
        
        unicode = "2713";
        checkMark = String.valueOf(Character.toChars(Integer.parseInt(unicode, 16)));
     
        if(aliens.size() > 0 && timerHard.isRunning() == true){
        	
        	g.drawString("Aliens left: " + aliens.size(), 5, 15);
        	g.drawString("Level: " + 1, 230, 15);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Locked", 490, 15);
        	g.drawString("Difficulty: Hard", 650, 15);
        	
        }
        
        if(aliens.size() > 0 && !timerHard.isRunning() && timerMedium.isRunning() == true){
        	
        	g.drawString("Aliens left: " + aliens.size(), 5, 15);
        	g.drawString("Level: " + 1, 230, 15);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Locked", 490, 15);
        	g.drawString("Difficulty: Medium", 650, 15);
        	
        }

        if(aliens.size() > 0 && !timerHard.isRunning() && !timerMedium.isRunning()){
        	
        	g.drawString("Aliens left: " + aliens.size(), 5, 15);
        	g.drawString("Level: " + 1, 230, 15);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Locked", 490, 15);
        	g.drawString("Difficulty: Easy", 650, 15);
        }
       
        if(goldstack.size() > 0){
        	g.drawString("Gold: " + (-(goldstack.size() - 12)), 140, 15);
        }
        
        if(goldstack.isEmpty()){
    		g.drawString("Gold: " + checkMark, 140, 15);
    	}
        
    }
    
    
    private void drawObjects3(Graphics g) {

        if (EvilHead.evilHead.isVisible() && MyShip.myShip.isVisible() && VolBtn.volButt.isVisible() && Bunker.bunkerObj.isVisible() && g.drawImage(bg3, 0, 0, null)) {
            g.drawImage(MyShip.myShip.getImage(), MyShip.myShip.getX(), MyShip.myShip.getY(),
                    this);
            g.drawImage(EvilHead.evilHead.getImage(), EvilHead.evilHead.getX(), EvilHead.evilHead.getY(),
                    this);
            g.drawImage(VolBtn.volButt.getImage(), VolBtn.volButt.getX(), VolBtn.volButt.getY(),
                    this);
            g.drawImage(Bunker.bunkerObj.getImage(), Bunker.bunkerObj.getX(), Bunker.bunkerObj.getY(), this);
        }
        
        

        @SuppressWarnings("unchecked")
		ArrayList<ShipMissile> ms = MyShip.myShip.getMissiles();
     
        for (ShipMissile m : ms) {
        	
            if (m.isVisible()) {
                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }
        }
        
        @SuppressWarnings("unchecked")
        ArrayList<ShipRocket> rs = MyShip.myShip.getRockets();

        for (ShipRocket r : rs) {
            if (r.isVisible()) {
                g.drawImage(r.getImage(), r.getX(), r.getY(), this);
            }
        }
        
        
        
        @SuppressWarnings("unchecked")
		ArrayList<FireBall> guner = EvilHead.evilHead.getEvilMissiles();
     
        for (FireBall n : guner) {
        	
            if (n.isVisible()) {
                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
            }
        }
        
        
        @SuppressWarnings("unchecked")
		ArrayList<CanonBall> can = EvilHead.evilHead.getCanons();
     
        for (CanonBall n : can) {
        	
            if (n.isVisible()) {
                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
            }
        }
        
        @SuppressWarnings("unchecked")
		ArrayList<BunkerBullet> bull = Bunker.bunkerObj.getBullets();

		for (BunkerBullet n : bull) {

			if (n.isVisible()) {
				g.drawImage(n.getImage(), n.getX(), n.getY(), this);
			}
		}
        
		@SuppressWarnings("unchecked")
		ArrayList<BunkerBullet> bull2 = Bunker.bunkerObj.getBullets2();

		for (BunkerBullet n : bull2) {

			if (n.isVisible()) {
				g.drawImage(n.getImage(), n.getX(), n.getY(), this);
			}
		}

        for (Alien a : aliens) {
            if (a.isVisible()) {
                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
        }
        
       for (Dragon d : dragons) {
            if (d.isVisible()) {
                g.drawImage(d.getImage(), d.getX(), d.getY(), this);
            }
        } 
        
        
        for (Gold b : goldstack) {
            if (b.isVisible()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }
        
        for (HealthPack b : healthpack) {
            if (b.isVisible()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }
        
        
        Font small = new Font("Helvetica", Font.BOLD, 17);
        g.setColor(Color.WHITE);
        g.setFont(small);
        
        unicode = "2713";
        checkMark = String.valueOf(Character.toChars(Integer.parseInt(unicode, 16)));

        if(aliens.size() > 0){
        	
        	g.drawString("Aliens left: " + aliens.size(), 5, 15);
        	g.drawString("Level: " + 1, 230, 15);
	        
        }
        
        if(dragons.isEmpty() && lifeBunker < 50){
    		g.drawString("Dragonzz: " + checkMark, 5, 15);
    		g.drawString("Level: " + 3, 230, 15);
    	}
        
        if(lifeBunker == 50){
    		g.drawString("Dragonzz: " + checkMark, 5, 15);
    		g.drawString("Level: " + 4, 230, 15);
    	}
       
        if(goldstack.size() > 0){
        	g.drawString("Gold: " + (-(goldstack.size() - 12)), 140, 15);
        }
        
        if(goldstack.isEmpty()){
    		g.drawString("Gold: " + checkMark, 140, 15);
    	}
        
        
        if(lifeMyShip < 3){
        	
        	g.drawString("GODMODE!", MyShip.myShip.x, MyShip.myShip.y);
        	
        }
        
        
        if(lifeMyShip == 3){
        	
        	g.drawString("Health: 100%", MyShip.myShip.x, MyShip.myShip.y);
        	
        }
        
        if(lifeMyShip == 4){
        	
        	g.drawString("Health: 75%", MyShip.myShip.x, MyShip.myShip.y);
        	
        }
       
        if(lifeMyShip == 5){
        	
        	g.drawString("Health: 50%", MyShip.myShip.x, MyShip.myShip.y);
        	
        }
       
        if(lifeMyShip == 6){
        	
        	g.drawString("Health: 25%", MyShip.myShip.x, MyShip.myShip.y);
        	
        }

    	if(lifeMyShip > 6){
        	
			ingame = false;
        	
        }
    }
    
    
    private void drawObjects2(Graphics g) {

        if (EvilHead.evilHead.isVisible() && MyShip.myShip.isVisible() && VolBtn.volButt.isVisible() 
        		&& Bunker.bunkerObj.isVisible() && g.drawImage(bg2, 0, 0, null)) {
            g.drawImage(MyShip.myShip.getImage(), MyShip.myShip.getX(), MyShip.myShip.getY(),
                    this);
            g.drawImage(EvilHead.evilHead.getImage(), EvilHead.evilHead.getX(), EvilHead.evilHead.getY(),
                    this);
            g.drawImage(VolBtn.volButt.getImage(), VolBtn.volButt.getX(), VolBtn.volButt.getY(),
                    this);
            g.drawImage(Bunker.bunkerObj.getImage(), Bunker.bunkerObj.getX(), Bunker.bunkerObj.getY(), this);
        }
        
        

        @SuppressWarnings("unchecked")
		ArrayList<ShipMissile> ms = MyShip.myShip.getMissiles();
     
        for (ShipMissile m : ms) {
        	
            if (m.isVisible()) {
                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }
        }
        
        @SuppressWarnings("unchecked")
        ArrayList<ShipRocket> rs = MyShip.myShip.getRockets();

        for (ShipRocket r : rs) {
            if (r.isVisible()) {
                g.drawImage(r.getImage(), r.getX(), r.getY(), this);
            }
        }
        
        
        
        @SuppressWarnings("unchecked")
		ArrayList<FireBall> fireballs = EvilHead.evilHead.getEvilMissiles();
     
        for (FireBall n : fireballs) {
        	
            if (n.isVisible()) {
                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
            }
        }
        
        @SuppressWarnings("unchecked")
		ArrayList<BunkerBullet> bull = Bunker.bunkerObj.getBullets();

		for (BunkerBullet n : bull) {

			if (n.isVisible()) {
				g.drawImage(n.getImage(), n.getX(), n.getY(), this);
			}
		}
		
		 @SuppressWarnings("unchecked")
			ArrayList<BunkerBullet> bull2 = Bunker.bunkerObj.getBullets2();

			for (BunkerBullet n : bull2) {

				if (n.isVisible()) {
					g.drawImage(n.getImage(), n.getX(), n.getY(), this);
				}
			}
        
        @SuppressWarnings("unchecked")
		ArrayList<CanonBall> canonballs = EvilHead.evilHead.getCanons();
     
        for (CanonBall n : canonballs) {
        	
            if (n.isVisible()) {
                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
            }
        }

        for (Alien a : aliens) {
            if (a.isVisible()) {
                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
        }
        
       for (Dragon d : dragons) {
            if (d.isVisible()) {
                g.drawImage(d.getImage(), d.getX(), d.getY(), this);
            }
        } 
        
        
        for (Gold b : goldstack) {
            if (b.isVisible()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }
        
        for (HealthPack b : healthpack) {
            if (b.isVisible()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }
        
        
        Font small = new Font("Helvetica", Font.BOLD, 17);
        g.setColor(Color.WHITE);
        g.setFont(small);
        
        unicode = "2713";
        checkMark = String.valueOf(Character.toChars(Integer.parseInt(unicode, 16)));

        if(aliens.size() > 0){
        	
        	g.drawString("Aliens left: " + aliens.size(), 5, 15);
        	g.drawString("Level: " + 1, 230, 15);
	        
        }
       
        if(goldstack.size() > 0){
        	g.drawString("Gold: " + (-(goldstack.size() - 12)), 140, 15);
        }
        
        if(goldstack.isEmpty()){
    		g.drawString("Gold: " + checkMark, 140, 15);
    	}
        
    }
    
    private void drawGameOver(Graphics g) {

        String msg = "Game Over!";
        Font small = new Font("Helvetica", Font.BOLD, 17);
        FontMetrics fm = getFontMetrics(small);
        
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - 286 - fm.stringWidth(msg)) / 2,
                (B_HEIGHT - 272) / 2);
    }
    
    private void drawCollect(Graphics g) {

        String msg = "Collect all the gold!";
        Font small = new Font("Helvetica", Font.BOLD, 17);
        FontMetrics fm = getFontMetrics(small);
        
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - 286 - fm.stringWidth(msg)) / 2,
                (B_HEIGHT - 272) / 2);
    }
    	    

	private void drawKillTheBunker(Graphics g) {
		
		String msg = "Destroy the bunker!";
        Font small = new Font("Helvetica", Font.BOLD, 17);
        FontMetrics fm = getFontMetrics(small);
        
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - 286 - fm.stringWidth(msg)) / 2,
                (B_HEIGHT - 272) / 2);
		
	}
    
    private void drawKillTheHead(Graphics g) {

        String msg = "Finally..Kill the evil head!";
        Font small = new Font("Helvetica", Font.BOLD, 17);
        FontMetrics fm = getFontMetrics(small);
        
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - 286 - fm.stringWidth(msg)) / 2,
                (B_HEIGHT - 272) / 2);
    }
    
    	    
    private void drawYouWon(Graphics g) {

        String msg = "You Won!";
        Font small = new Font("Helvetica", Font.BOLD, 17);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - 268 - fm.stringWidth(msg)) / 2,
                (B_HEIGHT - 272) / 2);
    }
    
    
    private void drawOuttaControl(Graphics g) {

        String msg = "Dragons invasion brings the ship outta control...";
        Font small = new Font("Helvetica", Font.BOLD, 17);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - 268 - fm.stringWidth(msg)) / 2,
                (B_HEIGHT - 272) / 2);
    }

}