package frames;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.net.URISyntaxException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import entities.MyShip;
import entities.Bunker;
import entities.EvilHead;
import items.VolBtn;
import multiplayer_tbd.JoinGame;


@SuppressWarnings("serial")
public class Main extends JFrame {
	
	static String buttonText = "Manual";
    static JButton button = new JButton(buttonText);
    
    public static final int UPDATE_TIME = 2;
    public static final int DURATION = 1000;
 
   

    public Main() {
        
        initUI();
    }
    
    private void initUI() {
        
	        add(new Board());
	        
	        setResizable(false);
	        setUndecorated(true);
	        pack();
	        
	        setTitle("EvilGalaxy");
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

	        
	        setIconImage(Toolkit.getDefaultToolkit().getImage("images/strikehead.gif"));
	
	        
	        setShape(new RoundRectangle2D.Double(60, 80, 1200, 1200, 100, 100));
	        ImageIcon tileIcon = new ImageIcon("images/shadow1.png"); 
	        getRootPane().setBorder(BorderFactory.createMatteBorder(150, 150, 150, 150, tileIcon ));
	        
	        //Game Menu
	        JMenuBar menubar = new JMenuBar();
	        setJMenuBar(menubar);
	        JMenu file = new JMenu("Main");
	        file.setFont(new Font("Segoe UI", Font.BOLD, 15));
	        menubar.add(file);
	        JMenuItem join = new JMenuItem("Join game");
	        join.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        JMenuItem newgame = new JMenuItem("Restart    R");
	        newgame.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        JMenuItem console = new JMenuItem("Console    C");
	        console.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        JMenuItem exit = new JMenuItem("Exit    ESC");
	        exit.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        file.add(newgame);
	        file.add(join);
	        file.add(console);
	        file.add(exit);
	        JMenu difficulty = new JMenu("Difficulty");
	        difficulty.setFont(new Font("Segoe UI", Font.BOLD, 15));
	        menubar.add(difficulty);
	        JMenuItem easy = new JMenuItem("Easy    E");
	        easy.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        JMenuItem medium = new JMenuItem("Medium    M");
	        medium.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        JMenuItem hard = new JMenuItem("Hard    H");
	        hard.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        difficulty.add(easy);
	        difficulty.add(medium);
	        difficulty.add(hard);
	        JMenu help = new JMenu("Help");
	        help.setFont(new Font("Segoe UI", Font.BOLD, 15));
	        menubar.add(help);
	        JMenuItem manual = new JMenuItem("Manual    O");
	        manual.setFont(new Font("Segoe UI", Font.BOLD, 14));
	        help.add(manual);
	        
	        
	        class ExitAction implements ActionListener {
		        	@Override
			        	public void actionPerformed(ActionEvent e){
			        	System.exit(0);
		        	}
	        	}
	        
	        class NewGameAction implements ActionListener {
	        	@Override
		        	public void actionPerformed(ActionEvent e){
	        		
	        		Board.god = false;
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
	    	        
	    	        Board.bunkerObj = new Bunker(450, 650);
	    	        Board.bunkerObj.isVisible();
	    	        
	    	        Board.volButt = new VolBtn(940, 15);
            		Board.volButt.isVisible();

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
        	}
	        
	        class Join implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					JoinGame joingame = new JoinGame();
					joingame.setVisible(true);					
				}
	        	
	        }
	        
	        class Consolee implements ActionListener {
	        	@Override
		        	public void actionPerformed(ActionEvent e){
	        		
	        							
	        		Console csl = new Console();
	        		if(!Board.consoleON){
	        			csl.setVisible(true);
	        			if(!Board.consoleON == true){
	                    	Board.consoleON = true;
	                    }
	        		}
	        		
	        	}
        	}
	        

        	class Manuaal implements ActionListener {
	        	@Override
	        	public void actionPerformed(ActionEvent e){
	        		Manual manual = new Manual(); 
	    				
	        		if(!Board.manualON){
	        			manual.setVisible(true);
	        			if(!Board.manualON == true){
	                    	Board.manualON = true;
	                    }
	        		}
	    			
	        	}
        	}
	        
	        class Easy implements ActionListener {
	        	@Override
		        	public void actionPerformed(ActionEvent e){
	        		
	        		Board.timerMedium.stop();
	        		Board.timerHard.stop();
	        		Board.timerEasy.start();
	        		Board.bgMusic.loop();
	            	if(Board.aliens.isEmpty()){
	            		Board.roar.loop();
	            	}
	            	if(!Board.ingame){
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
	            		Board.evilHead.AIOnMedium();
	            		
	            		Board.bunkerObj = new Bunker(450, 650);
		    	        Board.bunkerObj.isVisible();
		    	        
	            		Board.volButt = new VolBtn(940, 15);
	            		Board.volButt.isVisible();

	            		Board.initAliens();
	            		Board.initGold();
	            		Board.initDragons();
	            		Board.initHealth();
	            		
	            		Board.timerMedium.stop();
	            		Board.timerHard.stop();;
	            		Board.timerEasy.restart();
	            		Board.gameWon.play();
	            		Board.gameLost.stop();
	            		Board.bgMusic.loop();
		    	        Board.roar.stop();
	            		return;
	            	}

	        	}
        	}

	        class Medium implements ActionListener {
	        	@Override
		        	public void actionPerformed(ActionEvent e){

	        		Board.timerEasy.stop();
	        		Board.timerHard.stop();
	        		Board.timerMedium.start();
	        		Board.bgMusic.loop();
	            	if(Board.aliens.isEmpty()){
	            		Board.roar.loop();
	            	}
	            	if(!Board.ingame){
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
	            		Board.evilHead.AIOnMedium();
	            		
	            		Board.bunkerObj = new Bunker(450, 650);
		    	        Board.bunkerObj.isVisible();
		    	        
	            		Board.volButt = new VolBtn(940, 15);
	            		Board.volButt.isVisible();

	            		Board.initAliens();
	            		Board.initGold();
	            		Board.initDragons();
	            		Board.initHealth();
	            		
	            		Board.timerEasy.stop();
	            		Board.timerHard.stop();;
	            		Board.timerMedium.restart();
	            		Board.gameWon.play();
	            		Board.gameLost.stop();
	            		Board.bgMusic.loop();
		    	        Board.roar.stop();
	            		return;
	            	}
	        	}
        	}

	        class Hard implements ActionListener {
	        	@Override
		        	public void actionPerformed(ActionEvent e){
	        		
	        		Board.timerEasy.stop();
	        		Board.timerMedium.stop();
	        		Board.timerHard.start();
	        		Board.bgMusic.loop();
	            	if(Board.aliens.isEmpty()){
	            		Board.roar.loop();
	            	}
	            	if(!Board.ingame){
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
	            		Board.evilHead.AIOnMedium();
	            		
	            		Board.bunkerObj = new Bunker(450, 650);
		    	        Board.bunkerObj.isVisible();
		    	        
	            		Board.volButt = new VolBtn(940, 15);
	            		Board.volButt.isVisible();

	            		Board.initAliens();
	            		Board.initGold();
	            		Board.initDragons();
	            		Board.initHealth();
		    	        
	            		Board.timerEasy.stop();
	            		Board.timerMedium.stop();;
	            		Board.timerHard.restart();
	            		Board.gameWon.play();
	            		Board.gameLost.stop();
	            		Board.bgMusic.loop();
		    	        Board.roar.stop();
	            		return;
	            	}
	        	}
        	}

	        
	        	exit.addActionListener (new ExitAction());
	        	manual.addActionListener(new Manuaal());
	        	newgame.addActionListener(new NewGameAction());
	        	join.addActionListener(new Join());
	        	console.addActionListener(new Consolee());
	        	easy.addActionListener(new Easy());
	        	medium.addActionListener(new Medium());
	        	hard.addActionListener(new Hard());
        	}
          
    public static void main(String[] args) throws URISyntaxException {
    	
    	
	    EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main ex = new Main();
            		    ex.setVisible(true);
            }
        });    
    }

}