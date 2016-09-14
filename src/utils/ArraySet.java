package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
//提供随机取数据的hashSet
public class ArraySet {  
    private ArrayList<Integer> list ;  
    private HashSet<Integer> set ;  
    
    public ArraySet(int size){
    	this.list=new  ArrayList<Integer>(size);
    	this.set=new HashSet<Integer>();
    	for (int i=0;i<size;++i){
    		add(i);
    		
    	}
    }
    public int size(){
    	return this.set.size();
    }
    public ArraySet(){
    	this.list=new  ArrayList<Integer>();
    	this.set=new HashSet<Integer>();
    }
  
    /** 
     * @param index 
     * @return 
     * @see java.util.ArrayList#get(int) 
     */  
    public int get(int index) {  
        return list.get(index);  
    }  
    
    
    
  

    public boolean add(int o) {  
        if (this.set.add(o)) {  
            list.add(o);  
            return true;  
        } else  
            return false;  
    }  
  

    public int remove(int i) {  
    	
        if (this.set.remove(this.list.get(i))) { 
        	int result=this.list.get(i); 
            list.remove(i);  
            return result;  
        } else  
            return -1;  
    }  
    public int randomRemove() {  
    	int i =new Random().nextInt(this.set.size());
        if (this.set.remove(this.list.get(i))) { 
        	int result=this.list.get(i); 
            list.remove(i);  
            return result;  
        } else  
            return -1;  
    }  

    public void clear() {  
        set.clear();  
        list.clear();  
    }  
  
}  