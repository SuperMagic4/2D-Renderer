package com.waffler.game;

import java.awt.event.KeyEvent;

import com.waffler.engine.AbstractGame;
import com.waffler.engine.GameContainer;
import com.waffler.engine.Renderer;
import com.waffler.engine.audio.SoundClip;
import com.waffler.engine.gfx.Image;
import com.waffler.engine.gfx.ImageTile;
import com.waffler.engine.gfx.Light;

public class GameManager extends AbstractGame {
	
	private Image image;
	private Image image2;
	private SoundClip clip;
	private Light light;
	private Renderer r;
	
	public GameManager() {
		image = new Image("/64x64.png");
		image.setLightBlock(Light.FULL);
		image.setAlpha(true);
		image2 = new Image("/alphaTest.png");
		image2.setAlpha(true);
		clip = new SoundClip("/audio.wav");
		clip.setVolume(-10);
		light = new Light(100, 0xff00ffff);
	}
	
	public void reset() {
		
	}

	@Override
	public void update(GameContainer gc, float delta) {
		if(gc.getInput().isKeyDown(KeyEvent.VK_A)) {
			clip.play();
		}
		
		temp += delta * 20;
		
		if(temp > 3) {
			temp = 0;
		}
		
	}
	
	float temp = 0;

	@Override
	public void render(GameContainer gc, Renderer r) {

		r.setzDepth(0);
		r.drawImage(image2, 0, 0);
		r.setzDepth(1);
		r.drawImage(image, 100, 100);
		
		r.drawLight(light, gc.getInput().getMouseX(), gc.getInput().getMouseY());
	}
	
	public static void main(String[] args) {
		GameContainer gc = new GameContainer(new GameManager());
		gc.start();
	}

}
