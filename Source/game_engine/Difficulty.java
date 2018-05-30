package game_engine;

import java.awt.Toolkit;
import entities.Bunker;
import entities.EvilHead;
import entities.MyShip;
import items.VolBtn;
import sound_engine.LoadSounds;

public class Difficulty {

	public static void restart(){
		
	    DrawScene.bg1 = Toolkit.getDefaultToolkit().createImage("images/tenor.gif");
        InitObjects.ingame = true;
        UpdateObjects.lifeEvilHead = 3;
        UpdateObjects.lifeMyShip = 3;
        UpdateObjects.lifeBunker = 3;
        
        MyShip.myShip = new MyShip(40, 180);
        MyShip.myShip.isVisible();
        
        EvilHead.evilHead = new EvilHead(640, 180);
        EvilHead.evilHead.isVisible();
        EvilHead.evilHead.AIOnEasy();
        
        Bunker.bunkerObj = new Bunker(450, 680);
        Bunker.bunkerObj.isVisible();
        
        VolBtn.volButt = new VolBtn(940, 15);
        VolBtn.volButt.isVisible();

		InitObjects.initAliens();
		InitObjects.initGold();
		InitObjects.initDragons();
		InitObjects.initHealth();
		
        InitObjects.timerHard.stop();
        InitObjects.timerMedium.stop();
        InitObjects.timerEasy.restart();
        LoadSounds.gameWon.play();
        LoadSounds.gameLost.stop();
        LoadSounds.bgMusic.loop();
        LoadSounds.roar.stop();		
	}
	
	public static void easy(){
			
		DrawScene.bg1 = Toolkit.getDefaultToolkit().createImage("images/tenor.gif");
		InitObjects.ingame = true;
		UpdateObjects.lifeEvilHead = 3;
		UpdateObjects.lifeMyShip = 3;
		UpdateObjects.lifeBunker = 3;
        
		MyShip.myShip = new MyShip(40, 180);
		MyShip.myShip.isVisible();
        
		EvilHead.evilHead = new EvilHead(640, 180);
		EvilHead.evilHead.isVisible();
		EvilHead.evilHead.AIOnMedium();
		
		Bunker.bunkerObj = new Bunker(450, 680);
		Bunker.bunkerObj.isVisible();
        
		VolBtn.volButt = new VolBtn(940, 15);
		VolBtn.volButt.isVisible();

		InitObjects.initAliens();
		InitObjects.initGold();
		InitObjects.initDragons();
		InitObjects.initHealth();
		
		InitObjects.timerMedium.stop();
		InitObjects.timerHard.stop();;
		InitObjects.timerEasy.restart();
		LoadSounds.gameWon.play();
		LoadSounds.gameLost.stop();
		LoadSounds.bgMusic.loop();
		LoadSounds.roar.stop();
	}
	
	public static void medium(){
		
		DrawScene.bg1 = Toolkit.getDefaultToolkit().createImage("images/tenor.gif");
		InitObjects.ingame = true;
		UpdateObjects.lifeEvilHead = 3;
		UpdateObjects.lifeMyShip = 3;
		UpdateObjects.lifeBunker = 3;
        
		MyShip.myShip = new MyShip(40, 180);
		MyShip.myShip.isVisible();
        
		EvilHead.evilHead = new EvilHead(640, 180);
		EvilHead.evilHead.isVisible();
		EvilHead.evilHead.AIOnMedium();
		
		Bunker.bunkerObj = new Bunker(450, 680);
		Bunker.bunkerObj.isVisible();
        
		VolBtn.volButt = new VolBtn(940, 15);
		VolBtn.volButt.isVisible();

		InitObjects.initAliens();
		InitObjects.initGold();
		InitObjects.initDragons();
		InitObjects.initHealth();
		
		InitObjects.timerEasy.stop();
		InitObjects.timerHard.stop();;
		InitObjects.timerMedium.restart();
		
		LoadSounds.gameWon.play();
		LoadSounds.gameLost.stop();
		LoadSounds.bgMusic.loop();
		LoadSounds.roar.stop();
	}
	
	public static void hard(){
		
		DrawScene.bg1 = Toolkit.getDefaultToolkit().createImage("images/tenor.gif");
		InitObjects.ingame = true;
		UpdateObjects.lifeEvilHead = 3;
		UpdateObjects.lifeMyShip = 3;
		UpdateObjects.lifeBunker = 3;
		
		MyShip.myShip = new MyShip(40, 180);
		MyShip.myShip.isVisible();
        
		EvilHead.evilHead = new EvilHead(640, 180);
		EvilHead.evilHead.isVisible();
		EvilHead.evilHead.AIOnMedium();
		
		Bunker.bunkerObj = new Bunker(450, 680);
		Bunker.bunkerObj.isVisible();
        
		VolBtn.volButt = new VolBtn(940, 15);
		VolBtn.volButt.isVisible();

		InitObjects.initAliens();
		InitObjects.initGold();
		InitObjects.initDragons();
		InitObjects.initHealth();
        
		InitObjects.timerEasy.stop();
		InitObjects.timerMedium.stop();;
		InitObjects.timerHard.restart();
		LoadSounds.gameWon.play();
		LoadSounds.gameLost.stop();
		LoadSounds.bgMusic.loop();
		LoadSounds.roar.stop();
	}

}