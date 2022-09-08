package strategy;

public class Client {

	public static void main(String[] args) {
		Robot taekwonV = new TaekwonV("태권브이");
		Robot atom = new Atom("아톰");

		taekwonV.setAttackStrategy(new MissileStrategy());
		taekwonV.setMovingStrategy(new WalkingStrategy());
		
		atom.setAttackStrategy(new PunchStrategy());
		atom.setMovingStrategy(new FlyingStrategy());
		
		System.out.println(taekwonV.toString());
		taekwonV.move();
		taekwonV.attack();
		
		System.out.println(atom.toString());
		atom.move();
		atom.attack();
		
		
		
	}

}
