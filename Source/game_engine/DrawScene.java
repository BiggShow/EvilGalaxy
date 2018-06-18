package game_engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
//import com.sun.speech.freetts.Voice;
//import com.sun.speech.freetts.VoiceManager;
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
import sound_engine.LoadSounds;

public class DrawScene extends UpdateObjects {


	private String unicode;
	private String checkMark;
	private static final long serialVersionUID = 1L;
	static Image bg1;
    static Image bg2;
	static Image bg3;
//	private static final String VOICENAME = "kevin16"; 
//	static boolean voiceStopped;
//	static Voice voice;
//	public static int voiceInterruptor;

	
	public DrawScene() {
        bg1 = Toolkit.getDefaultToolkit().createImage("images/tenor.gif");
        bg2 = Toolkit.getDefaultToolkit().createImage("images/galaxy2.jpg");
        bg3 = Toolkit.getDefaultToolkit().createImage("images/galaxy3.jpg");		
	}
	
	
//	public static void initVoice(String message){	
//
//    	VoiceManager vm = VoiceManager.getInstance();
//    	voice = vm.getVoice(VOICENAME);
//    	voice.allocate();
//    	voice.speak(message);
//		
//    	if(voiceStopped == false){
//    		voice.speak(message);
//    		voiceStopped = true;
//    	}
//
//	}
		
	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame && Alien.aliens.size() > 0) {
        	drawObjects(g);  
        }
        
        
        if(Alien.aliens.isEmpty()){
        	
        	if(!timerMedium.isRunning() && timerHard.isRunning() == true){
            	
            	drawObjects2(g);
            	
            	if(Dragon.dragons.size() > 0){
            		g.drawString("Dragonzz: " + Dragon.dragons.size(), 5, 15);
            		g.drawString("Level: " + 2, 230, 15);
            		g.drawString("Missiles: Locked", 320, 15);
            		g.drawString("Rockets: Unlocked", 480, 15);
            		g.drawString("Difficulty: Hard", 650, 15);
            		drawOuttaControl(g);
            		MyShip.myShip.dragonShake();		
            	}
            	
            	UpdateObjects.updateDragons();
            	LoadSounds.roar.loop();
            	if(Dragon.dragons.isEmpty() && lifeBunker < 50){
            		g.drawString("Dragonzz: " + checkMark, 5, 15);
            		g.drawString("Level: " + 3, 230, 15);
            		g.drawString("Missiles: Unlocked", 320, 15);
            		g.drawString("Rockets: Unlocked", 490, 15);
            		g.drawString("Difficulty: Hard", 670, 15);
            	}
            	
            	if(lifeBunker >= 50){
            		g.drawString("Dragonzz: " + checkMark, 5, 15);
            		g.drawString("Level: " + 4, 230, 15);
            		g.drawString("Missiles: Unlocked", 320, 15);
            		g.drawString("Rockets: Unlocked", 490, 15);
            		g.drawString("Difficulty: Hard", 670, 15);
            	}
            	
            }
            
            
            if(!timerMedium.isRunning() && !timerHard.isRunning()){
            	
            	drawObjects2(g);
            	
            	if(Dragon.dragons.size() > 0){
            		g.drawString("Dragonzz: " + Dragon.dragons.size(), 5, 15);
            		g.drawString("Level: " + 2, 230, 15);
            		g.drawString("Missiles: Locked", 320, 15);
            		g.drawString("Rockets: Unlocked", 480, 15);
            		g.drawString("Difficulty: Easy", 650, 15);
            	}
            	UpdateObjects.updateDragons();
            	LoadSounds.roar.loop();
            	if(Dragon.dragons.isEmpty() && lifeBunker < 50){
            		g.drawString("Dragonzz: " + checkMark, 5, 15);
            		g.drawString("Level: " + 3, 230, 15);
            		g.drawString("Missiles: Unlocked", 320, 15);
            		g.drawString("Rockets: Unlocked", 490, 15);
            		g.drawString("Difficulty: Easy", 670, 15);
            	}
            	
            	if(lifeBunker >= 50){
            		g.drawString("Dragonzz: " + checkMark, 5, 15);
            		g.drawString("Level: " + 4, 230, 15);
            		g.drawString("Missiles: Unlocked", 320, 15);
            		g.drawString("Rockets: Unlocked", 490, 15);
            		g.drawString("Difficulty: Hard", 670, 15);
            	}
            	
            }
            

            
            if(timerMedium.isRunning() == true && !timerHard.isRunning()){
            	
            	drawObjects2(g);
            	
            	if(Dragon.dragons.size() > 0){
            		g.drawString("Dragonzz: " + Dragon.dragons.size(), 5, 15);
            		g.drawString("Level: " + 2, 230, 15);
            		g.drawString("Missiles: Locked", 320, 15);
            		g.drawString("Rockets: Unlocked", 480, 15);
            		g.drawString("Difficulty: Medium", 650, 15);
            	}
            	UpdateObjects.updateDragons();
            	LoadSounds.roar.loop();
            	if(Dragon.dragons.isEmpty() && lifeBunker < 50){
            		g.drawString("Dragonzz: " + checkMark, 5, 15);
            		g.drawString("Level: " + 3, 230, 15);
            		g.drawString("Missiles: Unlocked", 320, 15);
            		g.drawString("Rockets: Unlocked", 490, 15);
            		g.drawString("Difficulty: Medium", 670, 15);
            	}
            	
            	if(lifeBunker >= 50){
            		g.drawString("Dragonzz: " + checkMark, 5, 15);
            		g.drawString("Level: " + 4, 230, 15);
            		g.drawString("Missiles: Unlocked", 320, 15);
            		g.drawString("Rockets: Unlocked", 490, 15);
            		g.drawString("Difficulty: Hard", 670, 15);
            	}
            	
            }
        }



        if(lifeMyShip < 3){
//        	voiceInterruptor++;
//        	if(voiceInterruptor != 0){
//        		g.drawString("GODMODE!", MyShip.myShip.x, MyShip.myShip.y);
//        	}
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
       
//        if(lifeMyShip == 6 && voiceInterruptor == 0){
//        	initVoice("Critical!");
//        	voiceInterruptor++;
//        	return;
//        }
        
//        if(lifeMyShip != 6){
//    		voiceInterruptor = 0;
//    	}
        
//		if(lifeMyShip > 6){
//			initVoice("Game Over!");        	
//			ingame = false;
//        }
        
       	        
        if(Dragon.dragons.isEmpty()){
        	
        	drawObjects3(g);
        	LoadSounds.roar.stop();
        }
        
        if(Dragon.dragons.isEmpty() && lifeBunker >= 50 && Gold.goldstack.size() > 0 && timerHard.isRunning() == true){
        	
        	drawCollect(g);
        	g.drawString("Missiles: Locked", 320, 15);
    		g.drawString("Rockets: Locked", 480, 15);
    		g.drawString("Difficulty: Hard", 640, 15);
        	
        }
        
        if(Dragon.dragons.isEmpty() && lifeBunker >= 50 && Gold.goldstack.size() > 0 && !timerHard.isRunning() && timerMedium.isRunning() == true){
        	
        	drawCollect(g);
        	g.drawString("Missiles: Locked", 320, 15);
    		g.drawString("Rockets: Locked", 480, 15);
    		g.drawString("Difficulty: Medium", 640, 15);
        	
        }

        
        if(Dragon.dragons.isEmpty() && lifeBunker >= 50 && Gold.goldstack.size() > 0 && 
        		!timerHard.isRunning() && !timerMedium.isRunning()){
        	
        	drawCollect(g);
        	g.drawString("Missiles: Locked", 320, 15);
    		g.drawString("Rockets: Locked", 480, 15);
    		g.drawString("Difficulty: Easy", 640, 15);
        	
        }
        
        
        if(Dragon.dragons.isEmpty() && lifeBunker < 50 &&
        		timerHard.isRunning() == true){
        	
        	drawKillTheBunker(g);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Unlocked", 490, 15);	
        	g.drawString("Difficulty: Hard", 670, 15);
        }
        
        if(Dragon.dragons.isEmpty() && lifeBunker < 50 &&
        		!timerHard.isRunning() && timerMedium.isRunning() == true){
        	
        	drawKillTheBunker(g);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Unlocked", 490, 15);	
        	g.drawString("Difficulty: Medium", 670, 15);
        }
        
        
        
        if(Dragon.dragons.isEmpty() && lifeBunker < 50 &&
        		!timerHard.isRunning() && !timerMedium.isRunning()){
        	
        	drawKillTheBunker(g);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Unlocked", 490, 15);	
        	g.drawString("Difficulty: Easy", 670, 15);
        }
        
        if(Dragon.dragons.isEmpty() && Gold.goldstack.isEmpty() && lifeBunker >= 50 && 
        		timerHard.isRunning() == true /*&& voiceInterruptor == 0*/){

        	drawKillTheHead(g);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Unlocked", 490, 15);	
        	g.drawString("Difficulty: Hard", 670, 15);
        }
        
        if(Dragon.dragons.isEmpty() && Gold.goldstack.isEmpty() && lifeBunker >= 50 && 
        		!timerHard.isRunning() && timerMedium.isRunning() == true){
        	
        	drawKillTheHead(g);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Unlocked", 490, 15);	
        	g.drawString("Difficulty: Medium", 670, 15);
        }
        
        
        
        if(Dragon.dragons.isEmpty() && Gold.goldstack.isEmpty() && lifeBunker >= 50 && 
        		!timerHard.isRunning() && !timerMedium.isRunning()){
        	
        	drawKillTheHead(g);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Unlocked", 490, 15);	
        	g.drawString("Difficulty: Easy", 670, 15);
        }
        
        
        if(Dragon.dragons.isEmpty() && Gold.goldstack.isEmpty() && lifeBunker >= 50 
        		&& EvilHead.evilHead.x - MyShip.myShip.x == 400 && timerEasy.isRunning() == true){
        	EvilHead.evilHead.throwCanons();
        	EvilHead.evilHead.strikeHead();
        }
        
        	        	        
        if(Dragon.dragons.isEmpty() && Gold.goldstack.isEmpty() && lifeBunker >= 50 
        		&& EvilHead.evilHead.x - MyShip.myShip.x == 400 && timerMedium.isRunning() == true){
        	EvilHead.evilHead.throwFireballs();
        	EvilHead.evilHead.strikeHead();
        }
        
        if(Dragon.dragons.isEmpty() && Gold.goldstack.size() >= 0 && lifeBunker >= 50 
        		&& EvilHead.evilHead.x - MyShip.myShip.x == 400 && timerHard.isRunning() == true){
        	EvilHead.evilHead.throwFireballs();
        	EvilHead.evilHead.strikeHead();
        }
        
        if(EvilHead.evilHead.x - MyShip.myShip.x > 800 && Dragon.dragons.isEmpty() && Gold.goldstack.isEmpty()
        		&& lifeBunker >= 50){
        	MyShip.myShip.dragonShake();
        	MyShip.myShip.y = EvilHead.evilHead.y + 70;
    	}
        
        
        if(Dragon.dragons.isEmpty() && lifeBunker < 10 && Gold.goldstack.size() > 0){
        	g.drawString("EvilHead is waiting...", EvilHead.evilHead.x, EvilHead.evilHead.y);
        	g.drawString("Health: 100%", Bunker.bunkerObj.x, Bunker.bunkerObj.y);
        }
        
        
        if(lifeBunker >= 10 && lifeBunker < 20 && Gold.goldstack.size() > 0){
        	g.drawString("EvilHead is waiting...", EvilHead.evilHead.x, EvilHead.evilHead.y);
        	g.drawString("Health: 80%", Bunker.bunkerObj.x, Bunker.bunkerObj.y);
        	
        }
        
        
        if(lifeBunker >= 20 && lifeBunker < 30 && Gold.goldstack.size() > 0){
        	g.drawString("EvilHead is waiting...", EvilHead.evilHead.x, EvilHead.evilHead.y);
        	g.drawString("Health: 60%", Bunker.bunkerObj.x, Bunker.bunkerObj.y);
        }
        
        if(lifeBunker >= 30 && lifeBunker < 35){
        	LoadSounds.roar.loop();
        }
        
        if(lifeBunker >= 35){
        	LoadSounds.roar.stop();
        }
        
        if(lifeBunker >= 30 && lifeBunker < 40 && Gold.goldstack.size() > 0){
        	g.drawString("EvilHead is waiting...", EvilHead.evilHead.x, EvilHead.evilHead.y);
        	g.drawString("Health: 40%", Bunker.bunkerObj.x, Bunker.bunkerObj.y);
        }
        
        if(lifeBunker >= 40 && lifeBunker < 45){
        	LoadSounds.roar.loop();
        }
        
        if(lifeBunker >= 45){
        	LoadSounds.roar.stop();
        }
        
        if(lifeBunker >= 40 && lifeBunker < 50 && Gold.goldstack.size() > 0){
        	g.drawString("EvilHead is waiting...", EvilHead.evilHead.x, EvilHead.evilHead.y);
        	g.drawString("Health: 20%", Bunker.bunkerObj.x, Bunker.bunkerObj.y);
        }
       	
        if(lifeBunker == 50){
        	
//        	initVoice("Bunker destroyed!");
//        	initVoice("Level 4!");
//        	lifeBunker++;
        	
        	if(Gold.goldstack.size() > 0){
        		g.drawString("EvilHead is waiting...", EvilHead.evilHead.x, EvilHead.evilHead.y);
        	}
        	
        	Bunker.bunkerObj.initBunkerHit();
        }
        

    	if(lifeBunker > 50){
    		g.drawString("Bunker destroyed!", Bunker.bunkerObj.x, Bunker.bunkerObj.y);
    	}
        
        if(Dragon.dragons.isEmpty() && Gold.goldstack.isEmpty() && lifeBunker >= 50
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
        	LoadSounds.roar.loop();
        }
        
        if(lifeEvilHead >= 35){
        	LoadSounds.roar.stop();
        }
        
        if(lifeEvilHead >= 30 && lifeEvilHead < 40){
        	g.drawString("Health: 40%", EvilHead.evilHead.x, EvilHead.evilHead.y);
        }
        
        if(lifeEvilHead >= 40 && lifeEvilHead < 45){
        	LoadSounds.roar.loop();
        }
        
        if(lifeEvilHead >= 45){
        	LoadSounds.roar.stop();
        }
        
        if(lifeEvilHead >= 40 && lifeEvilHead < 50){
        	g.drawString("Health: 20%", EvilHead.evilHead.x, EvilHead.evilHead.y);
        }
       	        
        if(lifeEvilHead == 50){
        	
        	LoadSounds.gameWon.play();
        	ingame = false;
	        g.drawImage(bg1, 0, 0, null);
            drawYouWon(g);
        	g.drawString("Monsters: Killed!", 5, 15);
	        g.drawString("Gold: Collected!", 165, 15);
	        LoadSounds.bgMusic.stop();
	        return;
        }
        
        
        if (!ingame) {

        	LoadSounds.gameLost.play();
	    	g.drawImage(bg1, 0, 0, null);
            drawGameOver(g);
            LoadSounds.bgMusic.stop();
            LoadSounds.roar.stop();
            god = false;
            g.drawString("Monsters left: " + 0, 5, 15);
	        g.drawString("Gold: " + 0, 150, 15);
	        g.drawString("Health: 0%", 230, 15);
	        timerEasy.stop();
	        timerMedium.stop();
	        timerHard.stop();
	        LoadSounds.fuse.stop();
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


        for (Alien alien : Alien.aliens) {
            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }
        }
        
       for (Dragon dragon : Dragon.dragons) {
            if (dragon.isVisible()) {
                g.drawImage(dragon.getImage(), dragon.getX(), dragon.getY(), this);
            }
        } 
        
        
        for (Gold gold : Gold.goldstack) {
            if (gold.isVisible()) {
                g.drawImage(gold.getImage(), gold.getX(), gold.getY(), this);
            }
        }
        
        for (HealthPack health : HealthPack.healthpack) {
            if (health.isVisible()) {
                g.drawImage(health.getImage(), health.getX(), health.getY(), this);
            }
        }
        
        
        Font small = new Font("Helvetica", Font.BOLD, 17);
        g.setColor(Color.WHITE);
        g.setFont(small);
        
        unicode = "2713";
        checkMark = String.valueOf(Character.toChars(Integer.parseInt(unicode, 16)));
     
        if(Alien.aliens.size() > 0 && timerHard.isRunning() == true){
        	
        	g.drawString("Aliens left: " + Alien.aliens.size(), 5, 15);
        	g.drawString("Level: " + 1, 230, 15);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Locked", 490, 15);
        	g.drawString("Difficulty: Hard", 650, 15);
        	
        }
        
        if(Alien.aliens.size() > 0 && !timerHard.isRunning() && timerMedium.isRunning() == true){
        	
        	g.drawString("Aliens left: " + Alien.aliens.size(), 5, 15);
        	g.drawString("Level: " + 1, 230, 15);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Locked", 490, 15);
        	g.drawString("Difficulty: Medium", 650, 15);
        	
        }

        if(Alien.aliens.size() > 0 && !timerHard.isRunning() && !timerMedium.isRunning()){
        	
        	g.drawString("Aliens left: " + Alien.aliens.size(), 5, 15);
        	g.drawString("Level: " + 1, 230, 15);
        	g.drawString("Missiles: Unlocked", 320, 15);
        	g.drawString("Rockets: Locked", 490, 15);
        	g.drawString("Difficulty: Easy", 650, 15);
        }
       
        if(Gold.goldstack.size() > 0){
        	g.drawString("Gold: " + (-(Gold.goldstack.size() - 12)), 140, 15);
        }
        
        if(Gold.goldstack.isEmpty()){
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

        for (Alien a : Alien.aliens) {
            if (a.isVisible()) {
                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
        }
        
       for (Dragon d : Dragon.dragons) {
            if (d.isVisible()) {
                g.drawImage(d.getImage(), d.getX(), d.getY(), this);
            }
        } 
        
        
        for (Gold b : Gold.goldstack) {
            if (b.isVisible()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }
        
        for (HealthPack b : HealthPack.healthpack) {
            if (b.isVisible()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }
        
        
        Font small = new Font("Helvetica", Font.BOLD, 17);
        g.setColor(Color.WHITE);
        g.setFont(small);
        
        unicode = "2713";
        checkMark = String.valueOf(Character.toChars(Integer.parseInt(unicode, 16)));

        if(Alien.aliens.size() > 0){
        	
        	g.drawString("Aliens left: " + Alien.aliens.size(), 5, 15);
        	g.drawString("Level: " + 1, 230, 15);
	        
        }
        
//        if(Dragon.dragons.isEmpty() && voiceInterruptor == 0){
//        	if(lifeBunker < 50){
//        		initVoice("Loading level 3!");
//        		voiceInterruptor++;
//        		return;
//        	}
//    	}
        
        if(lifeBunker < 50){
    		g.drawString("Dragonzz: " + checkMark, 5, 15);
    		g.drawString("Level: " + 3, 230, 15);	
    	}
        
        if(lifeBunker >= 50){
    		g.drawString("Dragonzz: " + checkMark, 5, 15);
    		g.drawString("Level: " + 4, 230, 15);
    	}
       
        if(Gold.goldstack.size() > 0){
        	g.drawString("Gold: " + (-(Gold.goldstack.size() - 12)), 140, 15);
        }
        
        if(Gold.goldstack.isEmpty()){
    		g.drawString("Gold: " + checkMark, 140, 15);
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

        for (Alien a : Alien.aliens) {
            if (a.isVisible()) {
                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
        }
        
       for (Dragon d : Dragon.dragons) {
            if (d.isVisible()) {
                g.drawImage(d.getImage(), d.getX(), d.getY(), this);
            }
        } 
        
        
        for (Gold b : Gold.goldstack) {
            if (b.isVisible()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }
        
        for (HealthPack b : HealthPack.healthpack) {
            if (b.isVisible()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }
        
        
        Font small = new Font("Helvetica", Font.BOLD, 17);
        g.setColor(Color.WHITE);
        g.setFont(small);
        
        unicode = "2713";
        checkMark = String.valueOf(Character.toChars(Integer.parseInt(unicode, 16)));

        if(Alien.aliens.size() > 0){
        	
        	g.drawString("Aliens left: " + Alien.aliens.size(), 5, 15);
        	g.drawString("Level: " + 1, 230, 15);
	        
        }
       
        if(Gold.goldstack.size() > 0){
        	g.drawString("Gold: " + (-(Gold.goldstack.size() - 12)), 140, 15);
        }
        
        if(Gold.goldstack.isEmpty()){
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