package chapter05;

public class Practice5_5 {

	public static void main(String[] args) {

		//remove 메서드에서 데이터가 존재하지 않을 때 예외처리
		LinkedListDequeP2 deque = new LinkedListDequeP2();

//		deque.addFirst("100");
//		deque.addLast("200");
//		deque.addFirst("300");
//		deque.addLast("400");
//		deque.addFirst("500");
//		deque.addLast("600");
//		deque.addFirst("700");
//		System.out.println(String.format("삽입 후: %s", deque.print()));

		deque.removeFirst();
		deque.removeLast();
		System.out.println(String.format("삭제 후: %s", deque.print()));

	}

}

class LinkedListDequeP2 {
	private class Node {
		Object data = null;
		Node next = null;

		Node(Object data) {
			this.data = data;
		}

		private Object getValue() {
			return data;
		}
	}

	private Node front = null;
	private Node rear = null;

	public void addFirst(Object data) {
		Node node = new Node(data);
		if (front == null) {
			front = node;
			rear = front;
			return;
		}

		Node temp = front;
		front = node;
		front.next = temp; //원래 첫번째값은 다음으로 밀고 새로운 값이 첫번째가 됨
	}

	public void addLast(Object data) {
		Node node = new Node(data);
		if (front == null) {
			front = node;
			rear = front;
			return;
		}

		rear.next = node; //원래 마지막값은 이전으로 밀고 새로운 값이 마지막이 됨
		rear = rear.next;
	}

	public Object removeFirst() {
		
//		if (front == null) {
//            System.out.println("[ERROR] 앞 요소가 존재하지 않습니다. (size 0)");
//            return null;
//        }
		
		
		
		Object value = null;
		try {
			value = front.getValue();
			front = front.next;
			
		} catch (NullPointerException e) {
			System.out.println("값이 비어있습니다.");
		}
		return value;

	}

	public Object removeLast() {
		
//		if (rear == null) {
//      System.out.println("[ERROR] 뒤 요소가 존재하지 않습니다. (size 0)");
//      return null;
//  }
		Object value = null;
		
		try {
			value = rear.getValue();
			
		} catch (NullPointerException e) {
			System.out.println("값이 비어있습니다.");
		}

		Node temp = front;
		while (temp != null) {
			if (temp.next != rear) {
				temp = temp.next;
				continue;
			}

			rear = temp;
			rear.next = null;
		}
		return value;
	}

	public String print() {
		String datas = "";
		Node temp = front;

		while (temp != null) {
			Object value = temp.getValue();

			temp = temp.next;
			if (temp == null) {
				datas += value;
			} else {
				datas += String.format("%s->", value);
			}
		}

		return datas;
	}
}