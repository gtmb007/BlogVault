/*
   Find the first occurence of pattern in string
   Return the position where it found
   string will only contain alphanumeric characters
   pattern contains
   alphanumeric - exact match
   dot(.) - Matches any character
   Asterisk(*) - Previous character repeated 0 or more times
   (?) - Previous character repeated 0 or 1 time
   plus(+) - previous character is repeated 1 or more time


   int regex_find(pattern, string)


Examples:

string: aaabbbcccdddeee

pattern: bbb - Matches. position 3 // will run
pattern: c.c - Matches. position 6 // will run
pattern: eeee - Unmatched // will run
pattern: cd*e - Matches. position 8 // will run
pattern: c.*e - Matches. position 6 // will run
pattern: ccdddd? - Matches. postition 7 // will run
pattern: ccddde+ - Matched position 7 // will run





 To execute Java, please define "static void main" on a class
 named Solution.

 If you need more classes, simply define them inline.
*/

import java.util.*;

class Solution {

	static int isMatches(String str, String patt) {
		int i=0, j=0, res=-1, flag=0, l1=str.length(), l2=patt.length();
		while(i!=l1 && j!=l2) {
			if(str.charAt(i)==patt.charAt(j) || patt.charAt(j)=='.') {
				if(flag==0) {
					res=i;
					flag=1;
				}
				i++;
				j++;
			} else if(j<l2-1 && (patt.charAt(j+1)=='*' || patt.charAt(j+1)=='?')) {
				j+=2;
			} else if((j-1>-1 && (patt.charAt(j)=='+') || (patt.charAt(j)=='*')) ) {
				if((patt.charAt(j-1)=='.') || (str.charAt(i)==patt.charAt(j-1))) {
					i++;
				} else if(j<l2-1 && patt.charAt(j+1)==str.charAt(i)) {
					j+=2;
				} else {
					i=res+1;
					j=0;
					res=-1;
					flag=0;
				}
			} else if(patt.charAt(j)=='?') {
				if((patt.charAt(j-1)=='.') || (str.charAt(i)==patt.charAt(j-1))) {
					i++;
					j++;
				} else {
					i=res+1;
					j=0;
					res=-1;
					flag=0;
				}
			} else {
				if(flag==1) {
					i=res+1;
					j=0;
					flag=0;
					res=-1;
				} else {
					i++;
				}
			}
		}
		if(j!=l2) {
			if(patt.charAt(j)=='+' || patt.charAt(j)=='*') {
				if(!(j==l2-1 && (patt.charAt(j)=='+' || patt.charAt(j)=='*'))) {
					int temp=isMatches(str.substring(res+j), patt.substring(j+1));
					if(temp==-1) res=-1;
				}
			} else {
				res=-1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		String patt=sc.next();
		int ans=isMatches(str, patt);
		if(ans==-1) System.out.println("Unmatched");
		else System.out.println("Matches. position "+ans);
	}

}



