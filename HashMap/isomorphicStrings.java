import java.util.*;


public class isomorphicStrings 
{

    static boolean isomorphic(String s, String t)
    {
        if(s.length() != t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> used = new HashSet<>();

        for(int i = 0; i < s.length(); i++)
        {
            char s_char = s.charAt(i);
            char t_char = t.charAt(i);

            if(!map.containsKey(s_char))
            {
                if(!used.contains(t_char))
                {
                    map.put(s_char, t_char);
                    used.add(t_char);
                }
                else
                {
                    return false;
                }
            }
            else if(map.get(s_char) != t_char)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) 
    {
        String s = "egg";
        String t = "add";

        IO.println(isomorphic(s, t));
    }
    
}
