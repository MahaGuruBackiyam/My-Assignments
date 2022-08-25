package Week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = { 3, 2, 11, 4, 6, 7, 2, 3, 3, 6, 7 };
		Set<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < data.length; i++) {
			set.add(data[i]);
		}
		System.out.println("Elements in set are:  " + set);
		List<Integer> list = new ArrayList<Integer>(set);
		System.out.println("Elements in list are:   " + list);
		System.out.println("The second largest number is:  " + list.get(list.size() - 2));

	}

}
/**
 * list.get(0)-->gives the element in that index 0.
 * list.size()--->gives the six of the list.
 */


/*List<Integer> list=new ArrayList<Integer>(set);
int large=data[0];
for(Integer list1:list) {
if(list1>large) {
	large=list1;
}*/