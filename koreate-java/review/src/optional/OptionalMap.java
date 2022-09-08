package optional;

import java.util.Optional;

public class OptionalMap {

	public static void main(String[] args) {
		
		Optional<String> os1 = Optional.of("Optional String");
		Optional<String> os2 = os1.map(s -> s.toUpperCase());
		System.out.println(os2.get());
		
		Optional<String> os3 = os1.map(s -> s.replace(' ', '_')).map(s -> s.toLowerCase());
		System.out.println(os3.get());
		
		os1 = Optional.empty();
		os2 = Optional.of("So Basic");
		
		String s1 = os1.map(s -> s.toString()).orElse("Empty");
		String s2 = os2.map(s -> s.toString()).orElse("Empty");
		
		System.out.println(s1);
		System.out.println(s2);
		
		String s3 = null;
		s3.toString();
		
		
	}

}
