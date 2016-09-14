package utils;

import army.Army;

public class Utils {
	public static int mapHeight;
	public static int mapWidth;
	public static float[] tansBlockToCO(float x,float y){
		float[] xy=new float[2];
		xy[0]=((float)(mapWidth)/18)*(x-1);
		xy[1]=((float)(mapHeight)/32)*(y-1);
		return xy;
	}
	public static float tansBlockToCO_X(float x){
		return (((float)mapWidth)/18)*(x-1);
	}
	public static float tansBlockToCO_Y(float y){
		return (((float)mapHeight)/32)*(y-1);
	}
	public static int[] tansCOToBlock(float x,float y){
		int [] xy=new int[2];
		xy[0]=(int)((x/(float)mapWidth)*18)+1;
		xy[1]=(int)((y/(float)mapHeight)*32)+1;
		return xy; 
	}
	public static int tansCOToBlock_X(float x){
		return (int)((x/(float)mapWidth)*18)+1;
	}
	public static int tansCOToBlock_Y(float y){
		return (int)((y/(float)mapHeight)*32)+1;
	}
	public static int transCOToPX_X(float x){
		return (int)x;
	}
	public static int transCOToPX_Y(float y){
		return (int)y;
	}
	public static float distance(Army a,Army b){
		return (float)Math.sqrt(((a.oldX-b.oldX)*(a.oldX-b.oldX)+(a.oldY-b.oldY)*(a.oldY-b.oldY)));
	}
	public static float distance(float x1,float y1,float x2,float y2){
		return (float)Math.sqrt(((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)));
	}
}
