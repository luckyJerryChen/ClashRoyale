package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import army.Army;
import config.ArmyConf;
import config.CardConf;
import engine.Engine;
import utils.ArraySet;
import utils.ArraySet;
import utils.Utils;

//目前将配置应用到创建士兵时有问题，另外魔法继承什么没考虑好
class HollWaterLabel extends JLabel{
	ArmyConf cardConf;
	
	public HollWaterLabel(ArmyConf cardConf){
		this.cardConf=cardConf;
	}
}
class CardButton extends JButton{
	CardConf cardConf;
	Integer cardIndex=-1;
	ArraySet cardLibrary;
	ArraySet handCard;
	Integer nextCard;
	public CardButton(CardConf cardConf,int firstCard,ArraySet cardLibrary,ArraySet handCard,int nextCard){
		this.cardConf=cardConf;
		this.cardIndex=firstCard;
		this.cardLibrary=cardLibrary;
		this.handCard=handCard;
		this.nextCard=nextCard;
	}
}
class CardButtonListener extends MouseAdapter{
	public void mouseClicked(MouseEvent e){
		Integer cardIndex=((CardButton)e.getSource()).cardIndex;
		System.out.println(cardIndex);
		ArraySet cardLibrary=((CardButton)e.getSource()).cardLibrary;
		ArraySet handCard=((CardButton)e.getSource()).handCard;
		Integer nextCard=((CardButton)e.getSource()).nextCard;
		handCard.add(nextCard);
		nextCard=cardLibrary.randomRemove();
		cardLibrary.add(cardIndex);
		Object o=((CardButton)e.getSource()).cardConf.createArmy[1];
		System.out.println(123123);
		ClashRoyale.currentCardFactory=((CardButton)e.getSource()).cardConf.createArmy[cardIndex];
		
		ClashRoyale.currentCardConf=((CardButton)e.getSource()).cardConf.cards[cardIndex];
	}
}
class BackgroundPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image image;// 背景图片

    public BackgroundPanel() {
            setOpaque(false);
            setLayout(null);
    }

    public void setImage(Image image) {
            this.image = image;
    }

    /**
     * 画出背景
     */
    protected void paintComponent(Graphics g) {
            if (image != null) {
                    // 图片宽度
                    int width = getWidth();
                    // 图片高度
                    int height = getHeight();
                    // 画出图片
                    g.drawImage(image, 0, 0, width, height, this);
            }
            super.paintComponent(g);
    }
}

public class ClashRoyale extends JFrame{
	public Random random=new Random();
	public static Method currentCardFactory;
	public static ArmyConf currentCardConf;
	public JPanel gamePane;
	public JPanel mapPane;
	public JPanel cardPanel;
	
	
/*	Class<?> threadClazz = Class.forName("java.lang.Math");  
    Method method = threadClazz.getMethod("abs", long.class);  
    System.out.println(method.invoke(null, -10000l)); */ 
	public CardConf blueCardConf;
	public ArraySet cardLibrary;
	public ArraySet handCard;
	public int nextCard;
	public Map map;
	public ClashRoyale(CardConf blueCardConf,CardConf redCardConf,ArraySet cardLibrary,ArraySet handCard,int nextCard){
		this.blueCardConf=blueCardConf;
		this.cardLibrary=cardLibrary;
		this.handCard=handCard;
		this.nextCard=nextCard;
		getContentPane().setLayout(null);
		
		gamePane = new JPanel();
		gamePane.setBackground(Color.ORANGE);
		gamePane.setBounds(0, 0, 400, 711);
		getContentPane().add(gamePane);
		gamePane.setLayout(null);
		
		mapPane = new BackgroundPanel();
		mapPane.setBackground(Color.GREEN);
		mapPane.setBounds(56, 100, 287, 511);
		mapPane.setLayout(null);
		mapPane.setOpaque(false);
		
		Image img=new ImageIcon(
                ".\\image\\map\\map.jpg").getImage();
		((BackgroundPanel) mapPane).setImage(img);
		
		Utils.mapHeight=mapPane.getHeight();
		Utils.mapWidth=mapPane.getWidth();

		
/*		JPanel aa = new JPanel();
		aa.setBackground(Color.BLACK);
		aa.setBounds(56, 100, 100, 100);
		aa.setLayout(null);
		mapPane.add(aa);*/
		
		mapPane.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				System.out.println("dian ji");
				try {
					System.out.println(currentCardFactory.toString());
					System.out.println(currentCardConf.attack);
					map.armyBlue.add((Army)currentCardFactory.invoke(null,e.getX(),e.getY(),(JPanel)e.getSource(),true,currentCardConf));
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				((JPanel)e.getSource()).repaint();;
			}
		});
		gamePane.add(mapPane);
		
		
		
		this.map=new Map(this.mapPane);
		
		JPanel cardPanel = new JPanel();
		cardPanel.setBackground(new Color(160, 82, 45));
		cardPanel.setBounds(66, 621, 334, 90);
		gamePane.add(cardPanel);
		cardPanel.setLayout(null);
		
		this.nextCard=this.cardLibrary.randomRemove();
		
		CardButton cardButton1 = new CardButton(this.blueCardConf,this.cardLibrary.remove(random.nextInt(this.cardLibrary.size())),this.cardLibrary,this.handCard,this.nextCard);
		cardButton1.setBounds(10, 0, 63, 70);
		cardButton1.addMouseListener(new CardButtonListener());
		cardPanel.add(cardButton1);
		
		CardButton cardButton2 = new CardButton(this.blueCardConf,this.cardLibrary.remove(random.nextInt(this.cardLibrary.size())),this.cardLibrary,this.handCard,this.nextCard);
		cardButton2.setBounds(96, 0, 63, 70);
		cardButton2.addMouseListener(new CardButtonListener());
		cardPanel.add(cardButton2);
		
		CardButton cardButton3 = new CardButton(this.blueCardConf,this.cardLibrary.remove(random.nextInt(this.cardLibrary.size())),this.cardLibrary,this.handCard,this.nextCard);
		cardButton3.setBounds(184, 0, 63, 70);
		cardButton3.addMouseListener(new CardButtonListener());
		cardPanel.add(cardButton3);
		
		CardButton cardButton4 = new CardButton(this.blueCardConf,this.cardLibrary.remove(random.nextInt(this.cardLibrary.size())),this.cardLibrary,this.handCard,this.nextCard);
		cardButton4.setBounds(266, 1, 62, 70);
		cardButton4.addMouseListener(new CardButtonListener());
		cardPanel.add(cardButton4);
		
		JLabel hollWaterLabel = new JLabel("holy water");
		hollWaterLabel.setBounds(3, 72, 327, 17);
		hollWaterLabel.setOpaque(true);
		cardPanel.add(hollWaterLabel);
		
		
		
		JLabel nextCardLabel = new JLabel("New label");
		nextCardLabel.setBounds(10, 646, 46, 55);
		nextCardLabel.setOpaque(true);
		gamePane.add(nextCardLabel);
		
	}
	public static void main(String args[]){
		
		String blueCardConfFile="config\\game\\blue_card.xml";
		String redCardConfFile="config\\game\\red_card.xml";

		
		CardConf blueCardConf=new CardConf(blueCardConfFile);
		CardConf redCardConf=new CardConf(redCardConfFile);
		
		ArraySet cardLibrary=new ArraySet(8);
		ArraySet handCard=new ArraySet();
		int nextCard=-1;
		
		ClashRoyale clashRoyale=new ClashRoyale(blueCardConf,redCardConf,cardLibrary,handCard,nextCard);
		clashRoyale.setBounds(50, 50, 400, 711);
		clashRoyale.setVisible(true);
		Engine engine=new Engine(clashRoyale.map);
		engine.start();
		
	}
}
