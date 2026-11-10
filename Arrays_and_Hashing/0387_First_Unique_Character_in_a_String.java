import java.util.*;

class firstUniqueCharacterInAString 
{
    static int findUnique(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, -1);

            if(count == -1)
            {
                map.put(c, i);
            }
            else
            {
                map.put(c, -2);
            }
        }

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int count = map.get(c);

            if(count == i)
                return i;
        }

        return -1;

    }
    public static void main(String[] args) 
    {
        String s = "leetCode";
        IO.println(findUnique(s));
        
    }
    
}
