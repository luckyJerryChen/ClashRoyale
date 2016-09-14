package army;

import javax.swing.JPanel;

public class TowerFactory extends ArmyFactory {

	public static Army create(float x,float y,JPanel mapPanel){
		return ArmyFactory.create(x, y, mapPanel,new Tower());
	}
}
