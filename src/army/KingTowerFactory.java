package army;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import config.ArmyConf;
import utils.Utils;


public class KingTowerFactory extends ArmyFactory {

	public static Army create(float x,float y,JPanel mapPanel,boolean color){
		Army army=TowerFactory.create(x, y, mapPanel,new KingTower());
		ImageIcon icon=null;
		if(color==false)
			icon=new ImageIcon(".\\image\\army\\KingTower\\RedKingTower.png");
		else
			icon=new ImageIcon(".\\image\\army\\KingTower\\BlueKingTower.png");

		army.label.setIcon(icon);
		//army.label.setBounds((int)army.oldX-Utils.transCOToPX_X(5), (int)army.oldY-Utils.transCOToPX_Y(15), (int)army.width+Utils.transCOToPX_X(15), (int)army.height+Utils.transCOToPX_Y(19));
		army.label.setBounds(Utils.transCOToPX_X(army.oldX+army.labelX), Utils.transCOToPX_Y(army.oldY+army.labelY), Utils.transCOToPX_X(army.width+army.labelWidth),Utils.transCOToPX_Y(army.height+army.labelHeight));

	
		icon.setImage(icon.getImage().getScaledInstance(army.label.getWidth(),army.label.getHeight(),Image.SCALE_DEFAULT));

		army.label.setOpaque(false);
		army.color=color;

		return army;
	}
}
