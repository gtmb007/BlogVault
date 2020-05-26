import java.util.*;
class Main {

	static int findMin(int[] arr) {
		int min=Integer.MAX_VALUE;
		for(int a : arr) {
			if(a<min) min=a;
		}	
		return min;
	}	
	
	static int findMin1(int[] a, int l, int r) {
		if(l>r) return a[0];
		int mid=(l+r)/2;
		if(a[mid]<a[mid-1]) return a[mid];
		if(a[mid]<a[0]) return findMin1(a, 0, mid-1);
		else return findMin1(a, mid+1, r);
	}	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		System.out.println(findMin(a));
		System.out.println(findMin1(a, 0, n-1));
	}	
}
