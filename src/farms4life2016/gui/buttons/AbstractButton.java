package farms4life2016.gui.buttons;

import java.awt.Color;
import java.awt.Font;
import farms4life2016.util.Rectangle;
import java.awt.Graphics2D;

import java.awt.event.MouseEvent;

import farms4life2016.gui.Colours;
import farms4life2016.gui.StringDrawer;

public abstract class AbstractButton {

    //these variables should only be interacted with using setter/getters
    private boolean isSelected;
    private Color currentColour;

    //these variables can be modified by subclasses freely
    protected Color textColour, unselectedColour, selectedColour;
    protected Rectangle dimensions;
    protected String text;
    protected int textFormat;
    protected float fontSize;
    

    public static final int CENTERED = 0, LEFT_ALIGN = 1;

    public AbstractButton() {
        this(0, 0, 0, 0);
        
    }

    public AbstractButton(int x, int y, int w, int h) {
        //set vars to some non-null values
        dimensions = (new Rectangle(x, y, w, h));
        isSelected = false;
        unselectedColour = selectedColour = currentColour = Colours.GRAY80;
        textColour = Colours.WHITE;
        text = "farms4life2016";
        textFormat = LEFT_ALIGN;
        fontSize = 16;        

    }

    /**
     * how the button interacts when you click it
     * @param e
     */
    public abstract void onClick(MouseEvent e);

    /**
     * How the button should display itself on the gui
     * @param g
     */
    public abstract void drawSelf(Graphics2D g);

    /**
     * Draw borders around this button
     * @param g
     * @param width
     * @param colour
     */
    protected void drawBorders(Graphics2D g, int width, Color colour) {

        //draw in the borders
        g.setColor(colour);
        g.fillRect(dimensions.x, dimensions.y, width, dimensions.height);
		g.fillRect(dimensions.x, dimensions.y, dimensions.width, width);
        g.fillRect(dimensions.x + dimensions.width, dimensions.y, width, dimensions.height + width);
		g.fillRect(dimensions.x, dimensions.y + dimensions.height, dimensions.width, width);

    }

    /**
     * Draw the background colour for this button
     * @param g
     */
    protected void fillBgRect(Graphics2D g) {

        //draw in background colour
        g.setColor(getCurrentColour());
        g.fillRect(dimensions.x, dimensions.y, dimensions.width, dimensions.height);

    }

    /**
     * Draw text on this button
     * @param g
     */
    protected void drawText(Graphics2D g) {

        //draw the text
        g.setColor(textColour);
        if (textFormat == LEFT_ALIGN) {
            StringDrawer.drawStringCenteredYLeftAligned(g, text, dimensions, Font.PLAIN, fontSize);
        } else if (textFormat == CENTERED) {
            StringDrawer.drawStringSuperCentered(g, text, dimensions, Font.PLAIN, fontSize);
        }
        
    }

    @Override
    public String toString() {
        return dimensions.toString();
    }

    /**
     * Setters and getters 
     */

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;

        //change cell colour if this cell's selection changes
        if (this.isSelected) {
            currentColour = selectedColour;
        } else {
            currentColour = unselectedColour;
        }
    }

    public Color getUnselectedColour() {
        return unselectedColour;
    }

    public void setUnselectedColour(Color unselectedColour) {
        this.unselectedColour = unselectedColour;
    }

    public Color getSelectedColour() {
        return selectedColour;
    }

    public void setSelectedColour(Color selectedColour) {
        this.selectedColour = selectedColour;
    }

    public Color getTextColour() {
        return textColour;
    }

    public void setTextColour(Color textColour) {
        this.textColour = textColour;
    }

    public Color getCurrentColour() {
        return currentColour;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextFormat() {
        return textFormat;
    }

    public void setTextFormat(int textFormat) {
        this.textFormat = textFormat;
    }

    public float getFontSize() {
        return fontSize;
    }

    public void setFontSize(float fontSize) {
        this.fontSize = fontSize;
    }

    //the following 4 methods get some part of the button's
    //dimensions

    public int getX() {
        return dimensions.x;
    }

    public int getY() {
        return dimensions.y;
    }

    public int getWidth() {
        return dimensions.width;
    }

    public int getHeight() {
        return dimensions.height;
    }


    public Rectangle getDimensions() {
        return dimensions;
    }

    public void setDimensions(Rectangle dimensions) {
        this.dimensions = dimensions;
    }

}