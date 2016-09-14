package engine;

import java.util.Iterator;
import java.util.Set;

import javax.swing.JPanel;

import army.Army;
import core.Map;

public class Engine extends Thread{
	Map map;
	public Engine(Map map){
		this.map=map;
	}
	@Override
	public void run(){
		while(true){
			Iterator<Army> it=map.armyRed.iterator();
			while(it.hasNext()){
				Army army=it.next();
				ColliderList colliderList=new ColliderList();
				Army nearestOpponent=nearestArmy(army, map.armyBlue,colliderList);
				colliderList.addCopemateColliderList(army, map.armyRed);
				army.doSomething(nearestOpponent, map,colliderList);
			}
			it=map.armyBlue.iterator();

			while(it.hasNext()){
				Army army=it.next();
				ColliderList colliderList=new ColliderList();
				Army nearestOpponent=nearestArmy(army, map.armyRed,colliderList);
				colliderList.addCopemateColliderList(army, map.armyRed);
				army.doSomething(nearestOpponent, map,colliderList);
			}
			//¸üÐÂ
			it=map.armyRed.iterator();
			while(it.hasNext()){
				Army army=it.next();
				if(army.HP<=0){
					army.dead();
					it.remove();
					continue;
				}
					
				army.oldX=army.x;
				army.oldY=army.y;
			}
			it=map.armyBlue.iterator();
			while(it.hasNext()){
				Army army=it.next();
				if(army.HP<=0){
					army.dead();
					it.remove();
					
					continue;
				}
				army.oldX=army.x;
				army.oldY=army.y;
			}
			
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Army nearestArmy(Army a,Set<Army> set,ColliderList colliderList){
		float minDistance=Float.MAX_VALUE;
		Army minArmy=null;
		Iterator<Army> it=set.iterator();
		while(it.hasNext()){
			Army army=it.next();
			float d=distance(army, a);
			if(d<=a.r&&!(a.fly^army.fly)){
				colliderList.add(army);
			}
			if(d<minDistance){
				minDistance=d;
				minArmy=army;
			}
		}
		return minArmy;
	}
	public float distance(Army a,Army b){
		return (float)Math.sqrt(((a.oldX-b.oldX)*(a.oldX-b.oldX)+(a.oldY-b.oldY)*(a.oldY-b.oldY)));
	}

}
