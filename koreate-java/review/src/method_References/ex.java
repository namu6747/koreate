package method_References;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;

class IBox{
	private int n;
	public IBox(int i) { n = i; }
	public int larger(IBox b) {
		if(n > b.n)
			return n;
		else
			return b.n;
	}
}

public class ex {

	public void sort(List<?> ls) {
		Collections.reverse(ls);
	}
	
	public static void main(String[] args) {
		
		List<Integer> ls = Arrays.asList(1,3,5,7,9);
		ls = new ArrayList<>(ls);
		
		Consumer<List<Integer>> c = l -> Collections.reverse(l);
		c.accept(ls);
		System.out.println(ls);
		
		Consumer<List<Integer>> sm = Collections::reverse;
		sm.accept(ls);
		System.out.println(ls);
		
		ex al = new ex();
		Consumer<List<Integer>> im = al::sort;
		im.accept(ls);
		System.out.println(ls);
		
		ls.forEach(System.out::println);
		
		IBox ib1 = new IBox(5);
		IBox ib2 = new IBox(7);
		System.out.println("\n Method references without instance ");
		ToIntBiFunction<IBox, IBox> bf = (b1, b2) -> b1.larger(b2);
		bf = IBox::larger;
		int bigNum = bf.applyAsInt(ib1, ib2);
		System.out.println(bigNum);
		
		System.out.println("\n Constructor references");
		Function<char[], String> f = ar -> {return new String(ar);};
		f = ar -> new String(ar);
		f = String::new;
		char[] src = { 'R', 'o', 'b', 'o', 't' };
		String str = f.apply(src);
		System.out.println(str);
		
		
		
		
	}

}
