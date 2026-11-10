class FindMinimumInRotatedSortedArrayII 
{
    public static int findMin(int[] nums) 
    {
        int low = 0, high = nums.length - 1;

        while(low < high)
        {
            int mid = (low + high) / 2;

            if(nums[mid] > nums[high])
            {
                low = mid + 1;
            }
            else if(nums[mid] < nums[high])
            {
                high = mid;
            }
            else
            {
                high--;
            }
        }
        
        return nums[low];
    }

    public static void main(String[] args) 
    {
        int[] nums = new int[]{2,2,2,0,1};
        System.out.println(findMin(nums));
    }
}