package soma.first;

import java.util.Queue;
import java.util.LinkedList;

public class SM_Queue {

    public static void main(String[] args) {
        Queue queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
