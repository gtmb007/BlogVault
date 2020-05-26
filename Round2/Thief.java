import java.util.*;

class Main {
	
	static HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();	

	static int steal(int[] a, int i) {
		int l=a.length;
		if(i==l-1 || i==l-2) return a[i];
		if(hm.containsKey(i)) return hm.get(i);
		int max=Integer.MIN_VALUE;
		for(int j=i+2;j<l;j++) {
			int temp=steal(a, j);
			if(temp>max) max=temp;
		}
		int res=a[i]+max;
		hm.put(i, res);
		return res;
	}
	
	static int steal1(int[] a) {
		int l=a.length;
		if(l>1) a[1]=Math.max(a[1], a[0]);
		for(int i=2;i<l;i++) {
			a[i]=Math.max(a[i]+a[i-2], a[i-1]);
		}
		return a[l-1];
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		int max=Integer.MIN_VALUE;
		for(int j=0;j<n;j++) {
                        int temp=steal(a, j);
                        if(temp>max) max=temp;
                }
		System.out.println(max);
		System.out.println(steal1(a));
	}

}
