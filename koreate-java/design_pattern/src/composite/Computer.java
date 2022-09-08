package composite;

import java.util.ArrayList;
import java.util.List;

public class Computer {
	private List<ComputerDevice> components = new ArrayList<ComputerDevice>();;

//	컬렉션 프레임워크 인스턴스를 생성하는 게 아니라면 굳이 생성자가 필요하지 않다.

	public void addComponent(ComputerDevice component) {
		components.add(component);
	}
	
	public void removeComponent(ComputerDevice component) {
		components.remove(component);
	}
	
	public int getPrice() {
		int price = 0;
		for(int i = 0; i<components.size(); i++) {
			price += components.get(i).getPrice();
		}
		return price;
	}

	public int getPower() {
		int power = 0;
		for(ComputerDevice component : components) {
			power += component.getPower();
		}
		return power;
	}
}
