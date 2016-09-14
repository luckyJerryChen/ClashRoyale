package army;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import core.Map;
import engine.Collider;
import engine.ColliderList;
import utils.Utils;

public class Army {
	//1是蓝色 0是红色
	public static int aaa=0;
	public boolean color;
	public float r;
	//true 是飞行单位 false是陆地单位
	public boolean fly;
	public float x;
	public float y;
	public float oldX;
	public float oldY;
	public float speed;
	public float width;
	public float height;
	public float attackSpeed;
	public int attack;
	public int HP;
	public float attackDistance;
	//0是圆形碰撞  1 是方形碰撞
	public int collidType=0;
	
	public JLabel label;
	
	
	
	public float labelX;
	public float labelY;
	public float labelWidth;
	public float labelHeight;
	
	
	
	public Army(float x,float y){
		this.x=x;
		this.y=y;
	}
	public Army(float x,float y,float r){
		this.x=x;
		this.y=y;
		this.r=r;
	}
	public Army(){
		this.x=0;
		this.y=0;

		labelX=-this.r;
		labelY=-this.r;
		labelWidth=0;
		labelHeight=0;
	}

	public void doSomething(Army opponent,Map map,ColliderList colliderList){
		if(Collider.collidDistance(this, opponent)<attackDistance){
			attack(opponent,map);
		}
		else{
			if(this.speed>0)
				walk(opponent,map,colliderList);
			else
				stay(opponent,map,colliderList);
		}
	}
	public void dead(){
		
		System.out.println("dead");
		
		JPanel mapPanel=(JPanel)this.label.getParent();
		this.label.getParent().remove(this.label);
		mapPanel.repaint();
	}
	public void walk(Army opponent,Map map,ColliderList colliderList){

		float distance=Utils.distance(this, opponent);
		if(colliderList.isEmpty()){
			float diffx=((opponent.oldX-this.oldX)/distance)*this.speed;
			float diffy=((opponent.oldY-this.oldY)/distance)*this.speed;
			this.x=this.oldX+diffx;
			this.y=this.oldY+diffy;
			this.label.setBounds(Utils.transCOToPX_X(this.oldX+this.labelX), Utils.transCOToPX_Y(this.oldY+this.labelY), Utils.transCOToPX_X(this.width+this.labelWidth),Utils.transCOToPX_Y(this.height+this.labelHeight));
		}
	}
	public void stay(Army opponent,Map map,ColliderList colliderList){

			this.x=this.oldX;
			this.y=this.oldY;

	}
	public void attack(Army opponent,Map map){
		opponent.attacked(this, map);
	}
	public void attacked(Army attacker,Map map){
		System.out.println("attack by"+attacker.oldX+"  "+attacker.oldY);
		this.HP-=attacker.attack;

		
	}
	public float[] getLocationCO(int location){
		float[] CO=new float[2];
		if(location==0){
			CO[0]=this.oldX-this.width*0.5f;
			CO[1]=this.oldY-this.height*0.5f;
		}else if(location==1){
			CO[0]=this.oldX+this.width*0.5f;
			CO[1]=this.oldY-this.height*0.5f;
		}
		else if(location==2){
			CO[0]=this.oldX+this.width*0.5f;
			CO[1]=this.oldY+this.height*0.5f;
		}
		else if(location==3){
			CO[0]=this.oldX-this.width*0.5f;
			CO[1]=this.oldY+this.height*0.5f;
		}
		return CO;

		
	}
}
