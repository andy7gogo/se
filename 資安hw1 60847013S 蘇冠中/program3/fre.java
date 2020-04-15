import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class fre {
	public static void main(String args[]) throws IOException {
		
		String fp = "frequency_attack_cipher_example.txt";
	    FileReader fr = new FileReader(fp);
	    BufferedReader bfr = new BufferedReader(fr);	//讀取檔名設定
	    
	    String fs = "temp.txt";
	    FileWriter fw = new FileWriter(fs);
	    BufferedWriter bfw = new BufferedWriter(fw);	//寫入新的txt檔的變數設定bfw
	    
	    ArrayList<word> a = new ArrayList<word>();	//存放詞彙
	    ArrayList<word> single = new ArrayList<word>();	//存放單一字母
	    String record;
	    while((record = bfr.readLine())!=null)			//開始讀檔一行一行讀
        {
        	String [] report=record.split("[^a-zA-Z]+");	//利用正規表示將每一行劃分為單詞詞彙
        	for(int i=0;i<report.length;i++) {
        		if(!report[i].equals("")) {
            		check(report[i],a);				//計算詞彙的出現次數
            		String [] s=report[i].split("");	//將詞彙分割為單一字母
            		for(int j=0;j<s.length;j++) {
            			check(s[j],single);			//計算單一字母出現次數
            		}
        		}
        	}
        }
	    sort(single);	//將字母出現次數由大到小排序
	    sort(a);	//將單字出現次數由大到小排序
	    write(single,bfw);	//寫入單字出現次數到temp.txt檔中
	    bfw.write("---------單字母結束--------");
	    bfw.newLine();
	    write(a,bfw);	//寫入詞彙出現次數到temp.txt檔中
	    
	    bfr.close();
	    fr.close();
	    bfw.close();
	    fw.close();
	    //第一階段完成
	    
	    String fp1 = "frequency_attack_cipher_example.txt";
	    FileReader fr1 = new FileReader(fp1);
	    BufferedReader bfr1 = new BufferedReader(fr1);	//讀取檔名設定
	    
	    String fs1 = "break.txt";
	    FileWriter fw1 = new FileWriter(fs1);
	    BufferedWriter bfw1 = new BufferedWriter(fw1);	//寫入新的txt檔的變數設定bfw
	    
	    
	    
	    ArrayList<brewd> bd =new ArrayList<brewd>();	//開始加入轉換字串
	    brewd b1 = new brewd("y","e"); bd.add(b1);		//依照字母出現頻率，以及單字出現頻率去做比對，一個一個加上去解回去
	    brewd b2 = new brewd("u","a"); bd.add(b2);	
	    brewd b3 = new brewd("c","i"); bd.add(b3);
	    brewd b4 = new brewd("h","n"); bd.add(b4);
	    brewd b5 = new brewd("x","d"); bd.add(b5);
	    brewd b6 = new brewd("n","t"); bd.add(b6);
	    brewd b7 = new brewd("b","h"); bd.add(b7);
	    brewd b8 = new brewd("w","c"); bd.add(b8);
	    brewd b9 = new brewd("g","m"); bd.add(b9);
	    brewd b10 = new brewd("v","b"); bd.add(b10);
	    brewd b11 = new brewd("a","g"); bd.add(b11);
	    brewd b12 = new brewd("q","w"); bd.add(b12);
	    brewd b13 = new brewd("m","s"); bd.add(b13);
	    brewd b14 = new brewd("l","r"); bd.add(b14);
	    brewd b15 = new brewd("o","u"); bd.add(b15);
	    brewd b16 = new brewd("z","f"); bd.add(b16);
	    brewd b17 = new brewd("s","y"); bd.add(b17);
	    brewd b18 = new brewd("i","o"); bd.add(b18);
	    brewd b19 = new brewd("r","x"); bd.add(b19);
	    brewd b20 = new brewd("f","l"); bd.add(b20);
	    brewd b21 = new brewd("p","v"); bd.add(b21);
	    brewd b22 = new brewd("e","k"); bd.add(b22);
	    brewd b23 = new brewd("j","p"); bd.add(b23);
	    brewd b24 = new brewd("t","z"); bd.add(b24);
	    brewd b25 = new brewd("k","q"); bd.add(b25);
	    brewd b26 = new brewd("d","j"); bd.add(b26);
	    
	    String record1;
	    while((record1 = bfr1.readLine())!=null)			//開始讀檔一行一行讀
        {
        	String [] report=record1.split("");	//利用正規表示將每一行劃分為單詞詞彙
        	for(int i=0;i<report.length;i++) {
        		breakword(report[i],bd,bfw1);		//再讀一次密文，並將密文依照上面的轉換表解回明文，並寫數break.txt檔中
        	}
        	bfw1.newLine();
        }
	    
	    bfr1.close();
	    fr1.close();
	    bfw1.close();
	    fw1.close();
	    
	}
	public static void breakword(String c,ArrayList<brewd> brewd,BufferedWriter bfw1) throws IOException {
		boolean f =false;
		for(int i=0;i<brewd.size();i++) {
			if(c.equals(brewd.get(i).wd1)) {
				bfw1.write(brewd.get(i).wd2);	//當密文中的字母存在於轉換表中，則將轉換表對應的字母寫入txt檔
				f=true;
			}
		}
		if(f==false) {
			bfw1.write(c);	//當密文中的字母不存在於轉換表，則寫入原本的密文，有可能為標點符號或空白，不需要轉換
		}
	}
	public static void sort(ArrayList<word> a) {	//將Array依照字母出現次數大到小排序排好
		for(int i=0;i<a.size()-1;i++) {
			for(int j=i+1;j<a.size();j++) {
				if(a.get(i).count<a.get(j).count) {
					String s1 = a.get(i).wd;int c1 = a.get(i).count;
					a.get(i).wd = a.get(j).wd;a.get(i).count = a.get(j).count;
					a.get(j).wd = s1;a.get(j).count=c1;
				}
			}
		}
	}
	public static void write(ArrayList<word> a,BufferedWriter bfw) throws IOException{
		for(int i=0;i<a.size();i++) {	//將計算的字母次數寫入txt檔中
			System.out.println(a.get(i).wd+" "+a.get(i).count);
			bfw.write(a.get(i).wd+" "+a.get(i).count);
			bfw.newLine();
		}
	}
	public static void check(String c,ArrayList<word> a) {
		boolean f = false;
		for(int i=0;i<a.size();i++) {	
			if(c.equals(a.get(i).wd)) {
				a.get(i).count++;
				f =true;	//確認陣列有無此字詞存在，有的計算+1
			}
		}
		if(f == false) {
			word temp = new word(c,1);
			a.add(temp);	//陣列沒有此詞，則新加入
		}
	}
	
	public static class word
    {
		String wd;
		int count;
    	public word(String WD,int C)	//自製資料結構 存放 [英文字,次數]
    	{
    		wd = WD;
    		count = C;
    	}
    }
	public static class brewd
	{
		String wd1;
		String wd2;
		public brewd(String w1,String w2) 	//自製資料結構 為轉換表 存放[英文字,英文字]
		{
			wd1 = w1;
			wd2 = w2;
		}
	}
}
