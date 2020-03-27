import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;


public class one2 {
	public static void main(String args[]) throws IOException {
		String fs = "break.txt";
	    FileWriter fw = new FileWriter(fs);
	    BufferedWriter bfw = new BufferedWriter(fw);
	    String a[] = new String[200];
	    String n = "answerkey.txt";
	    read(a,n);
	    
	    for(int i=0;i<a.length;i++) {
	    	if(a[i]!=null ) {
	    		System.out.println(i+" "+a[i]);
	    	}
	    }
	    
	    ArrayList<Integer> a1 = new ArrayList<Integer>();
	    read2(a1,"cipher4.txt"); //challenge.txt
	    for(int i=0;i<a1.size();i++) {
	    	if(a[i]!=null) {
	    		int c = a1.get(i) ^ Integer.parseInt(a[i], 16);
	    		a1.set(i, c);
	    	}
	    	else {
	    		a1.set(i, 0);
	    	}
	    }
	    for(int i=0;i<a1.size();i++) {
	    	if(a1.get(i)!=0) {
	    	String c1 = Integer.toHexString(a1.get(i));
	    	System.out.print(hexTolLetter(c1));}
	    	else {
	    		System.out.print("*");
	    	}
	    }
	    
	    
	    bfw.close();
	    fw.close();
	}
	
	public static String hexTolLetter(String hex) {
		StringBuilder sb = new StringBuilder();
		int i = Integer.parseInt(hex, 16);
		sb.append((char)i);
		
		return sb.toString();
	}
	public static void read2(ArrayList<Integer> a,String n) throws IOException{
		String fp = n;
		FileReader fr = new FileReader(fp);
		BufferedReader bfr = new BufferedReader(fr);
		
		String record;
	    while((record = bfr.readLine())!=null)			//開始讀檔一行一行讀
        {
        	String [] report=record.split(" ");	//利用正規表示將每一行劃分為單詞詞彙
        	for(int i=0;i<report.length;i++) {
        		int c = Integer.parseInt(report[i], 16);
        		a.add(c);
        	}
        }
	    
	    bfr.close();
	    fr.close();
	}
	public static void read(String a[],String n) throws IOException{
		String fp = n;
		FileReader fr = new FileReader(fp);
		BufferedReader bfr = new BufferedReader(fr);
		
		String record;
	    while((record = bfr.readLine())!=null)			//開始讀檔一行一行讀
        {
        	String [] report=record.split(":");	//利用正規表示將每一行劃分為單詞詞彙
        	if(a[Integer.parseInt(report[0])]==null) 
        	{
        		a[Integer.parseInt(report[0])] = report[1];
        	}
        }
	    
	    bfr.close();
	    fr.close();
	}

}
