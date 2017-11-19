package space;

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
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {
	
    	Image img;
    	Image img2;
    	Image img3;
    	Sound Bgmusic = new Sound("backmusic2.wav");
    	Sound Bgmusic2 = new Sound("backmusic.wav");
        Sound Bossroar = new Sound("taunt.wav");
        Sound GameLost = new Sound("fin.wav");
        Sound GameWon = new Sound("highsc.wav");
        Sound Healthy = new Sound("magic.wav");
        //Sound Attack = new Sound("attack.wav");
        //Sound HeadShot = new Sound("denied.wav");
        private String c;
        private String tick;
        private Timer timer;
	    private Craft craft;
	    private EnemyShip enemy;
	    private VolButt voll;
	    private ArrayList<Alien> aliens;
	    private ArrayList<Gifts> gifts;
	    private ArrayList<Health> health;
	    private ArrayList<Boss> boss;
	    private boolean ingame;
	    private final int ICRAFT_X = 40;
	    private final int ICRAFT_Y = 180;
	    private final int ECRAFT_X = 640;
	    private final int ECRAFT_Y = 180;
	    private final int VOLBUT_X = 940;
	    private final int VOLBUT_Y = 15;
	    private final int B_WIDTH = 1310;
	    private final int B_HEIGHT = 1040;
	    private final int DELAY = 15;
	    private int lifepack_head = 3;
	    private int lifepack_craft = 3;
        //ImageIcon  tileIcon = new ImageIcon("shadow1.png"); 
	    String buttonText = "Restart";
	    JButton restartButton = new JButton(buttonText);
	    String buttonText2 = "Resume";
	    JButton continueButton = new JButton(buttonText2);
	    String buttonText3 = "Pause";
	    JButton pauseButton = new JButton(buttonText3);
	    

	    private final int[][] pos = {
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
	    
	    private final int[][] pos2 = {
		        {500, 1029}, {290, 1180}, {330, 60},
		        {510, 1839}, {620, 1600},
		        {480, 1359}, {360, 1150}, {640, 90},
		        {430, 1420}, {560, 1520},
		        {455, 1228}, {600, 1130}
		    };
		   
	    private final int[][] pos3 = {
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
	    
	    
	    private final int[][] pos4 = {
	    		{540, 869}, {709, 1060}, {650, 240},
	    		{600, 500}, {500, 600}
		    };
		    
	    

	    public Board() {
	    	
	    	

	    	initBoard();
	    
	        
	    }
	    
    

	    private void initBoard() {
	    	
	    	addKeyListener(new TAdapter());
	        //addRestartButton();
	        //addStartButton();
	        //addPauseButton();
	        setFocusable(true);
	        //setBackground(Color.BLACK);
	        img = Toolkit.getDefaultToolkit().createImage("tenor.gif");
	        img2 = Toolkit.getDefaultToolkit().createImage("galaxy2.jpg");
	        img3 = Toolkit.getDefaultToolkit().createImage("galaxy3.jpg");
	        ingame = true;
	        
	        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

	        craft = new Craft(ICRAFT_X, ICRAFT_Y);
	        craft.isVisible();
	        
	        enemy = new EnemyShip(ECRAFT_X, ECRAFT_Y);
	        enemy.isVisible();
	        enemy.move();
	        	        
	        voll = new VolButt(VOLBUT_X, VOLBUT_Y);
	        voll.isVisible();
	        
	        initAliens();
	        initGifts();
        	initBoss();
        	initHealth();
            
	        timer = new Timer(DELAY, this);
	        timer.start();
	        GameWon.play();
	        Bgmusic.loop();
        	       	
	    }
	    
	    
	    	    
	    public void addRestartButton() {
	        Font font = new Font("Helvetica", Font.BOLD, 14);
	        restartButton.setFont(font);
	        //restartButton.setBackground(new Color(59, 89, 182));
	        //restartButton.setForeground(Color.RED);

	        setLayout(null);
	        restartButton.setBounds(5, 40, 110, 45);
	        add(restartButton);
	        
	        
	        restartButton.setEnabled(false);
	        
	        restartButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	//addRestartButton();
	    	        //addStartButton();
	    	        //addPauseButton();
	    	        pauseButton.setEnabled(true);
	    	        setFocusable(true);
	    	        //setBackground(Color.BLACK);
	    	        img = Toolkit.getDefaultToolkit().createImage("tenor.gif");
	    	        img2 = Toolkit.getDefaultToolkit().createImage("galaxy2.gif");
	    	        img3 = Toolkit.getDefaultToolkit().createImage("galaxy3.gif");
	    	        ingame = true;
	    	        lifepack_head = 3;
	    	        lifepack_craft = 3;
	    	        
	    	        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

	    	        craft = new Craft(ICRAFT_X, ICRAFT_Y);
	    	        craft.isVisible();
	    	        
	    	        enemy = new EnemyShip(ECRAFT_X, ECRAFT_Y);
	    	        enemy.isVisible();
	    	        enemy.move();
	    	        
	    	        voll = new VolButt(VOLBUT_X, VOLBUT_Y);
	    	        voll.isVisible();

	    	        initAliens();
	    	        initGifts();
	    	        initBoss();
	    	        initHealth();
	    	        
	    	        timer.restart();
	            	GameWon.play();
	            	GameLost.stop();
	    	        Bgmusic.loop();
	    	        //Attack.stop();
            		Bossroar.stop();
	            	return;
	            }

	        });  

	        return;
	    }
	    
	    public void addStartButton() {
	        Font font = new Font("Helvetica", Font.BOLD, 14);
	        continueButton.setFont(font);

	        setLayout(null);
	        continueButton.setBounds(5, 80, 110, 45);
	        add(continueButton);
	        continueButton.setEnabled(false);
	        
	        continueButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	timer.start();
	            	Bgmusic.loop();
	            	if(aliens.isEmpty()){
	            		//Attack.loop();
	            		Bossroar.loop();
	            	}
	            	continueButton.setEnabled(false);
	            	pauseButton.setEnabled(true);
	            	return;
	            }

	        });  

	        return;
	    }
	    
	    
	    public void addPauseButton() {
	        Font font = new Font("Helvetica", Font.BOLD, 14);
	        pauseButton.setFont(font);

	        setLayout(null);
	        pauseButton.setBounds(5, 120, 110, 45);
	        add(pauseButton);
	        
	        	        
	        pauseButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	timer.stop();
	            	Bgmusic.stop();
	            	Bgmusic2.stop();
	            	Bossroar.stop();
	            	//Attack.stop();
	            	pauseButton.setEnabled(false);
	            	continueButton.setEnabled(true);
	            	return;
	            }

	        });  

	        return;
	    }


	    public void initAliens() {
	        aliens = new ArrayList<>();

	        for (int[] p : pos) {
	            aliens.add(new Alien(p[0], p[1]));
	            aliens.add(new Alien(p[0], p[1]));
	        }
	    }
	    
	  
	    
	    public void initGifts() {
	        gifts = new ArrayList<>();

	        for (int[] p : pos2) {
	        	gifts.add(new Gifts(p[0], p[1]));
	        }
	    }
	    
	    
	    public void initHealth() {
	        health = new ArrayList<>();

	        for (int[] p : pos4) {
	        	health.add(new Health(p[0], p[1]));
	        }
	    }
	    
	    
	    public void initBoss() {
	        boss = new ArrayList<>();
	        for (int[] p : pos3) {
	        	Boss born = new Boss(p[0], p[1]);
	        	boss.add(born);
	        	born.setVisible(false); 
	        }
	    }
	    
	    
	    public void Sounds2On(){
	    	
	    	Bgmusic.stop();
        	Bgmusic2.loop();
        	
	    }
	    
		    
	    
	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        if (ingame && aliens.size() > 0) {

	        	drawObjects(g);
	            
	        }
	        
	        
	        if(aliens.isEmpty()){
	        	
	        	drawObjects2(g);
	        	
	        	if(boss.size() > 0){
	        		g.drawString("Demonized: " + boss.size(), 5, 15);
	        		g.drawString("Level: " + 2, 230, 15);
	        		g.drawString("Missiles: Locked", 320, 15);
	        		g.drawString("Rockets: Unlocked", 480, 15);
	        		drawOuttaControl(g);
	        		craft.dragonShake();
	        		
	        	}
	        	updateBoss();
	        	Bossroar.loop();
	        	//Attack.loop();
	        	//Sounds2On();
	        	if(boss.isEmpty()){
	        		g.drawString("Demonized: " + tick, 5, 15);
	        		g.drawString("Level: " + 3, 230, 15);
	        		g.drawString("Missiles: Unlocked", 320, 15);
	        		g.drawString("Rockets: Unlocked", 490, 15);
	        	}
	        	
	        }
	        

	        if(lifepack_craft < 3){
	        	
	        	g.drawString("GODMODE!", craft.x, craft.y);
	        	craft.godMode();
	        }
	        
	        
	        if(lifepack_craft == 3){
	        	
	        	g.drawString("Health: 100%", craft.x, craft.y);
	        	
	        }
	        
	        if(lifepack_craft == 4){
	        	
	        	g.drawString("Health: 75%", craft.x, craft.y);
	        	
	        }
	       
	        if(lifepack_craft == 5){
	        	
	        	g.drawString("Health: 50%", craft.x, craft.y);
	        	
	        }
	       
	        if(lifepack_craft == 6){
	        	
	        	g.drawString("Health: 25%", craft.x, craft.y);
	        	
	        }
	        
			if(lifepack_craft > 6){
				        	
				ingame = false;
	        	
	        }
	        
	       	
	        
	        if(boss.isEmpty()){
	        	
	        	drawObjects3(g);
	        	//Attack.stop();
	        	Bossroar.stop();
	        }
	        
	        if(boss.isEmpty() && gifts.size() > 0){
	        	
	        	drawCollect(g);
	        	g.drawString("Missiles: Locked", 320, 15);
        		g.drawString("Rockets: Locked", 480, 15);
	        	
	        }
	        
	        if(boss.isEmpty() && gifts.isEmpty()){
	        	
	        	drawKillTheHead(g);
	        	g.drawString("Missiles: Unlocked", 320, 15);
	        	g.drawString("Rockets: Unlocked", 490, 15);	        	
	        }
	        
	        
	        if(boss.isEmpty() && gifts.isEmpty() && lifepack_head < 10){
	        	g.drawString("Health: 100%", enemy.x, enemy.y);
	        }
	        
	        
	        if(lifepack_head >= 10 && lifepack_head < 20){
	        	g.drawString("Health: 80%", enemy.x, enemy.y);
	        	
	        }
	        
	        
	        if(lifepack_head >= 20 && lifepack_head < 30){
	        	g.drawString("Health: 60%", enemy.x, enemy.y);
	        }
	        
	        if(lifepack_head >= 30 && lifepack_head < 35){
	        	Bossroar.loop();
	        }
	        
	        if(lifepack_head >= 35){
	        	Bossroar.stop();
	        }
	        
	        if(lifepack_head >= 30 && lifepack_head < 40){
	        	g.drawString("Health: 40%", enemy.x, enemy.y);
	        }
	        
	        if(lifepack_head >= 40 && lifepack_head < 45){
	        	Bossroar.loop();
	        }
	        
	        if(lifepack_head >= 45){
	        	Bossroar.stop();
	        }
	        
	        if(lifepack_head >= 40 && lifepack_head < 50){
	        	g.drawString("Health: 20%", enemy.x, enemy.y);
	        }
	       	        
	        if(lifepack_head == 50){
	        	
	        	GameWon.play();
	        	ingame = false;
		        g.drawImage(img, 0, 0, null);
	            drawYouWon(g);
	        	g.drawString("Monsters: Killed!", 5, 15);
		        g.drawString("Gold: Collected!", 165, 15);
	        	Bgmusic.stop();
	        	restartButton.setEnabled(true);
	        	continueButton.setEnabled(false);
		        pauseButton.setEnabled(false);
		        return;
	        }
	        
	        
	        if (!ingame) {

	        	GameLost.play();
	            g.drawImage(img, 0, 0, null);
	            drawGameOver(g);
	            Bgmusic.stop();
	            Bgmusic2.stop();
	            Bossroar.stop();
	            //Attack.stop();
		        g.drawString("Monsters left: " + 0, 5, 15);
		        g.drawString("Gold: " + 0, 150, 15);
		        g.drawString("Health: 0%", 230, 15);
		        restartButton.setEnabled(true);
		        continueButton.setEnabled(false);
		        pauseButton.setEnabled(false);
		        timer.stop();
		        return;
	            
	        }

	        Toolkit.getDefaultToolkit().sync();
	    }
	    
	    

	    

	    private void drawObjects(Graphics g) {

	        if (enemy.isVisible() && craft.isVisible() && voll.isVisible() && g.drawImage(img, 0, 0, null)) {
	            g.drawImage(craft.getImage(), craft.getX(), craft.getY(),
	                    this);
	            g.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(),
	                    this);
	            g.drawImage(voll.getImage(), voll.getX(), voll.getY(),
	                    this);
	        }
	        
	        

	        @SuppressWarnings("unchecked")
			ArrayList<Missile> ms = craft.getMissiles();
	     
	        for (Missile m : ms) {
	        	
	            if (m.isVisible()) {
	                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
	            }
	        }
	        
	        @SuppressWarnings("unchecked")
	        ArrayList<Rocket> rs = craft.getRockets();

	        for (Rocket r : rs) {
	            if (r.isVisible()) {
	                g.drawImage(r.getImage(), r.getX(), r.getY(), this);
	            }
	        }
	        
	        
	        
	        @SuppressWarnings("unchecked")
			ArrayList<EvilGun> guner = enemy.getEvilMissiles();
	     
	        for (EvilGun n : guner) {
	        	
	            if (n.isVisible()) {
	                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
	            }
	        }
	        
	        @SuppressWarnings("unchecked")
			ArrayList<CanonBall> can = enemy.getCanons();
	     
	        for (CanonBall n : can) {
	        	
	            if (n.isVisible()) {
	                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
	            }
	        }
	        


	        for (Alien a : aliens) {
	            if (a.isVisible()) {
	                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
	            }
	        }
	        
	       for (Boss d : boss) {
	            if (d.isVisible()) {
	                g.drawImage(d.getImage(), d.getX(), d.getY(), this);
	            }
	        } 
	        
	        
	        for (Gifts b : gifts) {
	            if (b.isVisible()) {
	                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
	            }
	        }
	        
	        for (Health b : health) {
	            if (b.isVisible()) {
	                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
	            }
	        }
	        
	        
	        Font small = new Font("Helvetica", Font.BOLD, 17);
	        g.setColor(Color.WHITE);
	        g.setFont(small);
	        
	        c = "2713";
	        tick = String.valueOf(Character.toChars(Integer.parseInt(c, 16)));
	     
	        
	        if(aliens.size() > 0){
	        	
	        	g.drawString("Aliens left: " + aliens.size(), 5, 15);
	        	g.drawString("Level: " + 1, 230, 15);
	        	g.drawString("Missiles: Unlocked", 320, 15);
	        	g.drawString("Rockets: Locked", 490, 15);
	        }
	       
	        if(gifts.size() > 0){
	        	g.drawString("Gold: " + (-(gifts.size() - 12)), 140, 15);
	        }
	        
	        if(gifts.isEmpty()){
        		g.drawString("Gold: " + tick, 140, 15);
        	}
	        
	    }
	    
	    
	    private void drawObjects3(Graphics g) {

	        if (enemy.isVisible() && craft.isVisible() && voll.isVisible() && g.drawImage(img3, 0, 0, null)) {
	            g.drawImage(craft.getImage(), craft.getX(), craft.getY(),
	                    this);
	            g.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(),
	                    this);
	            g.drawImage(voll.getImage(), voll.getX(), voll.getY(),
	                    this);
	        }
	        
	        

	        @SuppressWarnings("unchecked")
			ArrayList<Missile> ms = craft.getMissiles();
	     
	        for (Missile m : ms) {
	        	
	            if (m.isVisible()) {
	                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
	            }
	        }
	        
	        @SuppressWarnings("unchecked")
	        ArrayList<Rocket> rs = craft.getRockets();

	        for (Rocket r : rs) {
	            if (r.isVisible()) {
	                g.drawImage(r.getImage(), r.getX(), r.getY(), this);
	            }
	        }
	        
	        
	        
	        @SuppressWarnings("unchecked")
			ArrayList<EvilGun> guner = enemy.getEvilMissiles();
	     
	        for (EvilGun n : guner) {
	        	
	            if (n.isVisible()) {
	                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
	            }
	        }
	        
	        
	        @SuppressWarnings("unchecked")
			ArrayList<CanonBall> can = enemy.getCanons();
	     
	        for (CanonBall n : can) {
	        	
	            if (n.isVisible()) {
	                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
	            }
	        }
	        


	        for (Alien a : aliens) {
	            if (a.isVisible()) {
	                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
	            }
	        }
	        
	       for (Boss d : boss) {
	            if (d.isVisible()) {
	                g.drawImage(d.getImage(), d.getX(), d.getY(), this);
	            }
	        } 
	        
	        
	        for (Gifts b : gifts) {
	            if (b.isVisible()) {
	                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
	            }
	        }
	        
	        for (Health b : health) {
	            if (b.isVisible()) {
	                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
	            }
	        }
	        
	        
	        Font small = new Font("Helvetica", Font.BOLD, 17);
	        g.setColor(Color.WHITE);
	        g.setFont(small);
	        
	        c = "2713";
	        tick = String.valueOf(Character.toChars(Integer.parseInt(c, 16)));

	        if(aliens.size() > 0){
	        	
	        	g.drawString("Aliens left: " + aliens.size(), 5, 15);
	        	g.drawString("Level: " + 1, 230, 15);
		        
	        }
	        
	        if(boss.isEmpty()){
        		g.drawString("Demonized: " + tick, 5, 15);
        		g.drawString("Level: " + 3, 230, 15);
        	}
	       
	        if(gifts.size() > 0){
	        	g.drawString("Gold: " + (-(gifts.size() - 12)), 140, 15);
	        }
	        
	        if(gifts.isEmpty()){
        		g.drawString("Gold: " + tick, 140, 15);
        	}
	        
	        
	        if(lifepack_craft < 3){
	        	
	        	g.drawString("Health: GOD!", craft.x, craft.y);
	        	
	        }
	        
	        
	        if(lifepack_craft == 3){
	        	
	        	g.drawString("Health: 100%", craft.x, craft.y);
	        	
	        }
	        
	        if(lifepack_craft == 4){
	        	
	        	g.drawString("Health: 75%", craft.x, craft.y);
	        	
	        }
	       
	        if(lifepack_craft == 5){
	        	
	        	g.drawString("Health: 50%", craft.x, craft.y);
	        	
	        }
	       
	        if(lifepack_craft == 6){
	        	
	        	g.drawString("Health: 25%", craft.x, craft.y);
	        	
	        }

	    	if(lifepack_craft > 6){
	        	
				ingame = false;
	        	
	        }
	    }
	    
	    
	    private void drawObjects2(Graphics g) {

	        if (enemy.isVisible() && craft.isVisible() && voll.isVisible() && g.drawImage(img2, 0, 0, null)) {
	            g.drawImage(craft.getImage(), craft.getX(), craft.getY(),
	                    this);
	            g.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(),
	                    this);
	            g.drawImage(voll.getImage(), voll.getX(), voll.getY(),
	                    this);
	        }
	        
	        

	        @SuppressWarnings("unchecked")
			ArrayList<Missile> ms = craft.getMissiles();
	     
	        for (Missile m : ms) {
	        	
	            if (m.isVisible()) {
	                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
	            }
	        }
	        
	        @SuppressWarnings("unchecked")
	        ArrayList<Rocket> rs = craft.getRockets();

	        for (Rocket r : rs) {
	            if (r.isVisible()) {
	                g.drawImage(r.getImage(), r.getX(), r.getY(), this);
	            }
	        }
	        
	        
	        
	        @SuppressWarnings("unchecked")
			ArrayList<EvilGun> guner = enemy.getEvilMissiles();
	     
	        for (EvilGun n : guner) {
	        	
	            if (n.isVisible()) {
	                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
	            }
	        }
	        
	        @SuppressWarnings("unchecked")
			ArrayList<CanonBall> can = enemy.getCanons();
	     
	        for (CanonBall n : can) {
	        	
	            if (n.isVisible()) {
	                g.drawImage(n.getImage(), n.getX(), n.getY(), this);
	            }
	        }

	        for (Alien a : aliens) {
	            if (a.isVisible()) {
	                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
	            }
	        }
	        
	       for (Boss d : boss) {
	            if (d.isVisible()) {
	                g.drawImage(d.getImage(), d.getX(), d.getY(), this);
	            }
	        } 
	        
	        
	        for (Gifts b : gifts) {
	            if (b.isVisible()) {
	                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
	            }
	        }
	        
	        for (Health b : health) {
	            if (b.isVisible()) {
	                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
	            }
	        }
	        
	        
	        Font small = new Font("Helvetica", Font.BOLD, 17);
	        g.setColor(Color.WHITE);
	        g.setFont(small);
	        
	        c = "2713";
	        tick = String.valueOf(Character.toChars(Integer.parseInt(c, 16)));

	        if(aliens.size() > 0){
	        	
	        	g.drawString("Aliens left: " + aliens.size(), 5, 15);
	        	g.drawString("Level: " + 1, 230, 15);
		        
	        }
	       
	        if(gifts.size() > 0){
	        	g.drawString("Gold: " + (-(gifts.size() - 12)), 140, 15);
	        }
	        
	        if(gifts.isEmpty()){
        		g.drawString("Gold: " + tick, 140, 15);
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
	    
	    private void drawKillTheHead(Graphics g) {

	        String msg = "Now kill the evil head!";
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

	        String msg = "Demons invasion brings the ship outta control...";
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

	        updateCraft();
	        updateMissiles();
	        updateEvilMissiles();
	        updateEvilCanons();
	        updateRockets();
	        updateAliens();
	        updateEnemy();
	        updateGifts();
	        updateHealth();
	        
	        checkCollisions();

	        repaint();
	        
	    }

	    private void inGame() {
	        
	        if (!ingame) {
	            timer.stop();
	        }
	    }

	    private void updateCraft() {

	        if (craft.isVisible()) {
	            craft.move();
	        }
	    }

	    private void updateMissiles() {

	        @SuppressWarnings("unchecked")
			ArrayList<Missile> ms = craft.getMissiles();
	        
	        
	        for (int i = 0; i < ms.size(); i++) {

	            Missile m = ms.get(i);
	            	            
	            if (m.isVisible()) {
	                m.move();
	            } else {
	                ms.remove(i);
	            }
	        }
	        
	    }
	    
	    private void updateEvilMissiles(){
	    	
	        @SuppressWarnings("unchecked")
			ArrayList<EvilGun> guner = enemy.getEvilMissiles();
	        
	        
	        for (int er = 0; er < guner.size(); er++) {

	        	EvilGun n = guner.get(er);
	            	            
	            if (n.isVisible()) {
	                n.moveevilmis();
	            } else {
	            	guner.remove(er);
	            }
	        }
	    }
	    
	    private void updateEvilCanons(){
	    	
	        @SuppressWarnings("unchecked")
			ArrayList<CanonBall> can = enemy.getCanons();
	        
	        
	        for (int er = 0; er < can.size(); er++) {

	        	CanonBall n = can.get(er);
	            	            
	            if (n.isVisible()) {
	                n.movecanon();
	            } else {
	            	can.remove(er);
	            }
	        }
	    }
	    
	    private void updateRockets() {

	        @SuppressWarnings("unchecked")
			ArrayList<Rocket> rs = craft.getRockets();

	        for (int i = 0; i < rs.size(); i++) {

	            Rocket r = rs.get(i);

	            if (r.isVisible()) {
	                r.move();
	            } else {
	                rs.remove(i);
	            }
	        }
	    }
	    
	  
	    private void updateAliens() {

	    	for (int i = 0; i < aliens.size(); i++) {

	            Alien a = aliens.get(i);
	            if (a.isVisible()) {
	                a.move();
	            } else {
	                aliens.remove(i);
	                new AePlayWave("bloop.wav").start();
	            }
	        }
	    }
	    
	    
	    private void updateEnemy() {

	    	    if (enemy.isVisible() && (aliens.size() > 0 || boss.size() > 0)) {
	                enemy.move();
	            } 
	    	    
	    	    if(enemy.isVisible() && boss.isEmpty()){
	    	    	enemy.moveclean();
	    	    }
	    }
	    
	    
	    private void updateBoss() {
	    	
	    
	        for (int u = 0; u < boss.size(); u++) {

	            Boss d = boss.get(u);
	            d.setVisible(true);
	            checkBossCollisions();
	            if (d.isVisible()) {
	                d.move();
	            } else {
	                boss.remove(u);
	                new AePlayWave("bloop.wav").start();
	            }
	        }
	    }
	    
	    
	    private void updateGifts() {
	    

	        for (int g = 0; g < gifts.size(); g++) {

	            Gifts b = gifts.get(g);
	            if (b.isVisible()) {
	                b.move();
	            } else {
	            	gifts.remove(g);
	            }
	        }
	    }
	    
	    
	    private void updateHealth() {
		    

	        for (int g = 0; g < health.size(); g++) {

	            Health h = health.get(g);
	            if (h.isVisible()) {
	                h.move();
	            } else {
	            	health.remove(g);
	            	lifepack_craft--;
	            }
	        }
	    }
	    
	    public void checkBossCollisions() {
	    
	    	Rectangle r3 = craft.getBounds();
	    	
	    	for (Boss bs : boss) {
	            Rectangle r12 = bs.getBounds();

	            if (r3.intersects(r12)) {
	        		lifepack_craft++;
	        		bs.setVisible(false);
	        		new AePlayWave("scream.wav").start();
	        		craft.hitCraft();
	        		craft.shakeCraft();	        		
            	}		
	        }
	    	
	    	@SuppressWarnings("unchecked")
	        ArrayList<Rocket> rs = craft.getRockets();
	        
	        for (Rocket r : rs) {

	            Rectangle r4 = r.getBounds();
	            
	            for (Boss bs : boss) {

	                Rectangle r12 = bs.getBounds();

	                if (r4.intersects(r12)) {
	                    r.setVisible(false);
	                    bs.setVisible(false);
	                }
	            }          
	           
	        }
	        
	        

	    }

	    public void checkCollisions() {

	        Rectangle r3 = craft.getBounds();
	        

	        Rectangle r88 = enemy.getBounds();
	        
	        if(r3.intersects(r88)){
	        	
        			new AePlayWave("scream.wav").start();
        			craft.setVisible(false);
    		        enemy.setVisible(false);
    		        ingame = false;
			        return;
	        	}

        
	        for (Alien alien : aliens) {
	        	
		        	        	
	            Rectangle r2 = alien.getBounds();
     
	            	if (r3.intersects(r2)) {
		        		lifepack_craft++;
		        		alien.setVisible(false);
		        		new AePlayWave("burned.wav").start();
		        		craft.hitCraft();
		        		craft.shakeCraft();
	            	}		
		        			
			     }
		        		
		        				        
	        for (Gifts gfs : gifts) {
	        	Rectangle r8 = gfs.getBounds();

	            if (r3.intersects(r8)) {
	                gfs.setVisible(false);
	                new AePlayWave("collect.wav").start();
	            }
	        }
	        
	        for (Health hlt : health) {
	        	Rectangle r18 = hlt.getBounds();

	            if (r3.intersects(r18)) {
	                hlt.setVisible(false);
	                Healthy.play();
	            }
	        }

	        @SuppressWarnings("unchecked")
			ArrayList<Missile> ms = craft.getMissiles();
	       
	        for (Missile m : ms) {

	            Rectangle r1 = m.getBounds();
	            

	            for (Alien alien : aliens) {

	                Rectangle r2 = alien.getBounds();

	                if (r1.intersects(r2)) {
	                    m.setVisible(false);
	                    alien.setVisible(false);
	                }
	            }
	            
	            Rectangle r222 = enemy.getBounds();
	            
	            
	            if(boss.isEmpty() && gifts.isEmpty()){
	            	if(r1.intersects(r222)){
	            		m.setVisible(false);
	            		enemy.fire2();
		            	enemy.strikeHead();
		            	lifepack_head++;
	            	}
	            	
	            }
	        }
	        
	        
	        @SuppressWarnings("unchecked")
			ArrayList<EvilGun> guner = enemy.getEvilMissiles();
	       
	        for (EvilGun n : guner) {

	            	Rectangle r1 = n.getBounds();
	            	            
	                Rectangle r101 = craft.getBounds();

	                if (r1.intersects(r101)) {
		        		lifepack_craft++;
		        		n.setVisible(false);
		        		new AePlayWave("burned.wav").start();
		        		craft.hitCraft();
		        		craft.shakeCraft();
	            	}	
	        }
	        
	        @SuppressWarnings("unchecked")
			ArrayList<CanonBall> can = enemy.getCanons();
	       
	        for (CanonBall n : can) {

	            	Rectangle r1 = n.getBounds();
	            	            
	                Rectangle r101 = craft.getBounds();

	                if (r1.intersects(r101)) {
		        		lifepack_craft++;
		        		n.setVisible(false);
		        		new AePlayWave("burned.wav").start();
		        		craft.hitCraft();
		        		craft.shakeCraft();
	            	}	
	        }
	        
	        @SuppressWarnings("unchecked")
	        ArrayList<Rocket> rs = craft.getRockets();
	        
	        for (Rocket r : rs) {

	            Rectangle r4 = r.getBounds();

	            for (Alien alien : aliens) {

	                Rectangle r2 = alien.getBounds();

	                if (r4.intersects(r2)) {
	                    r.setVisible(false);
	                    alien.setVisible(false);
	                    new AePlayWave("scream.wav").start();
	                }
	            }
	            
	            Rectangle r222 = enemy.getBounds();
	            
	         	            
	            if(boss.isEmpty() && gifts.isEmpty()){
	            	if(r4.intersects(r222)){
	            		r.setVisible(false);
	            		enemy.fire2();
		            	enemy.strikeHead();
		            	lifepack_head++;
	            	}
	            	
	            }
	            
	        }
	        
	      
	    }

	    private class TAdapter extends KeyAdapter {

	        @Override
	        public void keyReleased(KeyEvent e) {
	            craft.keyReleased(e);
	        }
	        

	        @Override
	        public void keyPressed(KeyEvent e) {
	            craft.keyPressed(e);
	            voll.keyPressed(e);
	            int key = e.getKeyCode();
				
				if (key == KeyEvent.VK_S) {
					Bgmusic.stop();
		        }
				
				if (key == KeyEvent.VK_A) {
					Bgmusic.loop();
					if(!ingame || timer.isRunning() == false){
						Bgmusic.stop();
					}
		        }
				
				if (key == KeyEvent.VK_P) {
					timer.stop();
	            	Bgmusic.stop();
	            	Bgmusic2.stop();
	            	Bossroar.stop();
	            	//Attack.stop();
	            	pauseButton.setEnabled(false);
	            	continueButton.setEnabled(true);
		        }
				
				
				if (key == KeyEvent.VK_CONTROL && (aliens.size() == 0 && (boss.size() > 0 || gifts.isEmpty()))) {
		            craft.spechit();
		        }
				if (key == KeyEvent.VK_CONTROL && (aliens.size() > 0 || (boss.isEmpty() && gifts.size() > 0))) {
					craft.gunempty();
				}
				
				if (key == KeyEvent.VK_SPACE && (aliens.size() > 0 || (gifts.isEmpty() && boss.isEmpty()))) {
		            craft.fire();
		        }
				
				if (key == KeyEvent.VK_SPACE && (boss.size() > 0 && (aliens.isEmpty() && gifts.size() >= 0))){
					craft.gunempty();
				}
				
				
				if (key == KeyEvent.VK_SPACE && (boss.isEmpty() && gifts.size() > 0)){
					craft.gunempty();
				}
				
				
				
				if (key == KeyEvent.VK_R){
					
					
					//RELOAD BOARD
					/*CollisionEx reboard = new CollisionEx();
	                reboard.setVisible(true);*/
					timer.start();
	            	Bgmusic.loop();
	            	if(aliens.isEmpty()){
	            		//Attack.loop();
	            		Bossroar.loop();
	            	}
	            	if(ingame == false){
	            		//addRestartButton();
		    	        //addStartButton();
		    	        //addPauseButton();
		    	        restartButton.setVisible(true);
		    	        continueButton.setVisible(true);
		    	        pauseButton.setVisible(true);
		    	        setFocusable(true);
		    	        //setBackground(Color.BLACK);
		    	        img = Toolkit.getDefaultToolkit().createImage("tenor.gif");
		    	        ingame = true;
		    	        lifepack_head = 3;
		    	        lifepack_craft = 3;
		    	        
		    	        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

		    	        craft = new Craft(ICRAFT_X, ICRAFT_Y);
		    	        craft.isVisible();
		    	        
		    	        enemy = new EnemyShip(ECRAFT_X, ECRAFT_Y);
		    	        enemy.isVisible();
		    	        enemy.move();
		    	        
		    	        voll = new VolButt(VOLBUT_X, VOLBUT_Y);
		    	        voll.isVisible();

		    	        initAliens();
		    	        initGifts();
		    	        initBoss();
		    	        initHealth();
		    	        
		    	        timer.restart();
		            	GameWon.play();
		            	GameLost.stop();
		    	        Bgmusic.loop();
		    	        //Attack.stop();
	            		Bossroar.stop();
	            	}
	            	
	            	continueButton.setEnabled(false);
	            	pauseButton.setEnabled(true);
	
				}
				
				if (key == KeyEvent.VK_ESCAPE){
					
					//EXIT
					System.exit(0);

				}


	        }
	        
	    }

	}