package items;

import java.util.ArrayList;

import game_engine.SpritePattern;

public class Gold extends SpritePattern {

 public static ArrayList < Gold > goldstack;
 private final int INITIAL_Y = 1200;

 public Gold(int x, int y) {
  super(x, y);

  initGifts();
 }

 private void initGifts() {

  loadImage("images/gold.png");
  getImageDimensions();
 }

 public void move() {

  if (y < 0) {
   y = INITIAL_Y;
  }

  y -= 1;

 }
}