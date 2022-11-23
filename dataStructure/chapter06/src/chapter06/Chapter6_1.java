package chapter06;

public class Chapter6_1 {

	//이진 트리
	public static void main(String[] args) {

		//맨위에 루트 노드 생성
		BinaryTree bt = new BinaryTree();
		Node root = new Node(5);
		bt.setRoot(root);
		
		//노드를 하나씩 다 만든다
		Node node10 = new Node(10);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node9 = new Node(9);
		Node node2 = new Node(2);
		Node node1 = new Node(1);
		
		
		//루트와 연결
		root.setLeftChild(node10);
		root.setRightChild(node12);
		node10.setLeftChild(node13);
		
		node12.setLeftChild(node9);
		node12.setRightChild(node2);
		node13.setLeftChild(node1);
		
		//모두 출력하기
		bt.bfs(root);
		
	}

}

class BinaryTree{
	private Node root;

	public Node getRoot() {
		return this.root;
	}

	public void setRoot(Node node) {
		this.root = node;
	}
	
	//너비 우선 탐색
	public void bfs(Node root) {
		LinkedListQueue queue = new LinkedListQueue();
		queue.enqueue(root);
		
		while(!queue.empty()) {
			Node node = (Node)queue.dequeue();
			System.out.println(node.getValue() + " ");
			
			if(node.getLeftChild() != null) {
				queue.enqueue(node.getLeftChild());
			}
			
			if(node.getRightChild() != null) {
				queue.enqueue(node.getRightChild());
			}
		}
	}
}

//선형 구조에서 가져온 애
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


