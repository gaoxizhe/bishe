package dao;
import util.*;
import bean.*;

import java.sql.*;
import java.util.*;
public class PerfDAOImpl {

	@SuppressWarnings("finally")
	
	public ArrayList Selectall() {
		ArrayList arraylist = new ArrayList();
		String sql="select * from performance";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				arraylist.add(Integer.toString(rs.getInt("perfID")));
				arraylist.add(rs.getString("perfName"));
			}
			DBConnection.close(rs,pstmt,conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		return arraylist; 
	}
	public ArrayList<PerformanceBean> ByID(int id) {
		ArrayList<PerformanceBean> list = new ArrayList<PerformanceBean>();
		
		ResultSet rs = null;
		String sql="select * from performance where perfID=?";
		PreparedStatement pstmt=null;
		
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				PerformanceBean indexbean=new PerformanceBean();
				indexbean.setPerfID(Integer.parseInt(rs.getString("perfID")));			
				indexbean.setPerfName(rs.getString("perfName").toString());
				indexbean.setPerfClass(rs.getString("perfClass").toString());
				
				list.add(indexbean);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,pstmt,conn);
		}
		return list; 
	}
	public ArrayList<PerformanceBean> AllData() {
		ArrayList<PerformanceBean> list = new ArrayList<PerformanceBean>();
		
		ResultSet rs = null;
		String sql="select * from performance";
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				PerformanceBean indexbean=new PerformanceBean();
				indexbean.setPerfID(Integer.parseInt(rs.getString("perfID")));			
				indexbean.setPerfName(rs.getString("perfName").toString());
				indexbean.setPerfClass(rs.getString("perfClass").toString());
				
				list.add(indexbean);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,pstmt,conn);
		}
		return list; 
	}
	public int EditPerf(PerformanceBean perf) throws Exception {
		
		int rs=0;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		String sql ="update performance set perfName=?, perfClass=? where perfID=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,perf.getPerfName());
			pstmt.setString(2,perf.getPerfClass());
			pstmt.setInt(3,perf.getPerfID());
			rs=pstmt.executeUpdate();	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	
	}
	public int DelPerfByID(int id) throws Exception {
		
		String sql="delete from performance where perfID=?";
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
	public int InsertPerf(PerformanceBean perf) throws Exception {
		
		int rs=0;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		String sql ="insert into performance(perfName,perfClass) values(?,?)";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,perf.getPerfName());
			pstmt.setString(2,perf.getPerfClass());
			
			rs=pstmt.executeUpdate();	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	
	}
}