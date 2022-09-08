package Nested;

public class Example {
	public static void main(String[] args) {
		
//		create instance member class object
		Nested nest = new Nested(args);
		Nested.InnerI inneri = nest.new InnerI();
		Nested.InnerI.InnerI2 inneri2 = inneri.new InnerI2();
		
//		create static member class object
		Nested.InnerS inners = new Nested.InnerS();
		
		nest.methodA(5);
		Nested.InnerSI.methodo();
	}
}
