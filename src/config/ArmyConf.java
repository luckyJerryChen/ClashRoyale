package config;

public class ArmyConf {
	public  float speed;
	public  float width;
	public  float height;
	public  float attackSpeed;
	public  int attack;
	public  int HP;
	public  float attackDistance;
	public  float r;
	
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getAttackSpeed() {
		return attackSpeed;
	}
	public void setAttackSpeed(float attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public float getAttackDistance() {
		return attackDistance;
	}
	public void setAttackDistance(float attackDistance) {
		this.attackDistance = attackDistance;
	}
	public float getR() {
		return r;
	}
	public void setR(float r) {
		this.width=2*r;
		this.height=2*r;
		this.r = r;
	}

}
