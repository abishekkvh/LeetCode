# LeetCode Solutions — Java & C++

> A structured collection of Data Structures and Algorithms solutions organized
> by core computational patterns, focusing on optimal asymptotic complexity and
> clean code.

---

## Overview

This repository organizes LeetCode problems by fundamental algorithmic paradigms
rather than difficulty or completion date. Each solution emphasizes optimal time
and space complexity, clear invariants, and clean implementation practices.

---

## Pattern Taxonomy

| Category                | Sub-Patterns                                       | Core Techniques                             | Key Invariants / Approaches                                              |
| :---------------------- | :------------------------------------------------- | :------------------------------------------ | :----------------------------------------------------------------------- |
| **Arrays & Hashing**    | Frequency Tables, Bijective Maps, Matrices         | Inverted indexing, frequency arrays         | Constant-time lookups, direct-address tables                             |
| **Two Pointers**        | Opposite Direction, Same Direction, Sliding Window | Boundary convergence, fast & slow pointers  | In-place partitioning, dynamic window contraction                        |
| **Binary Search**       | 1D Arrays, 2D Matrices, Domain Bisection           | Monotonic predicate bisection               | Logarithmic search over sorted/inflected domains                         |
| **Stack & Queue**       | Monotonic Stack, LIFO Evaluation, Structure Adapters | Nearest greater element, expression parsing | Monotonic ordering maintenance, FIFO/LIFO emulation, bounded structures |
| **Dynamic Programming** | 1D Linear, State Machines, 2D Combinatorial        | Tabulation, memoization, state transitions  | Optimal substructure, rolling variable compaction                        |
| **Backtracking**        | Combinations, Permutations, N-Queens, Constraint Satisfaction (Sudoku) | Branch-and-bound recursion                  | In-place swap, state pruning, diagonal conflict checks, constraint propagation |
| **Graph**               | Grid Traversal, Topological Sort, Connectivity     | BFS, DFS, Kahn's Algorithm                  | Connected components, in-degree dependency ordering, DAG cycle detection |
| **Bit Manipulation**    | Bitwise Arithmetic, Bitmasking                     | Bitwise XOR, AND, shift operations          | Carry propagation, in-place binary state transitions                     |
| **Greedy**              | Change-Making, Interval Scheduling, Subsequence     | Local optimal choice, greedy exchange       | Greedy choice property, optimal substructure, resource reservation       |

---

## Repository Structure

```
.
|-- Arrays_and_Hashing/
|   |-- Matrix/
|-- Two_Pointers/
|   |-- Opposite_Direction/
|   |-- Same_Direction/
|   `-- Sliding_Window/
|-- Binary_Search/
|   |-- 1D_Arrays/
|   |-- 2D_Matrices/
|   `-- Domain_Search/
|-- Stack_and_Queue/
|   |-- Monotonic_Stack/
|   |-- LIFO_Evaluation/
|   `-- Queue_Adapters/
|-- Dynamic_Programming/
|   |-- 1D_Linear/
|   |-- State_Machines/
|   `-- 2D_Combinatorial/
|-- Backtracking/
|-- Graph/
|-- Bit_Manipulation/
`-- Greedy/
```

All solutions follow the standard numerical prefix convention:
`[LeetCode_ID]_[Problem_Name].[java|cpp]`.

---

## Build & Execution

### Java

```bash
# Compile and run any Java solution
javac path/to/Solution.java
java -cp path/to ClassName
```

### C++

```bash
# Compile with C++17 and optimization
g++ -std=c++17 -O3 path/to/solution.cpp -o solution
./solution
```
