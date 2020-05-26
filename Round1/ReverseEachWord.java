import java.util.*;
class Main {
	static String reverseWords(String s) {
		String res="";
		String[] arr=s.split(" ");
		for(String str : arr) {
			res+=new StringBuilder(str).reverse().toString()+" ";
		}
		return res.trim();
	}
	static String reverse(String str) {
		int i=0, j=str.length()-1;
		String str1="", str2="";
		while(i<j) {
			str1=str.charAt(i)+str1;
			str2+=str.charAt(j);
			i++;
			j--;
		}
		if(i==j) return str2+str.charAt(i)+str1;
		else return str2+str1;
	}
	static String reverseWords1(String s) {
		String res="";
		ArrayList<Integer> spaceIndexes=new ArrayList<Integer>();
		int i=0;
		for(i=0;i<s.length();i++) {
			if(s.charAt(i)==' ') spaceIndexes.add(i);
		} 
		spaceIndexes.add(i);
		i=0;
		for(int j : spaceIndexes) {
			res+=reverse(s.substring(i, j))+" ";
			i=j+1;
		}
		return res.trim();
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println(reverseWords(s));
		System.out.println(reverseWords1(s));
	}
}
