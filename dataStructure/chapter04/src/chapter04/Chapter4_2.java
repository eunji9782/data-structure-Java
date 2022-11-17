package chapter04;

public class Chapter4_2 {
	public static void main(String[] args) {
		System.out.println("결과 : "+ sum(100));
	}

	private static int sum(int range) {
		if(range == 1) {
			return range; //기저 조건
		}
		return range + sum(range -1);
		//메모리나 자원 소모가 크지만 이후에 트리 이해에 도움
	}

}
