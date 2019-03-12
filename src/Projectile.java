import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	int speed = 10;

	Projectile(int x, int y, int width, int height) {	
		super(x, y, width, height);
	}

	void update() {
		if(isAlive == true) {
		super.update();
		y -= speed;
		if (y <= 0) {
			isAlive = false;
		}
		}
		else {
			x=2000;
		}
	}

	void draw(Graphics graphic) {
		if(isAlive == true) {
		graphic.setColor(Color.RED);
		graphic.fillRect(x, y, width, height);
	}
		else{
x = 2000;			}
}
}