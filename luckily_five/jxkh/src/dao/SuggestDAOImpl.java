package dao;
import util.*;

import java.sql.*;
import java.util.*;

import bean.SuggestBean;

public class SuggestDAOImpl {

	@SuppressWarnings("finally")
	public int _insert(ArrayList data){
		int i=0;
		String sql="INSERT INTO suggest(mstuID,mteaID,mess)VALUES (?, ?, ?)";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,data.get(0).toString());
			pstmt.setString(2,data.get(1).toString());
			pstmt.setString(3,data.get(2).toString());
			
			i=pstmt.executeUpdate();
			
			DBConnection.close(rs,pstmt,conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			return i;
		}
	}
	public int _deleted(int id){
		int i=0;
		String sql="DELETE FROM suggest WHERE mID = ?";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1,id);
			i=pstmt.executeUpdate();
			
			DBConnection.close(rs,pstmt,conn);
		}catch (Exception e) {
			e.printStackTrace();
		}
			return i;
	}
	public boolean _SelectBystuID_steaID(String stuid,String teaid) {
		
		String sql="select * from suggest where mstuID=? and mteaID=?";
		boolean b=false;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,stuid);
			pstmt.setString(2,teaid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				b=true;
			}
			DBConnection.close(rs,pstmt,conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		return b; 
	}
	public ArrayList<SuggestBean> _ByTeacherID(String id) {
		ArrayList<SuggestBean> arraylist = new ArrayList<SuggestBean>();
		String sql="select * from suggest where mteaId=?";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				SuggestBean sugbean=new SuggestBean();
				sugbean.setmID(rs.getString("mID"));
				sugbean.setMstuID(rs.getString("mstuID"));
				sugbean.setMteaID(rs.getString("mteaID"));
				sugbean.setMess(rs.getString("mess"));
				sugbean.setMdate(rs.getString("mdate"));
				arraylist.add(sugbean);
			}
			DBConnection.close(rs,pstmt,conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		return arraylist; 
	}
	public ArrayList<SuggestBean> _ALLTeacher() {
		ArrayList<SuggestBean> arraylist = new ArrayList<SuggestBean>();
		String sql="select * from suggest order by mdate desc";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				SuggestBean sugbean=new SuggestBean();
				sugbean.setmID(rs.getString("mID"));
				sugbean.setMstuID(rs.getString("mstuID"));
				sugbean.setMteaID(rs.getString("mteaID"));
				sugbean.setMess(rs.getString("mess"));
				sugbean.setMdate(rs.getString("mdate"));
				arraylist.add(sugbean);
			}
			DBConnection.close(rs,pstmt,conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		return arraylist; 
	}
}