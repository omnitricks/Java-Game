import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

public class Hero{
	
	public BufferedImage image;
	public URL resource = getClass().getResource("run0.png");

	// circle's position
	public int x = 300;
	public int y = 300;
	public int height = 0;
	public int width = 0;
	public int direction = 0;

	// animation states
	public int state = 0;
	
	public Draw comp;
	
	public Hero(Draw comp){
		this.comp = comp;
	}

	public void reloadImage(){
		state++;
		if(direction == 0){
			if(state == 0){
				resource = getClass().getResource("run0.png");
			}
			else if(state == 1){
				resource = getClass().getResource("run1.png");
			}
			else if(state == 2){
				resource = getClass().getResource("run2.png");
			}
			else if(state == 3){
				resource = getClass().getResource("run3.png");
			}
			else if(state == 4){
				resource = getClass().getResource("run4.png");
			}
			else if(state == 5){
				resource = getClass().getResource("run5.png");
				state = 0;
			}
		}else {
			if(state == 0){
				resource = getClass().getResource("run0alt.png");
			}
			else if(state == 1){
				resource = getClass().getResource("run1alt.png");
			}
			else if(state == 2){
				resource = getClass().getResource("run2alt.png");
			}
			else if(state == 3){
				resource = getClass().getResource("run3alt.png");
			}
			else if(state == 4){
				resource = getClass().getResource("run4alt.png");
			}
			else if(state == 5){
				resource = getClass().getResource("run5alt.png");
				state = 0;
			}
		}
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		comp.repaint();
	}

	public void attackAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				if(direction == 0){
					for(int ctr = 0; ctr < 5; ctr++){
						try {
							if(ctr==4){
								resource = getClass().getResource("run0.png");
							}
							else{
								resource = getClass().getResource("attack"+ctr+".png");
							}
							
							try{
								image = ImageIO.read(resource);
							}
							catch(IOException e){
								e.printStackTrace();
							}
							comp.repaint();
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else{
					for(int ctr = 0; ctr < 5; ctr++){
						try {
							if(ctr==4){
								resource = getClass().getResource("run0alt.png");
							}
							else{
								resource = getClass().getResource("attack"+ctr+"alt.png");
							}
							
							try{
								image = ImageIO.read(resource);
							}
							catch(IOException e){
								e.printStackTrace();
							}
							comp.repaint();
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				
			}
		});
		thread1.start();
		comp.checkCollision();
		comp.checkDamage();
	}

	public void attack(){
		attackAnimation();
	}
	

	public void moveUp(){
		y = y - 5;
		reloadImage();
	}

	public void moveDown(){
		y = y + 5;
		reloadImage();
	}

	public void moveLeft(){
		direction = 1;
		x = x - 5;
		reloadImage();
	}

	public void moveRight(){
		direction = 0;
		x = x + 5;
		reloadImage();
	}
	
	
	public void moveUpRight(){
		direction = 0;
		x = x + 5;
		y = y - 5;
		reloadImage();
		
	}

	public void moveDownLeft(){
		direction = 1;
		x = x - 5;
		y = y + 5;
		reloadImage();
	}

	public void moveUpLeft(){
		direction = 1;
		x = x - 5;
		y = y - 5;
		reloadImage();
	}

	public void moveDownRight(){
		direction = 0;
		x = x + 5;
		y = y + 5;
		reloadImage();
	}

	
}