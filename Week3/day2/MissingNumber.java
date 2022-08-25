package Week3.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = { 1, 2, 10, 4, 6, 7, 9, 2, 3, 3, 6, 7, 8, 8, 1 };
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < data.length; i++) {
			set.add(data[i]);
		}
		System.out.println("Elements in set are:  " + set);
		List<Integer> list = new ArrayList<Integer>(set);
		System.out.println("Elements in list are:  " + list);

		for (int i = 0; i < list.size() - 1; i++) {
			int num = i + 1;
			if (num == list.get(i)) {
			} else {
				System.out.println("The missing number is: " + num);
				break;
			}

		}

	}

}
