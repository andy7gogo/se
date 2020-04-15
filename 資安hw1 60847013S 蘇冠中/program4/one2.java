import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;


public class one2 {
	public static void main(String args[]) throws IOException {
		String fs = "answer.txt";	//�g�J�ѱK������
	    FileWriter fw = new FileWriter(fs);
	    BufferedWriter bfw = new BufferedWriter(fw);
	    String a[] = new String[200];
	    String n = "answerkey.txt";	//Ū��key�ɡA���㪺���_��answerkey.txt
	    read(a,n);
	    
	    for(int i=0;i<a.length;i++) {
	    	if(a[i]!=null ) {
	    		System.out.println(i+" "+a[i]);	//��ܸ�key���C�ӥ[�K�줸
	    	}
	    }
	    
	    ArrayList<Integer> a1 = new ArrayList<Integer>();
	    read2(a1,"challenge.txt");	//Ū���K��A�i�令cipher1~10
	    for(int i=0;i<a1.size();i++) {
	    	if(a[i]!=null) {
	    		int c = a1.get(i) ^ Integer.parseInt(a[i], 16);	
	    		a1.set(i, c);	//�N�K��Pkey�i��XOR�A�i��ѱK
	    	}
	    	else {
	    		a1.set(i, 0);	//�Y�Ybyte�|����key�A�h��XOR
	    	}
	    }
	    for(int i=0;i<a1.size();i++) {
	    	if(a1.get(i)!=0) {
	    	String c1 = Integer.toHexString(a1.get(i));
	    	System.out.print(hexTolLetter(c1));
	    	bfw.write(hexTolLetter(c1));	//��ܨüg�Jtxt�ɤ�
	    	}
	    	
	    	else {
	    		System.out.print("*");	//�N�S�ѱK��key��m�g��*�A��K����
	    	}
	    }
	    
	    
	    bfw.close();
	    fw.close();
	}
	
	public static String hexTolLetter(String hex) {	//�Nhex�ন�r��
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
	    while((record = bfr.readLine())!=null)			//�}�lŪ�ɤ@��@��Ū
        {
        	String [] report=record.split(" ");	//�Q�Υ��W��ܱN�C�@�湺����������J
        	for(int i=0;i<report.length;i++) {
        		int c = Integer.parseInt(report[i], 16);	//Ū��cipher�s�JArray��
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
	    while((record = bfr.readLine())!=null)			//�}�lŪ�ɤ@��@��Ū
        {
        	String [] report=record.split(":");	//�Q�Υ��W��ܱN�C�@�湺����������J
        	if(a[Integer.parseInt(report[0])]==null) 
        	{
        		a[Integer.parseInt(report[0])] = report[1];		//Ū���ѱKkey�s�Ja[]�}�C��
        	}
        }
	    
	    bfr.close();
	    fr.close();
	}

}
