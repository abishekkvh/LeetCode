/*
Problem: Course Schedule (LeetCode 207)
Category: Graph / Topological Sort
Difficulty: Medium

Approach:
Kahn's Algorithm (BFS Topological Sort):
1. Build an adjacency list representation of directed dependencies (prerequisite -> course) and track the in-degree of every course.
2. Initialize a queue with all courses having an in-degree of 0 (no prerequisites required).
3. Process nodes from the queue, incrementing a processed count and decrementing the in-degree of dependent courses.
4. If a course's in-degree drops to 0, push it to the queue.
5. If the count of processed courses equals numCourses, all courses can be completed (valid DAG with no cycle) -> return true; otherwise, return false.

Time Complexity: O(V + E) where V = numCourses and E = prerequisites.length
Space Complexity: O(V + E) for adjacency list, in-degree array, and BFS queue
*/

import java.util.*;

class CourseSchedule 
{
    public static boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) 
        {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) 
        {
            adjList.get(edge[1]).add(edge[0]);
        }

        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) 
        {
            inDegree[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) 
        {
            if (inDegree[i] == 0) 
            {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) 
        {
            int current = queue.poll();
            count++;

            for (int neighbor : adjList.get(current)) 
            {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) 
                {
                    queue.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) 
    {
        int numCourses = 4;

        int[][] prerequisites = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        System.out.println(canFinish(numCourses, prerequisites));
    }
}
