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
public class Gugudan {
	public static void main(String[] args) {
		System.out.println("*** 备备窜1 ***");
		for(int i = 1; i<10; i++){
			for(int dan = 2; dan<10; dan++){
				System.out.print(dan + " * " + i + " = " + dan*i + "  ");
			}
		System.out.println();
		}

		System.out.println("*** 备备窜2 ***");
		for(int dan = 2; dan<10; dan++){
			for(int i = 1; i<10; i++){
				System.out.print(dan + " * " + i + " = " + dan*i + "  ");
			}
			System.out.println();
	}
}
}
