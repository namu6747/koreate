package Anonymous;

public class Anonymous {
//	확장하는 비용이 더 드는, 재사용성이 현저히 떨어지는 단발성 객체..
//	부모-자식간 상속 아래 익명 객체를 생성할 것인가?
//	인터페이스를 구현한 익명 구현 객체를 생성할 것인가?
//	익명 자식 객체 생성 방법에는 3가지 방법이 있다.
//	필드의 초기값, 로컬 변수의 초기값, 매개 변수의 매개값
	
	// 1. 필드에 익명 자식 객체를 생성
	Insect spider1 = new Insect() {
		String name = "무당거미";
		// 거미줄을 치다.
		void cobweb() {
			System.out.println("사각형으로 거미줄을 친다.");
		}
		
		@Override
		void attack() {
			System.out.println(name + " 독을 발사한다.");
		}
	};
	
	void method1() {
		Insect spider2 = new Insect() {
			String name = "늑대거미";
			// 거미줄을 치다.
			void cobweb() {
				System.out.println("육각형으로 거미줄을 친다.");
			}
			
			@Override
			void attack() {
				System.out.println(name + " 앞니로 문다.");
			}
		};
		
//		로컬 변수이기 때문에 메서드에서 바로 사용
		spider2.attack();
	}
	
	void method2(Insect spider) {
		spider.attack();
	}
	
}
