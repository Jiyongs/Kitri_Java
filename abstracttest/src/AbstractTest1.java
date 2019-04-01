import java.util.*;

public class AbstractTest1 {

public static void main(String[] args) {
	//1. 하위 클래스 참조
	//Calendar cal = new GregorianCalendar();

	//2. 자신의 객체를 return하는 static method 호출
	Calendar cal = Calendar.getInstance();

	int y = cal.get(Calendar.YEAR);
	int m = cal.get(Calendar.MONTH) + 1;  //월은 0부터 시작하므로, 1을 더해야 함!!
	String apm = "am";
	int pm = cal.get(Calendar.AM_PM);
	if(pm==1){
		apm = "pm";
	}
	int d = cal.get(Calendar.DATE);
	int h = cal.get(Calendar.HOUR_OF_DAY);
	int mi = cal.get(Calendar.MINUTE);
	int s = cal.get(Calendar.SECOND);

	System.out.println(y + "년 " + m + "월 " + d + "일 " + apm + " " + h + "시 " + mi + "분 " + s + "초");

}

}
