import java.util.*;
class Main {

	static int findNumber(String s){
		int ans=0, res=0;
		for(int i=0;i<s.length();i++) {
			int a=s.charAt(i)-'0';
			if(a>-1 && a<10) res=res*10+a;
			else {
				ans+=res;
				res=0;
			}
		}
		ans+=res;
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		System.out.println(findNumber(s));
	}
	
}
