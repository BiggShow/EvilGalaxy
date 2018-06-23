package game_engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import entities.Alien;
import entities.Dragon;
import entities.MyShip;
import frames.Manual;
import game_engine.Difficulty;
import game_engine.InitObjects;
import game_engine.UpdateObjects;
import items.Gold;
import items.VolBtn;
import sound_engine.LoadSounds;

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
			LoadSounds.bgMusic.stop();
        }
		
		if (key == KeyEvent.VK_A) {
			if(InitObjects.timerEasy.isRunning() || InitObjects.timerHard.isRunning() 
					|| InitObjects.timerMedium.isRunning()){
				LoadSounds.bgMusic.loop();
			}
        }
		
		if (key == KeyEvent.VK_P) {
			InitObjects.timerEasy.stop();
			InitObjects.timerHard.stop();
			InitObjects.timerMedium.stop();
			
			LoadSounds.bgMusic.stop();
			LoadSounds.roar.stop();
        }
		
		
		if (InitObjects.ingame == true && (InitObjects.timerEasy.isRunning() == true || 
				InitObjects.timerMedium.isRunning() == true || InitObjects.timerHard.isRunning() == true) 
				&& key == KeyEvent.VK_CONTROL 
				&& (Alien.aliens.isEmpty() 
						&& (Dragon.dragons.size() > 0 || UpdateObjects.lifeBunker < 50 || Gold.goldstack.isEmpty()))) {
			MyShip.myShip.loadRockets();
        }


		if (InitObjects.ingame == true && (InitObjects.timerEasy.isRunning() == true || InitObjects.timerMedium.isRunning() == true || InitObjects.timerHard.isRunning() == true) 
				&& key == KeyEvent.VK_CONTROL && 
				(Alien.aliens.size() > 0 || (Dragon.dragons.isEmpty() && UpdateObjects.lifeBunker >= 50 && Gold.goldstack.size() > 0))) {
			MyShip.myShip.gunempty();
		}
		
		if (InitObjects.ingame == true && (InitObjects.timerEasy.isRunning() == true || InitObjects.timerMedium.isRunning() == true || InitObjects.timerHard.isRunning() == true) 
				&& key == KeyEvent.VK_SPACE && 
				(Alien.aliens.size() > 0 || (Dragon.dragons.isEmpty() && UpdateObjects.lifeBunker < 50) || 
						(UpdateObjects.lifeBunker >= 50 && Gold.goldstack.isEmpty()))) {
			MyShip.myShip.loadMissiles();
        }
		
		if (InitObjects.ingame == true && (InitObjects.timerEasy.isRunning() == true || InitObjects.timerMedium.isRunning() == true || InitObjects.timerHard.isRunning() == true) 
				&& key == KeyEvent.VK_SPACE && 
				(Alien.aliens.isEmpty() && Dragon.dragons.size() > 0 || (Dragon.dragons.isEmpty() && UpdateObjects.lifeBunker >= 50 && Gold.goldstack.size() > 0))){
			MyShip.myShip.gunempty();
		}
		
						
		if (key == KeyEvent.VK_2){
			
			if (Alien.aliens.size() > 0) {
				Alien.aliens.clear();
				return;
			}
		}
		
		if (key == KeyEvent.VK_3){
			
			if(InitObjects.ingame == true && (Alien.aliens.size() > 0 || Dragon.dragons.size() > 0)){
				Alien.aliens.clear();
				Dragon.dragons.clear();
				return;
			}
		}
		
		if (key == KeyEvent.VK_4){
			
			if(InitObjects.ingame == true && (Alien.aliens.size() > 0 || Dragon.dragons.size() > 0 
					|| UpdateObjects.lifeBunker < 50)){
				Alien.aliens.clear();
				Dragon.dragons.clear();
				UpdateObjects.lifeBunker = 50;
				return;
			}
		}
		
		if (key == KeyEvent.VK_R){
			
            Difficulty.restart();
		}
		
		
		if (key == KeyEvent.VK_E){
			
			InitObjects.manualON = false;
			InitObjects.timerHard.stop();
			InitObjects.timerMedium.stop();
			InitObjects.timerEasy.start();
			LoadSounds.bgMusic.loop();
			
			if(Alien.aliens.isEmpty()){
        		LoadSounds.roar.loop();
        	}
        	if(!InitObjects.ingame){
    	    
        		Difficulty.easy();
        	}
        	
		}
		
		
	if (key == KeyEvent.VK_M){
			
			InitObjects.manualON = false;
			InitObjects.timerEasy.stop();
			InitObjects.timerHard.stop();
			InitObjects.timerMedium.start();
			LoadSounds.bgMusic.loop();
			
        	if(Alien.aliens.isEmpty()){
        		LoadSounds.roar.loop();
        	}
        	if(!InitObjects.ingame){
        	
        		Difficulty.medium();
        	}
        						

		}

		
		if (key == KeyEvent.VK_H){
			
			InitObjects.manualON = false;
			InitObjects.timerEasy.stop();
			InitObjects.timerMedium.stop();
			InitObjects.timerHard.start();
			LoadSounds.bgMusic.loop();
			
        	if(Alien.aliens.isEmpty()){
        		LoadSounds.roar.loop();
        	}
        	if(!InitObjects.ingame){
        		
        		Difficulty.hard();
        	}
        	    	
		}
		
		
		if (key == KeyEvent.VK_G){
			
			if(!InitObjects.god){
				
				InitObjects.god = true;
				UpdateObjects.lifeMyShip = -999;
				return;
			}
			
			else{
				
				InitObjects.god = false;
				UpdateObjects.lifeMyShip = 3;
				return;
				
			}
								
		}
		
		
		if (key == KeyEvent.VK_O && !InitObjects.manualON){	
			
			InitObjects.manual = new Manual();						
			InitObjects.manual.setVisible(true);
			
			if(!InitObjects.manualON == true){
            	
				InitObjects.manualON = true;
            }
            
		}

		if (key == KeyEvent.VK_ESCAPE){

			System.exit(0);
			
		}
					

    }

	@Override
	public void keyTyped(KeyEvent e) {

		
	}
    
}