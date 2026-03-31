package soma.first;

import java.util.Stack;

public class SM_Stack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i=1; i<=5; i++){
            stack.push(i);
            System.out.println(stack.peek());
        }

        stack.pop(); // 5 출력
        System.out.println("Pop()");
        System.out.println(stack.peek()); // 4
        System.out.println(stack.search(3)); // 요소가 top에서부터 몇번쨰에 존재하는지 순서 반환
        System.out.println(stack.empty()); // false
    }
}
