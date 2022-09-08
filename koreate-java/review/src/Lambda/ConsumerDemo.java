package Lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		Consumer<String> c = s -> System.out.println(s);
		c.accept("apple");
		
		ObjIntConsumer<String> oc = (s,i) -> System.out.println(i+" "+s);
		oc.accept("five", 5);
		
		
		
		
	}

}
