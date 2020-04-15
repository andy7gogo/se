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
	    BufferedReader bfr = new BufferedReader(fr);	//Ū���ɦW�]�w
	    
	    String fs = "temp.txt";
	    FileWriter fw = new FileWriter(fs);
	    BufferedWriter bfw = new BufferedWriter(fw);	//�g�J�s��txt�ɪ��ܼƳ]�wbfw
	    
	    ArrayList<word> a = new ArrayList<word>();	//�s����J
	    ArrayList<word> single = new ArrayList<word>();	//�s���@�r��
	    String record;
	    while((record = bfr.readLine())!=null)			//�}�lŪ�ɤ@��@��Ū
        {
        	String [] report=record.split("[^a-zA-Z]+");	//�Q�Υ��W��ܱN�C�@�湺����������J
        	for(int i=0;i<report.length;i++) {
        		if(!report[i].equals("")) {
            		check(report[i],a);				//�p����J���X�{����
            		String [] s=report[i].split("");	//�N���J���ά���@�r��
            		for(int j=0;j<s.length;j++) {
            			check(s[j],single);			//�p���@�r���X�{����
            		}
        		}
        	}
        }
	    sort(single);	//�N�r���X�{���ƥѤj��p�Ƨ�
	    sort(a);	//�N��r�X�{���ƥѤj��p�Ƨ�
	    write(single,bfw);	//�g�J��r�X�{���ƨ�temp.txt�ɤ�
	    bfw.write("---------��r������--------");
	    bfw.newLine();
	    write(a,bfw);	//�g�J���J�X�{���ƨ�temp.txt�ɤ�
	    
	    bfr.close();
	    fr.close();
	    bfw.close();
	    fw.close();
	    //�Ĥ@���q����
	    
	    String fp1 = "frequency_attack_cipher_example.txt";
	    FileReader fr1 = new FileReader(fp1);
	    BufferedReader bfr1 = new BufferedReader(fr1);	//Ū���ɦW�]�w
	    
	    String fs1 = "break.txt";
	    FileWriter fw1 = new FileWriter(fs1);
	    BufferedWriter bfw1 = new BufferedWriter(fw1);	//�g�J�s��txt�ɪ��ܼƳ]�wbfw
	    
	    
	    
	    ArrayList<brewd> bd =new ArrayList<brewd>();	//�}�l�[�J�ഫ�r��
	    brewd b1 = new brewd("y","e"); bd.add(b1);		//�̷Ӧr���X�{�W�v�A�H�γ�r�X�{�W�v�h�����A�@�Ӥ@�ӥ[�W�h�Ѧ^�h
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
	    while((record1 = bfr1.readLine())!=null)			//�}�lŪ�ɤ@��@��Ū
        {
        	String [] report=record1.split("");	//�Q�Υ��W��ܱN�C�@�湺����������J
        	for(int i=0;i<report.length;i++) {
        		breakword(report[i],bd,bfw1);		//�AŪ�@���K��A�ñN�K��̷ӤW�����ഫ��Ѧ^����A�üg��break.txt�ɤ�
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
				bfw1.write(brewd.get(i).wd2);	//��K�夤���r���s�b���ഫ���A�h�N�ഫ��������r���g�Jtxt��
				f=true;
			}
		}
		if(f==false) {
			bfw1.write(c);	//��K�夤���r�����s�b���ഫ��A�h�g�J�쥻���K��A���i�ର���I�Ÿ��ΪťաA���ݭn�ഫ
		}
	}
	public static void sort(ArrayList<word> a) {	//�NArray�̷Ӧr���X�{���Ƥj��p�ƧǱƦn
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
		for(int i=0;i<a.size();i++) {	//�N�p�⪺�r�����Ƽg�Jtxt�ɤ�
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
				f =true;	//�T�{�}�C���L���r���s�b�A�����p��+1
			}
		}
		if(f == false) {
			word temp = new word(c,1);
			a.add(temp);	//�}�C�S�������A�h�s�[�J
		}
	}
	
	public static class word
    {
		String wd;
		int count;
    	public word(String WD,int C)	//�ۻs��Ƶ��c �s�� [�^��r,����]
    	{
    		wd = WD;
    		count = C;
    	}
    }
	public static class brewd
	{
		String wd1;
		String wd2;
		public brewd(String w1,String w2) 	//�ۻs��Ƶ��c ���ഫ�� �s��[�^��r,�^��r]
		{
			wd1 = w1;
			wd2 = w2;
		}
	}
}
