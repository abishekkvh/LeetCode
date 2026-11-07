import java.util.HashMap;

public class validAnagram
{
    static boolean valid(String s, String t)
    {
        HashMap<Character, Integer> map = new HashMap<>();

        if(s.length() != t.length())
            return false;

        for(int i = 0; i < s.length(); i++)
        {
            int count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count + 1);
        }

        for(int i = 0; i < t.length(); i++)
        {
            int count = map.getOrDefault(t.charAt(i), 0);

            if(count == 0)
                return false;

            map.put(t.charAt(i), count - 1);
        }

        return true;
    }
    public static void main(String[] args) 
    {
        String s = "tea";
        String t = "eat";

        System.out.println(valid(s, t));
        
    }
}