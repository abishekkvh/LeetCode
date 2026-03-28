/*
Problem: Middle of the Linked List (LeetCode 876)
Category: Linked List / Two Pointers
Difficulty: Easy

Frequently Asked In: Amazon, Microsoft, Google, Meta

Approach:
1. Use slow and fast pointers.
2. Slow moves 1 step, fast moves 2 steps.
3. When fast reaches end, slow is at middle.

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
    ListNode* middleNode(ListNode* head) 
    {

        ListNode* slow = head;
        ListNode* fast = head;

        while (fast != nullptr && fast->next != nullptr) 
        {
            slow = slow->next;
            fast = fast->next->next;
        }

        return slow;
    }
};