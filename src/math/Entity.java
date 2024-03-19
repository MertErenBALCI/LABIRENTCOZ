package math;

import java.awt.Graphics2D;
import java.util.Random;

import math.Vector2D;


public abstract class Entity {
	protected Vector2D pos;
	protected Vector2D velocity;
	protected Vector2D acceleration;
	
	protected Random randomizer = new Random();
	
	public Entity(float x, float y) {
		pos = new Vector2D(x, y);
		velocity = new Vector2D(0, 0);
		acceleration = new Vector2D(0, 0);	
	}
	
	public Entity(Vector2D pos) {
		this.pos = pos;
		velocity = new Vector2D(0, 0);
		acceleration = new Vector2D(0, 0);
	}

	public void setVelocity(float xVel, float yVel) {
		this.velocity.x = xVel;
		this.velocity.y = yVel;
	}
	public void setVelocity(Vector2D velocity) {
		this.setVelocity(velocity.x, velocity.y);
	}
	public Vector2D getVelocity() {
		return velocity;
	}
	
	public void setAcceleration(float xAccel, float yAccel) {
		this.acceleration.x = xAccel;
		this.acceleration.y = yAccel;
	}
	public void setAcceleration(Vector2D acceleration) {
		this.setAcceleration(acceleration.x, acceleration.y);
	}
	public Vector2D getAcceleration() {
		return acceleration;
	}
	
	public void setPosition(float xVel, float yVel) {
		this.pos.x = xVel;
		this.pos.y = yVel;
	}
	public void setPosition(Vector2D velocity) {
		this.setPosition(velocity.x, velocity.y);
	}
	public Vector2D getPosition() {
		return pos;
	}
	
	public void applyForce(Vector2D force) {
		acceleration.add(force);
	}
	
	public void draw(Graphics2D g) {
		
	}
	
}
