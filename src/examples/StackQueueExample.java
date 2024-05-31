package examples;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class StackQueueExample {
    public static void sqe(String[] args) {
        // Stack example
        Stack<Integer> stack = new Stack<>();
        stack.push(1);  // Pushes 1 onto the stack
        stack.push(2);  // Pushes 2 onto the stack
        System.out.println(stack.pop());  // Removes and prints 2 (LIFO)

        // Queue example
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);  // Adds 1 to the queue
        queue.add(2);  // Adds 2 to the queue
        System.out.println(queue.remove());  // Removes and prints 1 (FIFO)
    }
}
