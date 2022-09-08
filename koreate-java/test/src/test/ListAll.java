package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class ListAll {
	
	
	public static void main(String[] args) throws Exception {

		List<Integer> arrayList = new ArrayList<>();
		Integer number = new Integer(0);
		arrayList.add(number);
		arrayList.add(1, new Integer(2));
		arrayList.add(new Integer(999));
		for (int i = 0; i < 100; i++) {
			arrayList.add((int) (Math.random() * 11));
		}
		for (int num : arrayList) {
			System.out.println(num);
		}

		System.out.println(arrayList.get(0));
		System.out.println(arrayList.size());
		System.out.println(arrayList.get(1));
		System.out.println(arrayList.get(2));

//			동기화는 사용하지만 스레드가 안전하진 못하다.
		List<String> vector = new Vector<>();
		vector.add("hello");
		String str = new String("str");
		vector.add(str);
		for (String string : vector) {
			System.out.println(string);
		}

//		삽입 삭제가 빈번하다면 LinkedList 빠른 조회가 우선이라면 ArrayList 
		List<ListAll> LA = new LinkedList<>(); 
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			LA.add(new ListAll());
			System.out.println(LA.get(i));
		}
//		LA.add(5, sc);
		sc.close();
		
		
//		Set, Map은 선형도 비선형도 아님. 
//		HashSet JCF의 경우 해시코드를 우선 비교하고 필요에따라 equals 메소드를 활용해 중복을 따짐
		Set<String> set = new HashSet<>();
		set.add("박재민");
		set.add("재민");
		set.add("민");
		set.add("민재");
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String str2 = iterator.next();
			System.out.println(str2);
			if(str2.equals("민")) {
				iterator.remove();
			}
		}
		System.out.println("\n");
		
//		HashMap은 객체인 key 값과 객체인 value 값을 활용함, HashTable은 ArrayList의 Vector 버전 느낌
//		동기화된 메소드가 적용된 HashTable은 멀티 스레드를 이용해 아이디 패스워드 비교하는 데 용이하다.
		Map<String, Integer> map = new HashMap(); 
		map.put("박재민", 27);
		int score = map.get("박재민");
		map.remove("박재민");
		map.put("재민", 28);
		map.put("박재민", 29);
		map.put("재민", 29);
		map.put("박재민", 30);
		map.put("민", 28);
		map.put("민재", 29);
		
		
		System.out.println("ggggg"+map.get(29));
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String result = keyIterator.next();
			System.out.println(result);
		}
		System.out.println("\n");
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {
//			entryIterator.next();
//			System.out.println(entryIterator);
			
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " and "+ value);
		}
		
//		Stack - LIFO | Queue - FIFO
//		Stack은 클래스이지만 Queue는 인터페이스이다. LinkedList 클래스로 구현할 수 있다.
		
	}

}
