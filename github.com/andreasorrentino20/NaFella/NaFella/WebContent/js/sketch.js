var xOffset;       // Perlin x-offset
var yOffset; // Perlin y-offset
var offsetInc; // Perlin offset increment
var inc;           // Perin increment
var s;          // Start size of perlin ring
var m;       // Size multiplier
var started = true;
var canvas;

function setup() {
  resetSketch();
  canvas = createCanvas(500, 500);
  canvas.parent("sketch_holder");
  noLoop();
  blendMode(ADD);
  noFill();
}

function draw() {
  if(started) {
    translate(width * 0.5, height * 0.5);

    if (s < 2000) {
      // Create a series of perlin rings from big to small
      for (var nTimes = 0; nTimes < 10; nTimes++) {

        // Less points for smaller rings
        nPoints = int(2 * PI * s);
        nPoints = min(nPoints, 500);

        // Create ring
        beginShape();
        for (var i = 0; i < nPoints; i++) {
          var a = i / nPoints * TAU;
          var p = p5.Vector.fromAngle(i / nPoints * TAU);
          var n = noise(xOffset + p.x * inc, yOffset + p.y * inc) * s;
          p.mult(n);
          vertex(p.x, p.y);
        }
        endShape(CLOSE);

        // Increment perlin offset for next ring
        xOffset += offsetInc;
        yOffset += offsetInc;

        // Update size
        s *= m;
      }
    } else {
      noLoop();
    }
  }
}

function startSketch(){
  if(started === true) {
    resetSketch();
  } else if (started === false) {
    started = true;
    loop();
  }
}

function resetSketch() {
  translate(-(width * 0.5), -(height * 0.5));
  clear();
  xOffset = Math.random();
  yOffset = Math.random();
  offsetInc = 0.006;
  inc = Math.random();
  s = 1;
  m = 1 + Math.random()*0.1;
  stroke(Math.random() * 240, Math.random() * 240, Math.random() * 240, 128);
  loop();
}