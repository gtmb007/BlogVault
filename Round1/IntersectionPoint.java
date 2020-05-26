import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val=val;
	}
	public String toString() {
		return Integer.toString(this.val);
	}
}

class Main {
	
	static ListNode findMergedPoint(ListNode head1, ListNode head2) {
		ListNode res=null;
		HashMap<ListNode, Boolean> hm=new HashMap<ListNode, Boolean>();
		while(head1!=null) {
			hm.put(head1, true);
			head1=head1.next;
		}		
		while(head2!=null) {
			if(hm.containsKey(head2)) {
				res=head2;	
				break;
			}
			head2=head2.next;
		}
		return res;
	}
	
	static ListNode findMergedPoint1(ListNode head1, ListNode head2) {
		ListNode temp1=head1;
		ListNode temp2=head2;
		int l1=0,l2=0;
		while(temp1!=null) {
			l1++;
			temp1=temp1.next;
		}
		while(temp2!=null) {
                        l2++;
                        temp2=temp2.next;
                }
		if(l1>l2) {
			int u=l1-l2;
			while(head1!=null && head2!=null && head1!=head2) {
				if(u-->0) head1=head1.next;
				else {
					head1=head1.next;
					head2=head2.next;
				}
			}
		}
		if(l1<l2) {
                        int u=l2-l1;
                        while(head1!=null && head2!=null && head1!=head2) {
                                if(u-->0) head2=head2.next;
                                else {
                                        head1=head1.next;
                                        head2=head2.next;
                                }
                        }
                }
		return head1;
	}
	
	public static void main(String[] args) {
                Scanner sc=new Scanner(System.in);
                System.out.println("Enter size of list1: ");
                int n=sc.nextInt();
                System.out.println("Enter elements of list1: ");
                ListNode head=null;
                ListNode temp=null;
                while(n-->0) {
                        ListNode node=new ListNode(sc.nextInt());
                        if(head==null) {
                                head=node;
                                temp=head;
                        } else {
                                temp.next=node;
                                temp=temp.next;
                        }
                }
		System.out.println("Enter size of list2: ");
                int n1=sc.nextInt();
                System.out.println("Enter elements of list2: ");
                ListNode head1=null;
                ListNode temp1=null;
                while(n1-->0) {
                        ListNode node=new ListNode(sc.nextInt());
                        if(head1==null) {
                                head1=node;
                                temp1=head1;
                        } else {
                                temp1.next=node;
                                temp1=temp1.next;
                        }
                }
		System.out.println("Enter size of merged part: ");
                int n2=sc.nextInt();
                System.out.println("Enter elements of merged part: ");
                ListNode head2=null;
                ListNode temp2=null;
                while(n2-->0) {
                        ListNode node=new ListNode(sc.nextInt());
                        if(head2==null) {
                                head2=node;
                                temp2=head2;
                        } else {
                                temp2.next=node;
                                temp2=temp2.next;
                        }
                }
		temp.next=head2;
		temp1.next=head2;
		System.out.println(findMergedPoint(head, head1));
		System.out.println(findMergedPoint(head, head1));	

        }

}
