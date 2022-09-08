package decorator;

public class LaneDecorator extends DisplayDecorator{

	public LaneDecorator(Display decoratedDisplay) {
		super(decoratedDisplay);
	}

	public void draw() {
//		부모 것도 호출하고 내 것도 호출하고.
		super.draw();
		drawLane();
	}
	
	private void drawLane() {
		System.out.println("\t차선 표시");
	}
}
