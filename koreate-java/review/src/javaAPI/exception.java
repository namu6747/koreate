package javaAPI;

class A{}
class B extends A {}
public class exception {
	
	public static void main(String[] args) {
//		try-catch-(finally), try-with-resources
//		예외를 잡아서 그 자리에서 처리하는 방법
//		throws 상위 메서드에 실행 예외를 이관
//		특정 메서드가 예외를 발생시킨다고 기술하는 방법
		/*특정 실행에서 예상되는 런타임 에러가 있을 때
		 * if 방어 로직이 없다면 프로그램은 종료된다.
		 * 하지만 코드 작성자가 이 에러를 사전에 인지하고 그에 대한 실행을 강제하고 싶을때
		 * try-catch문과 함께 throw를 이용하여 알맞은 대응을 실행시킨다.
		 * throw는 try로 메서드를 감싸고 catch문을 찾아가 실행문을 처리하고
		 * 해당 catch와 연결된 try문이 실행된다.
		*/
		
//		ArithmethicException
//		NullPointerException
//		ClassCastException
//		적절치 못하게 클래스를 형 변환 하는 경우
		exception cce = new exception();
		A a = new A();
		try{B b = (B) a;}catch(Exception e) {e.printStackTrace();}
		
		System.out.println();
		Error E = new Error("hello");
		E.printStackTrace();
		System.out.println();
		
//		cce1.methodA(cce);
		
//		NegativeArraySizeException
//		배열의 크기가 음수 값인 경우
		try{int[] nase = new int[-1];}catch(Exception e){e.printStackTrace();}
		
//		OutOfMemoryException
//		사용 가능한 메모리가 없는 경우
		
//		NoClassDefFoundException
//		원하는 클래스를 찾지 못하였을 경우
		
//		ArrayIndexOutOfBoundsException
//		배열을 참조하는 인덱스가 잘못된 경우
		try{int[] aioobe = new int[10];
		System.out.println(aioobe[11]);}
		catch(Exception e){e.printStackTrace();}
		

		
	}	
}
