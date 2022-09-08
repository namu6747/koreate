package Nested;

public class Nested {
	
	{message();}
	
	
	Nested(String[] args) {
		System.out.println("Nested object");
	}

	
	
	class InnerI {
//	인스턴스 멤버 클래스 - NestedClass $ InnerI .class
//	일반적으로 nest 외부에서 멤버의 객체를 생성할 일은 거의 없다.
//	대부분 nest 클래스 내부에서만 생성하여 사용한다.
//	인스턴스 클래스는 외부의 모든 것에 접근할 수 있다.(필드, 메소드를 가져와 쓰는) 로컬 변수 개념이 적용돼서 내부에는 접근할 수 없다.
		InnerI() {
			System.out.println("InnerI object");
		}
		
		class InnerI2 {
			InnerI2() {
				System.out.println("InnerI2 object");
			}}}
	
	static class InnerS {
//	정적 멤버 클래스 - NestedClass $ InnerS .class
//	정적 멤버 클래스 내부에는 인스턴스와 정적 멤버 모두 작성가능
//	직상위 클래스와 그 하위 모든 클래스에서 객체 생성 가능
//	외부의 인스턴스 필드,메소드,클래스에 접근할 수 없음.
		InnerS() {
			System.out.println("InnerS object");
		}}

	void methodA(int args) {
		int localVariable = 1;
		class Local {
//		인스턴스 로컬 클래스 - NestedClass $1 Local . class
//		로컬 클래스를 사용하기 위해선 메소드 내에 객체를 생성하고 사용해야 한다.
//		주로  비동기 처리를 위해 스레드 객체를 만들 때 사용한다.
			Local() {
				System.out.println("methodA Local object");
			}
			
//			자바에서는 컴파일시 로컬 클래스에서 사용하는 매개변수나 로컬 변수의 값을
//			로컬 클래스 내부에 복사해두고 사용합니다. 그러므로 값이 변경되면 복사해둔 값과 달라지므로
//			문제를 해결하기 위해 매개변수나 로컬 변수를 final 특성을 부여함
			void mothodB() {
				int result = args + localVariable;
			}}}

	static void message() {
		System.out.println("class load complete");
	}
	
	interface InnerII {
//	인스턴스 멤버 인터페이스
//	바깥 클래스에 구현 객체를 생성하여 사용
	}
	
	
	static interface InnerSI {
//	바깥 클래스의 객체 없이 바깥 클래스만으로 바로 접근 가능
//	주로 UI 프로그래밍에서 이벤트를 처리할 목적으로 활용
		static void methodo() {
			System.out.println("InnerSi static interface method");
		}
	}
}
