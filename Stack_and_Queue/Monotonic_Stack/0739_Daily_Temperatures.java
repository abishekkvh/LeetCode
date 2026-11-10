import java.util.*;

class DailyTemperatue {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() &&
                    temperatures[i] > temperatures[stack.peek()]) {
                int previousIndex = stack.pop();

                result[previousIndex] = i - previousIndex;
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        DailyTemperatue s = new DailyTemperatue();
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = s.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));

        int[] temperatures1 = { 30, 40, 50, 60 };
        int[] result1 = s.dailyTemperatures(temperatures1);
        System.out.println(Arrays.toString(result1));
    }
}