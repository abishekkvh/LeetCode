class FindMinimumInSortedArray 
{
    public static int findMin(int[] nums) 
    {
        int low = 0, high = nums.length - 1;
        int mid = -1;

        while(low < high)
        {
            mid = (low + high) / 2;

            if(nums[mid] > nums[high])
            {
                low = mid + 1;
            }
            else
            {
                high = mid;
            }
        }

        return nums[low];
    }

    public static void main(String[] args) 
    {
        int[] nums = new int[]{3,4,5,1,2};
        findMin(nums);
    }
}