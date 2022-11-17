package chapter04;

public class Chapter4_1 {

	public static void main(String[] args) {
		System.out.println("결과 : "+ sum(100));
	}
	
	private static int sum(int num) {
		int result = 0;
		for(int i = 1; i <= num; i++) {
			result += i;
		}
		
		return result;
	}

}
