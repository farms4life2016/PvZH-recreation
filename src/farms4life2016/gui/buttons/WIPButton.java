package farms4life2016.gui.buttons;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class WIPButton extends AbstractButton {



    @Override
    public void onClick(MouseEvent e) {
        System.out.println(text);       
    }

    @Override
    public void drawSelf(Graphics2D g) {
        
        fillBgRect(g);
        drawBorders(g, 1, getSelectedColour());
        drawText(g);
        
    }

    
    
}
