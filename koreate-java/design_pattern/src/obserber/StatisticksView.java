package obserber;

import java.text.DecimalFormat;
import java.util.List;

public class StatisticksView implements Observer{
	private ScoreRecord scoreRecord;

	public StatisticksView(ScoreRecord scoreRecord) {
		this.scoreRecord = scoreRecord;
	}

	@Override
	public void update() {
		List<Integer> record = scoreRecord.getScoreRecord();
		displayStatisticks(record);
	}
	
	private void displayStatisticks(List<Integer> record) {
		int sum = 0;
		for(int score:record) {
			sum += score;
		}
		DecimalFormat df = new DecimalFormat("#.#");
		String average = df.format((float) sum / record.size());
		System.out.println("Sum: "+sum+" Average: "+average);
	}
	
	
	
}
