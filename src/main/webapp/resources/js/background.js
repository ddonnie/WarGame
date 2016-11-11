var SCREEN_WIDTH = document.documentElement.clientWidth,
    SCREEN_HEIGHT = document.documentElement.clientHeight;

var canvas = document.getElementById('knightAnimation');
var c = canvas.getContext('2d');

canvas.width = SCREEN_WIDTH;
canvas.height =  200;

var xbox = 0,
    ybox = 0,
    index = 0,
    xpos = -200;
    ypos = 0;
    numFrames = 6,
    frameSize = 200;

image = new Image();
image.src = "/resources/assets/img/spritesheet.png";
window.addEventListener("load", init);

function init() {
    setInterval(loop, 120);
}

function loop() {
    c.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    c.rect(0,0,canvas.width,canvas.height);
    c.stroke();
    c.drawImage(image, xbox, ybox, frameSize, frameSize, xpos, ypos, frameSize, frameSize);
    xpos += 8;
    xbox += frameSize;
    index += 1;
    if (index >= numFrames) {
        xbox = 0;
        index = 0;
    }
    if (xpos > canvas.width) {
        xpos = -200;
    }
    if (document.documentElement.clientWidth != SCREEN_WIDTH) {
        SCREEN_WIDTH = document.documentElement.clientWidth;
        canvas.width = SCREEN_WIDTH;

    }
}