package ex_5_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest<E> {
	private int capacity;
	private E[] array;
	private int length;

	
	
	ArraysTest(int capacity) {
		this.capacity = capacity;
		array = (E[]) new Object[capacity];
	};

	public void add(E e) {
		for (int i = 0; i < capacity; i++) {
			if (array[i] == null) {
				array[i] = e;
				System.out.println(e + "저장");
				return;
			} else if (array[capacity - 1] != null) {
				Object[] temp = new Object[++capacity];
				temp = Arrays.copyOf(array, capacity);
				array = (E[]) temp;
			}
		}
	}

	public void remove(E e) {
		int index = Arrays.asList(array).indexOf(e);
		Object[] temp = new Object[--capacity];

		for (int i = 0; i < index; i++) {
			temp[i] = array[i];
		}
		for (int i = index; i < capacity; i++) {
			temp[i] = array[i + 1];
		}
		array = (E[]) temp;
	}

	public int size() {
		length = capacity;
		return length;
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}

	public static void main(String[] args) {
		ArraysTest<String> array = new ArraysTest<>(3);
		System.out.println(array);
		array.add("최기근");
		array.add("유관순");
		array.add("신사임당");
		array.add("최기근");

		System.out.println(array.size());
		System.out.println(array);

		array.remove("최기근");
		System.out.println(array.size());
		System.out.println(array);

		array.remove("최기근");
		System.out.println(array.size());
		System.out.println(array);
		
		List a = new ArrayList();
		
		
		
	}
}
