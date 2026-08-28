package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueues
{

    static class MyStack
    {

        private Queue<Integer> q1 = new ArrayDeque<>();
        private Queue<Integer> q2 = new ArrayDeque<>();

        public void push(int x)
        {
            q2.offer(x);

            while (!q1.isEmpty())
            {
                q2.offer(q1.poll());
            }

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop()
        {
            return q1.poll();
        }

        public int top()
        {
            return q1.peek();
        }

        public boolean empty()
        {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args)
    {

        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);

        System.out.println(stack.top()); // 2
        System.out.println(stack.pop()); // 2
        System.out.println(stack.empty()); // false
    }
}