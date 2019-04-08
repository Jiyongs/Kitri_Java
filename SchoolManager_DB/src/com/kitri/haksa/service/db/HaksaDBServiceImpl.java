package com.kitri.haksa.service.db;

import java.io.*;
import java.util.ArrayList;

import com.kitri.haksa.data.db.HaksaDto;

public class HaksaDBServiceImpl implements HaksaService {

	// [�ʵ�]
	private ArrayList<HaksaDto> list = new ArrayList<HaksaDto>();
	private BufferedReader in;
	
	private HaksaDao hdao;
	private HaksaDto hdto;
	
	// [������]
	public HaksaDBServiceImpl() {
		super();
		in = new BufferedReader(new InputStreamReader(System.in));
		hdao = new HaksaDao();
		hdto = new HaksaDto();
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
						
						setHDTO(age, name, 0, "�л�", studentNum);
						
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

						setHDTO(age, name, 1, "����", className);
						
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

						setHDTO(age, name, 2, "������", department);

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

	// <ã�� �޴�> �޼ҵ�
	@Override
	public void findNameMenu() {
		System.out.println("ã�� �̸��� �Է��� �ּ���.");
		System.out.print("�̸� : ");
		
		// �Է°� �ޱ�
		try {
			String name = in.readLine().trim();
			HaksaDto findDto = hdao.findName(name);
			
			// �Է��� �̸��� Dto��ü�� �ִ� ���,
			if(findDto!=null) {
				System.out.println("���� : " + findDto.getAge() + "\t�̸� : " + findDto.getName()
				+ "\t" + findDto.getKeyName() + " : " + findDto.getValue());
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

	// <���� �޴�> �޼ҵ�
	@Override
	public void deleteMenu() {
		System.out.println("������ ����� �̸��� �Է��� �ּ���.");
		System.out.print("�̸� : ");
		
		// �Է°� �ޱ�
		try {
			String name = in.readLine().trim();
			
			int isDelete = hdao.delete(name);
			// ���� �Ϸ��
			if(isDelete==1) {
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

	// <��� ã�� �޴�> �޼ҵ�
	@Override
	public void selectAll() {
		list = hdao.selectAllList();
		int size = list.size();
		for(int i = 0; i < size; i++) {
			System.out.println("�̸� : " + list.get(i).getName() + "\t���� : " + list.get(i).getAge() +
									"\t" + list.get(i).getKeyName() + " : " + list.get(i).getValue());
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

	@Override
	public void processExit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}
	
	///////////////////////////////////////////////////////////////
	public void setHDTO(int age, String name, int key, String keyName, String value) {
		hdto.setAge(age);
		hdto.setName(name);
		hdto.setKey(key);
		hdto.setKeyName(keyName);
		hdto.setValue(value);
		hdao.register(hdto);
	}

}
