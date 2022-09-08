package ex_4_29.drive;

public class DriverExample {
	public static void drive(Driver driver) {
		driver.drive();
	}

	public static void main(String[] args) {
		Driver busDriver = new BusDriver();
		busDriver.name = "김유산";
		drive(busDriver);
		Driver taxiDriver = new TaxiDriver();
		taxiDriver.name = "심현석";
		drive(taxiDriver);
	}

}
