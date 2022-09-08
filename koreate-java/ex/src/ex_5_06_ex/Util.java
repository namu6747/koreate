package ex_5_06_ex;

class Pair<K,V>{
	K key;
	V value;
	
	K getKey() {return null;}
	V getValue() {return null;}
}

public class Util {

	public static <K,V> V getValue(Pair<K, V> p, K k) {
		if(p.getKey().equals(k)) {
			return p.getValue();
		}
		return null;
	}
	/*
		getValue() 작성	
	*/
	
}
 