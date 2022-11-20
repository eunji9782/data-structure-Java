package chapter05;

public class Chapter5_1 {

	public static void main(String[] args) {

		ArrayStack arrayStack = new ArrayStack(3);
		arrayStack.push("1");
		arrayStack.push("2");
		arrayStack.push("3");
//		arrayStack.push("3");
//		arrayStack.push("3");
//		arrayStack.push("3");
//		arrayStack.push("3");

		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.empty());
	}

}

class ArrayStack {
	private Object[] stack;
	private int top;

	ArrayStack(int length) {
		// 빈 스택은 top = -1로 표현
		this.top = -1;
		this.stack = new Object[length];
	}

	/**
	 * 데이터 삽입
	 * @param data
	 */
	public void push(Object data) {
		if (stack.length - 1 == top) {
			throw new StackOverflowError();
		}

		stack[++top] = data;
	}

	/**
	 * 데이터 가져오기
	 * @return
	 */
	public Object pop() {
		if (top == -1) {
			throw new ArrayIndexOutOfBoundsException();
		}

		Object temp = stack[top]; //맨위에 있는 데이터 저장
		stack[top--] = null; //후위 연산자이므로 위에거를 null, 이후 top을 하나 줄임
		return temp;
	}

	/**
	 * 현재 스택의 마지막 데이터를 가져온다.
	 * @return
	 */
	public Object peek() {
		return stack[top];
	}

	/**
	 * 스택이 비었는지 확인
	 * @return
	 */
	public boolean empty() {
		return top == -1;
	}
}