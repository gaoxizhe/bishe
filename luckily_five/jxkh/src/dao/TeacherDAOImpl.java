package dao;
import util.*;
import bean.*;

import java.sql.*;
import java.util.*;

public class TeacherDAOImpl {

	@SuppressWarnings("finally")
	public boolean login(String username,String password) throws Exception {
		boolean flag=false;
		String sql="select * from teacher where teaId=? and password=?";
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
	public boolean _repassword(String password,String id) {
		boolean flag=false;
		int j=0;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		
		Connection conn=DBConnection.getConnection();
		String sql="update teacher set password=? where teaId=?";
		
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
	public ArrayList<IndexBean> TeacherByID(String stuid) {
		ArrayList<IndexBean> list = new ArrayList<IndexBean>();
		
		String sql="select * from sclass join classes on sclass.ClassId=classes.Cno join teacher on classes.Tno=teacher.teaId where StuId=?";
		ResultSet rs = null;
	
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,stuid);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				IndexBean indexbean=new IndexBean();
				indexbean.setCname(rs.getString("Cname").toString());
				indexbean.setTeaName(rs.getString("teaName").toString());
				indexbean.setScore(rs.getString("Score").toString());
				indexbean.setTeaId(rs.getString("teaId").toString());
				
				list.add(indexbean);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,pstmt,conn);
		}
		
		return list; 
	}
	public ArrayList TeacherByTeacherID(String id) {
		ArrayList arraylist = new ArrayList();
		String sql="select * from teacher where teaId=?";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				arraylist.add(rs.getString("teaName"));
				arraylist.add(rs.getString("teaSex"));
				arraylist.add(rs.getString("teaSdept"));
				arraylist.add(rs.getString("password"));
			}
			DBConnection.close(rs,pstmt,conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		return arraylist; 
	}
}