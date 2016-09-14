package engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import army.Army;

public class ColliderList {
	ArrayList<Army> colliderList=new ArrayList<Army>();
	public void add(Army army){
		this.colliderList.add(army);
	}
	public void addCopemateColliderList(Army a ,Set set){
		Iterator<Army> it=set.iterator();
		while(it.hasNext()){
			Army army=it.next();
			float d=distance(army, a);
			if(d<=a.r&&!(a.fly^army.fly)){
				colliderList.add(army);
			}
		}
		
	}
	public boolean isEmpty(){
		return this.colliderList.isEmpty();
	}
	public float distance(Army a,Army b){
		return (float)Math.sqrt(((a.oldX-b.oldX)*(a.oldX-b.oldX)+(a.oldY-b.oldY)*(a.oldY-b.oldY)));
	}
}
