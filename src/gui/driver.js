import {Random} from "../../util/random.js";

//get the canvas and stuff to draw on
const canvas = document.getElementById("gamewindow");
const HEIGHT = canvas.height, WIDTH = canvas.width;
const ctx = canvas.getContext("2d");


let driver;


export class Driver {

    static HEIGHT = HEIGHT;
    static WIDTH = WIDTH;
    static context = ctx;

    x = 50;
    static tick = 0;
    static gamemode = "mainmenu";

    /**
     * Begin the game!
     */
    constructor() {
        window.requestAnimationFrame(Driver.repaint);

        //internal clock for calculations runs at 30 ticks per second
        setInterval(Driver.increaseTimer, 1000/30);


        console.log(1000/30);
    }

    static repaint() {

        //clear previous garbage
        ctx.clearRect(0, 0, WIDTH, HEIGHT);
        //ctx.fillStyle = 'rgb(0, 0, 0)';
        //ctx.fillRect(0, 0, WIDTH, HEIGHT);

        ctx.fillStyle = '#696969';
        let s = Math.abs(Math.sin(this.tick) * 50);
        ctx.fillRect(30, 30, s, s);

        ctx.font = "69px Comic Sans MS";
        ctx.textAlign = "center";
        ctx.strokeStyle = "#FF00FF";
        ctx.strokeText("ticks: " + this.tick, 600, 200);
        

        window.requestAnimationFrame(this.repaint);

    }

    static onClick(e) {
        //for debugging
        console.log(e.clientX + " " +  e.clientY);
        
    }

    static increaseTimer() {
        this.tick++;

        
    }

}

for (let index = 0; index < 10; index++) {
    console.log(Random.randint(1, 10));
}

driver = new Driver();

//add listeners
document.addEventListener('click', driver.onClick);


