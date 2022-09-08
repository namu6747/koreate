package account.dao.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import account.dao.AccountDAO;
import account.vo.AccountVO;

// Account
// Statement
// Database Access Object
public class AccountSTMTDAOImpl 
implements AccountDAO{
	
	// DBMS 연결 객체
	private Connection conn;
	// 연결정보를 가지고 질의를 실행하는 객체
	private Statement stmt;
	// 검색질의의 결과를 전달 받는 객체
	private ResultSet rs;
	
	public AccountSTMTDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bigdata", 
					"bigdata"
					,"12345");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// account의 정보를 tbl_account table에 삽입
	@Override
	public void insert(AccountVO account) {
		// 작성
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO tbl_account "
						+" VALUES('"+account.getAno()+"','"+account.getOwner()+"',"
						+account.getBalance()+",'"+account.getPassword()+"')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
			} catch (SQLException e) {}
		}
	}
	
	// 계좌번호가 일치하는 계좌주의 
	// 잔고를 수정
	// UPDATE tbl_account SET balance = 값 WHERE ano = '계좌번호'
	@Override
	public int update(AccountVO account) {
		int result = 0;
		// 작성
		String sql = "UPDATE tbl_account SET "
					+" balance = "+account.getBalance()
					+" WHERE ano = '"+account.getAno()+"'";
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
			} catch (SQLException e) {}
		}
		return result;
	}

	// SELECT * FROM tbl_account WHERE ano = '계좌번호';
	@Override
	public AccountVO selectAccount(String ano) {
		AccountVO acc = null;
		// 작성
		String sql = "SELECT * FROM tbl_account WHERE ano = '"+ano+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				acc = new AccountVO(
					rs.getString("ano"),
					rs.getString("owner"),
					rs.getInt("balance"),
					rs.getString("password")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {}
		}
		return acc;
	}
	
	// SELECT * FROM tbl_account  
	// WHERE ano = '계좌번호' AND password = '비밀번호'; 
	@Override
	public AccountVO selectAccount(String ano, String password) {
		AccountVO acc = null;
		// 작성
		String sql = "SELECT * FROM tbl_account "
					+" WHERE ano = '"+ano+"' AND password ='"+password+"'";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				acc = new AccountVO(
					rs.getString(1),	// ano
					rs.getString(2),	// owner
					rs.getInt(3),		// balance
					rs.getString(4)		// password
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {}
		}
		return acc;
	}	
}









