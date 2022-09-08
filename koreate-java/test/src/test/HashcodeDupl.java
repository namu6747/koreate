package test;

public class HashcodeDupl {
	public static void main(String[] args) {
		int index = 0;
		int k;
		HashcodeDupl[] arr = new HashcodeDupl[200000];
		String[] str = new String[20];
		while (true) {
			arr[index] = new HashcodeDupl();
			System.out.println(arr[index].toString() + ":" + arr[index].hashCode() + " c: " + index);
			if (index != 0) {
				for (int j = 0; j < index; j++) {
					if (arr[index].hashCode() == arr[j].hashCode()) {
						for (k = 0; k < str.length; k++) {
							if (str[k] == null) {
								str[k] = index+"번 "+arr[index].toString() + ":" + arr[index].hashCode() + "\n" + j + "번 "
										+ arr[j].toString() + ":" + arr[j].hashCode();
								break;
							}
						}
					}
				}
			}
			index++;
			if (arr[199998] != null) {
				for (String m : str) {
					if (m != null) {
						System.out.println(m);
					}
				}
				break;
			}
		}
	}
}
//  서로 다른 Heap 주소를 참조하지만 HashCode가 동일한 경우가 있다. 10만개 중 2개
// array sort 객체 20만개를 미리 만들어두고 or 배열 내 동일한 값 비교