package test;


public class PrimaryTypeCast {

	public static void main(String[] args) {
		int  x = 1, y = 5;
//		System.out.println(x + y);
		char a = '8';
		char b = '가';
		int c = (int)b;
		int d = '박';
//		System.out.println(d);
//		System.out.println(c);
//		System.out.println(a < b);
		
//		자동 타입 변환
		int e = 500000;
		double f = e; // int -> double 소수부가 나타남. 실수 형태는 소수부가 반드시 나타남.
		char character = '박';
		byte n = -11; 
		char o = (char)n; // byte 음수 -> char 이상한 값이 나타남.
		int k = 130;
		char l = (char)k; // overflow? 값이 안 나타난다.
		byte m = (byte)character; // char -> byte  지정된 범위 내에서 나타남.
		int h = character;
		double i  = h; // int -> char -> double 유니코드가 정수형 태로 변환 후 소수부가 나타남.
		double j = character; // char -> double  유니코드가 실수 형태로 변환 후 소수부가 나타남.
		
//		강제 타입 변환의 오류들
		byte minus = -15;
		char plus = (char)minus; // 아스키코드 깨짐  
		System.out.println(plus); 
		
		int wow = 999999999;
		short oh = (short)wow; // int 9억이 -13825으로 나타남.
		System.out.println(oh);
		
		short minuss = -1000;
		plus = (char)minuss; // 아스키코드 깨짐
		System.out.println(plus);
		
		char pluss = 50000; 
		short ohh = (short)pluss; // char 50000이 short -15536으로 나타남.
		System.out.println(ohh);
		
		
//		기본 type이 int로 되어있지만 피연산자에 리터럴만 존재한다면 신경쓰지 않아도 된다.
//		정수의 연산에서 double의 값을 얻고 싶다면 피연산자 중 아무거나 double type으로 강제 타입 변환을 하면 된다.
//		문자열을 기본 타입으로 강제 변환할 때 parse를 사용한다. 역은 String.valueOf();
		
		byte overflow =  127; // ->-128
		overflow++;
		byte underflow = -128; // ->127
		underflow--;
		System.out.println(overflow);
		System.out.println(underflow);
		
		System.out.println();
		Outter: for(char upper='A'; upper<='Z'; upper++) {
			for(char lower='a'; lower<='z'; lower++) {
				System.out.println(upper+"-"+lower);
				if(lower=='g') {
					break Outter;
				}
			}
		}			
		
		}
		
	}


