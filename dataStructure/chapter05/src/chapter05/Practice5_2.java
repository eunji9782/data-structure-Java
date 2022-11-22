package chapter05;


public class Practice5_2 {

	//모든 요소 출력하는 메서드 작성
	public static void main(String[] args) {
		ArrayQueueP aq = new ArrayQueueP(5);
		aq.enqueue(1);
		aq.enqueue(2);
		aq.enqueue(3);
		aq.enqueue(4);
		aq.enqueue(5);
		
		
		LinkedListQueueP llq = new LinkedListQueueP();
		llq.enqueue(1000);
		llq.enqueue(2000);
		llq.enqueue(3000);
		
		aq.printAll();
		llq.printAll();
		
		System.out.println(aq.peek()); //첫번째 값 확인
		System.out.println(llq.peek());

	}

}
//배열
class ArrayQueueP {
	private Object[] arr;
	private int MAX_QUEUE_SIZE;
	private int front;
	private int rear;
	private int peek;

	ArrayQueueP(int size) {
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
	
	//printAll
	public void printAll() {
		while(front != MAX_QUEUE_SIZE) {
			System.out.println(peek());
			peek = ++front;
		}
		peek = 0;
	}
}

//리스트
class LinkedListQueueP {
	private Node front = null;
	private Node rear = null;
	private Node peek = null;

	private class Node {
		private Object value;
		private Node next;

		Node(Object value) {
			this.value = value;
		}

		private Object getValue() {
			return this.value;
		}
	}

	//삽입
	public void enqueue(Object value) {
		if (front == null) {
			front = new Node(value);
			peek = front;
			rear = front;
		} else {
			rear.next = new Node(value);
			rear = rear.next;
		}
	}

	//꺼내기
	public Object dequeue() {
		Object value = peek.getValue();
		Node temp = front;

		front = front.next;
		peek = front;
		temp = null;
		return value;
	}

	public Object peek() {
		return peek.getValue();
	}

	public boolean empty() {
		return peek == null;
	}
	
	//printAll
	public void printAll() {
		while(front != null) {
			System.out.println(front.getValue());
			front = front.next; //빼지 말고 값만 출력해야 함
		}
	}
}