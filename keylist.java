import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class keylist {
	public static void main(String args[]) throws IOException{
		String fs = "keylist.txt";
	    FileWriter fw = new FileWriter(fs);
	    BufferedWriter bfw = new BufferedWriter(fw);
		
	    String a[] = new String[150];
	    String n = "key.txt";
	    ArrayList<String> a1 = new ArrayList<String>();
	    read(a,n,a1);
	    
	    for(int i=0;i<a.length;i++) {
	    	if(a[i]!=null) {
		    	bfw.write(i+":"+a[i]);    
		    	bfw.newLine();
	    	}
	    }
	    System.out.print(a1);
		bfw.close();
	    fw.close();
	}
	public static void read(String a[],String n,ArrayList<String> a1) throws IOException{
		String fp = n;
		FileReader fr = new FileReader(fp);
		BufferedReader bfr = new BufferedReader(fr);
		
		String record;
	    while((record = bfr.readLine())!=null)			//�}�lŪ�ɤ@��@��Ū
        {
        	String [] report=record.split(":");	//�Q�Υ��W��ܱN�C�@�湺����������J
        	if(a[Integer.parseInt(report[0])]==null) 
        	{
        		a[Integer.parseInt(report[0])] = report[1];
        	}
        	else {
        		String c = report[0]+":"+report[1];
        		boolean f = false;
        		for(int i=0;i<a1.size();i++) {
        			if(c.equals(a1.get(i))) {
        				f=true;
        			}
        		}
        		if(f==false) {
        			a1.add(c);
        		}
        	}
        }
	    
	    bfr.close();
	    fr.close();
	}

}
