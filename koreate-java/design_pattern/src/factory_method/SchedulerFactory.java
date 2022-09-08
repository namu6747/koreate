package factory_method;

import java.util.Calendar;

enum SchedulingStrategyID {
	RESPONSE_TIME, THROUGHPUT, DYNAMIC
};

public class SchedulerFactory {
	public static ElevatorScheduler getScheduler(SchedulingStrategyID strategyID) {
		ElevatorScheduler scheduler = null;
		
//		열거로 상황 나누기
		switch (strategyID) {
		case RESPONSE_TIME:
			scheduler = ResponseTimeScheduler.getInstance();
			break;
		case THROUGHPUT:
			scheduler = ThroughputScheduler.getInstance();
			break;
		case DYNAMIC:
			int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			if (hour < 12) {
				scheduler = ResponseTimeScheduler.getInstance();
			} else {
				scheduler = ThroughputScheduler.getInstance();
			}
			break;
		default:
			break;
		}
		return scheduler;
	}
	
	
}
