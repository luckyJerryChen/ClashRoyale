package army;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.ArmyConf;
import utils.Utils;

public class MiniPEKKAFactory extends ArmyFactory {

	public static Army create(float x,float y,JPanel mapPanel,boolean color,ArmyConf conf){
		Army army= ArmyFactory.create(x, y, mapPanel,new MiniPEKKA(conf));
		
		army.labelX=-army.r;
		army.labelY=-army.r;
		army.labelWidth=0;
		army.labelHeight=0;
		
		ImageIcon icon=null;
		if(color==false)
			icon=new ImageIcon(".\\image\\army\\MiniPEKKA\\red_walk.png");
		else
			icon=new ImageIcon(".\\image\\army\\MiniPEKKA\\blue_walk.png");

		army.label.setIcon(icon);
		//army.label.setBounds((int)army.oldX-Utils.transCOToPX_X(5), (int)army.oldY-Utils.transCOToPX_Y(15), (int)army.width+Utils.transCOToPX_X(15), (int)army.height+Utils.transCOToPX_Y(19));
		System.out.println("army.label.getWidth()="+army.width);
		army.label.setBounds(Utils.transCOToPX_X(army.oldX+army.labelX), Utils.transCOToPX_Y(army.oldY+army.labelY), Utils.transCOToPX_X(army.width+army.labelWidth),Utils.transCOToPX_Y(army.height+army.labelHeight));

		
		icon.setImage(icon.getImage().getScaledInstance(army.label.getWidth(),army.label.getHeight(),Image.SCALE_DEFAULT));

		army.label.setOpaque(false);
		army.color=color;
		return army;
	}
}
