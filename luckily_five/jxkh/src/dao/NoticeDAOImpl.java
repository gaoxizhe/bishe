package dao;
import util.*;

import java.sql.*;
import java.util.*;

import bean.*;

public class NoticeDAOImpl {

	public ArrayList<NoticeBean> _select() {
		ArrayList<NoticeBean> list = new ArrayList<NoticeBean>();
		
		ResultSet rs = null;
		String sql="select * "
			+"from notice "
			+"order by dates desc;";
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				NoticeBean _bean=new NoticeBean();
				_bean.setId(rs.getInt("id"));
				_bean.setTitle(rs.getString("title"));
				_bean.setContent(rs.getString("content"));
				_bean.setDates(rs.getString("dates"));
				_bean.setIdent(rs.getString("ident"));
				list.add(_bean);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,pstmt,conn);
		}
		
		return list; 
	}
	public ArrayList<NoticeBean> _selectById(int id) {
		ArrayList<NoticeBean> list = new ArrayList<NoticeBean>();
		
		ResultSet rs = null;
		String sql="select * "
			+"from notice "
			+"where id=?;";
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				NoticeBean _bean=new NoticeBean();
				_bean.setId(rs.getInt("id"));
				_bean.setTitle(rs.getString("title"));
				_bean.setContent(rs.getString("content"));
				_bean.setDates(rs.getString("dates"));
				_bean.setIdent(rs.getString("ident"));
				list.add(_bean);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,pstmt,conn);
		}
		
		return list; 
	}
	public ArrayList<NoticeBean> _selectByIdent(String ident) {
		ArrayList<NoticeBean> list = new ArrayList<NoticeBean>();
		
		ResultSet rs = null;
		String sql="select * "
			+"from notice where ident!=?"
			+"order by dates desc;";
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ident);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				NoticeBean _bean=new NoticeBean();
				_bean.setId(rs.getInt("id"));
				_bean.setTitle(rs.getString("title"));
				_bean.setContent(rs.getString("content"));
				_bean.setDates(rs.getString("dates"));
				_bean.setIdent(rs.getString("ident"));
				list.add(_bean);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,pstmt,conn);
		}
		
		return list; 
	}
	public int _insert(NoticeBean data)throws Exception{
		int i=0;
		String sql="INSERT INTO notice(title,content,ident,dates)VALUES (?, ?, ?,now())";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Connection conn = DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,data.getTitle());
			pstmt.setString(2,data.getContent());
			pstmt.setString(3,data.getIdent());
			i=pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,pstmt,conn);
		}
		return i;
		
	}
	
	public int _delete(int id) throws Exception {
		
		String sql="delete from notice where id=?";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int result=0;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			result=pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,pstmt,conn);
		}
		return result;
	}
	public int _update(NoticeBean data) throws Exception {
		ResultSet rs = null;
		int i=0;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		String sql ="update notice set title=?, content=?,ident=? ,dates=now() where id=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,data.getTitle());
			pstmt.setString(2,data.getContent());
			pstmt.setString(3,data.getIdent());
			pstmt.setInt(4,data.getId());
			i=pstmt.executeUpdate();	
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,pstmt,conn);
		}
		
		return i;
	
	}
	
}