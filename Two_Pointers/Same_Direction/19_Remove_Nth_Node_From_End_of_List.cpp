/*
Problem: Remove Nth Node From End of List (LeetCode 19)
Category: Linked List / Two Pointers
Difficulty: Medium

Frequently Asked In: Amazon, Microsoft, Google, Meta

Approach:
1. Use dummy node to handle edge cases.
2. Move fast pointer n steps ahead.
3. Move both pointers until fast reaches end.
4. Delete the target node.

Time Complexity: O(n)
Space Complexity: O(1)
*/

struct ListNode 
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution 
{
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) 
    {


        ListNode* dummy = new ListNode(0);
        dummy->next = head;

        ListNode* fast = dummy;
        ListNode* slow = dummy;

        // Move fast n steps ahead
        for (int i = 0; i < n; i++) 
        {
            fast = fast->next;
        }

        // Move both until fast reaches last node
        while (fast->next != nullptr) 
        {
            fast = fast->next;
            slow = slow->next;
        }

        // Delete target node
        ListNode* toDelete = slow->next;
        slow->next = slow->next->next;

        delete toDelete;

        return dummy->next;
    }
};