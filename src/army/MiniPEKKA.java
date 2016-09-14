package army;

import config.ArmyConf;

public class MiniPEKKA extends Army {

	public MiniPEKKA(){
		super();
/*		super.speed=Knight.speed;
		super.width=Knight.width;
		super.height=Knight.height;
		super.attackSpeed=Knight.attackSpeed;
		super.attack=Knight.attack;
		super.HP=Knight.HP;
		super.attackDistance=Knight.attackDistance;
		super.r=Knight.r;*/
	}
	public MiniPEKKA(ArmyConf conf){
		super();
		super.speed=conf.speed;
		super.width=conf.r*2;
		super.height=conf.r*2;
		System.out.println("3333333"+conf.r);
		super.attackSpeed=conf.attackSpeed;
		super.attack=conf.attack;
		super.HP=conf.HP;
		super.attackDistance=conf.attackDistance;
		super.r=conf.r;
	}
	public MiniPEKKA(float x,float y){
		super(x,y);
/*		super.speed=Knight.speed;
		super.width=Knight.width;
		super.height=Knight.height;
		super.attackSpeed=Knight.attackSpeed;
		super.attack=Knight.attack;
		super.HP=Knight.HP;
		super.attackDistance=Knight.attackDistance;
		super.r=Knight.r;*/
	}
	public MiniPEKKA(float x,float y,ArmyConf conf){
		super(x,y);
		super.speed=conf.speed;
		super.width=conf.r*2;
		super.height=conf.r*2;
		super.attackSpeed=conf.attackSpeed;
		super.attack=conf.attack;
		super.HP=conf.HP;
		super.attackDistance=conf.attackDistance;
		super.r=conf.r;
		System.out.println("111111"+this.r);
	}
	/*public void doSomething(Army opponent,Map Map,ColliderList colliderList){
		this.y=this.oldY+1;
		this.x=this.oldX;
		this.label.setBounds((int)this.oldX, (int)this.oldY, (int)width, (int)height);
	}*/
}
