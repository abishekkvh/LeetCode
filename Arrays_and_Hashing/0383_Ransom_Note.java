import java.util.HashMap;

class ransomNote
{
    static boolean find(String ransom, String magazine)
    {
        if(ransom.length() > magazine.length())
        {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++)
        {
            char c = magazine.charAt(i);
            int count = map.getOrDefault(c, 0);

            map.put(c, count + 1);
        }

        for(int i = 0; i < ransom.length(); i++)
        {
            char c = ransom.charAt(i);
            int count = map.getOrDefault(c, 0);

            if(count == 0)
                return false;

            map.put(c, count - 1);
        }

        return true;

    }
    public static void main(String[] args) 
    {
        String magazine = "aab";
        String ransom = "a";

        IO.println(find(ransom, magazine));
    }
}