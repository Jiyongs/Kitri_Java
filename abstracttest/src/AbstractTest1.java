import java.util.*;

public class AbstractTest1 {

public static void main(String[] args) {
	//1. ���� Ŭ���� ����
	//Calendar cal = new GregorianCalendar();

	//2. �ڽ��� ��ü�� return�ϴ� static method ȣ��
	Calendar cal = Calendar.getInstance();

	int y = cal.get(Calendar.YEAR);
	int m = cal.get(Calendar.MONTH) + 1;  //���� 0���� �����ϹǷ�, 1�� ���ؾ� ��!!
	String apm = "am";
	int pm = cal.get(Calendar.AM_PM);
	if(pm==1){
		apm = "pm";
	}
	int d = cal.get(Calendar.DATE);
	int h = cal.get(Calendar.HOUR_OF_DAY);
	int mi = cal.get(Calendar.MINUTE);
	int s = cal.get(Calendar.SECOND);

	System.out.println(y + "�� " + m + "�� " + d + "�� " + apm + " " + h + "�� " + mi + "�� " + s + "��");

}

}
