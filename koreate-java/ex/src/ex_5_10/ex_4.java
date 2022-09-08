package ex_5_10;

import java.util.*;

public class ex_4 {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		int num;
		Scanner sc = new Scanner(System.in);
		boolean isRun = true;
		System.out.println("정수(-1이 입력될 때까지)");
		while(isRun) {
			num = sc.nextInt();
			if(num == -1) {
				System.out.println("가장 큰 수는 : " + Collections.max(set));
				System.out.println("시스템 종료");
				break;
			}
			set.add(num);
		}
		
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return 0;
			}
		};
		
	}
}
