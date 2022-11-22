package chapter05;

public class Chapter5_5 {

	//원형 큐
	public static void main(String[] args) {
		CircleArrayQueue queue = new CircleArrayQueue(5);
		queue.enqueue("사과");
		queue.enqueue("바나나");
		queue.enqueue("딸기");
		queue.enqueue("귤");
		queue.enqueue("배");

		System.out.println(String.format("첫 번째 값을 가져옵니다 => %s", queue.dequeue()));
		System.out.println(String.format("두 번째 값을 가져옵니다 => %s", queue.dequeue()));
		System.out.println(String.format("세 번째 값을 가져옵니다 => %s", queue.dequeue()));
		System.out.println(String.format("네 번째 값을 가져옵니다 => %s", queue.dequeue()));
		System.out.println(String.format("다섯 번째 값을 가져옵니다 => %s", queue.dequeue()));

//		System.out.println("");
//		System.out.println("--- 원형 큐이므로 가용 공간을 재사용할 수 있다.");
		queue.enqueue("체리");
		queue.enqueue("체리1");
		queue.enqueue("체리2");
		queue.enqueue("체리3");
		queue.enqueue("체리4");
		System.out.println(String.format("여섯 번째 값을 가져옵니다 => %s", queue.dequeue()));

		if (queue.empty()) {
			System.out.println("---");
			System.out.println("큐가 비어있습니다.");
		}
	

	}



}

class CircleArrayQueue {
	private Object arr[];
	private int MAX_QUEUE_SIZE;
	private int front = 0;
	private int rear = 0;

	CircleArrayQueue(int size) {
		this.MAX_QUEUE_SIZE = size + 1;
		this.arr = new Object[this.MAX_QUEUE_SIZE];
	}

	//삽입
	public void enqueue(Object v) {
		if ((rear + 1) % MAX_QUEUE_SIZE == front) { //삽입해야 하는 위치가 front와 같다면 꽉 찬 상태임
			throw new ArrayIndexOutOfBoundsException();
		}

		rear = (rear + 1) % MAX_QUEUE_SIZE; 
		arr[rear] = v;
	}

	public Object dequeue() {
		if (empty()) {
			throw new ArrayIndexOutOfBoundsException();
		}

		front = (front + 1) % MAX_QUEUE_SIZE;
		Object value = arr[front];
		arr[front] = null;

		return value;
	}

	public boolean empty() {
		return front == rear;
	}
}