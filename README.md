# LeetCode Solutions — Java & C++

> A structured collection of Data Structures and Algorithms solutions organized by core computational patterns, focusing on optimal asymptotic complexity and clean code.

---

## Overview

This repository organizes LeetCode problems by fundamental algorithmic paradigms rather than difficulty or completion date. Each solution emphasizes optimal time and space complexity, clear invariants, and clean implementation practices.

---

## Pattern Taxonomy

| Category | Sub-Patterns | Core Techniques | Key Invariants / Approaches |
| :--- | :--- | :--- | :--- |
| **Arrays & Hashing** | Frequency Tables, Bijective Maps, Matrices | Inverted indexing, frequency arrays | Constant-time lookups, direct-address tables |
| **Two Pointers** | Opposite Direction, Same Direction, Sliding Window | Boundary convergence, fast & slow pointers | In-place partitioning, dynamic window contraction |
| **Binary Search** | 1D Arrays, 2D Matrices, Domain Bisection | Monotonic predicate bisection | Logarithmic search over sorted/inflected domains |
| **Stack & Queue** | Monotonic Stack, LIFO Evaluation, Queue Adapters | Nearest greater element, expression parsing | Monotonic ordering maintenance, FIFO/LIFO emulation |
| **Dynamic Programming** | 1D Linear, State Machines, 2D Combinatorial | Tabulation, memoization, state transitions | Optimal substructure, rolling variable compaction |
| **Backtracking** | Permutations, Constraint Satisfaction (Sudoku) | Branch-and-bound recursion | In-place swap, state pruning, constraint propagation |
| **Graph** | Grid Traversal, Connectivity | Breadth-First Search (BFS), Depth-First Search (DFS) | Connected components, wavefront expansion |

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
`-- Graph/
```

All solutions follow the standard numerical prefix convention: `[LeetCode_ID]_[Problem_Name].[java|cpp]`.

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
