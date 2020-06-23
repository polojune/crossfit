package com.cos.crossfit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.crossfit.db.DBConn;
import com.cos.crossfit.model.Users;

public class UsersRepository {
	private static final String TAG = "UserRepository : ";

	private static UsersRepository instance = new UsersRepository();

	private UsersRepository() {

	}

	public static UsersRepository getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public int findByUsername(String username) {
		final String SQL = "SELECT count(*) FROM users " + "WHERE username = ?";

		Users user = null;

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, username);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findByUsername():" + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return -1;
	}

	public int save(Users user) {
		final String SQL = "INSERT INTO users(id,username,password,email,address,userRole,createDate) VALUES(USERS_SEQ.NEXTVAL, ?,?,?,?,?,SYSDATE)";

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getUserRole());
		} catch (Exception e) {
			System.out.println(TAG + "save : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
}
