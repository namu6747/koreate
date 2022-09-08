package ex_5_10;

import java.util.*;


class Nation {
	private String nation;
	private String capital;

	public Nation(String nation, String capital) {
		this.nation = nation;
		this.capital = capital;
	}

	public String getNation() {
		return nation;
	}

	public String getCapital() {
		return capital;
	}

	@Override
	public String toString() {
		return "Nation [nation=" + nation + ", capital=" + capital + "]\n";
	}

}

public class ex_2 {
	public static void main(String[] args) {

		String nation;
		String capital;
		String input;
		Nation temp;
		Random quiz = new Random();

		List<Nation> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		String text = "한국 서울 프랑스 파리 그리스 아테네 중국 베이징 스페인 마드리드 영국 런던 독일 베를린 러시아 모스크바";
		StringTokenizer st = new StringTokenizer(text, " ");
		while(st.hasMoreTokens()) {
		    nation = st.nextToken();
			capital = st.nextToken();
			list.add(new Nation(nation,capital));
		}

		boolean isRun = true;
		System.out.println("수도 맞추기 게임");
		int selectNum;
		while (isRun) {
			System.out.println("입력:1 퀴즈:2 종료:3 >>");
			selectNum = sc.nextInt();
			switch (selectNum) {
			case 1:
				System.out.printf("현재 %d개 나라의 수도가 입력되어 있습니다.\n", list.size());
				boolean run = true;
				Outer: while (run) {
					System.out.printf("국가 입력(현재:%d번째 국가 등록 / q는 종료)>>\n", (list.size() + 1));
					nation = sc.next();
					if (nation.equals('q')) {
						System.out.println("입력 종료");
						run = false;
					}

					System.out.println("수도 입력>>");
					capital = sc.next();
					for (Nation n : list) {
						if (n != null && n.getNation().equals(nation)) {
							System.out.printf("%s는(은) 이미 존재\n", nation);
							continue Outer;
						}
					}
					list.add(new Nation(nation, capital));
					System.out.println(list);
				}
				break;
			case 2:
				Collections.shuffle(list);
				nation = list.get(0).getNation();
				capital = list.get(0).getCapital();
				System.out.printf("%s의 수도는?", nation);
				input = sc.next();
				if (capital.equals(input)) {
					System.out.println("정답");
					break;
				}
				System.out.printf("오답 %s의 수도는 %s \n", nation, capital);
				break;
			case 3:
				isRun = false;
			default:
				break;

			}
		}
	}
}
