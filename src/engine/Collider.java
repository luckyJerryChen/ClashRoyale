package engine;

import army.Army;
import utils.Utils;

public class Collider {
	public static float collidDistance(Army aa,Army bb){
		Army a=aa;
		Army b=bb;
		if(a.collidType==0&&b.collidType==1){
			a=bb;
			b=aa;
		}
		if(a.collidType==0&&b.collidType==0){
			return (Utils.distance(a, b)-a.r-b.r);
		}
		else if(a.collidType==1&&b.collidType==0){
			
			
			float minD=Float.MAX_VALUE;
			
			int minLocation=-1;
			//int secondMinLocation=-1;
			//先判断与四个顶点的最小距离
			float[][] CO=new float[4][];
			CO[0]=a.getLocationCO(0);
			CO[1]=a.getLocationCO(1);
			CO[2]=a.getLocationCO(2);
			CO[3]=a.getLocationCO(3);
			float distance=Utils.distance(CO[0][0], CO[0][1], b.oldX, b.oldY);

			if(distance<minD){
				minD=distance;
			//	secondMinLocation=minLocation;
				minLocation=0;
			}
			distance=Utils.distance(CO[1][0], CO[1][1], b.oldX, b.oldY);
		
			if(distance<minD){
				minD=distance;
			//	secondMinLocation=minLocation;
				minLocation=1;
			}
			distance=Utils.distance(CO[2][0], CO[2][1], b.oldX, b.oldY);
			
			if(distance<minD){
				minD=distance;
			//	secondMinLocation=minLocation;
				minLocation=2;
			}
			distance=Utils.distance(CO[3][0], CO[3][1], b.oldX, b.oldY);
			if(distance<minD){
				minD=distance;
			//	secondMinLocation=minLocation;
				minLocation=3;
			}
			

			
			if(minLocation==0){
				if(b.oldX>CO[0][0]){
					minD=CO[0][1]-b.oldY;
				}
				else if(b.oldY>CO[0][1]){
					minD=CO[0][0]-b.oldX;
				}
			}
			else if(minLocation==1){
				if(b.oldY>CO[1][1]){
					minD=b.oldX-CO[1][0];
				}
				else if(b.oldX<CO[1][0]){
					minD=CO[1][1]-b.oldY;
				}
			}
			else if(minLocation==2){
				if(b.oldX<CO[2][0]){
					minD=b.oldY-CO[2][1];
				}
				else if(b.oldY<CO[2][1]){
					minD=b.oldX-CO[2][0];
				}
			}
			else if(minLocation==3){
				if(b.oldY<CO[3][1]){
					minD=CO[3][0]-b.oldX;
				}
				else if(b.oldX>CO[3][0]){
					minD=b.oldY-CO[3][1];
				}
			}else{
				System.out.println("?????????");
			}
			
			System.out.println(minD);
			return minD-b.r;
		}

		else{
			//方形和方形碰撞暂时没实现,目前主要是塔和塔,不影响
			
			return (Utils.distance(a, b)-a.r-b.r);
		}
		
	}
}
