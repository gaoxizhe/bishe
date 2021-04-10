package dao;
import util.*;
import bean.*;

import java.sql.*;
import java.util.*;

public class UserDAOImpl {

	@SuppressWarnings("finally")
	public boolean login(String username,String password) throws Exception {
		boolean flag=false;
		String sql="select * from student where Sno=? and Spw=?";
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
		String sql="update student set Spw=? where Sno=?";
		
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
	public ArrayList UserByID(String id) {
		ArrayList arraylist = new ArrayList();
		String sql="select * from student where Sno=?";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				arraylist.add(rs.getString("Sname"));
				arraylist.add(rs.getString("Spw"));
				arraylist.add(rs.getString("Sex"));
				arraylist.add(rs.getString("Sclass"));
			}
			DBConnection.close(rs,pstmt,conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		return arraylist; 
	}
	public int _update(Student data) throws Exception {
		ResultSet rs = null;
		int i=0;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		String sql ="update student set sname=?, spw=?,sex=? ,sclass=? where sno=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,data.getSname());
			pstmt.setString(2,data.getSpw());
			pstmt.setString(3,data.getSex());
			pstmt.setString(4,data.getSclass());
			pstmt.setString(5,data.getSno());
			i=pstmt.executeUpdate();	
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,pstmt,conn);
		}
		
		return i;
	
	}
	public int _insert(Student data) throws Exception {
		ResultSet rs = null;
		int i=0;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		String sql="INSERT INTO student(sname,spw,sex,sclass,sno)VALUES (?,?, ?, ?, ?)";
		
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,data.getSname());
			pstmt.setString(2,data.getSpw());
			pstmt.setString(3,data.getSex());
			pstmt.setString(4,data.getSclass());
			pstmt.setString(5,data.getSno());
			i=pstmt.executeUpdate();	
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,pstmt,conn);
		}
		
		return i;
	
	}
	public ArrayList<Student> _select() {
		ArrayList<Student> arraylist = new ArrayList<Student>();
		String sql="select * from student order by Sno";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				Student s=new Student();
				s.setSno(rs.getString("Sno"));
				s.setSname(rs.getString("Sname"));
				s.setSpw(rs.getString("Spw"));
				s.setSex(rs.getString("Sex"));
				s.setSclass(rs.getString("Sclass"));
				arraylist.add(s);
			}
			DBConnection.close(rs,pstmt,conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		return arraylist; 
	}
	public int _delete(String id) throws Exception {
		
		String sql="delete from student where Sno=?";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int result=0;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			result=pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,pstmt,conn);
		}
		return result;
	}
//
//	public List<User> findAllUser() throws Exception {
//		// TODO Auto-generated method stub
//		
//
//		Connection conn=DBConnection.getConnection();
//		List<User> users = null;
//		String sql="select * from user";
//		PreparedStatement pstmt=null;
//		ResultSet rs = null;
//		try{
//			pstmt=conn.prepareStatement(sql);
//			
//			rs=pstmt.executeQuery();
//			users=new ArrayList<User>();
//			while(rs.next()){
//				User user = new User();
//				user.setId(rs.getInt(1));
//				user.setUsername(rs.getString(2));
//				user.setPassword(rs.getString(3));
//				user.setRegisterdate(rs.getString(4));
//				users.add(user);
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			DBConnection.close(pstmt);
//			DBConnection.close(rs);
//			DBConnection.close(conn);
//			
//		}		
//		return users; 
//
//	}
//
//	public int DelUserByID(int id) throws Exception {
//		
//		String sql="delete from user where id=?";
//		PreparedStatement pstmt=null;
//		ResultSet rs = null;
//		int result=0;
//		Connection conn=DBConnection.getConnection();
//		try{
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setInt(1,id);
//			result=pstmt.executeUpdate();
//			
//			DBConnection.close(pstmt);
//			DBConnection.close(rs);
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			DBConnection.close(conn);
//		}
//		
//		return result;
//	}
//
//	public List<User> findUserByID(int id) throws Exception {
//
//
//		Connection conn=DBConnection.getConnection();
//		List<User> users = null;
//		String sql="select * from user where id="+id;
//		PreparedStatement pstmt=null;
//		ResultSet rs = null;
//		try{
//			pstmt=conn.prepareStatement(sql);
//			rs=pstmt.executeQuery();
//			users=new ArrayList<User>();
//			while(rs.next()){
//				User user = new User();
//				user.setId(rs.getInt(1));
//				user.setUsername(rs.getString(2));
//				user.setPassword(rs.getString(3));
//				user.setRegisterdate(rs.getString(4));
//				users.add(user);
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			DBConnection.close(pstmt);
//			DBConnection.close(rs);
//			DBConnection.close(conn);
//			
//		}		
//		return users; 
//	
//	}
//
//	public int EditUserByID(User user) throws Exception {
//			
//		int rs=0;
//		
//			Connection conn=DBConnection.getConnection();
//			String sql ="update user set username=?, password=?,registerdate=now() where id=?";
//			try{
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1,user.getUsername());
//			pstmt.setString(2,user.getPassword());
//			pstmt.setInt(3,user.getId());
//			rs=pstmt.executeUpdate();	
//			}catch(SQLException e){
//				e.printStackTrace();
//			}finally{
//			DBConnection.close(conn);
//		    }
//			return rs;
//	
//	}

}