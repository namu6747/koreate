package ex_5_10;

import java.util.*;

public class ex_1 {
	public static void main(String[] args) {
		
		int size = 6;
		List<Character> list = new ArrayList(size);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("6개의 학점을 빈 칸으로 분리 입력 (A/B/C/D/F) >> ");

		StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
		while(st.hasMoreTokens()) {
			list.add(st.nextToken().charAt(0));
		}
		System.out.println("입력 완료");

		double sum = 0;
		for (char m : list) {
			switch (m) {
			case 'A':
				sum += 4;
				break;
			case 'B':
				sum += 3;
				break;
			case 'C':
				sum += 2;
				break;
			case 'D':
				sum += 1;
				break;
			case 'F':
				break;
			default:
				break;
			}
		}
		
		System.out.printf("평균 : %.2f\n",sum/size);

		System.out.println("시스템 종료");
	}
}
