public class IfElseTest1 {
	public static void main(String[] args) {
		int x = 10;
		int y = 10;

		// ��� 1
		/*
		if(x > y) {
			System.out.println(x + "�� " + y + "���� ũ��.");
		} else {
			System.out.println(x + "�� " + y + "���� �۴�.");
		}
		*/

		// ��� 2 
		String result;
		if(x > y) {
			result = "ũ��";
		} else {
			result = "�۴�";
		}
		System.out.println(x + "�� " + y + "�� ���Ͽ� " + result);

		//��� 3 (if�� ��ø)
		if(x < y){
			result = "�۴�";
		} else {
			if(x == y){
				result = "����";
			} else {
				result = "ũ��";
			}
		}
		System.out.println(x + "�� " + y + "�� ���Ͽ� " + result);

		// ����, ���� if else�� �ٲٱ�


		System.out.println("���α׷� ����!!!!");
	}
}
