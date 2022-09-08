package Lambda;

import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {

		Function<String, Integer> f = s -> s.length();
		System.out.println(f.apply("Robot"));
		
		Function<Double, Double> cmToInch = d -> d * 0.393701;
		Function<Double, Double> inchToCm = d -> d * 2.54;
		System.out.println("1cm = " + cmToInch.apply(1.0)+"inch");
		System.out.printf("1inch = %.2fcm",inchToCm.apply(1.0));
		
	}

}
