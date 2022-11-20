package chapter05;

public class Chapter5_2 {
	
	public static void main(String[] args) {
	
		//연결 리스트로 stack 구현
		LinkedListStack stack = new LinkedListStack();
		stack.push("1");
		stack.push("2");
		stack.push("3");

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.empty());
	}

}

class LinkedListStack {
	private Node head;
	private Node top;

	private class Node {
		private Object data;
		private Node next;

		Node(Object data) {
			this.data = data;
		}
	}

	//삽입
	public void push(Object data) {
		if (head == null) {
			head = new Node(data);
			top = head;
			return;
		}

		Node node = new Node(data);
		top.next = node;
		top = node;
	}

	public Object pop() {
		if (top == null) {
			throw new ArrayIndexOutOfBoundsException();
		}

		Node temp = head;
		Object data = this.peek();
		if (temp.next == null) {
			head = null;
			top = null;
			return data;
		}

		while (temp.next != null) {
			top = temp;
			temp = temp.next;
		}

		top.next = null;
		return data;
	}

	public Object peek() {
		return top.data;
	}

	public boolean empty() {
		return top == null;
	}
}