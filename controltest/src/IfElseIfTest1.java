public class IfElseIfTest1 {
	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		String result;

		if(x == y) {
			result = "����.";
		} else if (x > y) {
			result = "ũ��.";
		} else {
			result = "�۴�.";
		}

		System.out.println(x + "�� " + y + "�� ���Ͽ� " + result);

		// ������ ���� ���, ���׿����ڴ� �������� �������Ƿ� if���� ���� ���� ����
		// ������, ���׿������� if�� ���� ���� �ӵ��� �� ���� (�� ������, ���� ��ǻ�� �ӵ��� �׷� �Ϳ� ���� ������� ����)
	}
}
