/*
Problem: Find Eventual Safe States (LeetCode 802)
Category: Graph / Topological Sort
Difficulty: Medium

Approach:
Reverse Graph + Topological Sort (Kahn's Algorithm):
1. A node is eventually safe if every possible path starting from it leads to a terminal node (out-degree 0).
2. Reverse all directed edges: if u -> v in the original graph, create v -> u in the reversed graph.
3. Compute the initial out-degree of each node in the original graph.
4. Terminal nodes (out-degree == 0) are inherently safe. Initialize a BFS queue with all terminal nodes.
5. While the queue is not empty, dequeue node `curr`, mark it as safe, and iterate through its predecessors in the reversed graph:
   - Decrement outDegree[predecessor].
   - If outDegree[predecessor] == 0, all outgoing paths from it lead only to safe nodes; enqueue it.
6. Collect and return all nodes marked as safe in ascending order (0 to n - 1).

Time Complexity: O(V + E) where V = graph.length and E = total directed edges
Space Complexity: O(V + E) for reversed adjacency list, out-degree tracking, BFS queue, and safe boolean array
*/

import java.util.*;

class EventualSafeStates 
{
    public static List<Integer> eventualSafeNodes(int[][] graph) 
    {
        int n = graph.length;
        List<List<Integer>> reversedGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) 
        {
            reversedGraph.add(new ArrayList<>());
        }

        int[] outDegree = new int[n];

        for (int i = 0; i < n; i++) 
        {
            outDegree[i] = graph[i].length;
            for (int neighbor : graph[i]) 
            {
                reversedGraph.get(neighbor).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) 
        {
            if (outDegree[i] == 0) 
            {
                queue.offer(i);
            }
        }

        boolean[] isSafe = new boolean[n];

        while (!queue.isEmpty()) 
        {
            int current = queue.poll();
            isSafe[current] = true;

            for (int predecessor : reversedGraph.get(current)) 
            {
                outDegree[predecessor]--;

                if (outDegree[predecessor] == 0) 
                {
                    queue.offer(predecessor);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) 
        {
            if (isSafe[i]) 
            {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) 
    {
        int[][] graph = {
            {1, 2},
            {2, 3},
            {5},
            {0},
            {5},
            {},
            {}
        };

        List<Integer> result = eventualSafeNodes(graph);
        System.out.println("Eventual Safe Nodes: " + result);
    }
}
