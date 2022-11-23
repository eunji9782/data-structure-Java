package chapter06;

public class Chapter6_2 {

	//완전 이진 트리
	public static void main(String[] args) {

		CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree();

        // 빈 노드는 -1로 대체합니다.
        int[] arr = new int[]{-1, 9, 7, 15, 4, 8, 11};
        completeBinaryTree.printAll(arr);
        
	}

}

class CompleteBinaryTree {
    public void printAll(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int leftNode = this.getLeftNode(arr, i);
            int rightNode = this.getRightNode(arr, i);

            if (leftNode > -1) {
                System.out.println(String.format("%d의 왼쪽 자식의 노드는 %d", arr[i], leftNode));
            }

            if (rightNode > -1) {
                System.out.println(String.format("%d의 오른쪽 자식의 노드는 %d", arr[i], rightNode));
            }
        }
    }

    private int getLeftNode(int[] arr, int index) {
        int findIndex = 2 * index;
        if (arr.length <= findIndex) {
            return -1;
        }

        return arr[findIndex];
    }

    private int getRightNode(int[] arr, int index) {
        int findIndex = (2 * index) + 1;
        if (arr.length <= findIndex) {
            return -1;
        }

        return arr[findIndex];
    }
}