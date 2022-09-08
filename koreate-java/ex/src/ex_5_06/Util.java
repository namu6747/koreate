package ex_5_06;

public class Util {
	/*
		getValue() 작성	
	*/
	public static <T extends Pair<K,V>, K, V> V getValue(T t, K k) {
		if(t.getKey().equals(k)) {
			return t.getValue();
		}
		
		return null;
	}
}
