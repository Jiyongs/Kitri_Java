/*
* ���� ���� �� ����.
1. 0 (����), 1(����), 2(��)
2. �� : ���� (0, 1, 2)
3. ��� Logic ���� (�̱�, ��, ���)
4. ��� ���
    �� : ��, �� : ���� ��� : �̰��.
    �� : ��, �� : �� ��� : ����.
    �� : ��, �� : ���� ��� : ����.
*/
public class GBB {
	public static void main(String[] args) {
		int my = 2; //���� �� ��(��)
		int com = (int) (Math.random() * 3); //��ǻ�Ͱ� ���� �� (����)

		String result;
		String my_result;
		String com_result;

		int mid = (my-com+2)%3;  //my-com�� ������ �־�, ����� ����� ���� 2�̻��� ���� ����  (+2)
		                                  //����� ���� 3�̹Ƿ�, 3���� ���� �������� ���ϸ� ������ ����� ���� ����.  (%3)

		// ��� ��
		if(mid == 0){
			result = "�̰��.";
		} else if(mid == 1){
			result = "����.";
		} else {
			result = "����.";
		}

		// �� ��� �ѱ۷� ��ȯ
		switch(my){
			case 0 : my_result = "����"; break;
			case 1 : my_result = "����"; break;
			default : my_result = "��";
		}

		// ��ǻ�� ��� �ѱ۷� ��ȯ
		switch(com){
			case 0 : com_result = "����"; break;
			case 1 : com_result = "����"; break;
			default : com_result = "��";
		}

			System.out.println("�� : " + my_result + ", �� : " + com_result + " ��� : " + result);

/*
		if(my == 0) {
			my_result = "����";
			switch(com){
				case 0 : com_result = "����"; result = "����."; break;
				case 1 : com_result = "����"; result = "����."; break;
				default : com_result = "��"; result = "�̰��.";
			}
		} else if(my == 1){
			my_result = "����";
			switch(com){
				case 0 : com_result = "����"; result = "�̰��."; break;
				case 1 : com_result = "����"; result = "����."; break;
				default : com_result = "��"; result = "����.";
			}
		} else{
			my_result = "��";
			switch(com){
				case 0 : com_result = "����"; result = "����."; break;
				case 1 : com_result = "����"; result = "�̰��."; break;
				default : com_result = "��"; result = "����.";
			}
		}
		*/

	}
	
}
