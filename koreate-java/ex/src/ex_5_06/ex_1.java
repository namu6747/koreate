package ex_5_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ex_1 {

	public static void main(String[] args) {
		List<Integer> array1 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			array1.add((int) (Math.random() * 10) + 1);
		}
		System.out.println("최초의 리스트 " + array1.toString());
		Collections.sort(array1);
		System.out.println("정렬된 리스트 " + array1.toString());

		int[] array2 = { 10, 20, 30, 40, 50 };
		int[] array3 = Arrays.copyOfRange(array2, 1, 3);
		System.out.println(Arrays.toString(array3));

		boolean isRun = true;
		Scanner sc = new Scanner(System.in);
		String input;
		while (isRun) {
			System.out.println("문자열을 입력해 주세요 >>");
			input = sc.next();
			if (input.indexOf("java") == -1) {
				System.out.println("java가 없다");
				continue;
			}
			System.out.println("통과");
			System.err.println("종료");
			isRun = false;
		}
		
		String chars = "qwertyuioplkjhgfdsazxcvbnm";
		String num = "7896541230";
		isRun = true;
		while (isRun) {
			System.out.println("문자나 숫자를 입력하세요: ");
			System.out.print("종료 하려면 100 입력");
			
			input = sc.next();
			try{if(Integer.parseInt(input) == 100) {isRun=false;return;}}catch(Exception e) {};
			System.out.println("입력 받은 문자: "+input);
			System.out.print("영어문자: ");
			if(chars.indexOf(input) == -1) {
				System.out.println(1<0);
			}else {System.out.println(1>0);}
			System.out.print("숫자 : ");
			if(num.indexOf(input) == -1) {
				System.out.println(1<0);
			}else {System.out.println(1>0);}
		}
		
		String scores = "100,11,35,41";
		int total = 0;
		double avg = 0.0;
		String[] score = scores.split(",");
		
		for(int i =0; i<score.length;i++) {
			total += Integer.valueOf(score[i]);
		}
		
		avg = (double)total/score.length;
		System.out.println(scores);
		System.out.println("총점: "+total+"점");
		System.out.printf("평균: %.1f점",avg);
		
		
		}

	}


