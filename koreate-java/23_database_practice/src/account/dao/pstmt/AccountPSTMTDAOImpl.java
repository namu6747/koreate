package account.dao.pstmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import account.dao.AccountDAO;
import account.vo.AccountVO;
import util.DBHelper;

public class AccountPSTMTDAOImpl implements AccountDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Statement stmt;
	
	public AccountPSTMTDAOImpl() {
		conn = DBHelper.getConnection();
	}
	
	@Override
	public void insert(AccountVO acc) {
		// 작성
		String sql = "INSERT INTO tbl_account VALUES (?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getAno());
			pstmt.setString(2, acc.getOwner());
			pstmt.setInt(3, acc.getBalance());
			pstmt.setString(4, acc.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
		}
	}

	@Override
	public int update(AccountVO acc) {
		int result = 0;
		// 작성
		String sql = "UPDATE tbl_account SET balance = ?"+" WHERE ano = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acc.getBalance());
			pstmt.setString(2, acc.getAno());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(pstmt);
		}
		return result;
	}

	@Override
	public AccountVO selectAccount(String ano) {
		AccountVO acc = null;
		
		// 작성
		String sql = "SELECT * FROM tbl_account WHERE ano = "+ano;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			acc = getAccount(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs,stmt);
		}
		return acc;
	}
	
	public AccountVO getAccount(ResultSet rs) throws SQLException {
		AccountVO account = null;
		// 작성
		if(rs.next()) {
			account = new AccountVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
		}
		return account;
	}
	@Override
	public AccountVO selectAccount(String ano, String password) {
		AccountVO acc = null;
		// 작성
		String sql = "SELECT * FROM tbl_account WHERE ano = ? AND password = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			acc = getAccount(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs,pstmt);
		}
		return acc;
	}

}







