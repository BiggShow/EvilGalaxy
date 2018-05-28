package frames;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import entities.Bunker;
import entities.EvilHead;
import entities.MyShip;
import items.VolBtn;
import sound_engine.SoundResources;

public class Controls extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	
	public void keyReleased(KeyEvent e) {
        MyShip.myShip.keyReleased(e);
    }
    

    public void keyPressed(KeyEvent e) {
        MyShip.myShip.keyPressed(e);
        VolBtn.volButt.keyPressed(e);
        int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_S) {
			SoundResources.bgMusic.stop();
        }
		
		if (key == KeyEvent.VK_A) {
			if(Board.timerEasy.isRunning() || Board.timerHard.isRunning() 
					|| Board.timerMedium.isRunning()){
				SoundResources.bgMusic.loop();
			}
        }
		
		if (key == KeyEvent.VK_P) {
			Board.timerEasy.stop();
			Board.timerHard.stop();
			Board.timerMedium.stop();
			
			SoundResources.bgMusic.stop();
			SoundResources.roar.stop();
        }
		
		
		if (Board.ingame == true && (Board.timerEasy.isRunning() == true || Board.timerMedium.isRunning() == true || Board.timerHard.isRunning() == true) 
				&& key == KeyEvent.VK_CONTROL 
				&& (Board.aliens.isEmpty() 
						&& (Board.dragons.size() > 0 || Board.lifeBunker < 50 || Board.goldstack.isEmpty()))) {
			MyShip.myShip.loadRockets();
        }


		if (Board.ingame == true && (Board.timerEasy.isRunning() == true || Board.timerMedium.isRunning() == true || Board.timerHard.isRunning() == true) 
				&& key == KeyEvent.VK_CONTROL && 
				(Board.aliens.size() > 0 || (Board.dragons.isEmpty() && Board.lifeBunker == 50 && Board.goldstack.size() > 0))) {
			MyShip.myShip.gunempty();
		}
		
		if (Board.ingame == true && (Board.timerEasy.isRunning() == true || Board.timerMedium.isRunning() == true || Board.timerHard.isRunning() == true) 
				&& key == KeyEvent.VK_SPACE && 
				(Board.aliens.size() > 0 || (Board.dragons.isEmpty() && Board.lifeBunker < 50) || 
						(Board.lifeBunker == 50 && Board.goldstack.isEmpty()))) {
			MyShip.myShip.loadMissiles();
        }
		
		if (Board.ingame == true && (Board.timerEasy.isRunning() == true || Board.timerMedium.isRunning() == true || Board.timerHard.isRunning() == true) 
				&& key == KeyEvent.VK_SPACE && 
				(Board.aliens.isEmpty() && Board.dragons.size() > 0 || (Board.dragons.isEmpty() && Board.lifeBunker == 50 && Board.goldstack.size() > 0))){
			MyShip.myShip.gunempty();
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
					|| Board.lifeBunker < 50)){
				Board.aliens.clear();
				Board.dragons.clear();
				Board.lifeBunker = 50;
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

	        MyShip.myShip = new MyShip(40, 180);
	        MyShip.myShip.isVisible();
	        
	        EvilHead.evilHead = new EvilHead(640, 180);
	        EvilHead.evilHead.isVisible();
	        EvilHead.evilHead.AIOnEasy();
	        
	        VolBtn.volButt = new VolBtn(940, 15);
	        VolBtn.volButt.isVisible();
	        
	        Bunker.bunkerObj = new Bunker(450, 650);
	        Bunker.bunkerObj.isVisible();

	        Board.initAliens();
	        Board.initGold();
	        Board.initDragons();
	        Board.initHealth();
	        
	        Board.timerHard.stop();
	        Board.timerMedium.stop();
	        Board.timerEasy.restart();
	        SoundResources.gameWon.play();
	        SoundResources.gameLost.stop();
	        SoundResources.bgMusic.loop();
	        SoundResources.roar.stop();
    		return;

		}
		
		
		if (key == KeyEvent.VK_E){
			
			Board.manualON = false;
			Board.timerHard.stop();
			Board.timerMedium.stop();
			Board.timerEasy.start();
			SoundResources.bgMusic.loop();
			
			if(Board.aliens.isEmpty()){
        		SoundResources.roar.loop();
        	}
        	if(!Board.ingame){
    	        setFocusable(true);
    	        Board.bg1 = Toolkit.getDefaultToolkit().createImage("images/tenor.gif");
    	        Board.ingame = true;
    	        Board.lifeEvilHead = 3;
    	        Board.lifeMyShip = 3;
    	        Board.lifeBunker = 3;
    	        
    	        setPreferredSize(new Dimension(Board.B_WIDTH, Board.B_HEIGHT));

    	        MyShip.myShip = new MyShip(Board.ICRAFT_X, Board.ICRAFT_Y);
    	        MyShip.myShip.isVisible();
    	        
    	        EvilHead.evilHead = new EvilHead(Board.ECRAFT_X, Board.ECRAFT_Y);
    	        EvilHead.evilHead.isVisible();
    	        EvilHead.evilHead.AIOnEasy();
    	        
    	        VolBtn.volButt = new VolBtn(Board.VOLBUT_X, Board.VOLBUT_Y);
    	        VolBtn.volButt.isVisible();
    	        
    	        Bunker.bunkerObj = new Bunker(Board.STATIC_GUN_X, Board.STATIC_GUN_Y);
    	        Bunker.bunkerObj.isVisible();

    	        Board.initAliens();
    	        Board.initGold();
    	        Board.initDragons();
    	        Board.initHealth();
    	        
    	        Board.timerHard.stop();
    	        Board.timerMedium.stop();
    	        Board.timerEasy.restart();
    	        SoundResources.gameWon.play();
    	        SoundResources.gameLost.stop();
    	        SoundResources.bgMusic.loop();
    	        SoundResources.roar.stop();
        	}
        	
		}
		
		
	if (key == KeyEvent.VK_M){
			
			Board.manualON = false;
			Board.timerEasy.stop();
			Board.timerHard.stop();
			Board.timerMedium.start();
			SoundResources.bgMusic.loop();
			
        	if(Board.aliens.isEmpty()){
        		SoundResources.roar.loop();
        	}
        	if(!Board.ingame){
        		Board.bg1 = Toolkit.getDefaultToolkit().createImage("images/tenor.gif");
        		Board.ingame = true;
        		Board.lifeEvilHead = 3;
        		Board.lifeMyShip = 3;
        		Board.lifeBunker = 3;
    	        
    	        setPreferredSize(new Dimension(Board.B_WIDTH, Board.B_HEIGHT));

    	        MyShip.myShip = new MyShip(Board.ICRAFT_X, Board.ICRAFT_Y);
    	        MyShip.myShip.isVisible();
    	        
    	        EvilHead.evilHead = new EvilHead(Board.ECRAFT_X, Board.ECRAFT_Y);
    	        EvilHead.evilHead.isVisible();
    	        EvilHead.evilHead.AIOnMedium();
    	        
    	        VolBtn.volButt = new VolBtn(Board.VOLBUT_X, Board.VOLBUT_Y);
    	        VolBtn.volButt.isVisible();

    	        Bunker.bunkerObj = new Bunker(Board.STATIC_GUN_X, Board.STATIC_GUN_Y);
    	        Bunker.bunkerObj.isVisible();

    	        Board.initAliens();
    	        Board.initGold();
    	        Board.initDragons();
    	        Board.initHealth();
    	        
    	        Board.timerEasy.stop();
    	        Board.timerHard.stop();;
    	        Board.timerMedium.restart();
    	        SoundResources.gameWon.play();
    	        SoundResources.gameLost.stop();
    	        SoundResources.bgMusic.loop();
    	        SoundResources.roar.stop();
        	}
        						

		}

		
		if (key == KeyEvent.VK_H){
			
			Board.manualON = false;
			Board.timerEasy.stop();
			Board.timerMedium.stop();
			Board.timerHard.start();
			SoundResources.bgMusic.loop();
			
        	if(Board.aliens.isEmpty()){
        		SoundResources.roar.loop();
        	}
        	if(!Board.ingame){
        		Board.bg1 = Toolkit.getDefaultToolkit().createImage("images/tenor.gif");
        		Board.ingame = true;
        		Board.lifeEvilHead = 3;
        		Board.lifeMyShip = 3;
        		Board.lifeBunker = 3;
    	        
    	        setPreferredSize(new Dimension(Board.B_WIDTH, Board.B_HEIGHT));

    	        MyShip.myShip = new MyShip(Board.ICRAFT_X, Board.ICRAFT_Y);
    	        MyShip.myShip.isVisible();
    	        
    	        EvilHead.evilHead = new EvilHead(Board.ECRAFT_X, Board.ECRAFT_Y);
    	        EvilHead.evilHead.isVisible();
    	        EvilHead.evilHead.AIOnHard();
    	        
    	        VolBtn.volButt = new VolBtn(Board.VOLBUT_X, Board.VOLBUT_Y);
    	        VolBtn.volButt.isVisible();

    	        Bunker.bunkerObj = new Bunker(Board.STATIC_GUN_X, Board.STATIC_GUN_Y);
    	        Bunker.bunkerObj.isVisible();

    	        Board.initAliens();
    	        Board.initGold();
    	        Board.initDragons();
    	        Board.initHealth();
    	        
    	        Board.timerEasy.stop();
    	        Board.timerMedium.stop();
    	        Board.timerHard.restart();
    	        SoundResources.gameWon.play();
    	        SoundResources.gameLost.stop();
    	        SoundResources.bgMusic.loop();
    	        SoundResources.roar.stop();
        	}
        	    	
		}
		
		
		if (key == KeyEvent.VK_G){
			
			if(!Board.god){
				
				Board.god = true;
				Board.lifeMyShip = -999;
				return;
			}
			
			else{
				
				Board.god = false;
				Board.lifeMyShip = 3;
				return;
				
			}
								
		}
		
						
		
		Board.console = new Console();
		
		if (key == KeyEvent.VK_C && !Board.consoleON){	
			
			Board.console.setVisible(true);
            if(!Board.consoleON == true){
            	
            	Board.consoleON = true;
            }
            
		}
		
		if (key == KeyEvent.VK_O && !Board.manualON){	
			
			Board.manual = new Manual();						
			Board.manual.setVisible(true);
			
			if(!Board.manualON == true){
            	
				Board.manualON = true;
            }
            
		}

		if (key == KeyEvent.VK_ESCAPE){

			System.exit(0);
			
		}
					

    }


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
    

}