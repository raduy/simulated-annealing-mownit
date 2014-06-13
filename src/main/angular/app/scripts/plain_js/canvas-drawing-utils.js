'use strict';

var IMAGE_HEIGHT = 890;
var IMAGE_WIDTH = 960;

/**
 * Drawing params
 */
var STROKE_STYLE = '#003300',
    FILL_COLOR = 'red',
    POINT_RADIUS = 7;

function writeMessage(context, message) {
    context.clearRect(0, 0, 280, 40);
    context.font = '18pt Verdana';
    context.fillStyle = 'black';
    context.fillText(message, 20, 35);
}

function getMousePosition(canvas, evt) {
    var rect = canvas.getBoundingClientRect();
    return {
        x: Math.floor(evt.clientX - rect.left),
        y: Math.floor(evt.clientY - rect.top)
    };
}

function createCanvasBackground() {
    var background = new Image();
    background.src = "http://polandmap.facts.co/polandmap3.png";

    return background;
}

function drawLine(canvasCtx, fromX, fromY, toX, toY) {
    canvasCtx.beginPath();
    canvasCtx.moveTo(fromX, fromY);
    canvasCtx.lineTo(toX, toY);
    canvasCtx.lineWidth = 4;
    canvasCtx.strokeStyle = STROKE_STYLE;
    canvasCtx.stroke();
}

function drawPoint(canvasCtx, centerX, centerY) {
    canvasCtx.beginPath();
    canvasCtx.arc(centerX, centerY, POINT_RADIUS, 0, 2 * Math.PI, false);
    canvasCtx.fillStyle = FILL_COLOR;
    canvasCtx.fill();
    canvasCtx.lineWidth = 1;
    canvasCtx.strokeStyle = STROKE_STYLE;
    canvasCtx.stroke();

}



function drawTour(canvasCtx, orderedCities) {
    canvasCtx.clearRect(0, 40, 960, 890);

    for (var i = 1; i < orderedCities.length; ++i) {
        drawLine(canvasCtx, orderedCities[i - 1].x, orderedCities[i - 1].y, orderedCities[i].x, orderedCities[i].y);
    }

    drawLine(canvasCtx, orderedCities[0].x, orderedCities[0].y,
        orderedCities[orderedCities.length - 1].x,
        orderedCities[orderedCities.length - 1].y);

    for (i = 0; i < orderedCities.length; ++i) {
        drawPoint(canvasCtx, orderedCities[i].x, orderedCities[i].y);
    }
}