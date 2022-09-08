package ex_4_29.GUIDE;

public class Player {
	
	private static PlayerLevel level;
//	
//	private Player() {
//		level = new BeginnerLevel();
//	}
//	
//	static Player getInstance() {
//		if(level == null)return null;		
//		return new Player();
//	}
	
	private static Player player;
	
	private Player() {}
	
	public static Player getInstance() {
		if(player == null) {
			player = new Player();
		}
		return player;
	}
	
	
	void getLevel() {
		this.level.showLevelMessage(); 
	}
	
	void upgradeLevel(PlayerLevel level) {
		if(level == null) {
			System.out.println("레벨 없음");
			return;
		}
		this.level = level;
		if(level instanceof AdvancedLevel) {
			this.level.showLevelMessage();
			return;
		}
		if(level instanceof SuperLevel) {
			this.level.showLevelMessage();
			return;
		}
		if(level instanceof BeginnerLevel) {
			this.level.showLevelMessage();
			return;
		}
	}
	void play(int num) {
		switch(num) {
		case 1:
			this.level.go(num);
			break;
		case 2:
			this.level.go(num);
			break;
		case 3:
			this.level.go(num);
			break;
		default:
			break;
				
		}
	}
}
