package space;

import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
//import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
//import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.Timer;


@SuppressWarnings("serial")
public class Main extends JFrame {
	
	static String buttonText = "Manual";
    static JButton button = new JButton(buttonText);
    
    public static final int UPDATE_TIME = 2;
    public static final int DURATION = 1000;
 
    //private Point primaryLocation;
    //private long startTime;
    //private Timer time;
    
    
    //used on a 'ShakingFrame' object to shake the jframe
    /*public void startShake()
    {
        primaryLocation = getLocation();
        startTime = System.currentTimeMillis();
        time= new Timer(UPDATE_TIME,timeListener);
        time.start();
    }*/
     
    //stops shake/puts back in original place
   /*public void stopShake()
    {
        //code to stop the screen shaking
        time.stop();
        setLocation(primaryLocation);
        setVisible(true);
        repaint();
    }*/
     
    /*private class ActionTime implements ActionListener
    {
         private int xOffset, yOffset;
         //every interval the timer ticks, this is performed
        @Override
         public void actionPerformed(ActionEvent e)
         {
             //get elapsed time(running time)
             long elapsedTime = System.currentTimeMillis() - startTime;
             Random r = new Random();
             int op = r.nextInt(5);
              
             if ( op > 0)
             {
                //change x and y offset then reallocate frame
                xOffset = primaryLocation.x + (r.nextInt(20));
                yOffset = primaryLocation.y + (r.nextInt(20));
                setLocation(xOffset,yOffset);
                setVisible(false);                
                repaint();
             }
             else
             {
                //change x and y offset then reallocate frame
                xOffset = primaryLocation.x - (r.nextInt(20));
                yOffset = primaryLocation.y - (r.nextInt(20));
                setLocation(xOffset,yOffset);
                setVisible(true);
                repaint();
             }
             //elapsedTime exceed  DURATION, so stop now
             if(elapsedTime > DURATION)
             {   
                stopShake();
             }
         }
    }
    //listener/instance of ActionTime
    private ActionTime timeListener = new ActionTime();*/

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
	        
	        setIconImage(Toolkit.getDefaultToolkit().getImage("strikehead.gif"));
	
	        
	        setShape(new RoundRectangle2D.Double(60, 80, 1200, 1200, 100, 100));
	        ImageIcon tileIcon = new ImageIcon("shadow1.png"); 
	        //getRootPane().setBorder(BorderFactory.createMatteBorder(144, 144, 144, 144, Color.BLACK));
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
	    	        //setBackground(Color.BLACK);
	    	        Board.img = Toolkit.getDefaultToolkit().createImage("tenor.gif");
	    	        Board.ingame = true;
	    	        Board.lifepack_head = 3;
	    	        Board.lifepack_craft = 3;
	    	        
	    	        setPreferredSize(new Dimension(1310, 1040));

	    	        Board.craft = new Craft(40, 180);
	    	        Board.craft.isVisible();
	    	        
	    	        Board.enemy = new EnemyShip(640, 180);
	    	        Board.enemy.isVisible();
	    	        Board.enemy.move_easy();
	    	        
	    	        Board.voll = new VolButt(940, 15);
	    	        Board.voll.isVisible();

	    	        Board.initAliens();
	    	        Board.initGifts();
	    	        Board.initBoss();
	    	        Board.initHealth();
	    	        
	    	        Board.timer_hard.stop();
	    	        Board.timer_med.stop();
	    	        Board.timer.restart();
	    	        Board.GameWon.play();
	    	        Board.GameLost.stop();
	    	        Board.Bgmusic.loop();
	    	        //Attack.stop();
	    	        Board.Bossroar.stop();
            		return;

	        	}
        	}
	        
	        class Join implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					JoinGame joingame = new JoinGame();
					joingame.setVisible(true);
					
				}
	        	
	        }
	        
	        class Consolee implements ActionListener {
	        	@Override
		        	public void actionPerformed(ActionEvent e){
	        		
	        							
	        		Console csl = new Console();
	        		if(!Board.open_cons){
	        			csl.setVisible(true);
	        			if(!Board.open_cons == true){
	                    	Board.open_cons = true;
	                    }
	        		}
	        		
	        	}
        	}
	        
	        
	        class Easy implements ActionListener {
	        	@Override
		        	public void actionPerformed(ActionEvent e){
	        		
	        		Board.timer_med.stop();
	        		Board.timer_hard.stop();
	        		Board.timer.start();
	        		Board.Bgmusic.loop();
	            	if(Board.aliens.isEmpty()){
	            		//Attack.loop();
	            		Board.Bossroar.loop();
	            	}
	            	if(Board.ingame == false){
	            		Board.img = Toolkit.getDefaultToolkit().createImage("tenor.gif");
	            		Board.ingame = true;
	            		Board.lifepack_head = 3;
	            		Board.lifepack_craft = 3;
		    	        
	            		setPreferredSize(new Dimension(1310, 1040));

	            		Board.craft = new Craft(40, 180);
	            		Board.craft.isVisible();
		    	        
	            		Board.enemy = new EnemyShip(640, 180);
	            		Board.enemy.isVisible();
	            		Board.enemy.move_med();
		    	        
	            		Board.voll = new VolButt(940, 15);
	            		Board.voll.isVisible();

	            		Board.initAliens();
	            		Board.initGifts();
	            		Board.initBoss();
	            		Board.initHealth();
		    	        
	            		Board.timer_med.stop();
	            		Board.timer_hard.stop();;
	            		Board.timer.restart();
	            		Board.GameWon.play();
	            		Board.GameLost.stop();
	            		Board.Bgmusic.loop();
		    	        //Attack.stop();
	            		Board.Bossroar.stop();
	            		return;
	            	}

	        	}
        	}

	        class Medium implements ActionListener {
	        	@Override
		        	public void actionPerformed(ActionEvent e){

	        		Board.timer.stop();
	        		Board.timer_hard.stop();
	        		Board.timer_med.start();
	        		Board.Bgmusic.loop();
	            	if(Board.aliens.isEmpty()){
	            		//Attack.loop();
	            		Board.Bossroar.loop();
	            	}
	            	if(Board.ingame == false){
	            		Board.img = Toolkit.getDefaultToolkit().createImage("tenor.gif");
	            		Board.ingame = true;
	            		Board.lifepack_head = 3;
	            		Board.lifepack_craft = 3;
		    	        
	            		setPreferredSize(new Dimension(1310, 1040));

	            		Board.craft = new Craft(40, 180);
	            		Board.craft.isVisible();
		    	        
	            		Board.enemy = new EnemyShip(640, 180);
	            		Board.enemy.isVisible();
	            		Board.enemy.move_med();
		    	        
	            		Board.voll = new VolButt(940, 15);
	            		Board.voll.isVisible();

	            		Board.initAliens();
	            		Board.initGifts();
	            		Board.initBoss();
	            		Board.initHealth();
		    	        
	            		Board.timer.stop();
	            		Board.timer_hard.stop();;
	            		Board.timer_med.restart();
	            		Board.GameWon.play();
	            		Board.GameLost.stop();
	            		Board.Bgmusic.loop();
		    	        //Attack.stop();
	            		Board.Bossroar.stop();
	            		return;
	            	}
	        	}
        	}

	        class Hard implements ActionListener {
	        	@Override
		        	public void actionPerformed(ActionEvent e){
	        		
	        		Board.timer.stop();
	        		Board.timer_med.stop();
	        		Board.timer_hard.start();
	        		Board.Bgmusic.loop();
	            	if(Board.aliens.isEmpty()){
	            		//Attack.loop();
	            		Board.Bossroar.loop();
	            	}
	            	if(Board.ingame == false){
	            		Board.img = Toolkit.getDefaultToolkit().createImage("tenor.gif");
	            		Board.ingame = true;
	            		Board.lifepack_head = 3;
	            		Board.lifepack_craft = 3;
		    	        
	            		setPreferredSize(new Dimension(1310, 1040));

	            		Board.craft = new Craft(40, 180);
	            		Board.craft.isVisible();
		    	        
	            		Board.enemy = new EnemyShip(640, 180);
	            		Board.enemy.isVisible();
	            		Board.enemy.move_med();
		    	        
	            		Board.voll = new VolButt(940, 15);
	            		Board.voll.isVisible();

	            		Board.initAliens();
	            		Board.initGifts();
	            		Board.initBoss();
	            		Board.initHealth();
		    	        
	            		Board.timer.stop();
	            		Board.timer_med.stop();;
	            		Board.timer_hard.restart();
	            		Board.GameWon.play();
	            		Board.GameLost.stop();
	            		Board.Bgmusic.loop();
		    	        //Attack.stop();
	            		Board.Bossroar.stop();
	            		return;
	            	}
	        	}
        	}



	        
	        	class AboutAction implements ActionListener {
		        	@Override
		        	public void actionPerformed(ActionEvent e){
		        		ManualForm readme = new ManualForm(); 
		    				
							readme.setVisible(true);
							Board.open_manual = true;
		                    
		                    	if(Board.open_manual == true){
		                    		
		                    		Board.open_manual = false;
		                    		
		                    }	        		
		    			
		        	}
	        	}
	        	exit.addActionListener (new ExitAction());
	        	manual.addActionListener(new AboutAction());
	        	newgame.addActionListener(new NewGameAction());
	        	join.addActionListener(new Join());
	        	console.addActionListener(new Consolee());
	        	easy.addActionListener(new Easy());
	        	medium.addActionListener(new Medium());
	        	hard.addActionListener(new Hard());
        	}
          
    public static void main(String[] args) throws URISyntaxException {
    	
    	
    	final URI uri = new URI("https://github.com/Hunterszone/Java/tree/master/SpaceIntruders");
	    class OpenUrlAction implements ActionListener {
	      @Override public void actionPerformed(ActionEvent e) {
	        open(uri);
	      }
	    }
        
	    //Interactive button - GitHub
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main ex = new Main();
                Container container = ex.getContentPane();
    		    container.setBounds(900, 15, 30, 10);
    		    button.setText("<HTML>"
    		    		+ "<p>Use the arrows to navigate the ship.</p>"
    		    		+ "<p>Use S to mute the background music and A to enable it.</p>"
    		    		+ "<p>Use Space to fire missiles and Ctrl to fire rockets.</p>"
    		    		+ "<p>Press Esc to close the game window.</p>"
    		    		+ "<p>Press TAB to use the buttons and one more time to interact with the ship.</p>"
    		    		+ "<p>Alternatively, you can also use R for reloading the game board and for disabling this view.</p>"
    		    		+ "<p>Click anywhere" 
    		        + " to visit the <FONT color=\"#000099\"><U>official game repository</U></FONT>.</p></HTML>");
    		    Font font = new Font("Helvetica", Font.BOLD, 14);
    	        button.setFont(font);
    	        button.setLayout(null);
    	        button.setBounds(5, 200, 110, 45);
    		    button.setVisible(true);
    		    button.addActionListener(new OpenUrlAction());
    		    //ex.add(button);
    		    //ex.startShake();
    		    ex.setVisible(true);
            }
        });    
    }

    private static void open(URI uri) {
	    if (Desktop.isDesktopSupported()) {
	      try {
	        Desktop.getDesktop().browse(uri);
	      } catch (IOException e) { /* TODO: error handling */ }
	    } else { /* TODO: error handling */ }
	  }
}