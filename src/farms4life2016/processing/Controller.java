package farms4life2016.processing;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import farms4life2016.gui.StringDrawer;
import farms4life2016.gui.displays.MainMenuDisplay;


public class Controller {

    public static final int WINDOW_W = 1200, WINDOW_H = 720;

    public static JFrame window;
    public static MainMenuDisplay mainMenu;
    public static CardLayout cdLayout;
    
    public static void run() {
        initGUI();

    }

    public static void initGUI() {

        //variables
        new StringDrawer();
        
        cdLayout = new CardLayout();
        window = new JFrame("Plants vs. Zombies Heroes - Recreation"); //name it 
        mainMenu = new MainMenuDisplay(window); //make a new window
        Container c = window.getContentPane(); //make something to add all the things to 

        //set window size, cannot resize
        window.setSize(WINDOW_W, WINDOW_H);
        window.setResizable(false);
        window.setIconImage(new ImageIcon("icons\\Logo.png").getImage());
        
        //add panel to frame
        c.setLayout(cdLayout);
        c.add("mainmenu", mainMenu);
        cdLayout.show(c, "mainmenu");
        mainMenu.setBackground(Color.GRAY);

        //why do we have to add this listener here I'm so confused
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
        window.addWindowListener(mainMenu);
        
        //final touches to make window visible and usable
        window.setVisible(true);
        
    }
}
