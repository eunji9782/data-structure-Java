package chapter04;

public class Chapter4_4 {

	//피보나치 수열
	public static void main(String[] args) {
		System.out.println("5 결과 : ");
		
		int num = 5;
		
		for(int i = 0; i < num; i++) {
			System.out.print(fibonacci(i) + " ");
		}
	}
	
	private static int fibonacci(int n) {
		if(n <= 1) {
			return n; //0이나 1이면 그대로 돌려줌
		}
		return fibonacci(n-1) + fibonacci(n-2);
		
	}
}
