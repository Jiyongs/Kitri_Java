public class AbstractTest2 {
	public static void main(String[] args) throws Exception {
	
	//3. �ܺ� Ŭ���� �̿�
	//Runtime r = new // �ܺ� Ŭ���� ��ü ���� (x) // �����ڰ� ����
	Runtime r = Runtime.getRuntime(); //�ܺ� Ŭ���� ��ü ���� (o) // 2����� �̿�
	Process p = 	r.exec("calc");            //�ܺ� Ŭ���� ��ü��, Process ��ü�� �����ϴ� �޼ҵ带 ȣ�� //3�� + 2��

	}
}
