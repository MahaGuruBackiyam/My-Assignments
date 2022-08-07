package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator mc = new Calculator();
		System.out.println("Addition of 3 number:" + mc.add(3, 4, 5));
		System.out.println("Subtraction:" + mc.sub(4, 5));
		System.out.println("Multiplication:" + mc.mul(43.65, 5.65));
		System.out.println("Division:" + mc.div(4.5f, 5.7f));
	}

}
