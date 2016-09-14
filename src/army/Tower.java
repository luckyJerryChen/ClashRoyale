package army;

import javax.swing.JPanel;

import utils.Utils;

public class Tower extends Army{
	public Tower(){
		super();
		super.speed=0;
		super.attackSpeed=1;
		super.attackDistance=1;
		super.collidType=1;

	}
	public Tower(float x,float y){
		super(x,y);
		super.speed=0;
		super.attackSpeed=1;
		super.attackDistance=1;
		super.collidType=1;
	}
}
