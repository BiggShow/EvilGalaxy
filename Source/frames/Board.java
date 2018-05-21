package frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import entities.Alien;
import entities.Bunker;
import entities.Dragon;
import entities.MyShip;
import entities.EvilHead;
import items.BunkerBullet;
import items.CanonBall;
import items.FireBall;
import items.Gold;
import items.HealthPack;
import items.ShipMissile;
import items.ShipRocket;
import items.VolBtn;
import sound_engine.PlayWave2nd;
import sound_engine.PlayWave1st;


@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {
	
    	static Image bg1;
    	Image bg2;
    	Image bg3;
    	static PlayWave2nd bgMusic = new PlayWave2nd("sounds/backmusic2.wav");
    	static PlayWave2nd roar = new PlayWave2nd("sounds/taunt.wav");
        static PlayWave2nd gameLost = new PlayWave2nd("sounds/fin.wav");
        static PlayWave2nd gameWon = new PlayWave2nd("sounds/highsc.wav");
        static PlayWave2nd gotHealthPack = new PlayWave2nd("sounds/magic.wav");
        static PlayWave2nd fuse = new PlayWave2nd("sounds/fuse.wav");
        private Console console;
        private Manual manual;
        private String unicode;
        private String checkMark;
        public static boolean consoleON = false;
        static boolean manualON = false;
        static Timer timerEasy;
        static Timer timerMedium;
        static Timer timerHard;
        static Bunker bunkerObj;
	    static MyShip myShip;
	    static EvilHead evilHead;
	    static VolBtn volButt;
	    static ArrayList<Alien> aliens;
	    private static ArrayList<Gold> goldstack;
	    static ArrayList<HealthPack> healthpack;
	    static ArrayList<Dragon> dragons;
	    static boolean ingame;
	    static boolean god = false;
	    private final int ICRAFT_X = 40;
	    private final int ICRAFT_Y = 180;
	    private final int ECRAFT_X = 640;
	    private final int ECRAFT_Y = 180;
	    private final int VOLBUT_X = 940;
	    private final int VOLBUT_Y = 15;
	    private final int STATIC_GUN_X = 450;
		private final int STATIC_GUN_Y = 650;
	    private final int B_WIDTH = 1310;
	    private final int B_HEIGHT = 1040;
	    private final int DELAY = 15;
	    static int lifeEvilHead = 3;
	    static int lifeMyShip = 3;
	    static int lifeBunker = 3;
	    

	    private final static int[][] posAlien = {
	        {1080, 333}, {500, 444}, {780, 59},
	        {910, 109}, {580, 139}, {680, 239},
	        {990, 159}, {760, 222}, {790, 150},
	        {785, 209}, {560, 59}, {510, 99},
	        {830, 159}, {590, 99}, {530, 859},
	        {940, 359}, {690, 111}, {620, 200},
	        {700, 459}, {660, 259}, {840, 29},
	        {810, 220}, {860, 259}, {740, 180},
	        {820, 128}, {490, 170}, {700, 49}
	    };
	    
	    private final static int[][] posGold = {
		        {500, 1029}, {290, 1180}, {330, 60},
		        {510, 1839}, {620, 1600},
		        {480, 1359}, {360, 1150}, {640, 90},
		        {430, 1420}, {560, 1520},
		        {455, 1228}, {600, 1130}
		    };
		   
	    private final static int[][] posDragon = {
		        {1380, 550}, {1580, 370}, {1680, 239},
		        {1390, 450}, {1460, 580}, {1790, 590},
		        {1400, 359}, {1460, 290}, {1540, 250},
		        {1410, 220}, {1560, 250}, {1740, 280},
		        {1420, 290}, {1590, 690}, {1700, 470},
		        {1380, 650}, {1580, 270}, {1680, 439},
		        {1390, 350}, {1460, 280}, {1790, 490},
		        {1400, 259}, {1460, 690}, {1540, 450},
		        {1410, 420}, {1560, 350}, {1740, 280},
		        {1420, 250}, {1590, 290}, {1700, 470}

	    };
	    
	    
	    private final static int[][] posHealthPack = {
	    		{540, 869}, {709, 1060}, {650, 240},
	    		{600, 500}, {500, 600}
		    };
		    
	    

	    public Board() {
	    	
	    	initBoard();    
	        
	    }
	    
    

	    private void initBoard() {
	    	
	    	addKeyListener(new TAdapter());
	        setFocusable(true);
	        bg1 = Toolkit.getDefaultToolkit().createImage("images/tenor.gif");
	        bg2 = Toolkit.getDefaultToolkit().createImage("images/galaxy2.jpg");
	        bg3 = Toolkit.getDefaultToolkit().createImage("images/galaxy3.jpg");
	        ingame = true;
	        
	        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

	        myShip = new MyShip(ICRAFT_X, ICRAFT_Y);
	        myShip.isVisible();
	        	        
	        evilHead = new EvilHead(ECRAFT_X, ECRAFT_Y);
	        evilHead.isVisible();
	        evilHead.AIOnEasy();
	        
	        volButt = new VolBtn(VOLBUT_X, VOLBUT_Y);
	        volButt.isVisible();
	        
	        bunkerObj = new Bunker(STATIC_GUN_X, STATIC_GUN_Y);
			bunkerObj.isVisible();
	        
	        initAliens();
	        initGold();
        	initDragons();
        	initHealth();
            
	        timerEasy = new Timer(DELAY, this);
	        timerMedium = new Timer(DELAY, this);
	        timerHard = new Timer(DELAY, this);
	        timerEasy.start();
	        gameWon.play();
	        bgMusic.loop();
        	       	
	    }
	    
	       
	    
	    public static void initAliens() {
	        aliens = new ArrayList<>();

	        for (int[] p : posAlien) {
	        	Alien born = new Alien(p[0], p[1]);
	        	aliens.add(born);
	            aliens.add(born);
	            //born.setVisible(false);
	        }
	    }
	    

	    
	    public static void initDragons() {
	        dragons = new ArrayList<>();
	        for (int[] p : posDragon) {
	        	Dragon born = new Dragon(p[0], p[1]);
	        	dragons.add(born);
	        	born.setVisible(false); 
	        }
	    }
	  
	    
	    public static void initGold() {
	        goldstack = new ArrayList<>();

	        for (int[] p : posGold) {
	        	goldstack.add(new Gold(p[0], p[1]));
	        }
	    }
	    
	    
	    public static void initHealth() {
	        healthpack = new ArrayList<>();

	        for (int[] p : posHealthPack) {
	        	healthpack.add(new HealthPack(p[0], p[1]));	
	        }
	        	        
	    }
	    
	    
	    
	    public void bgMusicOn(){
	    	
	    	bgMusic.stop();
        	
	    }
	    
		    
	    
	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        if (ingame && aliens.size() > 0) {

	        	drawObjects(g);
	        	
	            
	        }
	        
	        if(aliens.isEmpty() && timerMedium.isRunning() == false && timerHard.isRunning() == true){
	        	
	        	drawObjects2(g);
	        	
	        	if(dragons.size() > 0){
	        		g.drawString("Dragonzz: " + dragons.size(), 5, 15);
	        		g.drawString("Level: " + 2, 230, 15);
	        		g.drawString("Missiles: Locked", 320, 15);
	        		g.drawString("Rockets: Unlocked", 480, 15);
	        		g.drawString("Difficulty: Hard", 650, 15);
	        		drawOuttaControl(g);
	        		myShip.dragonShake();
	        		
	        		
	        	}
	        	updateDragons();
	        	roar.loop();
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

	        
	        
	        if(aliens.isEmpty() && timerMedium.isRunning() == false && timerHard.isRunning() == false){
	        	
	        	drawObjects2(g);
	        	
	        	if(dragons.size() > 0){
	        		g.drawString("Dragonzz: " + dragons.size(), 5, 15);
	        		g.drawString("Level: " + 2, 230, 15);
	        		g.drawString("Missiles: Locked", 320, 15);
	        		g.drawString("Rockets: Unlocked", 480, 15);
	        		g.drawString("Difficulty: Easy", 650, 15);
	        	}
	        	updateDragons();
	        	roar.loop();
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
	        
	        if(aliens.isEmpty() && timerMedium.isRunning() == true && timerHard.isRunning() == false){
	        	
	        	drawObjects2(g);
	        	
	        	if(dragons.size() > 0){
	        		g.drawString("Dragonzz: " + dragons.size(), 5, 15);
	        		g.drawString("Level: " + 2, 230, 15);
	        		g.drawString("Missiles: Locked", 320, 15);
	        		g.drawString("Rockets: Unlocked", 480, 15);
	        		g.drawString("Difficulty: Medium", 650, 15);
	        	}
	        	updateDragons();
	        	roar.loop();
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
	        	
	        	g.drawString("GODMODE!", myShip.x, myShip.y);
	        	myShip.godMode();
	        	
	        }        

	        if(lifeMyShip == 3){
	        	
	        	g.drawString("Health: 100%", myShip.x, myShip.y);
	        	
	        }
	        
	        if(lifeMyShip == 4){
	        	
	        	g.drawString("Health: 75%", myShip.x, myShip.y);
	        	
	        }
	       
	        if(lifeMyShip == 5){
	        	
	        	g.drawString("Health: 50%", myShip.x, myShip.y);
	        	
	        }
	       
	        if(lifeMyShip == 6){
	        	
	        	g.drawString("Health: 25%", myShip.x, myShip.y);
	        	
	        }
	        
			if(lifeMyShip > 6){
				        	
				ingame = false;
	        	
	        }
	        
	       	
	        
	        if(dragons.isEmpty()){
	        	
	        	drawObjects3(g);
	        	roar.stop();
	        }
	        
	        if(dragons.isEmpty() && lifeBunker == 50 && goldstack.size() > 0 && timerHard.isRunning() == true){
	        	
	        	drawCollect(g);
	        	g.drawString("Missiles: Locked", 320, 15);
        		g.drawString("Rockets: Locked", 480, 15);
        		g.drawString("Difficulty: Hard", 640, 15);
	        	
	        }
	        
	        if(dragons.isEmpty() && lifeBunker == 50 && goldstack.size() > 0 && timerHard.isRunning() == false && timerMedium.isRunning() == true){
	        	
	        	drawCollect(g);
	        	g.drawString("Missiles: Locked", 320, 15);
        		g.drawString("Rockets: Locked", 480, 15);
        		g.drawString("Difficulty: Medium", 640, 15);
	        	
	        }

	        
	        if(dragons.isEmpty() && lifeBunker == 50 && goldstack.size() > 0 && 
	        		timerHard.isRunning() == false && timerMedium.isRunning() == false){
	        	
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
	        		timerHard.isRunning() == false && timerMedium.isRunning() == true){
	        	
	        	drawKillTheBunker(g);
	        	g.drawString("Missiles: Unlocked", 320, 15);
	        	g.drawString("Rockets: Unlocked", 490, 15);	
	        	g.drawString("Difficulty: Medium", 670, 15);
	        }
	        
	        
	        
	        if(dragons.isEmpty() && lifeBunker < 50 &&
	        		timerHard.isRunning() == false && timerMedium.isRunning() == false){
	        	
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
	        		timerHard.isRunning() == false && timerMedium.isRunning() == true){
	        	
	        	drawKillTheHead(g);
	        	g.drawString("Missiles: Unlocked", 320, 15);
	        	g.drawString("Rockets: Unlocked", 490, 15);	
	        	g.drawString("Difficulty: Medium", 670, 15);
	        }
	        
	        
	        
	        if(dragons.isEmpty() && goldstack.isEmpty() && lifeBunker == 50 && 
	        		timerHard.isRunning() == false && timerMedium.isRunning() == false){
	        	
	        	drawKillTheHead(g);
	        	g.drawString("Missiles: Unlocked", 320, 15);
	        	g.drawString("Rockets: Unlocked", 490, 15);	
	        	g.drawString("Difficulty: Easy", 670, 15);
	        }
	        
	        
	        if(dragons.isEmpty() && goldstack.isEmpty() && lifeBunker == 50 && evilHead.x - myShip.x == 400 && timerEasy.isRunning() == true){
	        	evilHead.throwCanons();
	        	evilHead.strikeHead();
	        }
	        
	        	        	        
	        if(dragons.isEmpty() && goldstack.isEmpty() && lifeBunker == 50 && evilHead.x - myShip.x == 400 && timerMedium.isRunning() == true){
	        	evilHead.throwFireballs();
	        	evilHead.strikeHead();
	        }
	        
	        if(dragons.isEmpty() && goldstack.size() >= 0 && lifeBunker == 50 && evilHead.x - myShip.x == 400 && timerHard.isRunning() == true){
	        	evilHead.throwFireballs();
	        	evilHead.strikeHead();
	        }
	        
	        if(evilHead.x - myShip.x > 800 && dragons.isEmpty() && goldstack.isEmpty()
	        		&& lifeBunker == 50){
        		myShip.dragonShake();
        		myShip.y = evilHead.y + 70;
        	}
	        
	        
	        if(dragons.isEmpty() && lifeBunker < 10 && goldstack.size() > 0){
	        	g.drawString("EvilHead is waiting...", evilHead.x, evilHead.y);
	        	g.drawString("Health: 100%", bunkerObj.x, bunkerObj.y);
	        }
	        
	        
	        if(lifeBunker >= 10 && lifeBunker < 20 && goldstack.size() > 0){
	        	g.drawString("EvilHead is waiting...", evilHead.x, evilHead.y);
	        	g.drawString("Health: 80%", bunkerObj.x, bunkerObj.y);
	        	
	        }
	        
	        
	        if(lifeBunker >= 20 && lifeBunker < 30 && goldstack.size() > 0){
	        	g.drawString("EvilHead is waiting...", evilHead.x, evilHead.y);
	        	g.drawString("Health: 60%", bunkerObj.x, bunkerObj.y);
	        }
	        
	        if(lifeBunker >= 30 && lifeBunker < 35){
	        	roar.loop();
	        }
	        
	        if(lifeBunker >= 35){
	        	roar.stop();
	        }
	        
	        if(lifeBunker >= 30 && lifeBunker < 40 && goldstack.size() > 0){
	        	g.drawString("EvilHead is waiting...", evilHead.x, evilHead.y);
	        	g.drawString("Health: 40%", bunkerObj.x, bunkerObj.y);
	        }
	        
	        if(lifeBunker >= 40 && lifeBunker < 45){
	        	roar.loop();
	        }
	        
	        if(lifeBunker >= 45){
	        	roar.stop();
	        }
	        
	        if(lifeBunker >= 40 && lifeBunker < 50 && goldstack.size() > 0){
	        	g.drawString("EvilHead is waiting...", evilHead.x, evilHead.y);
	        	g.drawString("Health: 20%", bunkerObj.x, bunkerObj.y);
	        }
	       	
	        if(lifeBunker == 50){
	        	if(goldstack.size() > 0){
	        		g.drawString("EvilHead is waiting...", evilHead.x, evilHead.y);
	        	}
	        	g.drawString("Bunker destroyed!", bunkerObj.x, bunkerObj.y);
	        	bunkerObj.initBunkerHit();
	        }
	        
	        if(dragons.isEmpty() && goldstack.isEmpty() && lifeBunker == 50
	        		&& lifeEvilHead < 10){
	        	g.drawString("Health: 100%", evilHead.x, evilHead.y);
	        }
	        
	        
	        if(lifeEvilHead >= 10 && lifeEvilHead < 20){
	        	g.drawString("Health: 80%", evilHead.x, evilHead.y);
	        	
	        }
	        
	        
	        if(lifeEvilHead >= 20 && lifeEvilHead < 30){
	        	g.drawString("Health: 60%", evilHead.x, evilHead.y);
	        }
	        
	        if(lifeEvilHead >= 30 && lifeEvilHead < 35){
	        	roar.loop();
	        }
	        
	        if(lifeEvilHead >= 35){
	        	roar.stop();
	        }
	        
	        if(lifeEvilHead >= 30 && lifeEvilHead < 40){
	        	g.drawString("Health: 40%", evilHead.x, evilHead.y);
	        }
	        
	        if(lifeEvilHead >= 40 && lifeEvilHead < 45){
	        	roar.loop();
	        }
	        
	        if(lifeEvilHead >= 45){
	        	roar.stop();
	        }
	        
	        if(lifeEvilHead >= 40 && lifeEvilHead < 50){
	        	g.drawString("Health: 20%", evilHead.x, evilHead.y);
	        }
	       	        
	        if(lifeEvilHead == 50){
	        	
	        	gameWon.play();
	        	ingame = false;
		        g.drawImage(bg1, 0, 0, null);
	            drawYouWon(g);
	        	g.drawString("Monsters: Killed!", 5, 15);
		        g.drawString("Gold: Collected!", 165, 15);
	        	bgMusic.stop();
		        return;
	        }
	        
	        
	        if (!ingame) {

	        	gameLost.play();
		    	g.drawImage(bg1, 0, 0, null);
	            drawGameOver(g);
	            bgMusic.stop();
	            roar.stop();
	            Board.god = false;
	            g.drawString("Monsters left: " + 0, 5, 15);
		        g.drawString("Gold: " + 0, 150, 15);
		        g.drawString("Health: 0%", 230, 15);
		        timerEasy.stop();
		        timerMedium.stop();
		        timerHard.stop();
		        fuse.stop();
		        return;
	            
	        }

	        Toolkit.getDefaultToolkit().sync();
	    }
	    
	    


		private void drawObjects(Graphics g) {

	        if (evilHead.isVisible() && myShip.isVisible() && volButt.isVisible() && bunkerObj.isVisible() && g.drawImage(bg1, 0, 0, null)) {
	            g.drawImage(myShip.getImage(), myShip.getX(), myShip.getY(),
	                    this);
	            g.drawImage(evilHead.getImage(), evilHead.getX(), evilHead.getY(),
	                    this);
	            g.drawImage(volButt.getImage(), volButt.getX(), volButt.getY(),
	                    this);
	            g.drawImage(bunkerObj.getImage(), bunkerObj.getX(), bunkerObj.getY(), this);
	        }
	        
	        

	        @SuppressWarnings("unchecked")
			ArrayList<ShipMissile> ms = myShip.getMissiles();
	     
	        for (ShipMissile m : ms) {
	        	
	            if (m.isVisible()) {
	                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
	            }
	        }
	        
	        @SuppressWarnings("unchecked")
	        ArrayList<ShipRocket> rs = myShip.getRockets();

	        for (ShipRocket r : rs) {
	            if (r.isVisible()) {
	                g.drawImage(r.getImage(), r.getX(), r.getY(), this);
	            }
	        }
	        
	        
	        
	        @SuppressWarnings("unchecked")
			ArrayList<FireBall> guner = evilHead.getEvilMissiles();
	     
	        for (FireBall n : guner) {
	        	
	            if (n.isVisible()) {
	                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
	            }
	        }
	        
	        @SuppressWarnings("unchecked")
			ArrayList<CanonBall> can = evilHead.getCanons();
	     
	        for (CanonBall n : can) {
	        	
	            if (n.isVisible()) {
	                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
	            }
	        }
	        
	        
	        @SuppressWarnings("unchecked")
			ArrayList<BunkerBullet> bull = bunkerObj.getBullets();

			for (BunkerBullet n : bull) {

				if (n.isVisible()) {
					g.drawImage(n.getImage(), n.getX(), n.getY(), this);
				}
			}
	        
			
			@SuppressWarnings("unchecked")
			ArrayList<BunkerBullet> bull2 = bunkerObj.getBullets2();

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
	        
	        if(aliens.size() > 0 && timerHard.isRunning() == false && timerMedium.isRunning() == true){
	        	
	        	g.drawString("Aliens left: " + aliens.size(), 5, 15);
	        	g.drawString("Level: " + 1, 230, 15);
	        	g.drawString("Missiles: Unlocked", 320, 15);
	        	g.drawString("Rockets: Locked", 490, 15);
	        	g.drawString("Difficulty: Medium", 650, 15);
	        	
	        }

	        if(aliens.size() > 0 && timerHard.isRunning() == false && timerMedium.isRunning() == false){
	        	
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

	        if (evilHead.isVisible() && myShip.isVisible() && volButt.isVisible() && bunkerObj.isVisible() && g.drawImage(bg3, 0, 0, null)) {
	            g.drawImage(myShip.getImage(), myShip.getX(), myShip.getY(),
	                    this);
	            g.drawImage(evilHead.getImage(), evilHead.getX(), evilHead.getY(),
	                    this);
	            g.drawImage(volButt.getImage(), volButt.getX(), volButt.getY(),
	                    this);
	            g.drawImage(bunkerObj.getImage(), bunkerObj.getX(), bunkerObj.getY(), this);
	        }
	        
	        

	        @SuppressWarnings("unchecked")
			ArrayList<ShipMissile> ms = myShip.getMissiles();
	     
	        for (ShipMissile m : ms) {
	        	
	            if (m.isVisible()) {
	                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
	            }
	        }
	        
	        @SuppressWarnings("unchecked")
	        ArrayList<ShipRocket> rs = myShip.getRockets();

	        for (ShipRocket r : rs) {
	            if (r.isVisible()) {
	                g.drawImage(r.getImage(), r.getX(), r.getY(), this);
	            }
	        }
	        
	        
	        
	        @SuppressWarnings("unchecked")
			ArrayList<FireBall> guner = evilHead.getEvilMissiles();
	     
	        for (FireBall n : guner) {
	        	
	            if (n.isVisible()) {
	                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
	            }
	        }
	        
	        
	        @SuppressWarnings("unchecked")
			ArrayList<CanonBall> can = evilHead.getCanons();
	     
	        for (CanonBall n : can) {
	        	
	            if (n.isVisible()) {
	                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
	            }
	        }
	        
	        @SuppressWarnings("unchecked")
			ArrayList<BunkerBullet> bull = bunkerObj.getBullets();

			for (BunkerBullet n : bull) {

				if (n.isVisible()) {
					g.drawImage(n.getImage(), n.getX(), n.getY(), this);
				}
			}
	        
			@SuppressWarnings("unchecked")
			ArrayList<BunkerBullet> bull2 = bunkerObj.getBullets2();

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
	        	
	        	g.drawString("GODMODE!", myShip.x, myShip.y);
	        	
	        }
	        
	        
	        if(lifeMyShip == 3){
	        	
	        	g.drawString("Health: 100%", myShip.x, myShip.y);
	        	
	        }
	        
	        if(lifeMyShip == 4){
	        	
	        	g.drawString("Health: 75%", myShip.x, myShip.y);
	        	
	        }
	       
	        if(lifeMyShip == 5){
	        	
	        	g.drawString("Health: 50%", myShip.x, myShip.y);
	        	
	        }
	       
	        if(lifeMyShip == 6){
	        	
	        	g.drawString("Health: 25%", myShip.x, myShip.y);
	        	
	        }

	    	if(lifeMyShip > 6){
	        	
				ingame = false;
	        	
	        }
	    }
	    
	    
	    private void drawObjects2(Graphics g) {

	        if (evilHead.isVisible() && myShip.isVisible() && volButt.isVisible() && bunkerObj.isVisible() && g.drawImage(bg2, 0, 0, null)) {
	            g.drawImage(myShip.getImage(), myShip.getX(), myShip.getY(),
	                    this);
	            g.drawImage(evilHead.getImage(), evilHead.getX(), evilHead.getY(),
	                    this);
	            g.drawImage(volButt.getImage(), volButt.getX(), volButt.getY(),
	                    this);
	            g.drawImage(bunkerObj.getImage(), bunkerObj.getX(), bunkerObj.getY(), this);
	        }
	        
	        

	        @SuppressWarnings("unchecked")
			ArrayList<ShipMissile> ms = myShip.getMissiles();
	     
	        for (ShipMissile m : ms) {
	        	
	            if (m.isVisible()) {
	                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
	            }
	        }
	        
	        @SuppressWarnings("unchecked")
	        ArrayList<ShipRocket> rs = myShip.getRockets();

	        for (ShipRocket r : rs) {
	            if (r.isVisible()) {
	                g.drawImage(r.getImage(), r.getX(), r.getY(), this);
	            }
	        }
	        
	        
	        
	        @SuppressWarnings("unchecked")
			ArrayList<FireBall> fireballs = evilHead.getEvilMissiles();
	     
	        for (FireBall n : fireballs) {
	        	
	            if (n.isVisible()) {
	                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
	            }
	        }
	        
	        @SuppressWarnings("unchecked")
			ArrayList<BunkerBullet> bull = bunkerObj.getBullets();

			for (BunkerBullet n : bull) {

				if (n.isVisible()) {
					g.drawImage(n.getImage(), n.getX(), n.getY(), this);
				}
			}
			
			 @SuppressWarnings("unchecked")
				ArrayList<BunkerBullet> bull2 = bunkerObj.getBullets2();

				for (BunkerBullet n : bull2) {

					if (n.isVisible()) {
						g.drawImage(n.getImage(), n.getX(), n.getY(), this);
					}
				}
	        
	        @SuppressWarnings("unchecked")
			ArrayList<CanonBall> canonballs = evilHead.getCanons();
	     
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
	        
	        checkCollisions();

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

	        if (myShip.isVisible()) {
	            myShip.move();
	        }
	    }

	    private void updateMyShipMissiles() {

	        @SuppressWarnings("unchecked")
			ArrayList<ShipMissile> ms = myShip.getMissiles();
	        
	        
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
			ArrayList<BunkerBullet> bullets = bunkerObj.getBullets();
			@SuppressWarnings("unchecked")
			ArrayList<BunkerBullet> bullets2 = bunkerObj.getBullets2();  
 
			for (int i = 0; i < bullets.size(); i++) {

				BunkerBullet b = bullets.get(i);

				if (b.isVisible()) {
					b.moveDiagLeft();
					if(myShip.x > 200){
						b.moveDiagRight();
						b.moveRight();
					}
					
					
					else if(myShip.y > 300){
						b.moveDown();
						b.moveLeft();
					}
				}
				
				
				else {
					fuse.stop();
					bullets.remove(i);
				}
			}

			
			for (int i2 = 0; i2 < bullets2.size(); i2++) {

				BunkerBullet b2 = bullets2.get(i2);
				
				if (b2.isVisible()) {
					b2.moveDiagRight();
					if(myShip.x > 200){
						b2.moveDiagLeft();
						b2.moveLeft();
					}
					
					else if(myShip.y > 300){
						b2.moveDown();
						b2.moveLeft();
					}
				
				}
				
				
				else {
					fuse.stop();
					bullets2.remove(i2);
				}
			}

		
		}
	    
	    private void updateEvilHeadMissiles(){
	    	
	    		@SuppressWarnings("unchecked")
				ArrayList<FireBall> fireballs = evilHead.getEvilMissiles();
		        
		        
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
				ArrayList<CanonBall> canonballs = evilHead.getCanons();
		        
		        
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
			ArrayList<ShipRocket> rocketstack = myShip.getRockets();

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

		            if (a.isVisible() && timerHard.isRunning() == true && timerEasy.isRunning() == false && timerMedium.isRunning() == false){
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

	    		
	    	    if (evilHead.isVisible() && timerEasy.isRunning() == true && 
	    	    		(aliens.size() > 0 || dragons.size() > 0)) {
	                evilHead.AIOnEasy();
	            }
	    	    
	    	    if (evilHead.isVisible() && timerEasy.isRunning() == true && 
	    	    		dragons.isEmpty() && goldstack.size() >= 0) {
	                evilHead.AIOnEasy();
	            }
	    	    
	    	    if(evilHead.isVisible() && timerMedium.isRunning() == true && 
	    	    		dragons.isEmpty() && goldstack.size() >= 0){
	    	    	evilHead.AIOnMedium();
	    	    }
	    	    
	    	    
	    	    if (evilHead.isVisible() && timerMedium.isRunning() == true && 
	    	    		(aliens.size() > 0 || dragons.size() > 0)) {
	                evilHead.AIOnMedium();
	            } 
	    	    
	    	    if (evilHead.isVisible() && timerHard.isRunning() == true && 
	    	    		(aliens.size() > 0 || dragons.size() > 0)) {
	                evilHead.AIOnHard();
	            }
	    	    
	    	    if(evilHead.isVisible() && timerHard.isRunning() == true && 
	    	    		dragons.isEmpty() && goldstack.size() >= 0){
	    	    	evilHead.AIOnHard();
	    	    }
	    	    
	    }
	    
	    
	    private void updateDragons() {
	    	
	    		
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
	            	healthpack.add(i, new HealthPack(evilHead.x, evilHead.y));
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
	    
	    public void checkDragonsCollision() {
	    
	    	Rectangle myship = myShip.getBounds();
	    	
	    	for (Dragon dragon : dragons) {
	            Rectangle dragonUnit = dragon.getBounds();

	            if (myship.intersects(dragonUnit)) {
	        		lifeMyShip++;
	        		dragon.setVisible(false);
	        		new PlayWave1st("sounds/scream.wav").start();
	        		myShip.hitCraft();
	        		myShip.shakeCraft();	        		
            	}		
	        }
	    	
	    	@SuppressWarnings("unchecked")
	        ArrayList<ShipRocket> rocketstack = myShip.getRockets();
	        
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
	    
	

	    public static void checkCollisions() {

	        Rectangle myship = myShip.getBounds();
	        
	        Rectangle evilhead = evilHead.getBounds();
	        
	        Rectangle bunker = bunkerObj.getBounds();
	        
	        if(myship.intersects(evilhead)){
	        	
        			new PlayWave1st("sounds/scream.wav").start();
        			myShip.setVisible(false);
    		        evilHead.setVisible(false);
    		        ingame = false;
			        return;
	        	}
	        
        if(aliens.isEmpty() && dragons.isEmpty() && lifeBunker < 50){
        	
        	if(myship.intersects(bunker)){
	        	
    			new PlayWave1st("sounds/scream.wav").start();
    			new PlayWave1st("sounds/explosion.wav").start();
    			myShip.setVisible(false);
		        bunkerObj.setVisible(false);
		        ingame = false;
		        return;
        	}
        }
	        
	        
	        for (Alien alien : aliens) {
	        	
		        	        	
	            Rectangle alienUnit = alien.getBounds();
     
	            	if (myship.intersects(alienUnit)) {
		        		lifeMyShip++;
		        		alien.setVisible(false);
		        		new PlayWave1st("sounds/burned.wav").start();
		        		myShip.hitCraft();
		        		myShip.shakeCraft();
	            	}		
		        			
			     }
		        		
		        				        
	        for (Gold gold : goldstack) {
	        	Rectangle goldUnit = gold.getBounds();

	            if (myship.intersects(goldUnit)) {
	                gold.setVisible(false);
	                new PlayWave1st("sounds/collect.wav").start();
	            }
	        }
	        
	        for (HealthPack health : healthpack) {
	        	Rectangle healthUnit = health.getBounds();

	            if (myship.intersects(healthUnit)) {
	                health.setVisible(false);
	                gotHealthPack.play();
	            }
	        }

	        @SuppressWarnings("unchecked")
			ArrayList<ShipMissile> missiles = myShip.getMissiles();
	       
	        for (ShipMissile m : missiles) {

	            Rectangle missileUnit = m.getBounds();
	            

	            for (Alien alien : aliens) {

	                Rectangle alienUnit = alien.getBounds();

	                if (missileUnit.intersects(alienUnit)) {
	                    m.setVisible(false);
	                    alien.setVisible(false);
	                }
	            }

	            if(aliens.isEmpty() && dragons.isEmpty() && lifeBunker < 50){
	            	if(missileUnit.intersects(bunker)){
	            		bunkerObj.initBunkerHit();
	            		bunkerObj.loadBullet();
	    				bunkerObj.loadBullet2();
	            		m.setVisible(false);
	    				fuse.play();
	            		lifeBunker++;
	            	}
	            	
	            else{
            			
            			bunkerObj.initBunker();
            		}
	            	
	            }
	            	
	            
	            if(aliens.isEmpty() && 
	            		dragons.isEmpty() && goldstack.isEmpty() && lifeBunker == 50){
	            	if(missileUnit.intersects(evilhead)){
	            		m.setVisible(false);
	            		if(timerHard.isRunning() == true){
	            			evilHead.throwFireballs();
	            		}
	            		else{
	            			evilHead.throwCanons();
	            		}
		            	evilHead.strikeHead();
		            	lifeEvilHead++;
	            	}
	            	
	            }
	            
	            	            	            
	        }
	        
	        
	        @SuppressWarnings("unchecked")
			ArrayList<FireBall> fireballs = evilHead.getEvilMissiles();
	       
	        for (FireBall n : fireballs) {

	            	Rectangle fireballUnit = n.getBounds();
	            	            
	                Rectangle ship = myShip.getBounds();

	                if (fireballUnit.intersects(ship)) {
		        		lifeMyShip++;
		        		n.setVisible(false);
		        		new PlayWave1st("sounds/scream.wav").start();
		        		myShip.hitCraft();
		        		myShip.shakeCraft();
	            	}	
	        }
	        
	        @SuppressWarnings("unchecked")
			ArrayList<BunkerBullet> bullets = bunkerObj.getBullets();
	        
	       
	        for (BunkerBullet n : bullets) {

	            	Rectangle bulletUnit = n.getBounds();
	            	            
	                Rectangle ship = myShip.getBounds();
	                
	                if (bulletUnit.intersects(ship)) {
		        		lifeMyShip++;
		        		n.setVisible(false);
		        		new PlayWave1st("sounds/scream.wav").start();
		        		new PlayWave1st("sounds/explosion.wav").start();
		        		myShip.hitCraft();
		        		myShip.shakeCraft();
	            	}
	                
	        }

	        @SuppressWarnings("unchecked")
			ArrayList<BunkerBullet> bullets2 = bunkerObj.getBullets2();
	      
	        
	        for (BunkerBullet n : bullets2) {
	        
	            	Rectangle bulletUnit2 = n.getBounds();
	            	            
	                Rectangle ship = myShip.getBounds();

	                if (bulletUnit2.intersects(ship)) {
		        		lifeMyShip++;
		        		n.setVisible(false);
		        		new PlayWave1st("sounds/scream.wav").start();
		        		new PlayWave1st("sounds/explosion.wav").start();
		        		myShip.hitCraft();
		        		myShip.shakeCraft();
	            	}
	                	
	        }

	        @SuppressWarnings("unchecked")
			ArrayList<CanonBall> can = evilHead.getCanons();
	       
	        for (CanonBall n : can) {

	            	Rectangle r1 = n.getBounds();
	            	            
	              
	                if (r1.intersects(myship)) {
		        		lifeMyShip++;
		        		n.setVisible(false);
		        		new PlayWave1st("sounds/burned.wav").start();
		        		myShip.hitCraft();
		        		myShip.shakeCraft();
	            	}	
	        }
	        

	        
	        @SuppressWarnings("unchecked")
	        ArrayList<ShipRocket> rs = myShip.getRockets();
	        
	        for (ShipRocket r : rs) {

	            Rectangle rocketUnit = r.getBounds();

	            for (Alien alien : aliens) {

	                Rectangle alienUnit = alien.getBounds();

	                if (rocketUnit.intersects(alienUnit)) {
	                    r.setVisible(false);
	                    alien.setVisible(false);
	                    new PlayWave1st("sounds/scream.wav").start();
	                }
	            }
	            
	            
	            if(aliens.isEmpty() && 
	            		dragons.isEmpty() && goldstack.isEmpty() && lifeBunker == 50){
	            	if(rocketUnit.intersects(evilhead)){
	            		r.setVisible(false);
	            		if(timerHard.isRunning() == true){
	            			evilHead.throwFireballs();
	            		}
	            		else{
	            			evilHead.throwCanons();
	            		}
		            	evilHead.strikeHead();
		            	lifeEvilHead++;
	            	}
	            }
	            
	            if(aliens.isEmpty() && dragons.isEmpty() && lifeBunker < 50){
	            		if(rocketUnit.intersects(bunker)){
		            		bunkerObj.initBunkerHit();
		            		bunkerObj.loadBullet();
		    				bunkerObj.loadBullet2();
		    				r.setVisible(false);
		    				fuse.play();
		            		lifeBunker++;
		            	}
	            		
	            		
	            	else{
	            			
	            			bunkerObj.initBunker();
	            		}
	            		
	            	}
	            	
	            
	        }
	        
	      
	    }

	    public class TAdapter extends KeyAdapter {

	        @Override
	        public void keyReleased(KeyEvent e) {
	            myShip.keyReleased(e);
	        }
	        

	        @Override
	        public void keyPressed(KeyEvent e) {
	            myShip.keyPressed(e);
	            volButt.keyPressed(e);
	            int key = e.getKeyCode();
				
				if (key == KeyEvent.VK_S) {
					bgMusic.stop();
		        }
				
				if (key == KeyEvent.VK_A) {
					bgMusic.loop();
					if(!ingame || (timerEasy.isRunning() == false && timerHard.isRunning() == false && timerMedium.isRunning() == false)){
						bgMusic.stop();
					}
		        }
				
				if (key == KeyEvent.VK_P) {
					timerEasy.stop();
					timerHard.stop();
					timerMedium.stop();
	            	bgMusic.stop();
	            	roar.stop();
		        }
				
				
				if (ingame == true && (timerEasy.isRunning() == true || timerMedium.isRunning() == true || timerHard.isRunning() == true) && 
						key == KeyEvent.VK_CONTROL && 
						(aliens.isEmpty() && (dragons.size() > 0 || lifeBunker < 50 || goldstack.isEmpty()))) {
		            myShip.loadRockets();
		        }


				if (ingame == true && (timerEasy.isRunning() == true || timerMedium.isRunning() == true || timerHard.isRunning() == true) && 
						key == KeyEvent.VK_CONTROL && 
						(aliens.size() > 0 || (dragons.isEmpty() && lifeBunker == 50 && goldstack.size() > 0))) {
					myShip.gunempty();
				}
				
				if (ingame == true && (timerEasy.isRunning() == true || timerMedium.isRunning() == true || timerHard.isRunning() == true) && 
						key == KeyEvent.VK_SPACE && 
						(aliens.size() > 0 || (dragons.isEmpty() && lifeBunker < 50) || 
								(lifeBunker == 50 && goldstack.isEmpty()))) {
		            myShip.loadMissiles();
		        }
				
				if (ingame == true && (timerEasy.isRunning() == true || timerMedium.isRunning() == true || timerHard.isRunning() == true) && 
						key == KeyEvent.VK_SPACE && 
						(aliens.isEmpty() && dragons.size() > 0 || (dragons.isEmpty() && lifeBunker == 50 && goldstack.size() > 0))){
					myShip.gunempty();
				}
				
				
				
								
				if (key == KeyEvent.VK_2){
					
					if (Board.aliens.size() > 0) {
						Board.aliens.clear();
						return;
					}
					
				}
				
				if (key == KeyEvent.VK_3){
					
					if(Board.ingame == true && (Board.aliens.size() > 0 || Board.dragons.size() > 0)){
						Board.aliens.clear();
						Board.dragons.clear();
						return;
					}
				}
				
				if (key == KeyEvent.VK_4){
					
					if(Board.ingame == true && (Board.aliens.size() > 0 || Board.dragons.size() > 0 
							|| lifeBunker < 50)){
						Board.aliens.clear();
						Board.dragons.clear();
						lifeBunker = 50;
						return;
					}
				}
				
				if (key == KeyEvent.VK_R){
					
		            Board.god = false;
		            Board.manualON = false;
            	    setFocusable(true);
	    	        Board.bg1 = Toolkit.getDefaultToolkit().createImage("images/tenor.gif");
	    	        Board.ingame = true;
	    	        Board.lifeEvilHead = 3;
	    	        Board.lifeMyShip = 3;
	    	        Board.lifeBunker = 3;
	    	        
	    	        setPreferredSize(new Dimension(1310, 1040));

	    	        Board.myShip = new MyShip(40, 180);
	    	        Board.myShip.isVisible();
	    	        
	    	        Board.evilHead = new EvilHead(640, 180);
	    	        Board.evilHead.isVisible();
	    	        Board.evilHead.AIOnEasy();
	    	        
	    	        Board.volButt = new VolBtn(940, 15);
	    	        Board.volButt.isVisible();
	    	        
	    	        Board.bunkerObj = new Bunker(450, 650);
	    	        Board.bunkerObj.isVisible();

	    	        Board.initAliens();
	    	        Board.initGold();
	    	        Board.initDragons();
	    	        Board.initHealth();
	    	        
	    	        Board.timerHard.stop();
	    	        Board.timerMedium.stop();
	    	        Board.timerEasy.restart();
	    	        Board.gameWon.play();
	    	        Board.gameLost.stop();
	    	        Board.bgMusic.loop();
	    	        Board.roar.stop();
            		return;

				}
				
				
				if (key == KeyEvent.VK_E){
					
					Board.manualON = false;
					timerHard.stop();
					timerMedium.stop();
					timerEasy.start();
	            	bgMusic.loop();
	            	if(aliens.isEmpty()){
	            		roar.loop();
	            	}
	            	if(ingame == false){
		    	        setFocusable(true);
		    	        bg1 = Toolkit.getDefaultToolkit().createImage("images/tenor.gif");
		    	        ingame = true;
		    	        lifeEvilHead = 3;
		    	        lifeMyShip = 3;
		    	        lifeBunker = 3;
		    	        
		    	        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

		    	        myShip = new MyShip(ICRAFT_X, ICRAFT_Y);
		    	        myShip.isVisible();
		    	        
		    	        evilHead = new EvilHead(ECRAFT_X, ECRAFT_Y);
		    	        evilHead.isVisible();
		    	        evilHead.AIOnEasy();
		    	        
		    	        volButt = new VolBtn(VOLBUT_X, VOLBUT_Y);
		    	        volButt.isVisible();
		    	        
		    	        bunkerObj = new Bunker(STATIC_GUN_X, STATIC_GUN_Y);
		    			bunkerObj.isVisible();

		    	        initAliens();
		    	        initGold();
		    	        initDragons();
		    	        initHealth();
		    	        
		    	        timerHard.stop();
		    	        timerMedium.stop();
		    	        timerEasy.restart();
		            	gameWon.play();
		            	gameLost.stop();
		    	        bgMusic.loop();
	            		roar.stop();
	            	}
	            	
				}
				
				
			if (key == KeyEvent.VK_M){
					
					Board.manualON = false;
					timerEasy.stop();
					timerHard.stop();
					timerMedium.start();
	            	bgMusic.loop();
	            	if(aliens.isEmpty()){
	            		roar.loop();
	            	}
	            	if(ingame == false){
	 	    	        bg1 = Toolkit.getDefaultToolkit().createImage("images/tenor.gif");
		    	        ingame = true;
		    	        lifeEvilHead = 3;
		    	        lifeMyShip = 3;
		    	        lifeBunker = 3;
		    	        
		    	        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

		    	        myShip = new MyShip(ICRAFT_X, ICRAFT_Y);
		    	        myShip.isVisible();
		    	        
		    	        evilHead = new EvilHead(ECRAFT_X, ECRAFT_Y);
		    	        evilHead.isVisible();
		    	        evilHead.AIOnMedium();
		    	        
		    	        volButt = new VolBtn(VOLBUT_X, VOLBUT_Y);
		    	        volButt.isVisible();

		    	        bunkerObj = new Bunker(STATIC_GUN_X, STATIC_GUN_Y);
		    			bunkerObj.isVisible();

		    	        initAliens();
		    	        initGold();
		    	        initDragons();
		    	        initHealth();
		    	        
		    	        timerEasy.stop();
		    	        timerHard.stop();;
		    	        timerMedium.restart();
		            	gameWon.play();
		            	gameLost.stop();
		    	        bgMusic.loop();
		        		roar.stop();
	            	}
	            						
	
				}

				
				if (key == KeyEvent.VK_H){
					
					Board.manualON = false;
					timerEasy.stop();
					timerMedium.stop();
					timerHard.start();
	            	bgMusic.loop();
	            	if(aliens.isEmpty()){
	            		roar.loop();
	            	}
	            	if(ingame == false){
	 	    	        bg1 = Toolkit.getDefaultToolkit().createImage("images/tenor.gif");
		    	        ingame = true;
		    	        lifeEvilHead = 3;
		    	        lifeMyShip = 3;
		    	        lifeBunker = 3;
		    	        
		    	        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

		    	        myShip = new MyShip(ICRAFT_X, ICRAFT_Y);
		    	        myShip.isVisible();
		    	        
		    	        evilHead = new EvilHead(ECRAFT_X, ECRAFT_Y);
		    	        evilHead.isVisible();
		    	        evilHead.AIOnHard();
		    	        
		    	        volButt = new VolBtn(VOLBUT_X, VOLBUT_Y);
		    	        volButt.isVisible();

		    	        bunkerObj = new Bunker(STATIC_GUN_X, STATIC_GUN_Y);
		    			bunkerObj.isVisible();

		    	        initAliens();
		    	        initGold();
		    	        initDragons();
		    	        initHealth();
		    	        
		    	        timerEasy.stop();
		    	        timerMedium.stop();
		    	        timerHard.restart();
		            	gameWon.play();
		            	gameLost.stop();
		    	        bgMusic.loop();
		        		roar.stop();
	            	}
	            	    	
				}
				
				
				if (key == KeyEvent.VK_G){
					
					if(!god){
						
						god = true;
						Board.lifeMyShip = -999;
						return;
					}
					
					else{
						
							god = false;
							Board.lifeMyShip = 3;
							return;
						
					}
										
				}
				
								
				
				console = new Console();
				
				if (key == KeyEvent.VK_C && !consoleON){	
					
					console.setVisible(true);
                    if(!consoleON == true){
                    	
                    	consoleON = true;
                    }
                    
				}
				
				if (key == KeyEvent.VK_O && !manualON){	
					
					manual = new Manual();						
					manual.setVisible(true);
					
					if(!manualON == true){
                    	
						manualON = true;
                    }
                    
				}

				if (key == KeyEvent.VK_ESCAPE){

					System.exit(0);
					
				}
							

	        }
	        
	    }

	}