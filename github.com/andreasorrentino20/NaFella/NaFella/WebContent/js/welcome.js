var particles = [];
var particlesNum = 30;
var canvas;

function setup() {
  canvas = createCanvas(window.innerWidth, window.innerHeight);
  canvas.parent("sketch_holder");
  for(var i = 0; i < particlesNum; i++) {
    var pos = createVector(Math.random()*width, Math.random()*height);
    var vel = createVector(Math.random(), Math.random());
    var dim = (Math.random()*5)+5;
    particles[i] = new Particle(pos, vel, dim);
  }
}

function draw() {
  clear()
  for(var i = 0; i < particlesNum; i++) {
    particles[i].update();
    particles[i].display();
  }
}

function Particle(pos, vel, dim) {
  this.pos = pos;
  this.vel = vel;
  this.dim = dim;
  
  this.display=function() {
    this.check();
    noStroke();
    fill(128, 128);
    ellipse(this.pos.x, this.pos.y, dim, dim);
  }
  
  this.update=function() {
    this.pos.add(this.vel);
    this.wall();
  }
  
  this.check = function() {
    for(var i = 0; i < particlesNum; i++) {
      if(this.pos.dist(particles[i].pos) < 50) {
        var distance = this.pos.dist(particles[i].pos);
        stroke(map(distance, 0, 50, 0, 255));
        line(this.pos.x, this.pos.y, particles[i].pos.x, particles[i].pos.y);
      }
    }
  }
  
  this.wall=function() {
    if(pos.x > width) {
      vel.mult(-1);
    }
    if(pos.x < 0) {
      vel.mult(-1);
    }
    if(pos.y > height) {
      vel.mult(-1);
    }
    if(pos.y < 0) {
      vel.mult(-1);
    }
  }
}

function windowResized() {
  resizeCanvas(window.innerWidth, window.innerHeight);
}
