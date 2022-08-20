package Week3.day1;

public class AxisBank extends BankInfo {
	public void deposit() {
		System.out.println("Deposit in Axis Bank: 1000rs");
		//super.deposit();
	}

	public static void main(String[] args) {
		
		AxisBank b = new AxisBank();
		BankInfo bi=new BankInfo();
		bi.deposit();
		b.deposit();
		b.fixed();
		b.saving();

	}

}
