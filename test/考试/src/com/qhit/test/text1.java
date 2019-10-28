package com.qhit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.qhit.lei.guanliyuan;

public class text1 {
	//��java��jdbc���һ��myscool���ݿ���student�������
	//���
	public void tianjia(String shuming,int shuqian){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
			try {
				//2.��ȡ����
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/kaoshi?useUnicode=true&characterEncoding=utf8","root","123456789");
				pstmt = conn.prepareStatement("insert into bookshow (shuname,bookmoney) values(?,?)");
				pstmt.setString(1, shuming);
				pstmt.setInt(2, shuqian);
				int i = pstmt.executeUpdate();
				if(i!=0){
					System.out.println("��ӳɹ�");
				}else{
					System.out.println("���ʧ��");
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
	
	//ɾ��
	public void shanchu(String www){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
			try {
				//2.��ȡ����
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/kaoshi?useUnicode=true&characterEncoding=utf8","root","123456789");
				pstmt = conn.prepareStatement("delete from bookshow where shuname = ?");
				pstmt.setString(1,www);
				int i = pstmt.executeUpdate();
				if(i!=0){
					System.out.println("ɾ���ɹ�");
				}else{
					System.out.println("ɾ��ʧ��");
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
	
	//��
	public void gai(String wwww, int qian){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
			try {
				//2.��ȡ����
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/kaoshi?useUnicode=true&characterEncoding=utf8","root","123456789");
				pstmt = conn.prepareStatement("update bookshow set bookmoney=? where shuname=?");
				pstmt.setInt(1,qian);
				pstmt.setString(2,wwww);
				System.out.println("1");
				int i = pstmt.executeUpdate();
				System.out.println(i);
				if(i!=0){
					System.out.println("�޸ĳɹ�");
				}else{
					System.out.println("�޸�ʧ��");
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
	
	//��
	public void cha(String bn){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
			try {
				//2.��ȡ����
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/kaoshi?useUnicode=true&characterEncoding=utf8","root","123456789");
				pstmt = conn.prepareStatement("select * from bookshow where shuname = ?");
				pstmt.setString(1,bn);
				ResultSet rs= pstmt.executeQuery();
				while(rs.next()){
					System.out.println("������"+rs.getString("shuname")
							+"��Ǯ��"+rs.getInt("bookmoney"));
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
			System.out.println("��ӭ����ͼ�����ϵͳ");
			System.out.println("���������Ա�û���");
			String a = input.next();
			System.out.println("���������Ա����");
			int b = input.nextInt();
			if (a == gl.getName() || b == gl.getPassword()) {
				System.out.println("��½�ɹ�");
				i = 0;
				System.out.println("��ӭ�����ڲ��ռ�");
				System.out.println("1.��ʾͼʾ�б���Ϣ");
				System.out.println("2.���ͼ����Ϣ");
				System.out.println("3.�޸�ͼ����Ϣ");
				System.out.println("4.ɾ��ͼ����Ϣ");
				System.out.println("5.�˳�ϵͳ");
				int ii = input.nextInt();
				switch (ii) {
				case 1:
					System.out.println("��������������");
					String aa = input.next();
					tt.cha(aa);
					break;
				case 2:
					System.out.println("��������");
					String q = input.next();
					System.out.println("������ļ�Ǯ");
					int qq = input.nextInt();
					tt.tianjia(q, qq);
					break;
				case 3:
					System.out.println("���������޸��Ǳ��������");
					String eString = input.next();
					System.out.println("��Ǯ�޸ĳ�");
					int ww = input.nextInt();
					tt.gai(eString, ww);
				case 4:
					System.out.println("��������ɾ��������");
					String w = input.next();
					tt.shanchu(w);
					break;
				case 5:
					System.out.println("��ӭ�´ι���");
					System.exit(0);
				default:
					break;
				}

			} else {
				System.out.println("��½ʧ��������");
				i++;
				if (i == 3) {
					System.out.println("��½����ʧ�ܣ����Ѿ�û�л�����");
					System.exit(0);
				}
				continue;
			}

		}
	}
}