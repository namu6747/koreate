package factory_method;

public class ResponseTimeScheduler implements ElevatorScheduler{
	private static ElevatorScheduler scheduler;
	
	private ResponseTimeScheduler() {};
	
	public static ElevatorScheduler getInstance() {
		if(scheduler == null) {
			scheduler = new ResponseTimeScheduler();
		}
		return scheduler;
	}
	
	@Override
	public int selectElevator(ElevatorManager manager, int destination, Direction direction) {
		return 0;
	
	}
//	어디서든 이 객체를 사용하려면 클래스.겟인스턴스로 접근한다.
//	어디든 마찬가지다 하지만 스케쥴러가 이미 선언 되어 있고 객체를 누군가 생성한다면
//	프로그래밍이 종료되지 않는 한 계속 지속된다.
//	어짜피 ElevatorScheduler로 타입 변환 할 거라 간단하게 작성할 수 있다.
//	private static ResponseTimeScheduler responseTimeScheduler;
	
//	메소드 앞에 특정하는 명칭이 나타날 건데 굳이 이름을 또 나열할 필요 없다.
//	public static ResponseTimeScheduler getresponseTimeScheduler() {
//		if(responseTimeScheduler == null) {
//			responseTimeScheduler = new ResponseTimeScheduler();
//		}
//		return responseTimeScheduler;
//	}


	
}
