import java.util.*;
class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int val) {
		this.val=val;
	}
}
class Pair {
	int key, value;
	Pair(int key, int value) {
		this.key=key;
		this.value=value;
	}
}
class Main {
	static ArrayList<Integer> al=new ArrayList<Integer>();
	static void inOrder(TreeNode root) {
		if(root.left!=null) inOrder(root.left);
		al.add(root.val);
		if(root.right!=null) inOrder(root.right);
	}
	static ArrayList<Pair> merge(ArrayList<Integer> al1, ArrayList<Integer> al2) {
		ArrayList<Pair> list=new ArrayList<Pair>();
		int i=0, j=0;
		while(i<al.size() && j<al2.size()) {
			int a=al1.get(i), b=al2.get(j);
			if(a<=b) {
				list.add(new Pair(a, 1));
				i++;
			} else {
				list.add(new Pair(b, 2));
				j++;
			}
		}
		if(i<al1.size()) {
			while(i<al1.size()) {
				list.add(new Pair(al1.get(i), 1));
				i++;
			}
		}
		if(j<al2.size()) {
			while(j<al2.size()) {
				list.add(new Pair(al2.get(j), 2));
				j++;
			}
		}
		return list;
	}
	static ArrayList<Pair> findSum(ArrayList<Pair> al, int x) {
		ArrayList<Pair> res=new ArrayList<Pair>();
		int i=0, j=al.size()-1;
		while(i<j) {
			Pair pair1=al.get(i), pair2=al.get(j);
			if(pair1.key+pair2.key<x) i++;
			else if(pair1.key+pair2.key>x) j--;
			else {
				if(pair1.value!=pair2.value) res.add(new Pair(pair1.key, pair2.key));
				i++;
				j--;
			} 
		}
		return res;
	}
	static ArrayList<Pair> findPairs(ArrayList<Integer> al1, ArrayList<Integer> al2, int x) {
		int i=0, j=al2.size()-1;
		ArrayList<Pair> res=new ArrayList<Pair>();
		while(i<al1.size() && j>-1) {
			int a=al1.get(i), b=al2.get(j);
			if(a+b<x) i++;
			else if(a+b>x) j--;
			else {
				res.add(new Pair(a, b));
				i++;
				j--;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		TreeNode bst1=new TreeNode(5);
		bst1.left=new TreeNode(3);
		bst1.right=new TreeNode(7);
		bst1.left.left=new TreeNode(2);
		bst1.left.right=new TreeNode(4);
		bst1.right.left=new TreeNode(6);
		bst1.right.right=new TreeNode(8);
		TreeNode bst2=new TreeNode(10);
		bst2.left=new TreeNode(8);
		bst2.right=new TreeNode(12);
		bst2.left.left=new TreeNode(7);
		bst2.left.right=new TreeNode(9);
		bst2.right.left=new TreeNode(11);
		bst2.right.right=new TreeNode(13);
		inOrder(bst1);
		ArrayList<Integer> al1=new ArrayList<Integer>(al);
		al.clear();
		inOrder(bst2);
		ArrayList<Integer> al2=new ArrayList<Integer>(al);
		//System.out.println(al1+" "+al2);
		ArrayList<Pair> pairs=findPairs(al1, al2, 14);
		for(Pair pair : pairs) {
                        System.out.print("{"+pair.key+", "+pair.value+"} ");
                }
		System.out.println();
		ArrayList<Pair> list=merge(al1, al2);
		ArrayList<Pair> res=findSum(list, 14);
		for(Pair pair : res) {
			System.out.print("{"+pair.key+", "+pair.value+"} ");
		}
		System.out.println();
	}
}
