import java.util.HashMap;
import java.util.Scanner;

class TwoSum {
    public static int[] twoSum(int numbers[], int sum) {
        HashMap<Integer, Integer> result = new HashMap<>();

        for(int i = 0; i < numbers.length; i++) {
            int remaining = sum - numbers[i];
            if(result.containsKey(remaining)) {
                return new int[]{result.get(remaining), i};   
            }
            result.put(numbers[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int numbers[] = new int[n];
        for(int i = 0; i < n; i++) numbers[i] = sc.nextInt();
        int sum = sc.nextInt();

        int result[] = twoSum(numbers, sum);
        System.out.println("Final Answer : " + result[0] + ", " + result[1]);

        sc.close();
    }
}
