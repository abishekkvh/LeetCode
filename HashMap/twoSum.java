import java.util.HashMap;

int[] twoSum(int numbers[], int sum)
{
    HashMap<Integer, Integer> result = new HashMap<>();

    for(int i = 0; i < numbers.length; i++)
    {
        int remaining = sum - numbers[i];
        if(result.containsKey(remaining))
        {
            return new int[]{result.get(remaining), i};   
        }
        result.put(numbers[i], i);
    }

    return new int[]{-1, -1};
}

void main()
{
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int numbers[] = new int[n];
    int sum = sc.nextInt();

    int result[] = twoSum(numbers, sum);
    IO.println("Final Answer : " + result[0] + ", " + result[1]);

    sc.close();
}