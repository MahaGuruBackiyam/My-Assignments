package Week3.day2;

import java.util.HashSet;
import java.util.Set;

public class printUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "MahaGuruBackiyam";
		char[] ch = name.toCharArray(); ///converting string into array
//for(char c:ch) {
//System.out.println("Elements in char array: "+c);}
		Set<Character> s = new HashSet<Character>();
		for (int i = 0; i < ch.length; i++) {
			s.add(ch[i]);
		}
		System.out.println("Unique characters are: " + s);//Elements in Set s

	}

}
