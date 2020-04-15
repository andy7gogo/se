import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;


public class one {
	public static void main(String args[]) throws IOException {
		String fs = "key.txt";		//�N�i�઺key�g�Jkey.txt�ɤ�
	    FileWriter fw = new FileWriter(fs);
	    BufferedWriter bfw = new BufferedWriter(fw);
	    
		ArrayList<ArrayList<Integer>> a2 = new ArrayList<ArrayList<Integer>>();
	    for(int i=1;i<=10;i++) {
	    	String n = "cipher"+i+".txt";
	    	read(a2,n);		//Ū��10�ӱK��æs�J�G��Array��
	    }
	    int t =9;	//��ܭn�i����@��cipher��XOR
	    for(int q=0;q<=t;q++) {
	    	ArrayList<ArrayList<String>> A2 = new ArrayList<ArrayList<String>>();	//�s��XOR���G��Array
		
	    	XOR(a2,A2,q);	//�N��ܪ�����cipher�P��L9��cipher�i��XOR�A�ñN���G�s�JArray
	    	int l = Integer.MAX_VALUE;
	    	int count[] = new int[200];
	    	for(int i=0;i<A2.size();i++) {
	    		for(int j=0;j<A2.get(i).size();j++) {
	    			char s1 = A2.get(i).get(j).charAt(0);
	    			if ((s1 > 'A' && s1 < 'Z') || (s1 > 'a' && s1 < 'z')) {
	    				count[j]++;	//�p��cipher��XOR�����byte���X�{�^��r������
	    			}
	    		}
	    	}
	    	for(int i=0;i<count.length;i++) {
	    		if(count[i]>=5) {	//�NXOR��X�{�^��r�����ƶW�L5�����A�P" "�ťզA�i��XOR��A�i�o�X��byte��m���i�઺key�A�åB�g�Jkey.txt��
	    			String s = "20";
	    			int space = Integer.parseInt(s, 16);
	    			int c = a2.get(q).get(i) ^ space;
	    			String c1 = Integer.toHexString(c);
	    			bfw.write(i+":"+c1);
	    	    	bfw.newLine();
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
			if(a2.get(n).size()>a2.get(i).size()) {	//������cipher���j�p�A�Τ���p�����Ӫ��׷�@�`����
				int l = a2.get(i).size();
				for(int j=0;j<l;j++) {
					int c = a2.get(n).get(j)^a2.get(i).get(j);
					String c1 = Integer.toHexString(c);
					X.add(hexTolLetter(c1));	//�N���cipher�i��XOR�A���G�s�JArray��
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
	public static String hexTolLetter(String hex) {		//�Nhex�ର�r��
		StringBuilder sb = new StringBuilder();
		int i = Integer.parseInt(hex, 16);
		sb.append((char)i);
		
		return sb.toString();
	}
	public static void read(ArrayList<ArrayList<Integer>> a2,String n) throws IOException{
		String fp = n;		//Ū���ɦW
		FileReader fr = new FileReader(fp);
		BufferedReader bfr = new BufferedReader(fr);
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		String record;
	    while((record = bfr.readLine())!=null)			//�}�lŪ�ɤ@��@��Ū
        {
        	String [] report=record.split(" ");	//�Q�Υ��W��ܱN�C�@�湺����������J
        	for(int i=0;i<report.length;i++) {
        		int c = Integer.parseInt(report[i], 16);	//�Ncipher���rŪ���æs�JArray��
        		a.add(c);
        	}
        }
	    a2.add(a);
	    
	    bfr.close();
	    fr.close();
	}

}
