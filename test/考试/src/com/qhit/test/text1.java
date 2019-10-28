package com.qhit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.qhit.lei.guanliyuan;

public class text1 {
	//用java的jdbc添加一条myscool数据库中student表的数据
	//添加
	public void tianjia(String shuming,int shuqian){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			try {
				//2.获取连接
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/kaoshi?useUnicode=true&characterEncoding=utf8","root","123456789");
				pstmt = conn.prepareStatement("insert into bookshow (shuname,bookmoney) values(?,?)");
				pstmt.setString(1, shuming);
				pstmt.setInt(2, shuqian);
				int i = pstmt.executeUpdate();
				if(i!=0){
					System.out.println("添加成功");
				}else{
					System.out.println("添加失败");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//删除
	public void shanchu(String www){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			try {
				//2.获取连接
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/kaoshi?useUnicode=true&characterEncoding=utf8","root","123456789");
				pstmt = conn.prepareStatement("delete from bookshow where shuname = ?");
				pstmt.setString(1,www);
				int i = pstmt.executeUpdate();
				if(i!=0){
					System.out.println("删除成功");
				}else{
					System.out.println("删除失败");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//改
	public void gai(String wwww, int qian){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			try {
				//2.获取连接
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/kaoshi?useUnicode=true&characterEncoding=utf8","root","123456789");
				pstmt = conn.prepareStatement("update bookshow set bookmoney=? where shuname=?");
				pstmt.setInt(1,qian);
				pstmt.setString(2,wwww);
				System.out.println("1");
				int i = pstmt.executeUpdate();
				System.out.println(i);
				if(i!=0){
					System.out.println("修改成功");
				}else{
					System.out.println("修改失败");
					System.out.println();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//查
	public void cha(String bn){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			try {
				//2.获取连接
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/kaoshi?useUnicode=true&characterEncoding=utf8","root","123456789");
				pstmt = conn.prepareStatement("select * from bookshow where shuname = ?");
				pstmt.setString(1,bn);
				ResultSet rs= pstmt.executeQuery();
				while(rs.next()){
					System.out.println("书名："+rs.getString("shuname")
							+"价钱："+rs.getInt("bookmoney"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		text1 tt = new text1();
		guanliyuan gl = new guanliyuan();
		gl.setName("hero");
		gl.setPassword(123456);
		int i = 0;
		while (true) {
			System.out.println("欢迎来到图书挂历系统");
			System.out.println("请输入管理员用户名");
			String a = input.next();
			System.out.println("请输入管理员密码");
			int b = input.nextInt();
			if (a == gl.getName() || b == gl.getPassword()) {
				System.out.println("登陆成功");
				i = 0;
				System.out.println("欢迎进入内部空间");
				System.out.println("1.显示图示列表信息");
				System.out.println("2.添加图书信息");
				System.out.println("3.修改图书信息");
				System.out.println("4.删除图书信息");
				System.out.println("5.退出系统");
				int ii = input.nextInt();
				switch (ii) {
				case 1:
					System.out.println("输入你想查的书名");
					String aa = input.next();
					tt.cha(aa);
					break;
				case 2:
					System.out.println("输入书名");
					String q = input.next();
					System.out.println("输入书的价钱");
					int qq = input.nextInt();
					tt.tianjia(q, qq);
					break;
				case 3:
					System.out.println("输入你想修改那本书的书名");
					String eString = input.next();
					System.out.println("价钱修改成");
					int ww = input.nextInt();
					tt.gai(eString, ww);
				case 4:
					System.out.println("输入你想删除的书名");
					String w = input.next();
					tt.shanchu(w);
					break;
				case 5:
					System.out.println("欢迎下次光临");
					System.exit(0);
				default:
					break;
				}

			} else {
				System.out.println("登陆失败请重试");
				i++;
				if (i == 3) {
					System.out.println("登陆三次失败，你已经没有机会了");
					System.exit(0);
				}
				continue;
			}

		}
	}
}