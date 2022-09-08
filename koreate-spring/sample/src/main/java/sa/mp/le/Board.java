package sa.mp.le;

public class Board {
	private String name;
	private String pw;
	private String message;
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	@Override
	public String toString() {
		return "Board [name=" + name + ", pw=" + pw + ", message=" + message + "]";
	}
}
