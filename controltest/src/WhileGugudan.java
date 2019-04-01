/*
备备窜 1
2*1 = 2   ...   9*1 = 9
2*2 = 4   ...   9*2 = 18
...                ...

备备窜 2
2*1 = 2   2*2 = 4   ...
...
9*1 = 9   9*2 = 18 ...
*/

public class WhileGugudan {
	public static void main(String[] args) {
		System.out.println("*** 备备窜1 ***");
		int i = 1;
		int dan = 2;
		while(i!=10){
			while(dan!=10){
				System.out.print(dan + " * " + i + " = " + dan*i + "    ");
				dan++;
			}
			i++;
			dan = 2;
			System.out.println();
		}

		System.out.println("\n*** 备备窜2 ***");
		dan = 2;
		while(dan!=10){
			i = 1;
			while(i!=10){
				System.out.print(dan + " * " + i + " = " + dan*i + "    ");
				i++;
			}
			dan++;
			System.out.println();
		}
	}
}
