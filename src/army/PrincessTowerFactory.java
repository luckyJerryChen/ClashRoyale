package army;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import config.ArmyConf;
import utils.Utils;

public class PrincessTowerFactory extends ArmyFactory {

	public static Army create(float x,float y,JPanel mapPanel,boolean color){

		Army army=TowerFactory.create(x, y, mapPanel,new PrincessTower());
		ImageIcon icon=null;
		if(color==false)
			icon=new ImageIcon(".\\image\\army\\PriencessTower\\RedPriencessTower.png");
		else
			icon=new ImageIcon(".\\image\\army\\PriencessTower\\BluePriencessTower.png");

		army.label.setIcon(icon);
		
		army.label.setBounds(Utils.transCOToPX_X(army.oldX+army.labelX), Utils.transCOToPX_Y(army.oldY+army.labelY), Utils.transCOToPX_X(army.width+army.labelWidth),Utils.transCOToPX_Y(army.height+army.labelHeight));
		army.label.getParent().invalidate();
		icon.setImage(icon.getImage().getScaledInstance(army.label.getWidth(),army.label.getHeight(),Image.SCALE_DEFAULT));

		army.label.setOpaque(false);
		army.color=color;

		return army;

	}
}
