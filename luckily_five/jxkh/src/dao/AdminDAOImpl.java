package dao;
import util.*;

import java.sql.*;
import java.util.*;

public class AdminDAOImpl {

	@SuppressWarnings("finally")
	public boolean login(String username,String password) throws Exception {
		boolean flag=false;
		String sql="select * from admin where adminID=? and adminPW=?";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			rs=pstmt.executeQuery();
			while(rs.next()){
				flag=true;			
			}
			DBConnection.close(rs,pstmt,conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			return flag;
		}
	}
	public ArrayList ByID(String id) {
		ArrayList arraylist = new ArrayList();
		String sql="select * from admin where adminID=?";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				arraylist.add(rs.getString("adminName"));
				arraylist.add(rs.getString("adminPW"));
			}
			DBConnection.close(rs,pstmt,conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		return arraylist; 
	}
	public boolean _repassword(String password,String id) {
		boolean flag=false;
		int j=0;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		
		Connection conn=DBConnection.getConnection();
		String sql="update admin set adminPW=? where adminID=?";
		
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,password);
				pstmt.setString(2,id);
				j=pstmt.executeUpdate();	
				if(j==1){flag=true;}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBConnection.close(pstmt,conn);
		
		return flag;
	}
}