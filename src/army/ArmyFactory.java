package army;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.Utils;

public abstract class ArmyFactory {
	public static Army create(float x,float y,JPanel mapPanel,Army army2){
		Army army=army2;
		army.oldX=x;
		army.oldY=y;

		
		JLabel label = new JLabel();
		label.setBackground(Color.BLACK);
		System.out.println("9999="+army.width);
		label.setBounds((int)army.oldX, (int)army.oldY, (int)army.width, (int)army.height);
		label.setOpaque(true);
		mapPanel.add(label);
		//mapPanel.validate();
		army.label=label;
		return army;
	}
	

}
