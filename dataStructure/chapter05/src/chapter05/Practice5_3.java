package chapter05;

import java.util.Scanner;

public class Practice5_3 {
	//은행 창구표
	public static void main(String[] args) {
		
        LinkedListQueue queue = new LinkedListQueue();
        
		int count = 1; //표는 1번부터 시작
		int size = 0; //남은 인원
		boolean isStop = false;

        while (!isStop) {
            System.out.println("1.    대기표 발급받기");
            System.out.println("2.    입장하기");
            System.out.println("3.    총인원 확인하기");
            System.out.println("4.    종료하기");
            System.out.print("=>");

            int choose = new Scanner(System.in).nextInt();
            switch (choose) {
                case 1:
                    queue.enqueue(count);
                    System.out.println(String.format("대기 번호: %s번 발급되었습니다.\n", count));

                    count++;
                    size++;
                    break;
                case 2:
                    if (queue.empty()) {
                        System.out.println("대기 중인 고객이 없습니다.\n");
                        break;
                    }

                    int number = (int) queue.dequeue();
                    System.out.println(String.format("%s번 은행 창구로 이동해 주세요.\n", number));
                    size--;
                    break;
                case 3:
                    System.out.println(String.format("현재 인원은 %s명 입니다.\n", size));
                    break;
                case 4:
                    System.out.println("종료합니다.\n");
                    isStop = true;
                    break;
                default:
                        System.out.println("1.    대기표 발급");
                        System.out.println("2.    입장하기");
                        System.out.println("3.    총인원 확인");
                        System.out.print("=>");
            }
        }
    }
}