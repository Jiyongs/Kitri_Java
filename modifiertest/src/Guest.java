public class Guest {

	static int cnt;  // class ���� (��ü ����, Ŭ�����̸����� ���� ������ ����)
	String name;  // instance ���� (��ü�� �̿��Ͽ� ���� ������ ����)

	public Guest(String name) {
		this.name = name;
	}

// static �޼ҵ� -> non-static ������ �޼ҵ� (ȣ�� X)
// non-static �޼ҵ� -> static ������ �޼ҵ� (ȣ�� O)
	static public int visit() {
		cnt++;
		return cnt;
	}
}
