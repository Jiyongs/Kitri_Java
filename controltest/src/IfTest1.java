public class IfTest1 {
	public static void main(String[] args) {

		//if��
		int x = 10;
		int y = 7;
		
		if(x>y){
			System.out.println("ũ��.");
		}

		//if�� 2�� -> if�� 1��
		/*
		int jumin = 2;
			if(jumin % 2 == 0){
			System.out.println("����");
			}
			if(jumin % 2 != 0){
			System.out.println("����");         //���� ���๮�� ���� if���� �� �� ���� ���� ��ȿ����
			}
		*/
		int jumin = 2;
		String gender = "����";
		if(jumin%2!=0){
			gender = "����";
		}
		System.out.println(gender);

		System.out.println("���α׷� ����!!!");
	}
}
