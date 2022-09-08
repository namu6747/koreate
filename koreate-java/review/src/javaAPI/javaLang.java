package javaAPI;

import java.util.Scanner;

public class javaLang extends Object {
	String strC;int intC;static String k;
	javaLang() {this.strC = "5";this.intC = 5;}
//	javaLang 타입의 두 객체의 특정 필드 값이 동일한 지 비교
	boolean equals(javaLang a) {
		if (a instanceof javaLang) {
			javaLang objC = (javaLang) a;
			if (strC.equals(objC.strC)) {
				return true;
			}
		}
		return false;
	}

	static void br() {System.out.println();}
	String totoString() {return "strC " + this.strC + " intC " + this.intC;}
	static String otsStart(Object obj) {objectToString(obj);return k;}
	private static void objectToString(Object obj) {k = obj.toString();}

//	Object: 자바 클래스의 최상위 클래스
//	System: 표준 입출력 장치와 데이터를 전달 받을 때
//	Class: 클래스를 메모리로 로딩할 때  
//	String: 문자열을 저장하고 여러 가지  정보를 얻을 때
//	Wrapper: 기본 타입의  데이터를 갖는 객체를 만들 때, 문자열을 기본 타입으로 변환할 때
//	Math: 수학 함수를 이용할 때

	public static void main(String[] args) {
		long startT = System.currentTimeMillis();
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner4 = new Scanner(System.in);
		Class scanner2 = Scanner.class;
		Class scanner3 = scanner1.getClass();
//		인스턴스 접근, 클래스 식별자, 클래스 식별자
		System.out.println(scanner1 + "\n" + scanner2 + "\n" + scanner3);
		br();
		
		javaLang jl1 = new javaLang();
		javaLang jl2 = new javaLang();
		System.out.printf("%s : %s\n", jl1.toString(), jl2.toString());
		System.out.println(jl1.toString() == jl2.toString());
		br();

		System.out.printf("%s : %s\n", jl1.totoString(), jl2.totoString());
		System.out.println(jl1.totoString());
		br();
		
		System.out.println("ots 주소 출력: " + otsStart(jl1));
		String ots = otsStart(jl1);
		br();

		System.out.println("String 메소드");
//		특정 위치의 문자를 char로 리턴
		System.out.println(ots.charAt((int) (Math.random() * 20)));
//		매개 변수로부터 시작,끝 인덱스를 받아 그 부분만 문자열 형태로 반환
		System.out.println(ots.substring(0, 3).equals("java"));
//		문자열을 byte[] 형태로 리턴함 / 암호화
//		ASKI 범위를 가지는 1byte가 영어 숫자 정도는 표현해준다.
		System.out.println(ots.getBytes());
		byte[] otsBytes = ots.getBytes();
		int i=0;
		for (byte bbb : otsBytes) {
			i++;
			System.out.printf("%d: %s ", i, bbb);
		}
//		문자열 내에서 매개 변수로 주어진 문자열의 위치를 알려줌 -1은 문자열 내에 없다.
		System.out.println(ots.indexOf("9"));
		System.out.println(ots.getBytes().length);
		System.out.println(ots.replace("java", ""));
		int otsLength = ots.getBytes().length;
		System.out.println(String.valueOf(otsLength));
		br();

//		서로 다른 주소를 참조하는 String 객체의 hashcode는 문자열이 동일하다면 같다.
		System.out.println("hashcode: " + jl1.totoString().hashCode() + " , " + jl2.totoString().hashCode());
		String[] jlArr = new String[5];
		for (i = 0; i < jlArr.length; i++) {
			jlArr[i] = new String("hello");
			System.out.printf("%d번 %s\n", i, jlArr[i].hashCode());
		}

		System.out.println(jl1.totoString() == jl2.totoString());
		System.out.println(jl1.equals(jl2));
		br();
		
//		문자열로 변환할 때 각 인덱스를 유니코드로 나타냄
		byte[] bytes1 = new byte[10];
		byte[] bytes2 = new byte[10];
		for (i=0; i < 10; i++) {
			bytes1[i] = (byte) (Math.random() * 96 + 32); // ASKI
			bytes2[i] = (byte) (Math.random() * 96 + 32);
		}
		String str1 = new String(bytes1);
		System.out.println(str1);
		int[] int1 = { 45000 };
//		int[]의 각 인덱스를 문자열로 변환
		String int2 = new String(int1, 0, 1);
		System.out.println(int2);
//		byte[]의 각 인덱스를 문자열로 변환 5번 인덱스로부터 4개의 인덱스 출력
		String str2 = new String(bytes2, 5, 4);
		System.out.println("bytes1tostr1: "+str1);
		System.out.println("bytes2tostr2: "+str2);
		br();

//		Wrapper 클래스 어디 써먹는 지 모르겠다.
		int int5 = 10000;
		Integer intBoxing = new Integer("10000");
		System.out.println("Compare int5,intBoxing: "+(int5 == intBoxing));
//		매개변수의 value를 값는다~
		Integer intBoxing2 = Integer.valueOf("10000");
		System.out.println("intBoxing: "+intBoxing);
		System.out.println("intBoxing2: "+intBoxing2);
		int num = intBoxing.intValue();
		System.out.println("num: "+num);
		
//		Math 클래스
/*
 *  	int,double abs 절대값
 *  	double ceil 올림
 *  	double floor 내림
 *  	int,double max,min 둘 중 최대 최소
 *  	double rit 가까운 정수 실수값
 *  	long lound 반올림		
 */
		
		
		long endT = System.currentTimeMillis();
//		1/1000(ms)를 이용한 측정 시간
		long leadT = endT - startT;
		System.out.println("소요 시간: " + leadT + "ms");
		scanner1.close();
		scanner4.close();
//		JVM exit
		System.exit(0);
	}

}
