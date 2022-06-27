package farms4life2016.gui.displays;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import farms4life2016.gui.Colours;
import farms4life2016.gui.buttons.AbstractButton;
import farms4life2016.gui.buttons.WIPButton;
import farms4life2016.processing.Controller;
import farms4life2016.util.Rectangle;

import java.awt.Container;

public class MainMenuDisplay extends GenericDisplay {

    //idk if this is a good idea. prob not
    List<AbstractButton> buttons;

    /*
    Buttons required: 
    - play (multiplayer, join game or host)
    - collection
    - achivements
    - wiki?
    - github?
    - updates?
    - zen garden?
    */

    AbstractButton multiplayer, collection, achievements, wiki, github, updates, zenGarden;

    public MainMenuDisplay(Container p) {
        super(p);
        buttons = new ArrayList<>();

        multiplayer = new WIPButton();
        multiplayer.setDimensions(new Rectangle(0, 0, 300, 100));
        multiplayer.setFontSize(24);
        multiplayer.setText("Multiplayer");
        multiplayer.setUnselectedColour(Colours.D_JARATE);
        multiplayer.setSelectedColour(Colours.AQUA);
        multiplayer.setSelected(false);
        buttons.add(multiplayer);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).onClick(e);
        }

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(fps)) {

           
        }
        
    }

    @Override
    protected void paintComponent(Graphics2D g) {
        
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).drawSelf(g);
        }
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Controller.window.dispose();
        System.out.println("end of program?");
    }

}