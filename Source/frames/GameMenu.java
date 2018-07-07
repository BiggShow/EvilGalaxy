package frames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import entities.Alien;
import game_engine.Difficulty;
import game_engine.InitObjects;
import multiplayer_tbd.JoinGame;
import sound_engine.LoadSounds;

@SuppressWarnings("serial")
public class GameMenu extends JFrame {
	
	public GameMenu() {
        
        createMenu();
    }
	
    private void createMenu() {

        //Menu Bar
    	JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        JMenu file = new JMenu("Main");
        file.setFont(new Font("Segoe UI", Font.BOLD, 15));
        menubar.add(file);
        JMenuItem join = new JMenuItem("Join game");
        join.setFont(new Font("Segoe UI", Font.BOLD, 14));
        JMenuItem newgame = new JMenuItem("Restart      R");
        newgame.setFont(new Font("Segoe UI", Font.BOLD, 14));
        JMenuItem exit = new JMenuItem("Exit           Esc");
        exit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        file.add(newgame);
        file.addSeparator();
        file.add(join);
        file.addSeparator();
        file.add(exit);
        JMenu difficulty = new JMenu("Difficulty");
        difficulty.setFont(new Font("Segoe UI", Font.BOLD, 15));
        menubar.add(difficulty);
        JMenuItem easy = new JMenuItem("Easy           E");
        easy.setFont(new Font("Segoe UI", Font.BOLD, 14));
        JMenuItem medium = new JMenuItem("Medium    M");
        medium.setFont(new Font("Segoe UI", Font.BOLD, 14));
        JMenuItem hard = new JMenuItem("Hard         H");
        hard.setFont(new Font("Segoe UI", Font.BOLD, 14));
        difficulty.add(easy);
        difficulty.addSeparator();
        difficulty.add(medium);
        difficulty.addSeparator();
        difficulty.add(hard);
        JMenu help = new JMenu("Help");
        help.setFont(new Font("Segoe UI", Font.BOLD, 15));
        menubar.add(help);
        JMenuItem manual = new JMenuItem("Manual    O");
        manual.setFont(new Font("Segoe UI", Font.BOLD, 14));
        help.add(manual);
        
                
        //Menu SubItems
        class ExitAction implements ActionListener {
            	@Override
    	        	public void actionPerformed(ActionEvent e){
    	        	System.exit(0);
            	}
        	}
        
        class NewGameAction implements ActionListener {
        	@Override
            	public void actionPerformed(ActionEvent e){
        		Difficulty.restart();
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
        
    	class InvokeManual implements ActionListener {
        	@Override
        	public void actionPerformed(ActionEvent e){
        		Manual manual = new Manual(); 
    				
        		if(!InitObjects.manualON){
        			manual.setVisible(true);
        			if(!InitObjects.manualON == true){
                    	InitObjects.manualON = true;
                    }
        		}
    			
        	}
    	}
        
        class Easy implements ActionListener {
        	@Override
            	public void actionPerformed(ActionEvent e){
        		
        		InitObjects.timerMedium.stop();
        		InitObjects.timerHard.stop();
        		InitObjects.timerEasy.start();
        		LoadSounds.bgMusic.loop();
            	if(Alien.aliens.isEmpty()){
            		LoadSounds.roar.loop();
            	}
            	if(!InitObjects.ingame){
            		Difficulty.easy();
            		return;
            	}

        	}
    	}

        class Medium implements ActionListener {
        	@Override
            	public void actionPerformed(ActionEvent e){

        		InitObjects.timerEasy.stop();
        		InitObjects.timerHard.stop();
        		InitObjects.timerMedium.start();
        		LoadSounds.bgMusic.loop();
            	if(Alien.aliens.isEmpty()){
            		LoadSounds.roar.loop();
            	}
            	if(!InitObjects.ingame){
            		Difficulty.medium();
            		return;
            	}
        	}
    	}

        class Hard implements ActionListener {
        	@Override
            	public void actionPerformed(ActionEvent e){
        		
        		InitObjects.timerEasy.stop();
        		InitObjects.timerMedium.stop();
        		InitObjects.timerHard.start();
        		LoadSounds.bgMusic.loop();
            	if(Alien.aliens.isEmpty()){
            		LoadSounds.roar.loop();
            	}
            	if(!InitObjects.ingame){
            		Difficulty.hard();
            		return;
            	}
        	}
    	}

        
        	//Menu Events
        	exit.addActionListener (new ExitAction());
        	manual.addActionListener(new InvokeManual());
        	newgame.addActionListener(new NewGameAction());
        	join.addActionListener(new Join());
        	easy.addActionListener(new Easy());
        	medium.addActionListener(new Medium());
        	hard.addActionListener(new Hard());
	
    }
	
}