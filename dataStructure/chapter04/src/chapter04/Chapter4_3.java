package chapter04;

public class Chapter4_3 {

	//팩토리얼
	public static void main(String[] args) {
		System.out.println("5! : "+factorial(5));

	}
	
	private static int factorial(int num) {
		if(num <= 1) {
			return 1;
		}
		return num * factorial(--num);
	}

}
