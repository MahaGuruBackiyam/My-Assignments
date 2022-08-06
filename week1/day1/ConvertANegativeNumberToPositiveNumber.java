package week1.day1;

public class ConvertANegativeNumberToPositiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int negativeNumber = -40;
		int positiveNumber;
		if (negativeNumber < 0) {
			
			positiveNumber = negativeNumber * -1;

			System.out.println("The converted positive number is:" + positiveNumber);
		}
	}

}
