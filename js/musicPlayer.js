const audio = new Audio('Zombies on Your Lawn.mp3');
audio.loop = true;

const canvas = document.getElementById("gamewindow");
const ctx = canvas.getContext("2d");
ctx.fillStyle = "#FF2369";
ctx.fillRect(0, 0, 150, 140);

document.onmousedown = mouseDown;

function mouseDown(e) {
	
	//alert('Page: ' + e.pageX + " " + e.pageY + ' Client: ' + e.clientX);
}

function play() {
	
	audio.play();
	interval = setInterval(play_a_lot, 2000);
	
	
}

function print_ln(str) {
	console.log(str);
}

function pause() {
	audio.pause();
}

function play_a_lot() {
	const bingus = new Audio('Zombies on Your Lawn.mp3');
	bingus.play();
	console.log("x2");
}

function draw() {
	const canvas = document.getElementById("gamewindow");
	const ctx = canvas.getContext("2d");
	ctx.fillStyle = "#FF2369";
	ctx.fillRect(0, 0, 150, 140);
}

class Sunflower {
	
	//constructors cannot be overloaded 
	constructor(hp=100, production=30, sunSize=25) {
		this.hp = hp;
		this.production = production;
		this.sunSize = 25;
	}
	
}

class TwinSunflower extends Sunflower {
	constructor(hp=100, production=30, sunSize=25) {
		this.hp = hp;
		this.production = production;
		this.sunSize = 25;
	}
}
