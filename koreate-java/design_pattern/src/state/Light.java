package state;

public class Light {

//	현재 시스템의 상태 객체를 참조
//	상태에 따른 행위를 수행하려면 state 변수가 참조하는 상태 객체에 작업을 위임
	private State state;
	
	public Light() {
		state = Off.getInstance();
	}
	
	
//	Sleeping mode를 추가했다. if의 조건문을 이렇게 간략히 하려다간
//	이후 더 많은 기능이 생겼을 때 대처하기 힘들어질 수 있다.
//	기능이 추가될 때마다 Light 클래스를 변경하면 OCP 위배
//	on off 같은 이벤트는 한정적이므로 기능으로 분류
	
	public void on() {
			state.on_button_pushed(this);
	}
	
	public void off() {
			state.off_button_pushed(this);
	}
	
	
	public void setState(State state) {
		this.state = state;
	}
	
	public State getState() {
		return state;
	}
	
}
