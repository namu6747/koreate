package f.cooperation;

public class Worker {
	
	String workerName;		// 직장인 이름
	String companyName;		// 직장 이름
	int money;				// 보유 금액
	
	Worker(String workerName, int money){
		this.workerName = workerName;
		this.money = money;
	}
	
	void takeVehicle(Bus bus) {
		bus.take(1200);
		this.money -= 1200;
	}
	
	void takeVehicle(Subway subway) {
		subway.take(1300);
		this.money -= 1300;
	}
	
	void showInfo() {
		System.out.println(
			workerName+"님의 남은 돈은 "+money+" 입니다."
		);
	}
	
}










