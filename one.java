import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;


public class one {
	public static void main(String args[]) throws IOException {
		String fs = "key.txt";
	    FileWriter fw = new FileWriter(fs);
	    BufferedWriter bfw = new BufferedWriter(fw);
	    
		ArrayList<ArrayList<Integer>> a2 = new ArrayList<ArrayList<Integer>>();
	    for(int i=1;i<=10;i++) {
	    	String n = "cipher"+i+".txt";
	    	String o = "out"+i+".txt";
	    	read(a2,n);
	    }
	    int t =9;
	    for(int q=0;q<=t;q++) {
		ArrayList<ArrayList<String>> A2 = new ArrayList<ArrayList<String>>();
		
		XOR(a2,A2,q);
		int l = Integer.MAX_VALUE;
//		for(int i=0;i<A2.size();i++) {
//			bfw.write(A2.get(i).size()+" ");
//			for(int j=0;j<A2.get(i).size();j++) {
//				bfw.write("["+j+":"+A2.get(i).get(j)+"] ");
//			}
//			bfw.newLine();
//		}
//	    bfw.write(A2.size()+" ");
	    int count[] = new int[200];
	    for(int i=0;i<A2.size();i++) {
	    	for(int j=0;j<A2.get(i).size();j++) {
	    		char s1 = A2.get(i).get(j).charAt(0);
	   		 	if ((s1 > 'A' && s1 < 'Z') || (s1 > 'a' && s1 < 'z')) {
	   			count[j]++;
	   		 	}
	    	}
	    }
	    for(int i=0;i<count.length;i++) {
	    	if(count[i]>=5) {
	    		String s = "20";
	    	    int space = Integer.parseInt(s, 16);
	    	    int c = a2.get(q).get(i) ^ space;
	    	    String c1 = Integer.toHexString(c);
	    	    bfw.write(i+":"+c1);
	    	    bfw.newLine();
//	    	    System.out.println(i+":"+hexTolLetter(c1));
	    	}
	    }
	    
	    }
	    bfw.close();
	    fw.close();
	}
	public static void XOR(ArrayList<ArrayList<Integer>> a2,ArrayList<ArrayList<String>> A2,int n) {
		for(int i=0;i<a2.size();i++) {
			if(i!=n) {
			ArrayList<String> X = new ArrayList<String>();
			if(a2.get(n).size()>a2.get(i).size()) {
				int l = a2.get(i).size();
				for(int j=0;j<l;j++) {
					int c = a2.get(n).get(j)^a2.get(i).get(j);
					String c1 = Integer.toHexString(c);
					X.add(hexTolLetter(c1));
				}
			}
			else {
				int l = a2.get(n).size();
				for(int j=0;j<l;j++) {
					int c = a2.get(n).get(j)^a2.get(i).get(j);
					String c1 = Integer.toHexString(c);
					X.add(hexTolLetter(c1));
				}
			}
			A2.add(X);}
		}
	}
	public static String hexTolLetter(String hex) {
		StringBuilder sb = new StringBuilder();
		int i = Integer.parseInt(hex, 16);
		sb.append((char)i);
		
		return sb.toString();
	}
	public static void read(ArrayList<ArrayList<Integer>> a2,String n) throws IOException{
		String fp = n;
		FileReader fr = new FileReader(fp);
		BufferedReader bfr = new BufferedReader(fr);
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		String record;
	    while((record = bfr.readLine())!=null)			//開始讀檔一行一行讀
        {
        	String [] report=record.split(" ");	//利用正規表示將每一行劃分為單詞詞彙
        	for(int i=0;i<report.length;i++) {
        		int c = Integer.parseInt(report[i], 16);
        		a.add(c);
        	}
        }
	    a2.add(a);
	    
	    bfr.close();
	    fr.close();
	}

}
