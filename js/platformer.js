
const WIDTH = 1080;
const HEIGHT = 720
const config = {
    type : Phaser.AUTO,
    width : 1080,
    height : 720,
    scene: {
        preload : preload,
        create : create,
        update : update
    }
};

const game = new Phaser.Game(config);

function preload() {

    this.load.image("lawn", "day.png");
}

function create() {

    this.add.image(0, 0, 'lawn');
}

function update() {

}