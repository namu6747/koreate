package optional;

import java.util.Optional;

class Friend {
	String name;
	Optional<Company> cmp;

	public Friend(String n, Optional<Company> c) {
		name = n;
		cmp = c;
		
	}

	public String getName() {
		return name;
	}

	public Optional<Company> getCmp() {
		return cmp;
	}

}

class Company {
	String cName;
	Optional<ContInfo3> cInfo;

	public Company(String cn, Optional<ContInfo3> ci) {
		cName = cn;
		cInfo = ci;
	}

	public String getName() {
		return cName;
	}

	public Optional<ContInfo3> getCInfo() {
		return cInfo;
	}
}

class ContInfo3 {
	Optional<String> phone;
	Optional<String> adrs;

	public ContInfo3(Optional<String> ph, Optional<String> ad) {
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

public class NullPointerCaseStudy {

	public static void showCompAddr(Optional<Friend> f) {

		String addr = f.flatMap(Friend::getCmp).flatMap(Company::getCInfo).flatMap(ContInfo3::getAdrs).orElse("There's no address");
		System.out.println(addr);

	}

	public static void main(String[] args) {
		Optional<ContInfo3> ci = Optional.of(
				new ContInfo3(Optional.ofNullable(null), Optional.of("Republic of Korea")));
				Optional<Company> cp = Optional.of(new Company("Yaho ", ci));
				Optional<Friend> frn = Optional.of(new Friend("Lee Su", cp));
				showCompAddr(frn);
	}
}
