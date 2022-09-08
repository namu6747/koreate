package account.dao.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import account.dao.AccountDAO;
import account.vo.AccountVO;
import util.DBHelper;


// Account
// Statement
// Database Access Object
public class AccountSTMTDAOImpl 
implements AccountDAO{
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	
	public AccountSTMTDAOImpl() {
		conn = DBHelper.getConnection();
	}

	// account의 정보를 tbl_account table에 삽입
	@Override
	public void insert(AccountVO acc) {
		// 작성
		String sql = "INSERT INTO tbl_account VALUES ('"+acc.getAno()+"','"+acc.getOwner()+"','"+acc.getBalance()+"','"+acc.getPassword()+"')";
		try {
			
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(stmt);
		}
		
	}
	
	// 계좌번호가 일치하는 계좌주의 
	// 잔고를 수정
	// UPDATE tbl_account SET balance = 값 WHERE ano = '계좌번호'
	@Override
	public int update(AccountVO acc) {
		int result = 0;
		// 작성
		String sql = "UPDATE tbl_account SET balance = "+acc.getBalance()+" WHERE ano = "+acc.getAno();
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(stmt);
		}
		return result;
	}

	// SELECT * FROM tbl_account WHERE ano = '계좌번호';
	@Override
	public AccountVO selectAccount(String ano) {
		AccountVO acc = null;
		// 작성
		String sql = "SELECT * FROM tbl_account WHERE ano = "+ano;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next())
			acc = new AccountVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs,stmt);
		}
		return acc;
	}
	
	// SELECT * FROM tbl_account  
	// WHERE ano = '계좌번호' AND password = '비밀번호'; 
	@Override
	public AccountVO selectAccount(String ano, String password) {
		AccountVO acc = null;
		// 작성
		String sql = "SELECT * FROM tbl_account WHERE ano = "+ano+" AND password = "+password;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			acc = new AccountVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs,stmt);
		}
		return acc;
	}	
}









