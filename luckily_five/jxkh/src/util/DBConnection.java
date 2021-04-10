package util;
import java.sql.*;
public class DBConnection {

	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://47.94.175.90:3306/jxkh?user=root&password=root&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false";

	public static Connection getConnection() {
		
		Connection conn =null;
		try{
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(PreparedStatement pstmt,Connection conn) {
		if(pstmt != null){
			try{
				pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try{
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		if(rs != null){
			try{
				rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null){
			try{
				pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try{
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
