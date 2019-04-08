package com.kitri.haksa.service;

import java.io.*;
import java.util.ArrayList;

import com.kitri.haksa.data.HaksaDto;

public class HaksaServiceImpl implements HaksaService{
	
	private ArrayList<HaksaDto> list = new ArrayList<HaksaDto>();
	private String[] job = {"�й�", "����", "�μ�"};
	private BufferedReader in;
	
	// [������]
	public HaksaServiceImpl() {
		super();
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	// [implement�� Ŭ������ �޼ҵ� override]
	
	// <���� �޴�> �޼ҵ�
	@Override
	public void menu() {
		
		System.out.println("========== �޴� ���� ==========");
		System.out.println("1. ���");
		System.out.println("2. ã��");
		System.out.println("3. ����");
		System.out.println("4. ��ü ���");
		System.out.println("--------------------");
		System.out.println("0. ����");
		System.out.println("--------------------");
		System.out.print("��ȣ�� ������ �ּ���... ");

		// �Է°� �ޱ�
		try {
			String input = in.readLine().trim();
			
			switch(input) {
				case "1" : //���
					registerMenu(); 
					break;
				case "2" : //ã��
					findNameMenu();
					break;
				case "3" : //����
					deleteMenu();
					break;
				case "4" : //��ü ���
					selectAll();
					break;
				case "0" : //����
					processExit();
					break;
				default : //�߸��� �Է°�
					System.out.println("0~4������ ���ڸ� �Է����ּ���.");
					menu();
			}
			
			//����ó��
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// ���� �ݱ�
				if(in != null)
					in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// <��� �޴�> �޼ҵ�
	@Override
	public void registerMenu() {
		System.out.println("========== �޴� ���� ==========");
		System.out.println("1. �л�");
		System.out.println("2. ����");
		System.out.println("3. ������");
		System.out.println("4. �����޴�");
		System.out.print("��ȣ�� ������ �ּ���.. ");
		
		
		// �Է°� �ޱ�
				try {
					String input = in.readLine().trim();
					int age = 0;
					String name = null;
					
					//�޴� ���� ��ȣ�� ����, �й� | ���� | �μ� �Է� �ޱ�
					//                      Ű���� 0      1      2
					switch(input) {
					case "1" :
						// ����, �̸� �Է¹ޱ�
						System.out.print("�� �� : ");
						age = Integer.parseInt(in.readLine().trim());
						
						System.out.print("�� �� : ");
						name = in.readLine().trim();
						
						System.out.print("�� �� : ");
						String studentNum = in.readLine().trim();
						register(new HaksaDto(age, name, Integer.parseInt(input)-1, studentNum));
						System.out.println("�л� ����� �Ϸ�Ǿ����ϴ�!");  //###########
						registerMenu();
						break;		
					case "2" :
						// ����, �̸� �Է¹ޱ�
						System.out.print("�� �� : ");
						age = Integer.parseInt(in.readLine().trim());
						
						System.out.print("�� �� : ");
						name = in.readLine().trim();
						
						System.out.print("�� �� : ");
						String className = in.readLine().trim();
						register(new HaksaDto(age, name, Integer.parseInt(input)-1, className));
						System.out.println("���� ����� �Ϸ�Ǿ����ϴ�!");  //###########
						registerMenu();
						break;
					case "3" :
						// ����, �̸� �Է¹ޱ�
						System.out.print("�� �� : ");
						age = Integer.parseInt(in.readLine().trim());
						
						System.out.print("�� �� : ");
						name = in.readLine().trim();
						
						System.out.print("�� �� : ");
						String department = in.readLine().trim();
						register(new HaksaDto(age, name,Integer.parseInt(input)-1, department));
						System.out.println("������ ����� �Ϸ�Ǿ����ϴ�!");  //###########
						registerMenu();
						break;
					case "4" :
						System.out.println("�����޴� Ŭ�� �ڷΰ��ϴ�.");
						menu();
						break;
					default :
						System.out.println("1~4�������� ���ڸ� �Է� �����մϴ�.");
						registerMenu();
					}
					
					// ����ó��
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						// ���� �ݱ�
						if(in != null)
							in.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
	
	}

	//<�Է��� ������ ���� Dto ��ü�� list�� ����> �޼ҵ�
	@Override
	public void register(HaksaDto haksa) {
		list.add(haksa);
	}

	// <ã�� �޴�> �޼ҵ�
	@Override
	public void findNameMenu() {
		System.out.println("ã�� �̸��� �Է��� �ּ���.");
		System.out.print("�̸� : ");
		
		// �Է°� �ޱ�
		try {
			String name = in.readLine().trim();
			HaksaDto findDto = findName(name);
			
			// �Է��� �̸��� Dto��ü�� �ִ� ���,
			if(findDto!=null) {
				System.out.println("���� : " + findDto.getAge() + "\t�̸� : " + findDto.getName()
				+ "\t" + job[findDto.getKey()] + " : " + findDto.getValue());
				// �Է��� �̸��� Dto��ü�� ���� ���,
			} else {
				System.out.println("�Է��Ͻ� �̸��� ������ ã�� �� �����ϴ�.");
			}
			
			System.out.print("��� �Ͻ÷��� 1, ���� �Ͻ÷��� 0�� �Է����ּ��� ");
			String isContinue = in.readLine().trim();
			if(isContinue.equals("1")) {
				findNameMenu();
			} else if (isContinue.equals("0")){
				menu();
			} else {
				System.out.println("0 �Ǵ� 1�� �Է����ּ���. ���� �޴��� ���ư��ϴ�."); //#####
				menu(); //#####
			}
			
			// ���� ó��
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// ���� �ݱ�
				if(in != null)
					in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
	}

	// <�Է��� �̸��� ��ġ�ϴ� HaksaDto ��ü ã�� �� ����> �޼ҵ�
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

	// <���� �޴�> �޼ҵ�
	@Override
	public void deleteMenu() {
		System.out.println("������ ����� �̸��� �Է��� �ּ���.");
		System.out.print("�̸� : ");
		
		// �Է°� �ޱ�
		try {
			String name = in.readLine().trim();
			
			int isDelete = delete(name);
			// ���� �Ϸ��
			if(isDelete>=0) {
				System.out.println(name + "���� ���� �Ͽ����ϴ�.");
			} else {
				System.out.println(name + "���� ã�� �� �����ϴ�.");
			}
			
			System.out.print("��� �Ͻ÷��� 1, ���� �Ͻ÷��� 0�� �Է����ּ��� ");
			String isContinue = in.readLine().trim();
			if(isContinue.equals("1")) {
				deleteMenu();
			} else if (isContinue.equals("0")){
				menu();
			} else {
				System.out.println("0 �Ǵ� 1�� �Է����ּ���. ���� �޴��� ���ư��ϴ�."); //#####
				menu(); //#####
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	// <�Է¹��� �̸��� list ���� ����> �޼ҵ�
	// ���ϰ� : -1�̸�, �̸��� ��ġ�ϴ� �׸� ����
	// ���ϰ� 0�̻��̸�, ���� �Ϸ�
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
			System.out.println("�̸� : " + list.get(i).getName() + "\t���� : " + list.get(i).getAge() +
									"\t" + job[list.get(i).getKey()] + " : " + list.get(i).getValue());
		}
		
		// ��� ���� �Է°� �ޱ�
		try {
			System.out.print("��� �Ͻ÷��� 1, ���� �Ͻ÷��� 0�� �Է����ּ��� ");
			String isContinue;
			isContinue = in.readLine().trim();
			
			if(isContinue.equals("1")) {
				selectAll();
			} else if (isContinue.equals("0")){
				menu();
			} else {
				System.out.println("0 �Ǵ� 1�� �Է����ּ���. ���� �޴��� ���ư��ϴ�."); //#####
				menu(); //#####
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	// <���α׷� ����> �޼ҵ�
	@Override
	public void processExit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}


	
	
	
}
