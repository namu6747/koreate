package ex_5_10;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

//위도 x 경도 y
class Location {
	private double x;
	private double y;

	public Location(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Location [경도=" + x + ", 위도=" + y + "]";
	}

}

public class ex_3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		HashMap<String, Location> map = new HashMap();
		String input = null, city = null;
		double x = 0, y = 0;
		boolean isRun = true;
		System.out.println("도시, 경도, 위도를 한번에 입력하세요.(q는 입력완료)");

		try {
			while (isRun) {
				System.out.print(">>");
				input = sc.nextLine();
				if (input.trim().equals("q")) {
					System.out.println("입력 완료");
					break;
				}
				StringTokenizer st = new StringTokenizer(input, ", ");
				while (st.hasMoreTokens()) {
					city = st.nextToken();
					x = Double.parseDouble(st.nextToken());
					y = Double.parseDouble(st.nextToken());
				}
				map.put(city, new Location(x, y));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		;

		System.out.println("---------------------------------------");
		for (Entry<String, Location> elem : map.entrySet()) {
			System.out.println(elem.getKey() + " " + elem.getValue().getX() + " " + elem.getValue().getY());
		}
		System.out.println("---------------------------------------");

		Outer : while (isRun) {
			System.out.print("도시 이름 (q는 종료) >>");
			input = sc.next();
			if (input.equals("q")) {
				System.out.println("시스템 종료");
				break;
			}
			for (String key : map.keySet()) {
				if (input.equals(key)) {
					System.out.println(key + " " + map.get(key).toString());
					continue Outer;
				}
			}
			System.out.println(input + "는 없습니다.");
		}

	}

}
