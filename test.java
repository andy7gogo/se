
public class test {
	public static void main(String args[]) {
		int i = Integer.parseInt("68", 16); 

//		System.out.println(i);
		String c1 = hextoletter("65");
		System.out.println(c1);
		
		int j = Integer.parseInt("7E",16);
		int c = i ^ j;
		String c2 = Integer.toHexString(c);
		System.out.println(c2);
		
	}
	
	public static String hextoletter(String hex) {
		StringBuilder sb = new StringBuilder();
		int i = Integer.parseInt(hex, 16);
		sb.append((char)i);
		
		return sb.toString();
	}
}
