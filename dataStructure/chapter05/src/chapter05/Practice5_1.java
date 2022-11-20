package chapter05;

public class Practice5_1 {
	
	//값포함 여부, 스택의 크기 반환 메서드 작성
	public static void main(String[] args) {

		ArrayStackP arrayStack = new ArrayStackP(3);
		arrayStack.push("1");
		arrayStack.push("2");
		arrayStack.push("3");


		System.out.println(arrayStack.contains("2"));
		System.out.println(arrayStack.size());
	}

}

class ArrayStackP {
	private Object[] stack;
	private int top;

	ArrayStackP(int length) {
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
	
	/**
	 * value 값 포함 여부
	 * @return
	 */
	public boolean contains(Object value) {
		if (top == -1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		for(int i = 0; i < stack.length; i++) {
			if(stack[i] == value) {
				return true;
			}
		}
		
		return false;

	}
	
	/**
	 * 스택 크기 반환
	 * @return
	 */
	public int size() {
		
		return stack.length;

	}
	
	/** 답
    public boolean contains(Object value) {
        boolean result = false;
        for (Object data : stack) {
            if (data instanceof String && data.equals(value)
                    || data == value) {
                result = true;
                break;
            }
        }
        return result;
    }

    public int size() {
        return stack.length;
    }
    **/
	
	

}
