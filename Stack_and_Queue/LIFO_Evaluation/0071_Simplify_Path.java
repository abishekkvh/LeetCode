import java.util.*;

/*
Problem: Simplify Path (LeetCode 71)
Category: Stack
Difficulty: Medium

Description:
Given an absolute path for a Unix-style file system, which begins with a slash '/', 
transform this path into its simplified canonical path.

In a Unix-style file system:
- A period '.' refers to the current directory.
- A double period '..' refers to the directory up a level.
- Any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
- Any sequence of periods that does not match the rules above is treated as a valid directory/file name.

The simplified canonical path must:
- Start with a single slash '/'.
- Have directories separated by a single slash '/'.
- Not end with a trailing '/'.
- Only contain the directories on the path from the root directory to the target (i.e., no '.' or '..').

Approach:
1. Split the input path by "/".
2. Use a Stack to store the directory names.
3. Iterate through the split parts:
   - If the part is "..", pop the top directory from the stack (if not empty).
   - If the part is "." or empty, skip it.
   - Otherwise, push the directory name onto the stack.
4. Construct the simplified path by joining the directory names in the stack with a leading "/".
5. If the stack is empty, return "/".

Time Complexity: O(n) where n is the length of the path.
Space Complexity: O(n) for storing the directory names in the stack.
*/

import java.util.*;

class SimplifyPath {
    public String simplifyPath(String path) {
        String paths[] = path.split("/");

        Stack<String> stack = new Stack<>();

        for (String ch : paths) {
            if (ch.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (ch.equals(".") || ch.equals("")) {
                continue;
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        if (result.length() == 0)
            return "/";

        return result.toString();
    }

    public static void main(String[] args) {
        SimplifyPath solver = new SimplifyPath();

        System.out.println("Running LeetCode 71: Simplify Path");
        System.out.println("===================================");

        // Test Case 1
        String path1 = "/home/";
        System.out.println("Test Case 1:");
        System.out.println("Path:     " + path1);
        System.out.println("Expected: /home");
        System.out.println("Actual:   " + solver.simplifyPath(path1));
        System.out.println();

        // Test Case 2
        String path2 = "/home//foo/";
        System.out.println("Test Case 2:");
        System.out.println("Path:     " + path2);
        System.out.println("Expected: /home/foo");
        System.out.println("Actual:   " + solver.simplifyPath(path2));
        System.out.println();

        // Test Case 3
        String path3 = "/home/user/Documents/../Pictures";
        System.out.println("Test Case 3:");
        System.out.println("Path:     " + path3);
        System.out.println("Expected: /home/user/Pictures");
        System.out.println("Actual:   " + solver.simplifyPath(path3));
        System.out.println();

        // Test Case 4
        String path4 = "/../";
        System.out.println("Test Case 4:");
        System.out.println("Path:     " + path4);
        System.out.println("Expected: /");
        System.out.println("Actual:   " + solver.simplifyPath(path4));
        System.out.println();

        // Test Case 5
        String path5 = "/.../a/../b/c/../d/./";
        System.out.println("Test Case 5:");
        System.out.println("Path:     " + path5);
        System.out.println("Expected: /.../b/d");
        System.out.println("Actual:   " + solver.simplifyPath(path5));
        System.out.println();
    }
}