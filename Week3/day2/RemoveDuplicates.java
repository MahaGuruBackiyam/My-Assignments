package Week3.day2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String upi="PayPal India";
		char[] ch=upi.toCharArray();
		String s=Arrays.toString(ch);
		Set<Character>charSet=new HashSet<Character>();
		Set<Character>dupCharSet=new HashSet<Character>();
		for (char c : ch) {
			if (!charSet.add(c)) {
				dupCharSet.add(c);
			}
		}
		System.out.println("Elements in array: " + s);
		System.out.println("Duplicte elements are: " + dupCharSet);

	}
}