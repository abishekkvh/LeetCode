
import java.util.HashMap;

public class majorityElement 
{
    static int MajorityElement(int numbers[])
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int requirement = numbers.length / 2;

        for(int num : numbers)
        {
            int count = map.getOrDefault(num, 0);

            map.put(num, count + 1);
            count++;

            if(count >= requirement)
            {
                return num;
            }
        }

        return -1;

    }
    public static void main(String[] args) 
    {
        int numbers[] = {2,3,3,3,2,2,2,2,2};
        int MAJORITY_ELEMENT =  MajorityElement(numbers);

        IO.println("Majority ELement : " + MAJORITY_ELEMENT);
    }
}
