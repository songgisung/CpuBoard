package board.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	public static Connection getMySqlConnection() {
		
		Connection conn = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String Url = "jdbc:mysql://localhost:3306/board";
			String User = "root";
			String Pass = "123456789";
			
			conn = DriverManager.getConnection(Url, User, Pass);
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
		if(conn != null) {
			System.out.println("DB 연결 성공");
		}else {
			System.out.println("DB 연결 실패");
		}
		
		return conn;
	}
	
	public static void Close(Connection conn) {
		try {
			if(conn != null){
				conn.close();
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
