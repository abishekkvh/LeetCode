/*
Problem: Sum of Two Integers (LeetCode 371)
Category: Bit Manipulation
Difficulty: Medium

Approach:
Bitwise Addition without '+' or '-':
1. XOR (`a ^ b`) calculates sum of bits without considering carry (half-adder logic).
2. AND followed by left shift (`(a & b) << 1`) calculates the carry bits.
3. Repeat the process by updating `a = a ^ b` and `b = carry` until there is no carry left (`b == 0`).
4. In Java, 32-bit signed two's complement integer arithmetic naturally handles negative numbers and overflow.

Time Complexity: O(1) - at most 32 iterations (number of bits in an integer)
Space Complexity: O(1) - constant auxiliary space
*/

class SumOfTwoIntegers 
{
    public static int getSum(int a, int b) 
    {
        while (b != 0) 
        {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }

    public static void main(String[] args) 
    {
        int a = 3;
        int b = 2;

        System.out.println(getSum(a, b));
    }
}
