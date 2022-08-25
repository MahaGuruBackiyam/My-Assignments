package Week3.day2;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class PrintDuplicateNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = { 4, 3, 6, 8, 29, 1, 2, 4, 7, 8 };
		String s1 = Arrays.toString(data);
		Set<Integer> s = new HashSet<Integer>();
		Set<Integer> s2 = new HashSet<Integer>();

		for (int in : data) {
			if (!s.add(in)) {
				s2.add(in);
			}
		}
		System.out.println("Elements in array: " + s1);
		System.out.println("The Duplicate numbers are: " + s2);//elements in set s2

	}

}
