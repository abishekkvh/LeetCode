import java.util.*;

class differenceOfTwoArrays 
{
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        Set<Integer> set2 = new HashSet<>();

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
                map.put(nums2[i], 0);
            }
            else
            {
                set2.add(nums2[i]);
            }
        }

        List<Integer> list2 = new ArrayList<>(set2);

        for(int i = 0; i < nums1.length; i++)
        {
            if(map.get(nums1[i]) == 1)
            {
                map.put(nums1[i], 0);
                list1.add(nums1[i]);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(list1);
        result.add(list2);

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};

        differenceOfTwoArrays obj = new differenceOfTwoArrays();

        System.out.println(obj.findDifference(nums1, nums2));
    }
}