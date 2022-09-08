package Lambda;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfDemo {

	public static void main(String[] args) throws IOException {

		List<Integer> ls1 = Arrays.asList(1, -2, 3, -4, 5);
		ls1 = new ArrayList<>(ls1);
		List<Double> ls2 = Arrays.asList(-1.1, 2.2, -3.3, 4.4, -5.5);
		ls2 = new ArrayList<>(ls2);
		
		Predicate<Number> p = n -> n.doubleValue() < 0.0;
		ls1.removeIf(p); // removeIf(Predicate<? super E> filter)
		ls2.removeIf(p);
		
		System.out.println(ls1);
		System.out.println(ls2);
		
		File file = new File("C:\\Users\\030\\Desktop\\a\\b\\c\\d\\file.txt");
		file.mkdirs();
		file.createNewFile();
		
		String[] k = {"abcdef", "aaa"};
		System.out.println(k.length);
		
		
		
	}

}
