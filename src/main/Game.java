package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import engeller.*;
import entities.Labirent;
import inputs.MouseInputs;


public class Game implements Runnable {
	
	private GameWindow gamewindow;
	private GamePanel gamepanel;
	private Thread gameDrawLoop;
	
	private Random randomizer = new Random();
	
	private final int TARGET_FPS = 120;
	private int TARGET_UPS = 20;
	
	private boolean running = true;
	
	private float mouseX;
	private float mouseY;
	private boolean mouseLeft;
	
	//----------------------------------
	
	long sure;
	Labirent l;
	
	Engel a;
	
	public Game() {
		LoadImage();
		InitClasses();
		
		gamepanel = new GamePanel(this);
		gamewindow = new GameWindow(gamepanel);
		gamepanel.setFocusable(true);
		gamepanel.requestFocus();
		
		startGameDraw();
		
		
	}
	
	private void LoadImage() {
		
	}
	
	private void startGameDraw() {
		gameDrawLoop = new Thread(this);
		gameDrawLoop.start();
	}
	
	private void InitClasses() {
		File f = new File("res\\url1.txt");

		l = new Labirent(31, 31);
		/*
		
		try {
		  l = new Labirent(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
		sure = System.currentTimeMillis();
	}

	public void update() {
		setMousePos(mouseX, mouseY);
		
		if(mouseLeft) {
			TARGET_UPS = 100;
		}
		
		l.update();
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		l.draw(g2d);
		long sonsure = System.currentTimeMillis() - sure;
		String a = String.valueOf(sonsure);
		
		g.drawString(a, 50, 50);
	}
	
	@Override
	public void run() {
		
		double timePerFrame = 1000000000.d / TARGET_FPS;
		double timePerUpdate = 1000000000.d / TARGET_UPS;
		
		long currentTime = System.nanoTime();
		long LastTime = System.nanoTime();

		int frames = 0;
		int updates = 0;
		
		long lastTimeMilli = System.currentTimeMillis();
		long currentTimeMilli = System.currentTimeMillis();
		
		double deltaUpdate = 0;
		double deltaFrames = 0;
		while(running) {
			
			currentTime = System.nanoTime();
			currentTimeMilli = System.currentTimeMillis();
			
			deltaUpdate += (currentTime - LastTime) / timePerUpdate;
			deltaFrames += (currentTime - LastTime) / timePerFrame;
			
			LastTime = currentTime;
			
			if(deltaFrames >= 1) {
				gamepanel.repaint();
				frames++;
				deltaFrames--;
			}
			
			if(deltaUpdate >= 1) {
				gamepanel.update();
				updates++;
				deltaUpdate--;
			}
			
			
			
			
			if(currentTimeMilli - lastTimeMilli >= 1000) {
				lastTimeMilli = currentTimeMilli;
				
				System.out.println("FPS: " + frames + " | Updates: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	public void setMouseLeft(boolean press) {
		mouseLeft = press;
	}
	
	public void setMousePos(float x, float y) {
		mouseX = x;
		mouseY = y;
	}
	
	public Color getRandomColor() {
		int r = randomizer.nextInt(255);
		int g = randomizer.nextInt(255);
		int b = randomizer.nextInt(255);
		return new Color(r, g, b);
	}

}
