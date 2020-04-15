import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;


public class one2 {
	public static void main(String args[]) throws IOException {
		String fs = "answer.txt";	//寫入解密的明文
	    FileWriter fw = new FileWriter(fs);
	    BufferedWriter bfw = new BufferedWriter(fw);
	    String a[] = new String[200];
	    String n = "answerkey.txt";	//讀取key檔，完整的金鑰為answerkey.txt
	    read(a,n);
	    
	    for(int i=0;i<a.length;i++) {
	    	if(a[i]!=null ) {
	    		System.out.println(i+" "+a[i]);	//顯示該key的每個加密位元
	    	}
	    }
	    
	    ArrayList<Integer> a1 = new ArrayList<Integer>();
	    read2(a1,"challenge.txt");	//讀取密文，可改成cipher1~10
	    for(int i=0;i<a1.size();i++) {
	    	if(a[i]!=null) {
	    		int c = a1.get(i) ^ Integer.parseInt(a[i], 16);	
	    		a1.set(i, c);	//將密文與key進行XOR，進行解密
	    	}
	    	else {
	    		a1.set(i, 0);	//若某byte尚未有key，則不XOR
	    	}
	    }
	    for(int i=0;i<a1.size();i++) {
	    	if(a1.get(i)!=0) {
	    	String c1 = Integer.toHexString(a1.get(i));
	    	System.out.print(hexTolLetter(c1));
	    	bfw.write(hexTolLetter(c1));	//顯示並寫入txt檔中
	    	}
	    	
	    	else {
	    		System.out.print("*");	//將沒解密的key位置寫成*，方便辨識
	    	}
	    }
	    
	    
	    bfw.close();
	    fw.close();
	}
	
	public static String hexTolLetter(String hex) {	//將hex轉成字符
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
        		int c = Integer.parseInt(report[i], 16);	//讀取cipher存入Array中
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
        		a[Integer.parseInt(report[0])] = report[1];		//讀取解密key存入a[]陣列中
        	}
        }
	    
	    bfr.close();
	    fr.close();
	}

}
