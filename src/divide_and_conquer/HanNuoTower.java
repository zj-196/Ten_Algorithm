package dac;

public class HanNuoTower {

	static long number = 0;
	
	public static void main(String[] args) {
		hanNuoTower(6, 'A', 'B', 'C');
		System.out.println("总共移动"+number+"次");
	}
	
	private static void hanNuoTower(int num,char a,char b,char c) {
		number++;
		if(num==1) {
			System.out.println("第1个盘从"+a+"->"+c);
		}else {
			hanNuoTower(num-1, a, c, b);
			System.out.println("第"+num+"个盘从"+a+"->"+c);
			hanNuoTower(num-1, b, a, c);
		}
	}

}
