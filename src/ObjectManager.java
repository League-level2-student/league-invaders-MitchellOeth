import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	long enemyTimer = 0;
	int enemySpawnTime = 5000;
	ArrayList<Alien> enemy = new ArrayList<Alien>();
	ArrayList<Projectile> bullets = new ArrayList<Projectile>();
	Rocketship rocket;

	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
		rocket = new Rocketship(250, 700, 50, 50);
	}

	void update() {
		rocket.update();
		for (Projectile projectile : bullets) {
			projectile.update();
		}
		for (Alien alien : enemy) {
			alien.update();
		}
	}

	void draw(Graphics graphic) {
		rocket.draw(graphic);
		for (Projectile projectile : bullets) {
			projectile.draw(graphic);
		}
		for (Alien alien : enemy) {
			alien.draw(graphic);
		}
	}

	void addProjectile(Projectile projectile) {
		bullets.add(projectile);
	}

	void addAlien(Alien alien) {
		enemy.add(alien);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects(GameObject gameObject) {
if(gameObject.isAlive==false) {
	gameObject.exit;
		}
	}

	void checkCollision() {
		for (Alien alien : enemy) {
			if (rocket.collisionBox.intersects(alien.collisionBox)) {
				rocket.isAlive = false;
			}
		}
		for (Alien alien : enemy) {
			for (Projectile projectile : bullets) {
				if (projectile.collisionBox.intersects(alien.collisionBox)) {
					projectile.isAlive = false;
					alien.isAlive = false;
				}
			}
		}
	}
}