package Objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FroggerPanel extends JPanel implements KeyListener, Runnable {

	public static int HEIGHT = 600;
	public static int WIDTH = 720;

	Image truck, car, sLog, mLog, bLog;
	
    private FroggerGame game;
	private BufferedImage sprite;
    private int dx = 0;
    private int dy = 10;
	private int posX,posY = 50;
	private int VelX,VelY =0;
	
	Timer time = new Timer();
	
	public FroggerPanel() {

		setSize(HEIGHT, WIDTH);
		reset();
		
		   Thread pThread;

	        try {
	            pThread = new Thread(this);
	            pThread.start();
	        } catch (Exception e) {
	            System.err.println("Error creating thread.");
	            e.printStackTrace();
	            System.exit(-2);
	        }
		
		try {
			sprite = ImageIO.read(new File("src/resources/sprite.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		truck = sprite.getSubimage(200, 400, 300, 75).getScaledInstance(280, 55, Image.SCALE_DEFAULT);
		car = sprite.getSubimage(300, 480, 145, 75).getScaledInstance(135, 55, Image.SCALE_DEFAULT);
		sLog = sprite.getSubimage(380, 240, 200, 75).getScaledInstance(125, 70, Image.SCALE_DEFAULT);
		mLog = sprite.getSubimage(380, 240, 200, 75).getScaledInstance(175, 70, Image.SCALE_DEFAULT);
		bLog = sprite.getSubimage(380, 240, 200, 75).getScaledInstance(250, 70, Image.SCALE_DEFAULT);

		setOpaque(false);
		
		addKeyListener(this);	
		setFocusable(true);
		requestFocus();
		
	}

	//on dessine les �l�ments sur le terrain, suffit de les faire bouger maintenant
	public void paint(Graphics g) {
	
		g.drawImage(truck, 300, 372, null);
		g.drawImage(car, 80, 425, null);
		g.drawImage(sLog, 80, 30, null);
		g.drawImage(sLog, 80, 85, null);
		g.drawImage(bLog, 80, 140, null);
		g.drawImage(sLog, 80, 195, null);
		g.drawImage(mLog, 80, 250, null);
		
		
		g.setFont(new Font("Arial",Font.CENTER_BASELINE,32));
        int time = game.getTimeLeft();
        g.drawString("Time Left: "+time, 10, getHeight() - 30);
        
  		g.drawString("Lives: ", 400, getHeight()-30);
		g.setColor(Color.RED);
	    for (int i = 0; i < game.getLives(); i++) 
	    {
	    	g.drawString("♥", 500 + i * 30, getHeight() - 30);
	    }
	   
	    g.drawImage(game.getFrog().MovingObject, game.getFrog().getX(), game.getFrog().getY(), null);
	}
		//l'initialisation de la grenouille cr�� des erreurs :(

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			game.getFrog().up();
			System.out.println("up");
		}
		if (code == KeyEvent.VK_RIGHT) {
			game.getFrog().right();
			System.out.println("right");
		}
		if (code == KeyEvent.VK_LEFT) {
			game.getFrog().left();
			System.out.println("left");
		}
		if (code == KeyEvent.VK_DOWN) {
			game.getFrog().down();
			System.out.println("down");
		}
		repaint();

	}



	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			update();
			repaint();
			try {
				Thread.sleep(35);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
	}
	
	public void update(){
		game.update();
	}
	public void reset(){
		game = new FroggerGame();
	}

}