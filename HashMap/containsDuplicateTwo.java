import java.util.*;

public class containsDuplicateTwo 
{
    static List<Integer> containsDuplicate(int numbers[])
    {
        List<Integer> result = new ArrayList<>();

        int len = numbers.length / 3;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : numbers)
        {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        for(int num : map.keySet())
        {
            int count =  map.getOrDefault(num, 0);
            if(count > len)
            {
                result.add(num);
            }
        }

        return result;
    }
    public static void main(String[] args) 
    {
        int numbers[] = {2,3,4,5,3,2,2,3};
        List<Integer> answer = containsDuplicate(numbers);

        for(int num : answer)
        {
            IO.print(num + " ");
            IO.println();
        }
    }
    
}
