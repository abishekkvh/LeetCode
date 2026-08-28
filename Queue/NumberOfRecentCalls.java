package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfRecentCalls
{

    static class RecentCounter
    {

        private final Queue<Integer> requests;

        public RecentCounter()
        {
            requests = new ArrayDeque<>();
        }

        public int ping(int t)
        {

            // Add current request time
            requests.offer(t);

            // Remove requests outside [t - 3000, t]
            while (!requests.isEmpty() && requests.peek() < t - 3000)
            {

                requests.poll();
            }

            return requests.size();
        }
    }

    public static void main(String[] args)
    {

        RecentCounter recentCounter = new RecentCounter();

        System.out.println(recentCounter.ping(1)); // 1
        System.out.println(recentCounter.ping(100)); // 2
        System.out.println(recentCounter.ping(3001)); // 3
        System.out.println(recentCounter.ping(3002)); // 3
    }
}