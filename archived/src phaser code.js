console.log("I like to eat chocolate chip cookies.")

const WIDTH = 1080;
const HEIGHT = 720;
const config = {
    type : Phaser.AUTO,
    width : WIDTH,
    height : HEIGHT,
    
    scene: {
        preload : preload,
        create : create,
        update : update
    }
};

const game = new Phaser.Game(config);

//keyboard input
let keys;
let textbox;
let player;
let graphics;
let rect;

function preload() {
    
    //this.load.image('bg', 'images\\day.png');

}

function create() {

    //const bg = this.add.image(0, 0, 'bg').setOrigin(0,0);

    //bg.setTint(0xFFFF00);
    //bg.setAlpha(0.2);

    //let rectangle1 = this.add.rectangle(600, 600, 150, 150, 0xFFFFFF);

    /*
        Geom class very useful!
        https://newdocs.phaser.io/docs/3.55.2/Phaser.Geom.Rectangle
    */

    rect = new Phaser.Geom.Rectangle(0, 0, WIDTH, HEIGHT); //creates a rectangle object
    player = new Phaser.Geom.Circle(50, 50, 5);

    graphics = this.add.graphics(
        {
            lineStyle: {width : 4, color : 0x0000aa}, //colour to outline shapes with + thiccness
            fillStyle: {color : 0x00aa00} //colour to fill shapes with
        }
    );

    graphics.clear(); //idk why this is necessary but it is
    graphics.fillRectShape(rect); //fills the rectangle object

    //graphics.clear();

    //graphics.fillStyle(0xaa0000);
    graphics.strokeCircleShape(player);

    //init keyboard input
    keys = this.input.keyboard.addKeys('W, A, S, D'); //u can add more keys in the string
    textbox = this.add.text(10, 10, "now's your chance"); //draw text on screen

    

}

function update() {

    //poll keyboard input 
    if (keys.A.isDown) {
        textbox.setText("previously pressed key: A");
        Phaser.Geom.Circle.Offset(player, -5, 0);
    } else if (keys.D.isDown) {
        textbox.setText("previously pressed key: D");
        Phaser.Geom.Circle.Offset(player, +5, 0);
        //console.log(player);
    } else if (keys.S.isDown) {
        textbox.setText("previously pressed key: S");
        Phaser.Geom.Circle.Offset(player, 0, 5);
    } else if (keys.W.isDown) {
        textbox.setText("previously pressed key: W");
        Phaser.Geom.Circle.Offset(player, 0, -5);
    } else {
        //v = 0
    }

    //graphics.fillRectShape(rect);
    graphics.strokeCircleShape(player);
    //graphics.clear();

    //more keys can be added, just make sure to init the letters
    //go here to find keycodes https://newdocs.phaser.io/docs/3.55.2/Phaser.Input.Keyboard.KeyCodes
    
    
}

//do not use monke docs, use this instead https://www.phaser.io/examples/v3