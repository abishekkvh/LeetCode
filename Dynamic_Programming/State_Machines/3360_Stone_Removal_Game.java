/*
Problem: Stone Removal Game (LeetCode 3360)
Category: Dynamic Programming / State Machines (Game Theory Simulation)
Difficulty: Easy

Description:
Alice and Bob take turns playing a game, with Alice going first.
There are n stones on a table.
- On Alice's first turn, she must remove 10 stones.
- On each subsequent turn, the player must remove 1 fewer stone than the previous turn.
- The first player who cannot make their move loses the game.
Return true if Alice wins the game, and false otherwise.

Approach:
State Transition Simulation (Alternating Game Invariant):
1. Alice starts with a requirement to remove 10 stones.
2. In each round, if remaining stones n >= current requirement:
   - Deduct the requirement from n.
   - Decrement the required stones for the next player.
   - Toggle the active player turn between Alice and Bob.
3. The moment n < requirement, the current player cannot make their move and loses.
4. If it is Bob's turn when the loop terminates, Alice wins (return true); otherwise, Bob wins (return false).

Time Complexity: O(1) - bounded by at most 10 state transitions (10 down to 1)
Space Complexity: O(1) - constant auxiliary space
*/

class StoneRemovalGame 
{
    public static boolean canAliceWin(int n) 
    {
        int remove = 10;
        boolean aliceTurn = true;

        while (n >= remove) 
        {
            n -= remove;
            remove--;
            aliceTurn = !aliceTurn;
        }

        return !aliceTurn;
    }

    public static void main(String[] args) 
    {
        int n1 = 12;
        System.out.println("Output 1 (n = 12): " + canAliceWin(n1)); // Expected: true

        int n2 = 1;
        System.out.println("Output 2 (n = 1):  " + canAliceWin(n2)); // Expected: false

        int n3 = 19;
        System.out.println("Output 3 (n = 19): " + canAliceWin(n3)); // Expected: false
    }
}
