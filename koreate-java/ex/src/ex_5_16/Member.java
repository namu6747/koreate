package ex_5_16;

public class Member {

	private String Id;
	private String Password;
	private String Name;

	public void setId(String Id) {
		this.Id = Id;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + Id + ", password=" + Password + ", name=" + Name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member m = (Member)obj;
			if(Id.equals(m.Id) && Password.equals(m.Password)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Member choi = new Member();
		choi.setId("id001");
		choi.setPassword("pw001");
		choi.setName("최기근");
		System.out.println(choi);
		
		Member park = new Member();
		park.setId("id001");
		park.setPassword("pw001");
		park.setName("박주신");
		System.out.println(park);
		
		System.out.println(choi.equals(park));
	}

}
