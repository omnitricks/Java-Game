import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener{

	Draw drawing;

	public MyFrame(){
		this.drawing = new Draw();
	}

	public void keyPressed(KeyEvent e){
		boolean Up = false;
		boolean Down = false;
		boolean Right = false;
		boolean Left = false;
	
		if(e.getKeyCode() == KeyEvent.VK_UP){
			Up = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			Down = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			Right = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Left = true;
		}
		
		
		/*if(Up && Right){
			drawing.moveUpRight();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}
		else if(Up && Left){
			drawing.moveUpLeft();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}
		else if(Down && Right){
			drawing.moveDownRight();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}
		else if(Down && Left){
			drawing.moveDownLeft();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}*/
		if(Right){
			drawing.hero1.moveRight();
			System.out.println("pos: " + drawing.hero1.x + ", " + drawing.hero1.y);
		}
		
		else if(Left){
			drawing.hero1.moveLeft();;
			System.out.println("pos: " + drawing.hero1.x + ", " + drawing.hero1.y);
		}
		else if(Down){
			drawing.hero1.moveDown();
			System.out.println("pos: " + drawing.hero1.x + ", " + drawing.hero1.y);
		}
		else if(Up){
			drawing.hero1.moveUp();
			System.out.println("pos: " + drawing.hero1.x + ", " + drawing.hero1.y);
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			drawing.hero1.attack();
			System.out.println("attack");
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){
			drawing.spawnEnemy();
		}
	}

	public void keyReleased(KeyEvent e){

	}

	public void keyTyped(KeyEvent e){
		
	}

	public static void main(String args[]){
		MyFrame gameFrame = new MyFrame();
		gameFrame.setSize(600,600);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(gameFrame.drawing);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("practical programming");
		}
}