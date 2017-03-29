package Objects;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Frog extends MovableObject  {

	private int direction;
	BufferedImage sprite;

	public Frog() {
		
		try {
			sprite = ImageIO.read(new File("src/resources/sprite.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		MovingObject = sprite.getSubimage(0, 0, 50,75).getScaledInstance(80, 90, Image.SCALE_DEFAULT);
		//JLabel Grenouille = new JLabel(new ImageIcon(MovingObject));
		
		//Grenouille.setFocusable(true);
		//Grenouille.setOpaque(false);

	}

	public int getX() {
		return posX;
	}

	public int getY() {
		return posY;
	}

	public int getDirection() {
		return direction;
	}

	@Override
	public void move(int x, int y) {
		this.posX = x;
		this.posY = y;

	}
	//il faut s'assurer que le mouvement de la grenouille se fait avec le bon nombre de pixels par rapport au GameFrame.
	
	void up(){
		
		move(posX,posY-GAP_BETWEEN_LANES);
	}
	void down(){
		move(posX,posY+GAP_BETWEEN_LANES);
	}	
	void right(){
		move(posX+LEFT_RIGHT_SHIFT,posY);
	}	
	void left(){
		move(posX-LEFT_RIGHT_SHIFT,posY);
	}

}
