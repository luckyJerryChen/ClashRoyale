import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


class Tuple{
	int day;
	int play;
	public Tuple(int day,int play){
		this.day=day;
		this.play=play;
	}
}
public class Preprocess {

public static void main(String[] args) {
	Map<String,List<Tuple>> map=new HashMap<String,List<Tuple>>();
	Map<Integer,String>artNum=new HashMap<Integer,String>();
	File artFile=new File("C:\\Users\\lenovo\\Desktop\\wp1\\artist_id");
	File f=new File("C:\\Users\\lenovo\\Desktop\\wp1\\data218\\data_before_218.txt");
	try {
		BufferedReader reader=new BufferedReader(new FileReader(artFile));
		String line =reader.readLine();
		while(line!=null){
			String temp[]=line.split(",");
			artNum.put(Integer.parseInt(temp[0]), temp[1]);
			line=reader.readLine();
		}
		reader.close();
		reader=new BufferedReader(new FileReader(f));
		line =reader.readLine();
		int k=0;
		while(line!=null){
			k++;
			String[] temp=line.split(",");
			String key=temp[0];//System.out.println(key);
			Tuple tuple=new Tuple(Integer.parseInt(temp[1]),Integer.parseInt(temp[3]));
			if(map.containsKey(key)){
				List list=map.get(key);
				list.add(tuple);
			}
			else{
				List list=new LinkedList<Tuple>();
				list.add(tuple);
				map.put(key, list);
			}
			line=reader.readLine();
		}
		reader.close();
		BufferedWriter writer;
		for(int i=1;i<=50;i++){
			Map<Integer,Integer> mapArt=new HashMap<Integer,Integer>();
			String key=artNum.get(i).replace(" ", "");
			Iterator<Tuple> it=null;
			if(!map.containsKey(key)){
				//System.out.println(key);
				continue;
			}
			else{
				it=map.get(key).iterator();
			}
			while(it.hasNext()){
				Tuple tuple=it.next();
				mapArt.put(tuple.day, tuple.play);
			}
			writer=new BufferedWriter(new FileWriter("C:\\Users\\lenovo\\Desktop\\wp1\\data218\\data\\"+i));
			for(int j=1;j<=183;j++){
				if(mapArt.containsKey(j)){
					if(j<183)
						writer.write(mapArt.get(j).toString()+"\n");
					else
						writer.write(mapArt.get(j).toString());
				}
				else{
					if(j<183)
						writer.write("0"+"\n");
					else
						writer.write("0");
				}
			}
			writer.close();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
