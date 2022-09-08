package com.test.legacy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static Object test(String input) {
		Map<Integer, List<String>> map = new HashMap<>();
		map.put(100, Arrays.asList("인문학", "철학"));
		map.put(200, Arrays.asList("천문학", "물리학"));

		Object num = map.keySet().stream()
				.filter(key -> map.get(key).contains(input))
				.findAny()
				.orElse(0);
		return num;
	}
	
	public static void main(String[] args) {
		
		Object result = Test.test("물리학");
		System.out.println(result);
	}
	
}
