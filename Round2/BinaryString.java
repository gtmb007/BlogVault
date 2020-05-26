import java.util.*;
class Main {
	
	static int countSubstring(String s) {
		int l=s.length(), res=0;
		int[] a=new int[l];
		for(int i=l-1;i>-1;i--) {
			if(s.charAt(i)=='1')  {
				if(i==l-1) a[i]=1;
				else a[i]=a[i+1]+1;
				
			} else {
				if(i==l-1) a[i]=0;
                                else a[i]=a[i+1];
			}
		}
		for(int i=0;i<l;i++) {
			if(s.charAt(i)=='1') res+=a[i]-1;
		}
		return res;
	}
	
	static int count(String s) {
		int count=0;
		for(int i=0;i<s.length();i++) {
                        if(s.charAt(i)=='1') count++;
                }	
		return (count*(count-1))/2;
	}	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		System.out.println(countSubstring(s));
		System.out.println(count(s));
	}
}
