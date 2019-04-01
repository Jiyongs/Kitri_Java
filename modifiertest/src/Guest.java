public class Guest {

	static int cnt;  // class 변수 (객체 없이, 클래스이름으로 참조 가능한 변수)
	String name;  // instance 변수 (객체를 이용하여 참조 가능한 변수)

	public Guest(String name) {
		this.name = name;
	}

// static 메소드 -> non-static 변수나 메소드 (호출 X)
// non-static 메소드 -> static 변수나 메소드 (호출 O)
	static public int visit() {
		cnt++;
		return cnt;
	}
}
