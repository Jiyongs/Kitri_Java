package com.kitri.haksa.service.db;

import java.sql.*;
import java.util.ArrayList;

import com.kitri.haksa.data.db.HaksaDto;

public class HaksaDao {
	
	Connection conn = null;			  // DB연결된 상태(세션)을 담은 객체
	
	// 쿼리문에 변수넣을 때 사용하는 state객체
    PreparedStatement pstm = null;  // 변수 받을 sql문 설정하는 객체
    
    // 그냥 쿼리문 사용하는 state객체
    Statement st = null;
    ResultSet rs = null;

	public HaksaDao() {
		
	}

	// <입력한 정보를 담은 Dto 객체를 db에 저장> 메소드
	// insert
	public void register(HaksaDto haksa) {
		
		try {	
			// db 연결
			conn = getConnection();
			
        	// 1) 쿼리문 준비
            String query = "INSERT INTO SCHOOL(NAME, AGE, KEY, VALUE) VALUES(?, ?, ?, ?)";
			
            // 2) 연결한 db를 이용해서, preparedStatement 객체 생성
            //     그리고 쿼리문의 ?에, 인자로 받은 haksa객체의 필드값을 넣어줌
            pstm = conn.prepareStatement(query);
            pstm.setString(1, haksa.getName());
            pstm.setInt(2, haksa.getAge());
            pstm.setInt(3, haksa.getKey());
            pstm.setString(4, haksa.getValue());
			
			                                    
            // 3) 쿼리문 실행
            int result = pstm.executeUpdate();  // result : 변경된 결과의 개수

            System.out.println("쿼리 실행 완료");
            
            if(result>0) {
            	System.out.println(haksa.getName() + "님의 등록 정보를 db에 저장했습니다.");
            } else
            	System.out.println("등록에 실패하였습니다.");
            
        } catch (SQLException sqle) {
            System.out.println("INSERT문에서 예외 발생");
            sqle.printStackTrace();
            
        } finally{
            // 4) DB 연결 종료
            try{
                if ( pstm != null ){pstm.close();}
                if ( conn != null ){conn.close(); }
            } catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
  
        }

	}

	
	// <입력한 이름과 일치하는 HaksaDto값을 db에서 찾은 후 리턴> 메소드
	// select
	public HaksaDto findName(String name) {

		HaksaDto resultDto = null;
		
		try {
			
			// db 연결
			conn = getConnection();
			
			// 1) 쿼리문 준비
            String query = "SELECT s.name, s.age, s.key, j.key_name, s.value FROM SCHOOL s, JOB j WHERE s.KEY = j.KEY AND NAME=?";
            
            // 2) 연결한 db를 이용해서, PreparedStatement 객체 생성
            //     그리고 찾을 이름인 인자값을 ?에 넣어줌
            pstm = conn.prepareStatement(query);
            pstm.setString(1, name);
            
            // 3) 쿼리문 실행 후, 그 결과로 ResultSet 객체 생성
            rs = pstm.executeQuery();  // rs : select문 결과 저장
            
            // 모든 결과에서 key값을 찾아와, 그 key값과 같은 HaksaDto 객체를 생성하여 리턴
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
            System.out.println("SELECT문에서 예외 발생");
            sqle.printStackTrace();
            
        } finally{
            // 4) DB 연결 종료
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
	
	
	// <입력받은 이름의 db행을 삭제> 메소드
		// 리턴값 : 0이면, 이름과 일치하는 항목 없음
		// 리턴값 1이면, 삭제 완료
	// delete
	public int delete(String name) {
		int result = 0;
		try {
        	
			// db 연결
			conn = getConnection();
			
        	// 1) 쿼리문 준비
            String query = "DELETE FROM SCHOOL WHERE name = ?";
            
            // 2) 연결한 db를 이용해서, preparedStatement 객체 생성
            //     그리고 쿼리문의 ?에, 인자로 받은 haksa객체의 필드값을 넣어줌
            pstm = conn.prepareStatement(query);
            pstm.setString(1, name);
            
            // 3) 쿼리문 실행
            result = pstm.executeUpdate();  // result : 변경된 결과의 개수
            
            if(result>0) {
            	System.out.println(name + "님의 등록 정보를 db에서 삭제했습니다.");
            	return result;
            } else
            	System.out.println("삭제에 실패하였습니다.");
            
        } catch (SQLException sqle) {
            System.out.println("DELETE문에서 예외 발생");
            sqle.printStackTrace();
            
        } finally{
            // 4) DB 연결 종료
            try{
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
  
        }
		
		return result;
	}
	
	// <모두 찾기> 메소드
	public ArrayList<HaksaDto> selectAllList() {
		ArrayList<HaksaDto> hd = new ArrayList<HaksaDto>();
		
		try {

			// db 연결
			conn = getConnection();
        	
        	// 1) 쿼리문 준비
            String query = "SELECT s.name, s.age, s.key, j.key_name, s.value FROM SCHOOL s, JOB j WHERE s.KEY = j.KEY";
            
            // 2) 연결한 db를 이용해서, PreparedStatement 객체 생성
              st = conn.createStatement();
            
            // 3) 쿼리문 실행 후, 그 결과로 ResultSet 객체 생성
              rs = st.executeQuery(query);  // rs : select문 결과 저장
            
            // 모든 결과에서 key값을 찾아와, 그 key값과 같은 HaksaDto 객체를 생성하여 리턴
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
            System.out.println("SELECT문에서 예외 발생");
            sqle.printStackTrace();
            
        } finally{
            // 4) DB 연결 종료
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
	
	
	
	/////////////////////////////////[DB연결]///////////////////////////////////////
	
	// <db 연결> 메소드
	public Connection getConnection() {
		 Connection conn = null;
        try {
        	
            String user = "kitri"; 
            String pw = "kitri";
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database에 연결되었습니다.\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패 : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
        return conn;     

	}
	
}
