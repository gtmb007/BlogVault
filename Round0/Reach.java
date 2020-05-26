import java.util.*;
class Pair {
	int key;
	boolean value;
	Pair(int key, boolean value) {
		this.key=key;
		this.value=value;	
	}
}
class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();	
		while(t-->0) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			char[][] arr=new char[n][m];
			int x=0,y=0,u=0,v=0;
			for(int i=0;i<n;i++) {
				String s=sc.next();
				for(int j=0;j<m;j++) {
					char c=s.charAt(j);
					if(c=='M') {
						x=i;
						y=j;
					}
					if(c=='*') {
						u=i;
						v=j;
					}
					arr[i][j]=c;
				}
			}
			int k=sc.nextInt();
			Pair pair=f(arr, x, y, u, v, n, m);
			int ans=pair.key;
			if(!pair.value) ans=-1;
			if(ans==k) System.out.println("Correct");
			else System.out.println("Wrong");
		}
	}	
	static Pair f(char[][] arr, int x, int y, int u, int v, int n, int m) {
		if((x==u+1 && y==v) || (x==u-1 && y==v) || (x==u && y==v+1) || (x==u && y==v-1)) {
			int flag=0;
			if(x+1<n && (arr[x+1][y]=='.')) flag=1;
			if(x-1>-1 && (arr[x-1][y]=='.')) flag=1;
			if(y+1<m && (arr[x][y+1]=='.')) flag=1;
			if(y-1>-1 && (arr[x][y-1]=='.')) flag=1;
			if(flag==0) return new Pair(0, true);
			else return new Pair(1, true);
		}
		int flag=0;
		ArrayList<Pair> al=new ArrayList<Pair>();
		arr[x][y]='X';
		if(x+1<n) {
			if(arr[x+1][y]=='.') al.add(f(arr, x+1, y, u, v, n, m));
		} 
		if(x-1>-1) {
			if(arr[x-1][y]=='.') al.add(f(arr, x-1, y, u, v, n, m));
		}		
		if(y+1<m) {
			if(arr[x][y+1]=='.') al.add(f(arr, x, y+1, u, v, n, m));	
		}
		if(y-1>-1 && arr[x][y-1]=='.') {
			if(arr[x][y-1]=='.') al.add(f(arr, x, y-1, u, v, n, m));
		}
		arr[x][y]='.';
		int min=Integer.MAX_VALUE;
		for(Pair pair : al) {
			if(pair.value && pair.key<min) min=pair.key;
		}
		if(al.size()==0 || min==Integer.MAX_VALUE) return new Pair(0, false);
		if(al.size()>1) return new Pair(min+1, true);
		return new Pair(min, true);
	}
}
