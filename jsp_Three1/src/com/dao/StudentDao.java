package com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.factory.StudentBean;

public class StudentDao {
		
	protected static Statement stat=null;
	protected static ResultSet rs=null;
	protected static Connection conn=null;
	
		//连接
		public static Connection GetConnect() {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    String url = "jdbc:sqlserver://localhost:1433;databaseName = text";
				conn = DriverManager.getConnection(url,"sa","admin"); 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
		}
		
		//关闭
		public static void closed(ResultSet rs,Statement stat,Connection conn) {
			try {
				if(rs!=null)rs.close();
				if(stat!=null)stat.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//查询all分页
		public static ArrayList<StudentBean> queryAllStudentPage(int currentPage,int pageSize){
			ArrayList<StudentBean> result = new ArrayList<StudentBean>();
			StudentBean stu = null;
			String sql = "select * form "
					+"("
					+"select row_number() over (id order by id asc) as r,* form student"
					+"where r<?"
					+")"
					+"where r>? ";
			Object[] params = {currentPage * pageSize , pageSize * (currentPage -1 ) + 1};
			conn = GetConnect();
			PreparedStatement pstat;
			try {
			
				pstat = conn.prepareStatement(sql);
				pstat.setObject(1, params[0]);
				pstat.setObject(2, params[1]);
				rs = pstat.executeQuery();
				while(rs.next()) {
					stu = new StudentBean(rs.getInt("id"),rs.getString("name"),rs.getString("sex"),rs.getString("date"),rs.getString("phone"),rs.getString("email"),rs.getString("address"),rs.getString("other"));
					result.add(stu);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		//查询总数据数
		public static int getTotalCount() {
			PreparedStatement pstat = null;
			int count = -1;
			String sql = "select count(1) form three";
			try {
				conn = GetConnect();
				pstat = conn.prepareStatement(sql);
				rs = pstat.executeQuery();
				if(rs.next()) {
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closed(rs,pstat,conn);
			}
			
			return count;
		}
		
		//查看all
		public static ArrayList<StudentBean> queryAllStudent() {			
			StudentBean stu = null;
			try {
				ArrayList<StudentBean> result = new ArrayList<StudentBean>();
				String sql = "select * from three ";
				conn = GetConnect();
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()) {
					stu = new StudentBean(rs.getInt("id"),rs.getString("name"),rs.getString("sex"),rs.getString("date"),rs.getString("phone"),rs.getString("email"),rs.getString("address"),rs.getString("other"));
					result.add(stu);
				}
				closed(rs,stat,conn);
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}	catch(Exception e) {
				e.printStackTrace();
				return null;
			}

		}
	
		//查看id
		public static StudentBean queryStudent(int id) {
			StudentBean stu = null;
			String sql = "select * from three where id='"+id+"'";
			try {
				conn = GetConnect();
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()) {
					stu = new StudentBean(rs.getInt("id"),rs.getString("name"),rs.getString("sex"),rs.getString("date"),rs.getString("phone"),rs.getString("email"),rs.getString("address"),rs.getString("other"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closed(rs,stat,conn);
			}
			return stu;
				
		}
		
		//插入
		public static boolean insertStudent(StudentBean stu) {
			boolean temp = false;
			PreparedStatement pstat = null;
			//stat.execute("insert into login(name,password,id,sex,date,address,email,hometown) values('"+stu.getName()+"','"+stu.getPassword()+"',"+stu.getId()+",'"+stu.getSex()+"','"+stu.getDate()+"','"+stu.getAddress()+"','"+stu.getEmail()+"','"+stu.getHometown()+"')"); 
			String sql = "insert into three(id,name,sex,date,phone,email,address,other) values(?,?,?,?,?,?,?,?)";
			try {		
				conn = GetConnect();
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, stu.getId());
				pstat.setString(2, stu.getName());
				pstat.setString(3, stu.getSex());
				pstat.setString(4, stu.getDate());
				pstat.setString(5, stu.getPhone());
				pstat.setString(6, stu.getEmail());
				pstat.setString(7, stu.getAddress());
				pstat.setString(8, stu.getOther());
				int count = pstat.executeUpdate();
				if(count>0) {
					temp = true;
				}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closed(rs,pstat,conn);
			}
			return temp;
		}
		
		//删除
		public static boolean deleteStudent(int id){
			boolean temp = false;
			String sql = "delete from three where id='"+id+"'";
			conn = GetConnect();			
			int count = -1;
			try {
				stat = conn.createStatement();
				count = stat.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count>0) {
				temp = true;
			}
			closed(rs,stat,conn);
			return temp;
		}
		
		//修改
		public static boolean updateStudent(StudentBean stu) {
			boolean temp = false;
			PreparedStatement pstat = null;
			String sql = "update three set id=?, name=?,sex=?,date=?,phone=?,email=?,address=?,other=? where id='"+stu.getId()+"'";
			conn = GetConnect();
			try {
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, stu.getId());
				pstat.setString(2, stu.getName());
				pstat.setString(3, stu.getSex());
				pstat.setString(4, stu.getDate());
				pstat.setString(5, stu.getPhone());
				pstat.setString(6, stu.getEmail());
				pstat.setString(7, stu.getAddress());
				pstat.setString(8, stu.getOther());
				int count = pstat.executeUpdate();
				if(count>0) {
					temp = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			closed(rs,pstat,conn);
			return temp;
		}
		
		
}
