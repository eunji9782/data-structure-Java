package chapter05;

public class Practice5_4 {

	public static void main(String[] args) {
		//print 메서드에서 while > for문으로 바꾸기
			LinkedListDequeP deque = new LinkedListDequeP();

			deque.addFirst("100");
			deque.addLast("200");
			deque.addFirst("300");
			deque.addLast("400");
			deque.addFirst("500");
			deque.addLast("600");
			deque.addFirst("700");
			System.out.println(String.format("삽입 후: %s", deque.print()));

			deque.removeFirst();
			deque.removeLast();
			System.out.println(String.format("삭제 후: %s", deque.print()));

		}

	}

	class LinkedListDequeP {
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
			Object value = front.getValue();
			front = front.next;

			return value;
		}

		public Object removeLast() {
			Object value = rear.getValue();

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

			for(; temp.next != null; temp = temp.next) {
				Object value = temp.getValue();

					datas += String.format("%s->", value);
				
			}
			datas += String.format("%s", temp.getValue()); //마지막꺼 화살표는 안나오게

			return datas;
		}
	}