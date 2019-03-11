public class ObjectManager{
Rocketship rocket;
ObjectManager(Rocketship rocket){
	this.rocket=rocket;
	rocket = new Rocketship(250,700,50,50);
}
	void update(){
		rocket.update();
	}

}