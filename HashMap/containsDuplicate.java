boolean containsDuplicate(int numbers[])
{
    HashMap<Integer, Integer> map = new HashMap<>();

    for(int i = 0; i < numbers.length; i++)
    {
        if(map.containsKey(numbers[i]))
        {
            return true;
        }

        map.put(numbers[i], map.getOrDefault(numbers[i], 0)+1);
    }
    return false;
}

void main()
{
    int numbers[] = {1,2,3,1};
    int nums[] = {1,2,3,4};

    IO.println(containsDuplicate(numbers));
    IO.println(containsDuplicate(nums));
}