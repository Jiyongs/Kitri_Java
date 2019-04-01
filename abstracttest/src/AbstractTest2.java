public class AbstractTest2 {
	public static void main(String[] args) throws Exception {
	
	//3. 외부 클래스 이용
	//Runtime r = new // 외부 클래스 객체 생성 (x) // 생성자가 없음
	Runtime r = Runtime.getRuntime(); //외부 클래스 객체 생성 (o) // 2번방법 이용
	Process p = 	r.exec("calc");            //외부 클래스 객체로, Process 객체를 리턴하는 메소드를 호출 //3번 + 2번

	}
}
