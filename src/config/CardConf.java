package config;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JPanel;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import army.Army;

public class CardConf {
	public ArmyConf[] cards;
	public Method[] createArmy;

	public CardConf(String file) {
		this.cards = new ArmyConf[8];
		System.out.println(this.cards);
		this.createArmy = new Method[8];
		XMLConfiguration cardsConfig = null;
		try {
			cardsConfig = new XMLConfiguration(file);
			for (int i = 0; i < cards.length; i++) {
				String name = cardsConfig.getString("card" + (i + 1) + ".name");
				int level = cardsConfig.getInt("card" + (i + 1) + ".level");
				XMLConfiguration cardConfig = new XMLConfiguration("config\\army\\" + name + "\\army.xml");
				Class armyClass = ArmyConf.class;
				
				String factoryName="army."+name+"Factory";
				System.out.println(factoryName);
				//Class factoryClass=Class.forName("army.knightFactory");
				Class factoryClass=Class.forName("army."+name+"Factory");

				createArmy[i]=factoryClass.getMethod("create",float.class,float.class,JPanel.class,boolean.class,ArmyConf.class);
				
				this.cards[i]=new ArmyConf();
				getFields(armyClass, cardConfig, cards[i], level);
				
				
				//??????null
				
			}System.out.println("3333"+cards[1].r);
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getFields(Class cls, XMLConfiguration cardConfig, ArmyConf card, int level) {
		for (; cls != Object.class; cls = cls.getSuperclass()) {
			
			System.out.println("2222"+card);
			Field[] fs = cls.getDeclaredFields();
			java.lang.Float AA = new Float(11);
			java.lang.Float aa = new Float(11);
			for (Field f : fs) {
				Method method;
				try {
					

					String value = cardConfig.getString("level" + level + "." + f.getName());
					if (value != null) {
						method = card.getClass().getMethod(
								"set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1),
								f.getType());
						
						String typeName=f.getType().getName().substring(0, 1).toUpperCase()
								+ f.getType().getName().substring(1);
						if(typeName.equals("Int")){
							typeName="Integer";
						}
						Class TypeClass = Class
								.forName("java.lang." +typeName );
						Method parse = TypeClass.getMethod("parse" + f.getType().getName().substring(0, 1).toUpperCase()
								+ f.getType().getName().substring(1), String.class);
						System.out.println("value="+value);
						method.invoke(card,
								parse.invoke(card, value));
						
					}

				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// =cardConfig.getString("level"+level+"."+f.getName());
			}

		}
	}
}