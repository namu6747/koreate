package obserber;

public class Client {
	public static void main(String[] args) {

		ScoreRecord scoreRecord = new ScoreRecord();
		MinMaxView minMaxView = new MinMaxView(scoreRecord);

		DataSheetView dataSheetView3 = new DataSheetView(scoreRecord, 3);
		scoreRecord.attach(dataSheetView3);
		scoreRecord.attach(minMaxView);

		DataSheetView dataSheetView5 = new DataSheetView(scoreRecord, 5);
		scoreRecord.attach(dataSheetView5);

		for (int i = 0; i < 5; i++) {
			int score = (int) (Math.random() * 100 + 1);
			System.out.println("\nAdding " + score);
			scoreRecord.addScore(score);
		}

		scoreRecord.detach(dataSheetView3);
		StatisticksView statisticksView = new StatisticksView(scoreRecord);
		scoreRecord.attach(statisticksView);

		for (int i = 0; i < 5; i++) {
			int score = (int) (Math.random() * 100 + 1);
			System.out.println("\n\nAdding " + score);
			scoreRecord.addScore(score);
		}
	}
}

/*
 * 성적을 출력하는 기능 성적 값을 출력하는 프로그램 입력된 점수를 저장하는 스코어레코드 클래스 점수를 목록의 형태로 출력하는 데이터싯뷰
 * 클래스 성적이 입력된 경우 애드스코어 메서드가 실행될때 성적을 출력하려면 스코어레코드는 데이터시트뷰를 참조해야한다.
 * 옵저버 패턴은 데이터의 변경이 발생했을 경우
 * 상대 클래스나 객체에 의존하지 않으면서 데이터 변경을 통보하고자 할 때 유용하다.
 * 
 *
 *
 */
