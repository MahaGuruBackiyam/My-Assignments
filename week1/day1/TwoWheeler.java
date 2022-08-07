package week1.day1;

public class TwoWheeler {
	int noOfWheels = 2;
	short noOfMirrors = 2;
	long chassisNumber = 5655l;
	boolean isPunctured = false;
	String bikeName = "RX100";
	double runningKM = 400.50;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoWheeler t = new TwoWheeler();
		System.out.println("Number of Wheels:"+t.noOfWheels);
		System.out.println("Number of mirrors:"+t.noOfMirrors);
		System.out.println("Number ofchassis:"+t.chassisNumber);
		System.out.println("Is the wheel puncture?:"+t.isPunctured);
		System.out.println("Name of the bike:"+t.bikeName);
		System.out.println("Running KM:"+t.runningKM);

	}

}
