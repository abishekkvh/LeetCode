/*
Problem: Sort List (LeetCode 148)
Category: Merge Sort / Linked List
Difficulty: Medium
*/

#include <iostream>
using namespace std;

// Definition for singly-linked list
struct ListNode {
    int val;
    ListNode* next;

    ListNode(int x) {
        val = x;
        next = nullptr;
    }
};

class Solution {
public:

    ListNode* merge(ListNode* l1, ListNode* l2) {
        ListNode dummy(0);
        ListNode* tail = &dummy;

        while (l1 && l2) {
            if (l1->val < l2->val) {
                tail->next = l1;
                l1 = l1->next;
            } else {
                tail->next = l2;
                l2 = l2->next;
            }
            tail = tail->next;
        }

        tail->next = l1 ? l1 : l2;

        return dummy.next;
    }

    ListNode* sortList(ListNode* head) {
        if (!head || !head->next)
            return head;

        // Find middle
        ListNode* slow = head;
        ListNode* fast = head->next;

        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }

        ListNode* mid = slow->next;
        slow->next = nullptr;

        ListNode* left = sortList(head);
        ListNode* right = sortList(mid);

        return merge(left, right);
    }
};

// Helper function to print list
void printList(ListNode* head) {
    while (head) {
        cout << head->val << " ";
        head = head->next;
    }
    cout << endl;
}

// Helper function to insert at end
ListNode* insert(ListNode* head, int val) {
    if (!head) return new ListNode(val);

    ListNode* temp = head;
    while (temp->next)
        temp = temp->next;

    temp->next = new ListNode(val);
    return head;
}

int main() {
    Solution sol;

    // Create linked list: 4 -> 2 -> 1 -> 3
    ListNode* head = nullptr;
    head = insert(head, 4);
    head = insert(head, 2);
    head = insert(head, 1);
    head = insert(head, 3);

    cout << "Original List: ";
    printList(head);

    head = sol.sortList(head);

    cout << "Sorted List: ";
    printList(head);

    return 0;
}