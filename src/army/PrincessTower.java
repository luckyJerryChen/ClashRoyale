package army;

import config.ArmyConf;
import utils.Utils;

public class PrincessTower extends Tower {
	public PrincessTower(){
		super();
		super.attack=1;
		super.height=Utils.tansBlockToCO_X(3+1);
		super.width=Utils.tansBlockToCO_Y(3+1);
		super.HP=1;
		

		super.labelX=-31f;
		super.labelY=-49f;
		super.labelWidth=15f;
		super.labelHeight=29f;
	}
	
	public PrincessTower(ArmyConf conf){
		super();
		super.attack=1;
		super.height=Utils.tansBlockToCO_X(3+1);
		super.width=Utils.tansBlockToCO_Y(3+1);
		super.HP=1;
		

		super.labelX=-31f;
		super.labelY=-49f;
		super.labelWidth=15f;
		super.labelHeight=29f;
	}
	public PrincessTower(float x,float y){
		super(x,y);
		super.attack=1;
		super.height=Utils.tansBlockToCO_X(3+1);
		super.width=Utils.tansBlockToCO_Y(3+1);
		super.HP=1;
		
		super.labelX=-31f;
		super.labelY=-49f;
		super.labelWidth=15f;
		super.labelHeight=29f;
	}
	public PrincessTower(float x,float y,ArmyConf conf){
		super(x,y);
		super.attack=1;
		super.height=Utils.tansBlockToCO_X(3+1);
		super.width=Utils.tansBlockToCO_Y(3+1);
		super.HP=1;
		
		super.labelX=-31f;
		super.labelY=-49f;
		super.labelWidth=15f;
		super.labelHeight=29f;
	}
}
