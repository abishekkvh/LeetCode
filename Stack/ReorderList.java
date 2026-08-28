import java.util.*;

/*
Problem: Reorder List (LeetCode 143)
Category: Stack / Linked List
Difficulty: Medium

Description:
You are given the head of a singly linked-list. The list can be represented as:
L0 -> L1 -> ... -> Ln-1 -> Ln

Reorder the list to be on the following form:
L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Approach:
1. Put all the list nodes into a Stack. Since a stack is LIFO, popping from it gives nodes from the end of the list.
2. Maintain a `left` pointer starting from the head.
3. In each step, pop a node `right` from the stack.
4. Stop when the pointers meet:
   - If `left == right`, we are at the center of an odd-length list. Set `left.next = null` and stop.
   - If `left.next == right`, we are at the center of an even-length list. Set `right.next = null` and stop.
5. Insert the `right` node between `left` and `left.next`.
6. Advance the `left` pointer to `nextLeft` (the original successor of `left`).

Time Complexity: O(n) where n is the number of nodes in the list.
Space Complexity: O(n) to store all nodes in the stack.
*/

import java.util.*;

class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        Stack<ListNode> st  ack = new Stack<>();
        ListNode temp = head;

        // Put all nodes into stack
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        ListNode left = head;

        while (left != null) {
            ListNode right = stack.pop();

            // Stop when both pointers meet
            if (left == right) {
                left.next = null;
                break;
            }
            if (left.next == right) {
                right.next = null;
                break;
            }

            ListNode nextLeft = left.next;

            left.next = right;
            right.next = nextLeft;

            left = nextLeft;
        }
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReorderList solver = new ReorderList();

        System.out.println("Running LeetCode 143: Reorder List");
        System.out.println("===================================");

        // Test Case 1: [1, 2, 3, 4]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        System.out.println("Test Case 1 (Even Length):");
        System.out.print("Original list: ");
        printList(head1);
        solver.reorderList(head1);
        System.out.print("Reordered list: ");
        printList(head1);
        System.out.println();

        // Test Case 2: [1, 2, 3, 4, 5]
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        System.out.println("Test Case 2 (Odd Length):");
        System.out.print("Original list: ");
        printList(head2);
        solver.reorderList(head2);
        System.out.print("Reordered list: ");
        printList(head2);
        System.out.println();
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}