/*
Problem: Lemonade Change (LeetCode 860)
Category: Greedy
Difficulty: Easy

Description:
At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order given by bills).
Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
Note that you do not have any change in hand at first.
Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.

Approach:
Greedy Choice Property:
1. Maintain counts of available $5 and $10 bills ($20 bills cannot be given as change, so they don't need tracking).
2. For each incoming bill:
   - If bill == 5: Accept and increment five count.
   - If bill == 10: Requires a $5 bill in change. If five > 0, decrement five and increment ten; else return false.
   - If bill == 20: Requires $15 in change.
     - Greedy preference: Giving one $10 bill and one $5 bill is strictly optimal because $5 bills are more flexible (needed for both $10 and $20 bills).
     - If ten > 0 and five > 0: decrement ten and five.
     - Else if five >= 3: decrement five by 3.
     - Otherwise: return false (insufficient change).
3. If all customers receive change, return true.

Time Complexity: O(n) where n is the length of bills array
Space Complexity: O(1) constant auxiliary space for bill counters
*/

class LemonadeChange 
{
    public static boolean lemonadeChange(int[] bills) 
    {
        int five = 0;
        int ten = 0;

        for (int bill : bills) 
        {
            if (bill == 5) 
            {
                five++;
            } 
            else if (bill == 10) 
            {
                if (five == 0) 
                {
                    return false;
                }
                five--;
                ten++;
            } 
            else if (bill == 20) 
            {
                if (ten > 0 && five > 0) 
                {
                    ten--;
                    five--;
                } 
                else if (five >= 3) 
                {
                    five -= 3;
                } 
                else 
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) 
    {
        int[] bills1 = {5, 5, 5, 10, 20};
        System.out.println("Output 1: " + lemonadeChange(bills1)); // Expected: true

        int[] bills2 = {5, 5, 10, 10, 20};
        System.out.println("Output 2: " + lemonadeChange(bills2)); // Expected: false
    }
}
