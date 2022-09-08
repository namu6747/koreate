package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Basic {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 5 };
		Arrays.stream(ar).filter(n -> n % 2 == 1).forEach(n -> System.out.println(n + "\t"));
		System.out.println();

		List<String> sl = Arrays.asList("Toy", "Robot", "Box");
		sl.stream().filter(s -> s.length() == 3).forEach(s -> System.out.print(s + "\t"));
		System.out.println();

		sl.stream().map(s -> s.length()).forEach(s -> System.out.println(s));

		List<String> ls = Arrays.asList("Box", "Simple", "Complex", "Robot");

		BinaryOperator<String> lc = (s1, s2) -> {
			if (s1.length() > s2.length()) {
				return s1;

			} else {
				return s2;
			}
		};

		String str = ls.stream().reduce("", lc);
		System.out.println(str);
		
		str = ls.parallelStream().reduce("", lc);
		System.out.println(str);
		
	}
}
