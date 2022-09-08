package ex_4_29.GUIDE;
public class MainBoardPlay {

	public static void main(String[] args) {

		Player player = Player.getInstance();
		player.play(1);
		
		AdvancedLevel aLevel = new AdvancedLevel();
		player.upgradeLevel(aLevel);
		player.play(2);
		
		SuperLevel sLevel = new SuperLevel();
		player.upgradeLevel(sLevel);
		player.play(3);
		
		System.out.println();
		player.getLevel();
	}     
}