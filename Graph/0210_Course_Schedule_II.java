/*
Problem: Course Schedule II (LeetCode 210)
Category: Graph / Topological Sort
Difficulty: Medium

Approach:
Kahn's Algorithm (BFS Topological Sort):
1. Build an adjacency list representation of directed dependencies (prerequisite -> course) and calculate in-degrees for all courses.
2. Initialize a queue with all courses having in-degree 0 (no prerequisites required).
3. Process courses in BFS order: dequeue a course, record it in the topological order list, and decrement in-degrees of dependent neighbors.
4. When a neighbor's in-degree drops to 0, enqueue it.
5. If the number of processed courses equals numCourses, return the topological order array; otherwise, return an empty array (cycle detected).

Time Complexity: O(V + E) where V = numCourses and E = prerequisites.length
Space Complexity: O(V + E) for adjacency list, in-degree array, queue, and result array
*/

import java.util.*;

class CourseScheduleII 
{
    public static int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> order = new ArrayList<>();
        int[] result = new int[numCourses];

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

        while (!queue.isEmpty()) 
        {
            int current = queue.poll();
            order.add(current);

            for (int neighbor : adjList.get(current)) 
            {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) 
                {
                    queue.offer(neighbor);
                }
            }
        }

        if (order.size() != numCourses) 
        {
            return new int[0];
        }

        for (int i = 0; i < numCourses; i++) 
        {
            result[i] = order.get(i);
        }

        return result;
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

        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }
}
