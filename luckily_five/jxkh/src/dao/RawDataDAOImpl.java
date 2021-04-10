package dao;
import util.*;

import java.sql.*;
import java.util.*;

import bean.*;

public class RawDataDAOImpl {

	public boolean _SelectBystuID_steaID(String stuid,String teaid) {
		
		String sql="select * from rawdata where StuID=? and TeaID=?";
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
	
	public int _insert(ArrayList data){
		int i=0;
		String sql="INSERT INTO rawdata(StuID,TeaID,PerfID,Score)VALUES (?, ?, ?, ?)";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,data.get(0).toString());
			pstmt.setString(2,data.get(1).toString());
			pstmt.setInt(3,Integer.parseInt(data.get(2).toString()));
			pstmt.setInt(4,Integer.parseInt(data.get(3).toString()));
			i=pstmt.executeUpdate();
			
			DBConnection.close(rs,pstmt,conn);
		}catch (Exception e) {
			e.printStackTrace();
		}
			return i;
		
	}

	public ArrayList<IndexTeacherBean> ByTeacherID(String steaid) {
		ArrayList<IndexTeacherBean> list = new ArrayList<IndexTeacherBean>();
		
		String sql="select teacher.teaName as tname,sum(score) as scores,performance.perfName as perfnames "
			+"from rawdata JOIN teacher ON teacher.teaId=rawdata.TeaID JOIN performance "
			+"ON performance.perfID=rawdata.PerfID where rawdata.TeaID=? group by rawdata.PerfID;";
		ResultSet rs = null;
	
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,steaid);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				IndexTeacherBean indexteacherbean=new IndexTeacherBean();
				indexteacherbean.setTeaName(rs.getString("tname").toString());
				indexteacherbean.setPerfname(rs.getString("perfnames").toString());
				indexteacherbean.setScore(rs.getString("scores").toString());
				
				list.add(indexteacherbean);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,pstmt,conn);
		}
		
		return list; 
	}

	public ArrayList<IndexAdminBean> AllData() {
		ArrayList<IndexAdminBean> list = new ArrayList<IndexAdminBean>();
		/*
		String sql="select teacher.teaName as tname,sum(score) as scores,performance.perfName as perfnames "
			+"from rawdata JOIN teacher ON teacher.teaId=rawdata.TeaID JOIN performance "
			+"ON performance.perfID=rawdata.PerfID group by rawdata.PerfID,rawdata.TeaID "
			+"order by rawdata.TeaID,rawdata.PerfID;";
		*private String teaName;
		private String teaSex;
		private String teaSdept;
		private String Perfname;
		private String Scores;
		*/
		ResultSet rs = null;
		String sql="select rawdata.TeaID as id,teacher.teaName as tname,teacher.teaSex as tsex,"
			+"teacher.teaSdept as tsdept,sum(score) as scores "
			+"from rawdata JOIN teacher ON teacher.teaId=rawdata.TeaID group by rawdata.TeaID "
			+"order by scores desc;";
		PreparedStatement pstmt=null;
		Connection conn=DBConnection.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				IndexAdminBean indexbean=new IndexAdminBean();
				indexbean.setTeaId(rs.getString("id").toString());			
				indexbean.setTeaName(rs.getString("tname").toString());
				indexbean.setTeaSex(rs.getString("tsex").toString());
				indexbean.setTeaSdept(rs.getString("tsdept").toString());
				indexbean.setScores(rs.getString("scores").toString());
				
				list.add(indexbean);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs,pstmt,conn);
		}
		
		return list; 
	}
}