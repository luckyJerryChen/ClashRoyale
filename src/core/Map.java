package core;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import army.Army;
import army.KingTowerFactory;
import army.PrincessTowerFactory;
import army.Tower;
import army.TowerFactory;
import utils.Utils;

public class Map {
	public int [][] map={
			{1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1},
			{0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0},
			{0,0,1,1,1,0,0,0,0,0,0,0,0,1,1,1,0,0},
			{0,0,1,1,1,0,0,0,0,0,0,0,0,1,1,1,0,0},
			{0,0,1,1,1,0,0,0,0,0,0,0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1},
			{1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,0,0,0,0,0,0,0,0,1,1,1,0,0},
			{0,0,1,1,1,0,0,0,0,0,0,0,0,1,1,1,0,0},
			{0,0,1,1,1,0,0,0,0,0,0,0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1},
	};
	public float width=540f;
	public float high=960f;
	public Set<Army> armyRed=new HashSet<Army>();
	public Set<Army> armyBlue=new HashSet<Army>();
	public Map(JPanel mapPanel){
		//!!!这里以后要改成用配置文件的
		this.armyRed.add(KingTowerFactory.create(Utils.tansBlockToCO_X(10),Utils.tansBlockToCO_Y(4),mapPanel,false));
		//this.armyRed.add(PrincessTowerFactory.create(Utils.tansBlockToCO_X(4.5f),Utils.tansBlockToCO_Y(7.5f),mapPanel,false));
		//this.armyRed.add(PrincessTowerFactory.create(Utils.tansBlockToCO_X(15.5f),Utils.tansBlockToCO_Y(7.5f),mapPanel,false));
		this.armyBlue.add(KingTowerFactory.create(Utils.tansBlockToCO_X(10),Utils.tansBlockToCO_Y(30),mapPanel,true));
		//this.armyBlue.add(PrincessTowerFactory.create(Utils.tansBlockToCO_X(4.5f),Utils.tansBlockToCO_Y(26.5f),mapPanel,true));
		//this.armyBlue.add(PrincessTowerFactory.create(Utils.tansBlockToCO_X(15.5f),Utils.tansBlockToCO_Y(26.5f),mapPanel,true));
		
	}
	
}
