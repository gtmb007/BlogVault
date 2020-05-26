import java.util.*;
class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val=val;
	}
}
class Main {
	static boolean detectCircle(ListNode head) {
		ListNode slow=head, fast=head;
		boolean res=false, flag=false;
		while(fast!=null && fast.next!=null) {
			if(slow==fast && flag) {
				res=true;
				break;
			}
			slow=slow.next;	
			fast=fast.next.next;
			if(!flag) flag=true;
		}
		return res;
	}
	static ListNode meetPoint(ListNode head) {
		ListNode temp=head;
		ListNode res=null;
		HashSet<ListNode> hs=new HashSet<ListNode>();
		while(temp!=null) {
			if(hs.contains(temp))  {
				res=temp;
				break;
			} else hs.add(temp);
			temp=temp.next;
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ListNode head=null;
		ListNode temp=null;
		System.out.println("Number of nodes: ");
		int n=sc.nextInt();
		ListNode meetNode=null;
		System.out.println("Enter meet point: ");
		int m=sc.nextInt();
		System.out.println("Enter node values: ");
		for(int i=1;i<=n;i++) {
			ListNode node=new ListNode(sc.nextInt());
			if(i==m) meetNode=node;
			if(head==null) {
				head=node;
				temp=head;
			} else {
				temp.next=node;
				temp=temp.next;
			}
		}
		temp.next=meetNode;
		ListNode res=meetPoint(head);
		if(res==null) {
			System.out.println("Linear.");
		} else {
			System.out.println("Meet node: "+res.val);
		}
		System.out.println("Circle detected: "+detectCircle(head));
	}		
}
