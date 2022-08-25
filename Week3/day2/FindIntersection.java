package Week3.day2;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 3, 2, 11, 4, 6, 7 };
		int[] array2 = { 1, 2, 8, 4, 9, 7 };
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		for (int a : array1) {
			list1.add(a);
		}
		System.out.println("Elements in list 1: " + list1);
		for (int b : array2) {
			list2.add(b);
		}
		System.out.println("Elements in list 2: " + list2);
		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if (list1.get(i) == list2.get(j)) {
					System.out.println("The matching numbers are:  " + list1.get(i));
				}
			}

		}

	}

}
