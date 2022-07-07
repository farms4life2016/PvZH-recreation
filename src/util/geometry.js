
export class Point {

    x;
    y;

    /**
     * Creates a point in a hypothetical 2D plane
     * @param {Number} x 
     * @param {Number} y 
     */
    constructor(x = 0, y = 0) {
        this.x = x;
        this.y = y;
    }

    /**
     * Moves this point to a new location
     * @param {Number} newX 
     * @param {Number} newY 
     */
    setPosition(newX, newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     * Translates this point by vector (dx, dy)
     * @param {Number} dx 
     * @param {Number} dy 
     */
    translate(dx, dy) {
        this.x += dx;
        this.y += dy;
    }

}

/**
 * Java doc comment lel
 * Using the export kwd allows you to import the class from other files
 */
 export class Rectangle {

    x; y; w; h;
    colour;
    centerX; centerY;

    
    constructor(x=0, y=0, w=0, h=0) {
        this.setDimensions(x, y, w, h);
        this.colour = 'rgba(0, 0, 0, 0)';

    }

    /**
     * stupid js not being able to declare types unless ts or in javadoc :blobweary:
     * @param {Number} r 
     * @param {Number} g 
     * @param {Number} b 
     * @param {Number} a 
     */
    setColourRGBA(r=0, g=0, b=0, a=0) {
        this.colour = 'rgba(' + r + "," + g + "," + b + "," + a + ")";
    }

    /**
     * Input a hex string in the form of "#RRGGBBAA" or "#RRGGBB"
     * @param {String} str 
     */
    setColourHex(str) {
        this.colour = str;
    }

    setDimensions(x=0, y=0, w=0, h=0) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    fillRect(context) {
        context.fillStyle = this.colour;
        context.fillRect(this.x, this.y, this.w, this.h);
    }

}

export class Circle {

    constructor(Xcenter = 0, Ycenter = 0, r = 1) {
        this.hitbox = new Rectangle(0, 0, 0, 0);
        this.setDimensions(Xcenter, Ycenter, r);
        this.colour = 'rgba(0, 0, 0, 0)';
        
    }

    /**
     * stupid js not being able to declare types unless ts or in javadoc :blobweary:
     * @param {Number} r 
     * @param {Number} g 
     * @param {Number} b 
     * @param {Number} a 
     */
     setColour(r=0, g=0, b=0, a=0) {
        this.colour = 'rgba(' + r + "," + g + "," + b + "," + a + ")";
    }

    moveHitbox(newX, newY) {
        this.hitbox.setDimensions(newX, newY, 2*this.r, 2*this.r);
        this.Xcenter = newX + this.r;
        this.Ycenter = newY + this.r;
    }

    translate(vectorX, vectorY) {
        this.moveHitbox(this.hitbox.x + vectorX, this.hitbox.y + vectorY);
    }

    setDimensions(Xcenter, Ycenter, r) {
        this.Xcenter = Xcenter;
        this.Ycenter = Ycenter;
        this.r = r;
        this.hitbox.setDimensions(Xcenter - r, Ycenter - r, 2*r, 2*r);
    }

    fillCircle(context) {
        context.fillStyle = this.colour;

        //must write beginPath so that other paths aren't filled by accident
        context.beginPath();
        context.arc(this.Xcenter, this.Ycenter, this.r, 0, 2*Math.PI, false); //create path
        context.fill(); //fill shape
    }

}
