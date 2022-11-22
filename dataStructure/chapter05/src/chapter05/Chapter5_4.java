package chapter05;

public class Chapter5_4 {

	//리스트로 큐 구현
	public static void main(String[] args) {
		LinkedListQueue queue = new LinkedListQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		System.out.println(String.format("첫 번째 값을 가져옵니다 => %s", queue.dequeue()));
		System.out.println(String.format("두 번째 값을 가져옵니다 => %s", queue.dequeue()));
		System.out.println(String.format("세 번째 값을 가져옵니다 => %s", queue.dequeue()));
		System.out.println("---");
		System.out.println(String.format("큐의 현재 값입니다 => %s",queue.peek()));
		System.out.println("---");
		System.out.println(String.format("네 번째 값을 가져옵니다 => %s", queue.dequeue()));
		System.out.println(String.format("다섯 번째 값을 가져옵니다 => %s", queue.dequeue()));

		if (queue.empty()) {
			System.out.println("---");
			System.out.println("큐가 비어있습니다.");
		}
	
	}

}

class LinkedListQueue {
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
}
