import java.util.*;

public class intersectionOfTwoArrays 
{
    static int[] intersection(int[] nums1, int[] nums2) 
    {
        List<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums1.length; i++)
        {
            if(!map.containsKey(nums1[i]))
            {
                map.put(nums1[i], 1);
            }
        }

        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]))
            {
                arr.add(nums2[i]);
                map.remove(nums2[i]);
            }
        }
        
        int result[] = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++)
        {
            result[i] = arr.get(i);
        }

        return result;
    }

    public static void main(String[] args) 
    {
        int nums1[] = {1,2,2,3};
        int nums2[] = {1,2,5,5};
        int result[] = intersection(nums1, nums2);

        IO.print("Intersected Array : ["); 
        for (int i = 0; i < result.length; i++) 
        {
            if(i == result.length - 1)
            {
                IO.print(result[i]); 
            }
            else
            {
                IO.print(result[i] + " "); 
            }
        }   
        IO.println("]");
    }
}