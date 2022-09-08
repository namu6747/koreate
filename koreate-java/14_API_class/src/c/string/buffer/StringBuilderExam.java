package c.string.buffer;

public class StringBuilderExam {

	public static void main(String[] args) {
		String a = "최기근";
		String b = "최기근";
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
//		멀티 스레드에선 StringBuffer
		StringBuilder sb = new StringBuilder("초기값 : ");
		// 기존 값 뒤에 매개변수로 넘겨받은 값을 추가
		sb.append("자바 ");
		sb.append("Programming Study!!");
		System.out.println(sb);
		String result = sb.toString();
		System.out.println(result);
		System.out.println(result.hashCode());
		System.out.println(sb.hashCode());
		// 문자열에서 4번째 인덱스에 두번째 매개변수값을 삽입
		sb.insert(4, 2);
		System.out.println(sb.toString());
		System.out.println(sb.hashCode());
		// 해당 인덱스에 있는 문자를 두번째 매개변수 문자로 변경 
		sb.setCharAt(4, '8');
		System.out.println(sb.toString());
		System.out.println(sb.hashCode());
		// delete(시작인덱스, 해당 자리까지) 문자열삭제
		sb.delete(4, 6);
		System.out.println(sb.toString());
		System.out.println(sb.hashCode());
		
	}

}











