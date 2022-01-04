


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author admin
 * This class makes a window to play games in
 */
public class test {
	
	//declare variables
	public static final int WINDOW_W = 1030+100, WINDOW_H = 639+50;
	
	/**
	 * @param args This will run first
	 */
	public static void main(String[] args) {
		
		
		
		//variables
		Display bigPanel = new Display(); //make a new window
		JFrame window = new JFrame("Xmas time!"); //name it Vasebreaker Endless
		Container c = window.getContentPane(); //make something to add all the things to
		
		//set window size
		window.setSize(WINDOW_W, WINDOW_H);
		
		//allow window to exit
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add panel to frame
		c.setLayout(new BorderLayout());
		c.add(bigPanel, BorderLayout.CENTER);
		
		//make window visible
		window.setVisible(true);
		
		//the window must be resized to work
		window.setBounds(0, 0, WINDOW_W, WINDOW_H);
		
		
	} //end main method   
    

} //end Vasebreaker class




class Display extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	
	private Point mouse;
	private Timer fps; 
	private String[] giving, receiving;
	private int gamemode;
	private Rectangle next, back, rev, export;
	private boolean show;
	private int pointer;
	
	//note: amy cannot give gift but can receive gift. 
	//anny can give gift but cannot receive gift
	
	
	
	public Display() {
		
		mouse = new Point(0,0);
		gamemode = 0;
		next = new Rectangle(0, 200, 300, 100);
		back = new Rectangle(0, 300, 300, 100);
		rev = new Rectangle(0, 500, 300, 100);
		export = new Rectangle(0, 0, 300, 100);
		show = false;
		pointer = 0;
		
		genArrays();
		
		addMouseMotionListener(this);
		addMouseListener(this);
		
		//update the screen once every 60 milliseconds
		fps = new Timer(60, this); 
		fps.start();
		
		
		
	}
	
	
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

		mouse.setLocation(e.getX(), e.getY());
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource().equals(fps)) {
			repaint();
		}
		
		
	}
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		g.setFont(new Font("Papyrus", Font.BOLD, 40) );
		
		
		//main menu
		if (gamemode == 0) {
			g.drawString("Click anywhere to begin.", 100, 100);
			
		//actual thing
		} else if (gamemode == 1) {
			
			g.setColor(Color.RED);
			g.fillRect(0, 200, 300, 100);
			g.setColor(Color.GREEN);
			g.fillRect(0, 300, 300, 100);
			g.setColor(Color.ORANGE);
			g.fillRect(0, 500, 300, 100);
			g.setColor(Color.CYAN);
			g.fillRect(0, 0, 300, 100);
			
			g.setColor(Color.BLACK);
			g.drawString("Next", 10, 250);
			g.drawString("Back", 10, 350);
			g.drawString("Reveal", 10, 550);
			g.drawString("Export", 10, 50);
			
			g.drawString("Person giving the gift:", 500, 100);
			g.drawString("Person receiving the gift:", 500, 400);
			
			g.setFont(new Font("Times New Roman", Font.BOLD, 80) );
			g.drawString(giving[pointer], 500, 200);
			g.drawString(receiving[pointer], 500, 500);
			
			if (!show) {
				g.setColor(Color.ORANGE);
				g.fillRect(500, 430, 500, 200);
			}
			
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getButton() == MouseEvent.BUTTON1 && gamemode == 0) {
			gamemode++;
		} else if (e.getButton() == MouseEvent.BUTTON1) {
			
			if (next.contains(mouse)) {
				show = false;
				pointer = Math.min(pointer + 1, giving.length - 1);
				
			} else if (back.contains(mouse)) {
				show = false;
				pointer = Math.max(pointer - 1, 0);
				
			} else if (rev.contains(mouse)) {
				show = !show;
			} else if (export.contains(mouse)) {
				
				
				try {
					
					BufferedWriter write = new BufferedWriter( new FileWriter (new File ("Person giving the gift is " + giving[pointer] + ".txt") ) );
					write.write("you are giving a gift to: " + receiving[pointer]);
					write.close();
					
				} catch (IOException ee) {
					ee.printStackTrace();
				}
				
				
			}
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void genArrays() {
		
		try {
			
			BufferedReader in = new BufferedReader( new FileReader ( new File(".\\test.txt") ));
			String lastIn = in.readLine();
			List<String> list = new LinkedList<>();
			boolean flag = true;
			
			while (lastIn != null) {
				list.add(lastIn);
				lastIn = in.readLine();
			}
			
			flag = list.remove("Amy");
			giving = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				giving[i] = list.get(i);
			}
			
			if (flag) list.add("Amy");
			list.remove("Anny");
			receiving = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				receiving[i] = list.get(i);
			}
			
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//randomize receiving array recursively.
		randomize();
		
		//System.out.println(Arrays.toString(giving));
		//System.out.println(Arrays.toString(receiving));
		
				
	}
	
	public void randomize() {
		
		int[] rng = (new Random()).ints(50, 0, receiving.length).toArray();
		boolean redo = false;
		
		for (int i = 0; i < rng.length; i = i + 2) {
			int index1 = rng[i], index2 = rng[i+1];
			
			String temp = receiving[index1];
			receiving[index1] = receiving[index2];
			receiving[index2] = temp;
		}
		
		for (int i = 0; i < giving.length; i++) {
			if (receiving[i].equals(giving[i])) {
				redo = true;
				break;
			}
		}
		
		if (redo) randomize();
		
	}
	
}
