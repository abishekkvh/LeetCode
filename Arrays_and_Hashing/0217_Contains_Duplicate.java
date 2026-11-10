import java.util.HashMap;

class ContainsDuplicate {
    public static boolean containsDuplicate(int numbers[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(numbers[i])) {
                return true;
            }
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int numbers[] = {1, 2, 3, 1};
        int nums[] = {1, 2, 3, 4};

        System.out.println(containsDuplicate(numbers));
        System.out.println(containsDuplicate(nums));
    }
}
