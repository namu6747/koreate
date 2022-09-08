package obserber;

import java.util.Collections;
import java.util.List;

public class MinMaxView implements Observer{
	private ScoreRecord scoreRecord;
	
//	객체를 새로 만들 생각을 하지 말고 사용중인 객체를
//	생성자의 매개변수에 대입해줌으로써 연관시켜준다.
	public MinMaxView(ScoreRecord scoreRecord) {
		this.scoreRecord = scoreRecord;
	}
	
	public void update() {
		List<Integer> record = scoreRecord.getScoreRecord();
		displayMinMaxView(record);
	}
	
	public void displayMinMaxView(List<Integer> record) {
		int min = Collections.min(record, null);
		int max = Collections.max(record, null);
		System.out.println("Min: "+min+" Max: "+max);
	}
}
