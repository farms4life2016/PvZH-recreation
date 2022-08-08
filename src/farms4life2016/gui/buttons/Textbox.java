package farms4life2016.gui.buttons;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class Textbox extends AbstractButton {

    @Override
    public void onClick(MouseEvent e) {
        //no onclick        
    }

    @Override
    public void drawSelf(Graphics2D g) {
        
        fillBgRect(g);
        drawText(g);
        
    }
    
}
