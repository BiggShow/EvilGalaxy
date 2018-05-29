package game_engine;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import entities.Alien;
import entities.Bunker;
import entities.Dragon;
import entities.MyShip;
import frames.Console;
import frames.Manual;
import entities.EvilHead;
import items.Gold;
import items.HealthPack;
import items.VolBtn;
import sound_engine.LoadSounds;

@SuppressWarnings("serial")
public abstract class InitObjects extends JPanel implements ActionListener {
	
		public static boolean consoleON;
	    public static boolean manualON;
	    public static boolean ingame;
	    public static boolean god;
	    static Console console;
        static Manual manual;
        public static Timer timerEasy;
        public static Timer timerMedium;
        public static Timer timerHard;
	    final static int ICRAFT_X = 40;
	    final static int ICRAFT_Y = 180;
	    final static int ECRAFT_X = 640;
	    final static int ECRAFT_Y = 180;
	    final static int VOLBUT_X = 940;
	    final static int VOLBUT_Y = 15;
	    final static int BUNKER_X = 450;
	    final static int BUNKER_Y = 680;
	    final static int B_WIDTH = 1310;
	    final static int B_HEIGHT = 1040;
	    private final int DELAY = 15;
	    

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
		    
	    

	    public InitObjects() {
	    	
	    	initBoard();    
	        
	    }
	    
    
	    private void initBoard() {
	    	
	    	addKeyListener(new Controls());
	        setFocusable(true);
	        ingame = true;
	        
	        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

	        MyShip.myShip = new MyShip(ICRAFT_X, ICRAFT_Y);
	        MyShip.myShip.isVisible();
	        	        
	        EvilHead.evilHead = new EvilHead(ECRAFT_X, ECRAFT_Y);
	        EvilHead.evilHead.isVisible();
	        EvilHead.evilHead.AIOnEasy();
	        
	        VolBtn.volButt = new VolBtn(VOLBUT_X, VOLBUT_Y);
	        VolBtn.volButt.isVisible();
	        
	        Bunker.bunkerObj = new Bunker(BUNKER_X, BUNKER_Y);
	        Bunker.bunkerObj.isVisible();
	        
	        initAliens();
	        initGold();
        	initDragons();
        	initHealth();
            
	        timerEasy = new Timer(DELAY, this);
	        timerMedium = new Timer(DELAY, this);
	        timerHard = new Timer(DELAY, this);
	        timerEasy.start();
	        LoadSounds.gameWon.play();
	        LoadSounds.bgMusic.loop();
	    }
	    
	       
	    
	    static void initAliens() {
	        Alien.aliens = new ArrayList<>();

	        for (int[] p : posAlien) {
	        	Alien born = new Alien(p[0], p[1]);
	        	Alien.aliens.add(born);
	        	Alien.aliens.add(born);
	        }
	    }
	    

	    
	    static void initDragons() {
	        Dragon.dragons = new ArrayList<>();
	        for (int[] p : posDragon) {
	        	Dragon born = new Dragon(p[0], p[1]);
	        	Dragon.dragons.add(born);
	        	born.setVisible(false); 
	        }
	    }
	  
	    
	    static void initGold() {
	        Gold.goldstack = new ArrayList<>();

	        for (int[] p : posGold) {
	        	Gold.goldstack.add(new Gold(p[0], p[1]));
	        }
	    }
	    
	    
	    static void initHealth() {
	    	HealthPack.healthpack = new ArrayList<>();

	        for (int[] p : posHealthPack) {
	        	HealthPack.healthpack.add(new HealthPack(p[0], p[1]));	
	        }
	        	        
	    }   
	    
}