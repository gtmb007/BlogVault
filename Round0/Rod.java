import java.util.*;
class Main {
	static HashMap<String, Integer> hm=new HashMap<String, Integer>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(cutting(arr, 0, n-1, x, y));
	}	
	static int cutting(int[] arr, int l, int r, int x, int y) {
		if(r-l==1) return 0;
		String s=l+" "+r;
		if(hm.containsKey(s)) return hm.get(s);
		Integer min=Integer.MAX_VALUE;
		for(int i=l+1;i<r;i++) {
			int cost=x*(arr[i]-arr[l])+y*(arr[r]-arr[i])+cutting(arr, l, i, x, y)+cutting(arr, i, r, x, y);
			if(cost<min) min=cost;
		}
		hm.put(s, min);
		return min;
	}
}
