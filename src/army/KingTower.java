package army;

import config.ArmyConf;
import utils.Utils;

public class KingTower extends Tower {
	public KingTower(){
		super();
		super.attack=1;
		super.height=Utils.tansBlockToCO_X(4+1);
		super.width=Utils.tansBlockToCO_Y(4+1);
		super.HP=1;
		super.labelX=-39f;
		super.labelY=-53f;
		super.labelWidth=15f;
		super.labelHeight=25f;
		
	}
	
	public KingTower(ArmyConf conf){
		super();
		super.attack=1;
		super.height=Utils.tansBlockToCO_X(4+1);
		super.width=Utils.tansBlockToCO_Y(4+1);
		super.HP=1;
		super.labelX=-39f;
		super.labelY=-53f;
		super.labelWidth=15f;
		super.labelHeight=25f;
		
	}
	
	public KingTower(float x,float y){
		super(x,y);
		super.attack=1;
		super.height=Utils.tansBlockToCO_X(4+1);
		super.width=Utils.tansBlockToCO_Y(4+1);
		super.HP=1;
		super.labelX=-39f;
		super.labelY=-53f;
		super.labelWidth=15f;
		super.labelHeight=25f;
	}
	public KingTower(float x,float y,ArmyConf conf){
		super(x,y);
		super.attack=1;
		super.height=Utils.tansBlockToCO_X(4+1);
		super.width=Utils.tansBlockToCO_Y(4+1);
		super.HP=1;
		super.labelX=-39f;
		super.labelY=-53f;
		super.labelWidth=15f;
		super.labelHeight=25f;
	}
}
