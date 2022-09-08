package composite;

public abstract class ComputerDevice {
	
//	추상 메소드로 나타내면 메소드 내부 변수를 위한 필드를 고민할 필요가 없다
	public abstract int getPrice();
	public abstract int getPower();
	
}

// 추상 메소드는 크게 중요하지 않다. 
// 다형성과 타입 변환을 활용하면 매개 클래스를 통해 OCP 위배 없이 작성할 수 있다.
/*
 *Coumputer computer = new Computer
 *ComputerDevice keyboard = new keyboard();
 *computer.addComponent(keyboard);
 *기능만을 공유해야될 것 같다 
 *componenets는 리스트 형태로 나타나야할 듯.
 */
