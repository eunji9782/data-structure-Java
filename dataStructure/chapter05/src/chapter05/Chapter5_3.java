package chapter05;

public class Chapter5_3 {

	public static void main(String[] args) {
		
		//큐는 FIFO
		ArrayQueue arrayQueue = new ArrayQueue(5);
		arrayQueue.enqueue(1000);
		arrayQueue.enqueue(2000);
		arrayQueue.enqueue(5000);
		arrayQueue.enqueue(5001);
		arrayQueue.enqueue(5002);

		System.out.println(arrayQueue.isFull());
		System.out.println(arrayQueue.dequeue());
		System.out.println(arrayQueue.dequeue());
//		System.out.println(arrayQueue.dequeue());

	}

}

class ArrayQueue {
	private Object[] arr;
	private int MAX_QUEUE_SIZE;
	private int front;
	private int rear;
	private int peek;

	ArrayQueue(int size) {
		this.arr = new Object[size];
		this.MAX_QUEUE_SIZE = size;
		this.front = 0; //큐 첫번째 위치
		this.rear = -1; //큐 마지막 위치
		this.peek = this.front;
	}

	//삽입
	public void enqueue(Object value) {
		if (MAX_QUEUE_SIZE - 1 == rear) {
			throw new StackOverflowError();
		}
		arr[++rear] = value;
	}

	//꺼내기
	public Object dequeue() {
		if (front == MAX_QUEUE_SIZE) {
			throw new ArrayIndexOutOfBoundsException();
		}

		Object value = arr[peek];
		arr[peek] = null;
		peek = ++front; //맨앞에 있는 값을 꺼내면 빈 값에 그 다음 값을 넣도록 함

		return value;
	}

	//front가 바라보는 데이터 가져오기
	public Object peek() {
		return arr[peek];
	}

	public boolean isFull() {
		return MAX_QUEUE_SIZE - 1 == rear;
	}
}