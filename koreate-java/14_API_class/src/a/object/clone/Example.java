package a.object.clone;

public class Example {

	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		java.lang.Object obj = new Object();
		System.out.println(obj.toString());
		
		obj = new Car("벤츠");
		System.out.println(obj);
		
		Member member = new Member("최기근", 28, new int[]{ 100, 95, 99 }, new Car("캐스퍼"));
		System.out.println(member);
		Member cloned = (Member) member.clone();
		System.out.println(cloned);
		cloned.scores[0] = 90;
		System.out.println(member);
		System.out.println(cloned);

		Member member0 = new Member("id001");
		Member member1 = new Member("id001");
		Member member2 = new Member("id002");
		// 주소값 비교
		System.out.println(member0 == member1);
		System.out.println(member0 == member2);
		// 두객체간 id값 비교
		System.out.println(member0.equals(member1));
		System.out.println(member0.equals(member2));
		
		for(int i=0; i<5; i++) {
			Car car = new Car("캐스퍼");
			car = null;
			System.gc();
		}
		
	}



}
