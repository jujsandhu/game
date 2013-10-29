import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;

//subclass of JFrame, so we have a window, hence why we can use setBackground
public class Main extends JFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//x,y,bit depth(number of colours), refresh rate(i dont know, default)
		DisplayMode dm = new DisplayMode(800,600,16, DisplayMode.REFRESH_RATE_UNKNOWN);
        Main main = new Main();
        main.run(dm);
	}

	public void run(DisplayMode dm) {
		setBackground(Color.PINK);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN,24));
		
		Screen scrn = new Screen();
		try{
			scrn.setFullScreen(dm, this);
			try{
				Thread.sleep(5000);
			}catch(Exception ex){}
		}catch(Exception ex){
			
		}finally{
			scrn.restoreScreen();
		}
	}
	
	//whenever you extend JFrame it calls paint ONCE automatically
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.drawString("This is gonna be awesome, i am about to do nuts", 200, 200);
	}
	

}
