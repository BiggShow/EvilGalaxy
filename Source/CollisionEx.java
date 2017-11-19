package space;

import java.awt.Container;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class CollisionEx extends JFrame {
	
	static String buttonText = "Manual";
    static JButton button = new JButton(buttonText);
    
    public static final int UPDATE_TIME = 2;
    public static final int DURATION = 1000;
 
    private Point primaryLocation;
    private long startTime;
    private Timer time;
    
    
    //used on a 'ShakingFrame' object to shake the jframe
    public void startShake()
    {
        primaryLocation = getLocation();
        startTime = System.currentTimeMillis();
        time= new Timer(UPDATE_TIME,timeListener);
        time.start();
    }
     
    //stops shake/puts back in original place
    public void stopShake()
    {
        //code to stop the screen shaking
        time.stop();
        setLocation(primaryLocation);
        setVisible(true);
        repaint();
    }
     
    private class ActionTime implements ActionListener
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
    private ActionTime timeListener = new ActionTime();

    public CollisionEx() {
        
        initUI();
    }
    
    private void initUI() {
        
	        add(new Board());
	        
	        setResizable(false);
	        setUndecorated(true);
	        pack();
	        
	        setTitle("HellGalaxy");
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        setIconImage(Toolkit.getDefaultToolkit().getImage("strikehead.gif"));
	
	        
	        setShape(new RoundRectangle2D.Double(60, 80, 1200, 1200, 100, 100));
	        ImageIcon tileIcon = new ImageIcon("shadow1.png"); 
	        //getRootPane().setBorder(BorderFactory.createMatteBorder(144, 144, 144, 144, Color.BLACK));
	        getRootPane().setBorder(BorderFactory.createMatteBorder(150, 150, 150, 150, tileIcon ));
	        
	        //Game Menu
	        /*JMenuBar menubar = new JMenuBar();
	        setJMenuBar(menubar);
	        JMenu file = new JMenu("Menu");
	        menubar.add(file);
	        JMenuItem newgame = new JMenuItem("New game");
	        JMenuItem settings = new JMenuItem("Settings");
	        JMenuItem exit = new JMenuItem("Exit");
	        file.add(newgame);
	        file.add(settings);
	        file.add(exit);
	        JMenu help = new JMenu("Help");
	        menubar.add(help);
	        JMenuItem manual = new JMenuItem("Manual");
	        help.add(manual);
	        JMenu difficulty = new JMenu("Difficulty");
	        menubar.add(difficulty);
	        JMenuItem easy = new JMenuItem("Easy");
	        JMenuItem medium = new JMenuItem("Medium");
	        JMenuItem hard = new JMenuItem("Hard");
	        difficulty.add(easy);
	        difficulty.add(medium);
	        difficulty.add(hard);
	        
	        class ExitAction implements ActionListener {
		        	@Override
			        	public void actionPerformed(ActionEvent e){
			        	System.exit(0);
		        	}
	        	}
	        
	        class NewGameAction implements ActionListener {
	        	@Override
		        	public void actionPerformed(ActionEvent e){
		        	

	        	}
        	}

	        
	        	class AboutAction implements ActionListener {
		        	@Override
		        	public void actionPerformed(ActionEvent e){
		        		AboutForm pass = new AboutForm(); 
		    			pass.setVisible(true);
		    			pass.setSize(500, 500);
		        	}
	        	}
	        	exit.addActionListener (new ExitAction());
	        	manual.addActionListener(new AboutAction());
	        	newgame.addActionListener(new NewGameAction());*/
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
                CollisionEx ex = new CollisionEx();
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