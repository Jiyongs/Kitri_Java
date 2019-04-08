package com.kitri.haksa.service;

import java.io.*;
import java.util.ArrayList;

import com.kitri.haksa.data.HaksaDto;

public class HaksaServiceImpl implements HaksaService{
	
	private ArrayList<HaksaDto> list = new ArrayList<HaksaDto>();
	private String[] job = {"학번", "과목", "부서"};
	private BufferedReader in;
	
	// [생성자]
	public HaksaServiceImpl() {
		super();
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	// [implement한 클래스의 메소드 override]
	
	// <메인 메뉴> 메소드
	@Override
	public void menu() {
		
		System.out.println("========== 메뉴 선택 ==========");
		System.out.println("1. 등록");
		System.out.println("2. 찾기");
		System.out.println("3. 삭제");
		System.out.println("4. 전체 출력");
		System.out.println("--------------------");
		System.out.println("0. 종료");
		System.out.println("--------------------");
		System.out.print("번호를 선택해 주세요... ");

		// 입력값 받기
		try {
			String input = in.readLine().trim();
			
			switch(input) {
				case "1" : //등록
					registerMenu(); 
					break;
				case "2" : //찾기
					findNameMenu();
					break;
				case "3" : //삭제
					deleteMenu();
					break;
				case "4" : //전체 출력
					selectAll();
					break;
				case "0" : //종료
					processExit();
					break;
				default : //잘못된 입력값
					System.out.println("0~4까지의 숫자를 입력해주세요.");
					menu();
			}
			
			//예외처리
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 버퍼 닫기
				if(in != null)
					in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// <등록 메뉴> 메소드
	@Override
	public void registerMenu() {
		System.out.println("========== 메뉴 선택 ==========");
		System.out.println("1. 학생");
		System.out.println("2. 교수");
		System.out.println("3. 관리자");
		System.out.println("4. 이전메뉴");
		System.out.print("번호를 선택해 주세요.. ");
		
		
		// 입력값 받기
				try {
					String input = in.readLine().trim();
					int age = 0;
					String name = null;
					
					//메뉴 선택 번호에 따라, 학번 | 과목 | 부서 입력 받기
					//                      키값은 0      1      2
					switch(input) {
					case "1" :
						// 나이, 이름 입력받기
						System.out.print("나 이 : ");
						age = Integer.parseInt(in.readLine().trim());
						
						System.out.print("이 름 : ");
						name = in.readLine().trim();
						
						System.out.print("학 번 : ");
						String studentNum = in.readLine().trim();
						register(new HaksaDto(age, name, Integer.parseInt(input)-1, studentNum));
						System.out.println("학생 등록이 완료되었습니다!");  //###########
						registerMenu();
						break;		
					case "2" :
						// 나이, 이름 입력받기
						System.out.print("나 이 : ");
						age = Integer.parseInt(in.readLine().trim());
						
						System.out.print("이 름 : ");
						name = in.readLine().trim();
						
						System.out.print("과 목 : ");
						String className = in.readLine().trim();
						register(new HaksaDto(age, name, Integer.parseInt(input)-1, className));
						System.out.println("교수 등록이 완료되었습니다!");  //###########
						registerMenu();
						break;
					case "3" :
						// 나이, 이름 입력받기
						System.out.print("나 이 : ");
						age = Integer.parseInt(in.readLine().trim());
						
						System.out.print("이 름 : ");
						name = in.readLine().trim();
						
						System.out.print("부 서 : ");
						String department = in.readLine().trim();
						register(new HaksaDto(age, name,Integer.parseInt(input)-1, department));
						System.out.println("관리자 등록이 완료되었습니다!");  //###########
						registerMenu();
						break;
					case "4" :
						System.out.println("이전메뉴 클릭 뒤로갑니다.");
						menu();
						break;
					default :
						System.out.println("1~4번까지의 숫자만 입력 가능합니다.");
						registerMenu();
					}
					
					// 예외처리
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						// 버퍼 닫기
						if(in != null)
							in.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
	
	}

	//<입력한 정보를 담은 Dto 객체를 list에 저장> 메소드
	@Override
	public void register(HaksaDto haksa) {
		list.add(haksa);
	}

	// <찾기 메뉴> 메소드
	@Override
	public void findNameMenu() {
		System.out.println("찾을 이름을 입력해 주세요.");
		System.out.print("이름 : ");
		
		// 입력값 받기
		try {
			String name = in.readLine().trim();
			HaksaDto findDto = findName(name);
			
			// 입력한 이름의 Dto객체가 있는 경우,
			if(findDto!=null) {
				System.out.println("나이 : " + findDto.getAge() + "\t이름 : " + findDto.getName()
				+ "\t" + job[findDto.getKey()] + " : " + findDto.getValue());
				// 입력한 이름의 Dto객체가 없는 경우,
			} else {
				System.out.println("입력하신 이름의 정보를 찾을 수 없습니다.");
			}
			
			System.out.print("계속 하시려면 1, 종료 하시려면 0을 입력해주세요 ");
			String isContinue = in.readLine().trim();
			if(isContinue.equals("1")) {
				findNameMenu();
			} else if (isContinue.equals("0")){
				menu();
			} else {
				System.out.println("0 또는 1만 입력해주세요. 메인 메뉴로 돌아갑니다."); //#####
				menu(); //#####
			}
			
			// 예외 처리
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 버퍼 닫기
				if(in != null)
					in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
	}

	// <입력한 이름과 일치하는 HaksaDto 객체 찾은 후 리턴> 메소드
	@Override
	public HaksaDto findName(String name) {
		
		int size = list.size();
		for(int i = 0; i < size; i++) {
			if(list.get(i).getName().equals(name)) {
				return list.get(i);
			}
		}
		
		return null;
	}

	// <삭제 메뉴> 메소드
	@Override
	public void deleteMenu() {
		System.out.println("삭제할 사람의 이름을 입력해 주세요.");
		System.out.print("이름 : ");
		
		// 입력값 받기
		try {
			String name = in.readLine().trim();
			
			int isDelete = delete(name);
			// 삭제 완료시
			if(isDelete>=0) {
				System.out.println(name + "님을 삭제 하였습니다.");
			} else {
				System.out.println(name + "님을 찾을 수 없습니다.");
			}
			
			System.out.print("계속 하시려면 1, 종료 하시려면 0을 입력해주세요 ");
			String isContinue = in.readLine().trim();
			if(isContinue.equals("1")) {
				deleteMenu();
			} else if (isContinue.equals("0")){
				menu();
			} else {
				System.out.println("0 또는 1만 입력해주세요. 메인 메뉴로 돌아갑니다."); //#####
				menu(); //#####
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	// <입력받은 이름의 list 값을 삭제> 메소드
	// 리턴값 : -1이면, 이름과 일치하는 항목 없음
	// 리턴값 0이상이면, 삭제 완료
	@Override
	public int delete(String name) {
		
		int size = list.size();
		
		for(int i = 0; i < size; i++) {
			if(list.get(i).getName().equals(name)) {
				list.remove(i);
				return i;
			}
		}
		return -1;
	}

	@Override
	public void selectAll() {
		int size = list.size();
		for(int i = 0; i < size; i++) {
			System.out.println("이름 : " + list.get(i).getName() + "\t나이 : " + list.get(i).getAge() +
									"\t" + job[list.get(i).getKey()] + " : " + list.get(i).getValue());
		}
		
		// 계속 여부 입력값 받기
		try {
			System.out.print("계속 하시려면 1, 종료 하시려면 0을 입력해주세요 ");
			String isContinue;
			isContinue = in.readLine().trim();
			
			if(isContinue.equals("1")) {
				selectAll();
			} else if (isContinue.equals("0")){
				menu();
			} else {
				System.out.println("0 또는 1만 입력해주세요. 메인 메뉴로 돌아갑니다."); //#####
				menu(); //#####
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	// <프로그램 종료> 메소드
	@Override
	public void processExit() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}


	
	
	
}
