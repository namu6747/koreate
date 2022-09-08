package Anonymous.Button;

public class ButtonHandler {

	Button endButton = new Button();
	Button startButton = new Button();
	
    //클래스 필드 객체 생성과 동시에 익명 구현객체 할당
	Button.OnClickListener listener = new Button.OnClickListener() {
		@Override
		public void onClick() {
			System.out.println("프로그램을 종료합니다.");
			
		}
	};
	
	ButtonHandler(){
		
        //위 필드에서 생성한 익명 구현객체로 endButton listener setting
		endButton.setOnClickListener(listener);
		
        //startButton listener setting하는 메서드 호출과 동시에 익명 구현객체 정의
		startButton.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("프로그램을 시작합니다.");
				
			}
		});
		
	}
	
}