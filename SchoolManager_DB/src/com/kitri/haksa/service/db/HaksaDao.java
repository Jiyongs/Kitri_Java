package com.kitri.haksa.service.db;

import java.sql.*;
import java.util.ArrayList;

import com.kitri.haksa.data.db.HaksaDto;

public class HaksaDao {
	
	Connection conn = null;			  // DB����� ����(����)�� ���� ��ü
	
	// �������� �������� �� ����ϴ� state��ü
    PreparedStatement pstm = null;  // ���� ���� sql�� �����ϴ� ��ü
    
    // �׳� ������ ����ϴ� state��ü
    Statement st = null;
    ResultSet rs = null;

	public HaksaDao() {
		
	}

	// <�Է��� ������ ���� Dto ��ü�� db�� ����> �޼ҵ�
	// insert
	public void register(HaksaDto haksa) {
		
		try {	
			// db ����
			conn = getConnection();
			
        	// 1) ������ �غ�
            String query = "INSERT INTO SCHOOL(NAME, AGE, KEY, VALUE) VALUES(?, ?, ?, ?)";
			
            // 2) ������ db�� �̿��ؼ�, preparedStatement ��ü ����
            //     �׸��� �������� ?��, ���ڷ� ���� haksa��ü�� �ʵ尪�� �־���
            pstm = conn.prepareStatement(query);
            pstm.setString(1, haksa.getName());
            pstm.setInt(2, haksa.getAge());
            pstm.setInt(3, haksa.getKey());
            pstm.setString(4, haksa.getValue());
			
			                                    
            // 3) ������ ����
            int result = pstm.executeUpdate();  // result : ����� ����� ����

            System.out.println("���� ���� �Ϸ�");
            
            if(result>0) {
            	System.out.println(haksa.getName() + "���� ��� ������ db�� �����߽��ϴ�.");
            } else
            	System.out.println("��Ͽ� �����Ͽ����ϴ�.");
            
        } catch (SQLException sqle) {
            System.out.println("INSERT������ ���� �߻�");
            sqle.printStackTrace();
            
        } finally{
            // 4) DB ���� ����
            try{
                if ( pstm != null ){pstm.close();}
                if ( conn != null ){conn.close(); }
            } catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
  
        }

	}

	
	// <�Է��� �̸��� ��ġ�ϴ� HaksaDto���� db���� ã�� �� ����> �޼ҵ�
	// select
	public HaksaDto findName(String name) {

		HaksaDto resultDto = null;
		
		try {
			
			// db ����
			conn = getConnection();
			
			// 1) ������ �غ�
            String query = "SELECT s.name, s.age, s.key, j.key_name, s.value FROM SCHOOL s, JOB j WHERE s.KEY = j.KEY AND NAME=?";
            
            // 2) ������ db�� �̿��ؼ�, PreparedStatement ��ü ����
            //     �׸��� ã�� �̸��� ���ڰ��� ?�� �־���
            pstm = conn.prepareStatement(query);
            pstm.setString(1, name);
            
            // 3) ������ ���� ��, �� ����� ResultSet ��ü ����
            rs = pstm.executeQuery();  // rs : select�� ��� ����
            
            // ��� ������� key���� ã�ƿ�, �� key���� ���� HaksaDto ��ü�� �����Ͽ� ����
            while(rs.next()) {
            	int rage = rs.getInt("age");
            	String rname = rs.getString("name");
            	int rkey = rs.getInt("key");
            	String rkeyname = rs.getString("key_name");
            	String rvalue = rs.getString("value");
            	
            	resultDto = new HaksaDto();
            	resultDto.setAge(rage);
            	resultDto.setKey(rkey);
            	resultDto.setKeyName(rkeyname);
            	resultDto.setName(rname);
            	resultDto.setValue(rvalue);
            }
            
        } catch (SQLException sqle) {
            System.out.println("SELECT������ ���� �߻�");
            sqle.printStackTrace();
            
        } finally{
            // 4) DB ���� ����
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
		
		return resultDto;
	}
	
	
	// <�Է¹��� �̸��� db���� ����> �޼ҵ�
		// ���ϰ� : 0�̸�, �̸��� ��ġ�ϴ� �׸� ����
		// ���ϰ� 1�̸�, ���� �Ϸ�
	// delete
	public int delete(String name) {
		int result = 0;
		try {
        	
			// db ����
			conn = getConnection();
			
        	// 1) ������ �غ�
            String query = "DELETE FROM SCHOOL WHERE name = ?";
            
            // 2) ������ db�� �̿��ؼ�, preparedStatement ��ü ����
            //     �׸��� �������� ?��, ���ڷ� ���� haksa��ü�� �ʵ尪�� �־���
            pstm = conn.prepareStatement(query);
            pstm.setString(1, name);
            
            // 3) ������ ����
            result = pstm.executeUpdate();  // result : ����� ����� ����
            
            if(result>0) {
            	System.out.println(name + "���� ��� ������ db���� �����߽��ϴ�.");
            	return result;
            } else
            	System.out.println("������ �����Ͽ����ϴ�.");
            
        } catch (SQLException sqle) {
            System.out.println("DELETE������ ���� �߻�");
            sqle.printStackTrace();
            
        } finally{
            // 4) DB ���� ����
            try{
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
  
        }
		
		return result;
	}
	
	// <��� ã��> �޼ҵ�
	public ArrayList<HaksaDto> selectAllList() {
		ArrayList<HaksaDto> hd = new ArrayList<HaksaDto>();
		
		try {

			// db ����
			conn = getConnection();
        	
        	// 1) ������ �غ�
            String query = "SELECT s.name, s.age, s.key, j.key_name, s.value FROM SCHOOL s, JOB j WHERE s.KEY = j.KEY";
            
            // 2) ������ db�� �̿��ؼ�, PreparedStatement ��ü ����
              st = conn.createStatement();
            
            // 3) ������ ���� ��, �� ����� ResultSet ��ü ����
              rs = st.executeQuery(query);  // rs : select�� ��� ����
            
            // ��� ������� key���� ã�ƿ�, �� key���� ���� HaksaDto ��ü�� �����Ͽ� ����
            while(rs.next()) {
            	int rage = rs.getInt("age");
            	String rname = rs.getString("name");
            	int rkey = rs.getInt("key");
            	String rkeyname = rs.getString("key_name");
            	String rvalue = rs.getString("value");
            	
            	HaksaDto resultDto = new HaksaDto();
            	resultDto.setAge(rage);
            	resultDto.setKey(rkey);
            	resultDto.setKeyName(rkeyname);
            	resultDto.setName(rname);
            	resultDto.setValue(rvalue);
            	
            	hd.add(resultDto);
            }
            
        } catch (SQLException sqle) {
            System.out.println("SELECT������ ���� �߻�");
            sqle.printStackTrace();
            
        } finally{
            // 4) DB ���� ����
            try{
                if ( rs != null ){rs.close();}   
                if ( st != null ){st.close();}   
                if ( conn != null ){conn.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
		
		return hd;
	}
	
	
	
	/////////////////////////////////[DB����]///////////////////////////////////////
	
	// <db ����> �޼ҵ�
	public Connection getConnection() {
		 Connection conn = null;
        try {
        	
            String user = "kitri"; 
            String pw = "kitri";
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database�� ����Ǿ����ϴ�.\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB ����̹� �ε� ���� :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB ���ӽ��� : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
        return conn;     

	}
	
}
