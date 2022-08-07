package week1.day2;

public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 14;
		boolean flag = false;
		for (int i = 2; i <= n - 1; i++) {
			if (n % i == 0) {
				flag = true;
				
			}
		}
		if (flag) {
			System.out.println(n+" is not a prime Number");
		} else {
			System.out.println(n+" is a prime Number");
		}

	}

}
