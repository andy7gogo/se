import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class test2 {
	public static void main(String args[]) throws IOException{
		ArrayList<String> a = new ArrayList<String>();
		read(a,"key.txt");
		
		ArrayList<String> a1 = new ArrayList<String>();
		read2(a1,"challenge.txt");
		
		ArrayList<String> a2 = new ArrayList<String>();
		for(int i=0;i<a.size();i++) {
			int j = Integer.parseInt(stringToHexString(a.get(i)), 16);
			int k = Integer.parseInt(a1.get(i), 16);
			int c = j ^ k;
			
			String c2 = Integer.toHexString(c);
			a2.add(c2);
		}
		
		String fs = "answerkey.txt";
	    FileWriter fw = new FileWriter(fs);
	    BufferedWriter bfw = new BufferedWriter(fw);
	    
		for(int i=0;i<a2.size();i++) {
			bfw.write(i+":"+a2.get(i));
			bfw.newLine();
		}
		
		bfw.close();
		fw.close();
	}
	public static String stringToHexString(String s) {  
        String str = "";  
        for (int i = 0; i < s.length(); i++) {  
            int ch = s.charAt(i);  
            String s4 = Integer.toHexString(ch);  
            str = str + s4;  
        }  
        return str;  
    }
	public static String hextoletter(String hex) {
		StringBuilder sb = new StringBuilder();
		int i = Integer.parseInt(hex, 16);
		sb.append((char)i);
		
		return sb.toString();
	}
	public static void read(ArrayList<String> a,String n) throws IOException{
		String fp = n;
		FileReader fr = new FileReader(fp);
		BufferedReader bfr = new BufferedReader(fr);
		
		String record;
	    while((record = bfr.readLine())!=null)			//開始讀檔一行一行讀
        {
        	String [] report=record.split("");	//利用正規表示將每一行劃分為單詞詞彙
        	for(int i=0;i<report.length;i++) {
        		a.add(report[i]);
        	}
        }
	    
	    bfr.close();
	    fr.close();
	}
	public static void read2(ArrayList<String> a,String n) throws IOException{
		String fp = n;
		FileReader fr = new FileReader(fp);
		BufferedReader bfr = new BufferedReader(fr);
		
		String record;
	    while((record = bfr.readLine())!=null)			//開始讀檔一行一行讀
        {
        	String [] report=record.split(" ");	//利用正規表示將每一行劃分為單詞詞彙
        	for(int i=0;i<report.length;i++) {
        		a.add(report[i]);
        	}
        }
	    
	    bfr.close();
	    fr.close();
	}
}
