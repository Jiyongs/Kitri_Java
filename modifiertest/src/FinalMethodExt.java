// *error 예제

public class FinalMethodExt extends FinalMethod {

	@Override
	public void a() {  //final method는 override 불가능.
		x = 30;
	}

}
