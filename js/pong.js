
//tarriff free imports
import { Circle, Rectangle } from "./geometry.js";

//get the canvas and stuff to draw on
const canvas = document.getElementById("gamewindow");
const HEIGHT = canvas.height, WIDTH = canvas.width;
const ctx = canvas.getContext("2d");

//variables
let x = 0;
let t = 0;

let lawn = new Rectangle(300, 120, 1200 - 300, 670-120);
lawn.setColour(8,164,24,255);

let bgRect = new Rectangle(0, 0, WIDTH, HEIGHT);
bgRect.colour = '#f4ecca';

const paddle = {
    hitbox: new Rectangle(),
    vy: 0
};
paddle.hitbox.setColour(240, 0, 0, 1);
paddle.hitbox.setDimensions(300-20, 120 + lawn.h/2 - 50, 20, 100);

const ball = {
    circle: new Circle(),
    vx: 5,
    vy: 2
};
ball.circle.setDimensions(300 + 20, 120 + lawn.h/2 - 10, 20);
ball.circle.setColour(200, 200, 0, 1);

//let lawn = new Image();
//lawn.src = 'day.png';


//please work lol
window.start = start;

//check for canvas support (do we really need this?)
if (canvas.getContext) {
    //const ctx = canvas.getContext("2d");


//canvas not supported
} else {
    //exit(); 
}

function repaint() {

    ctx.clearRect(0, 0, WIDTH, HEIGHT) //clear previous garbage
    bgRect.fillRect(ctx);

    //draw the background lawn
    //ctx.drawImage(lawn, 0, 0, lawn.width * (HEIGHT/lawn.height), HEIGHT);
    lawn.fillRect(ctx);

    ctx.fillStyle = 'rgba(200, 0 , 0, 0.6)';
    ctx.fillRect(30, 30, 50, 50);

    ctx.beginPath();
    ctx.fillStyle = "rgba(0, 150, 200, 0.8)";
    ctx.arc(30, 30, 50, 0, 2*Math.PI, false);
    ctx.fill();
    //ctx.fillRect(x, 20, 60, 60);

    //draw stuffs
    paddle.hitbox.fillRect(ctx);
    ball.circle.fillCircle(ctx);

    //update stuff

    //prevent paddle from going outside of screen
    if (paddle.hitbox.y <= lawn.y && paddle.vy < 0) paddle.vy = 0;
    else if (paddle.hitbox.y + paddle.hitbox.h >= lawn.y + lawn.h && paddle.vy > 0) paddle.vy = 0;
    paddle.hitbox.y += paddle.vy;

    //prevent ball from leaving lawn and realistic bouncing
    if (ball.circle.hitbox.y <= lawn.y) {bounceBall('up'); }
    else if (ball.circle.hitbox.y + ball.circle.hitbox.h >= lawn.h + lawn.y) {bounceBall('down');}

    if (ball.circle.hitbox.x + ball.circle.hitbox.w >= lawn.x + lawn.w) bounceBall('right');
    else if (ball.circle.hitbox.x < lawn.x) bounceBall('left'); //TEMP

    ball.circle.translate(ball.vx, ball.vy);
    

    window.requestAnimationFrame(repaint);
}

function keyDown(e) {

    //move left if W or up arrow is pressed
    if (e.keyCode == 87 || e.keyCode == 38) {
        paddle.vy = -5; //-10
         
    //move right if S or down arrow is pressed
    } else if (e.keyCode == 83 || e.keyCode == 40) {
        paddle.vy = +5;
    }
}

function keyUp(e) {
    //stop velocity of paddle when key is released
    if (e.keyCode == 87 || e.keyCode == 38 || e.keyCode == 83 || e.keyCode == 40) paddle.vy = 0;
}

function onClick(e) {
    //for debugging
    console.log(e.clientX + " " +  e.clientY);

}

function start() {
    window.requestAnimationFrame(repaint);
    //probably don't use a separate tick system unless ur spawning mobs or doing redstone lol
    //setInterval( increaseTimer, 50);  //this is the speed that minecraft runs at ._. which is not very smooth
    //setInterval( increaseTimer, 30/1000); //trying out 60 fps, which is faster than requestAnimFrame lol
    //setInterval( increaseTimer, 10); //seems like a decent speed for animations, v silimar to requestAnimFrame
}

function increaseTimer() {
    t++;
}

/**
 * changes vx and vy of the ball
 * @param {string} surface acceptable values: 'left', 'right', 'up', 'down'
 */
function bounceBall(surface) {
    let rng = Math.floor(Math.random() * 3) - 1;
    if (surface === 'left' || surface === 'right') {
        ball.vx = - ball.vx + rng;
    } else if (surface === 'up' || surface === 'down') {
        ball.vy = - ball.vy + rng;
    }
}

//keyboard listener
document.addEventListener('keydown', keyDown);
document.addEventListener('click', onClick);
document.addEventListener('keyup', keyUp);