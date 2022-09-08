package obserber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ScoreRecord extends Subject{
	
	private List<DataSheetView> dataSheetViews = new ArrayList<DataSheetView>();
	private List<Integer> scores = new LinkedList<Integer>();
//	private MinMaxView minMaxView;
//	private DataSheetView dataSheetView;
	
//	public void addDataSheetView(DataSheetView dataSheetView) {
//		dataSheetViews.add(dataSheetView);
//	}
//	
//	public void setMinMaxView(MinMaxView minMaxView) {
//		this.minMaxView = minMaxView;
//	}
//	
//	public void setStatisticsView(MinMaxView minMaxView) {
//		this.minMaxView = minMaxView;
//	}
	
//	public void setDataSheetView(DataSheetView dataSheetView) {
//		 this.dataSheetView = dataSheetView;
//	}
	
//	public void addScores(int score) {
//		scores.add(score);
//		for(DataSheetView dataSheetView : dataSheetViews) {
//			dataSheetView.update();
//		}
//		minMaxView.update();
//	}
	public void addScore(int score) {
		scores.add(score);
		notifyObservers();
	}
	
	public List<Integer> getScoreRecord(){
		return scores;
	}
	
	
	
}
