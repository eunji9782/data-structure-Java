package chapter04;

public class Chapter4_6 {
	
	//하노이 탑
	public static void main(String[] args) {
		int disks = 3; //원반 수
		topOfHanoi(disks, "A", "B", "C");
		
	}
	public static void topOfHanoi(int disks, String begin, String middle, String end) {
		if(disks == 1) {
			System.out.println(String.format("1번 원반을 %s 기둥으로 옮깁니다", end));
			return; //1번째 동작은 C(목표지점 end)로 옮김
		}
		
		topOfHanoi(disks - 1, begin, end, middle); 
		System.out.println(String.format("%s번 원반을 %s 기둥으로 옮깁니다", disks, end));
		//가장 작은 원반이 C로 가있으므로 다음 원반인 2번 원반은 B(목표지점 end)로 옮김
		topOfHanoi(disks - 1, middle, begin, end);
		//다시 1번 원반 동작 후 disk가 3이었던 시점으로 돌아감 >> 반복
		
	}

}
