/*
Problem: Rotate List (LeetCode 61)
Category: Two Pointers / Linked List
Difficulty: Medium

Approach:
1. Find the length of the list and keep a reference to the tail node.
2. Connect the tail to the head, making the list circular.
3. Calculate the actual rotation offset: k = k % length.
4. If k is 0, we don't need to rotate; break the circular link and return head.
5. Otherwise, find the new tail node at position (length - k) from head.
6. The new head will be the node next to the new tail.
7. Break the circular link by setting newTail.next = null.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Find the length of the list and the tail node
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // 2. Adjust k
        k = k % len;
        if (k == 0) {
            return head;
        }

        // 3. Make it a circular list temporarily
        tail.next = head;

        // 4. Find the new tail: (len - k) steps from head
        int stepsToNewTail = len - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // 5. Break the circle and set new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Helper to print list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Rotate_List solver = new Rotate_List();

        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        System.out.println("Running LeetCode 61: Rotate List");
        System.out.print("Original list: ");
        printList(head);
        System.out.println("Rotate right by: " + k);

        ListNode result = solver.rotateRight(head, k);
        System.out.print("Rotated list:  ");
        printList(result);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
