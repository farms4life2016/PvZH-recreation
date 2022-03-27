package farms4life2016.gui.displays;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import farms4life2016.processing.Controller;

import java.awt.Container;

public class MainMenuDisplay extends GenericDisplay {

    public MainMenuDisplay(Container p) {
        super(p);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void paintComponent(Graphics2D g) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Controller.window.dispose();
        System.out.println("end of program?");
    }

}