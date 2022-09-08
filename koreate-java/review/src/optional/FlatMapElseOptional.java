package optional;

import java.util.Optional;

class ContInfo2 {
	Optional<String> phone;
	Optional<String> adrs;

	public ContInfo2(Optional<String> ph, Optional<String> ad) {
		phone = ph;
		adrs = ad;
	}

	public Optional<String> getPhone() {
		return phone;
	}

	public Optional<String> getAdrs() {
		return adrs;
	}
}

public class FlatMapElseOptional {

		public static void main(String[] args) {
			Optional<ContInfo2> ci = Optional.of(new ContInfo2(Optional.ofNullable(null), Optional.of("Republic of Korea")));
			String phone = ci.flatMap(c -> c.getPhone()).orElse("There is no phone number.");
			String addr = ci.flatMap(c -> c.getAdrs()).orElse("There is no adress.");

			System.out.println(phone);
			System.out.println(addr);

			// 옵셔널 클래스만 하고 예전 책에서 파일 입출력 공부
		}

	}

