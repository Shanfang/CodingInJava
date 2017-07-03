import java.util.*;
public class RemoveStr {

public int minLength(String s, Set<String> dict) {
        // Write your code here
        Queue<String> que = new LinkedList<String>();
        Set<String> hash = new HashSet<String>();
    
        int min = s.length();
        que.offer(s);
        hash.add(s);

        while (!que.isEmpty()) {
            s = que.poll();
            for (String sub : dict) {
            	System.out.println("substring from dict is: " + sub);
                int found = s.indexOf(sub);
                while (found != -1) {
                    String new_s = s.substring(0, found) +
                        s.substring(found + sub.length(), s.length());
                    System.out.println("new substring is: " + new_s);
                    if (!hash.contains(new_s)) {
                        if (new_s.length() < min)
                            min = new_s.length();
                        que.offer(new_s);
                        hash.add(new_s);
                    }
                    found = s.indexOf(sub, found + 1);
                }
            }
            System.out.println("Hashset contains: ");
            for (String str : hash) {
            	System.out.println(str);
            }
             System.out.println("queue contains: ");
            for (String str : que) {
            	System.out.println(str);
            }           
        }
        return min;
    }

	public static void main(String[] args) {
		RemoveStr remove = new RemoveStr();
		String s = "ccdaabcdbb";
		Set<String> dict = new HashSet<>();
		dict.add("ab");
		dict.add("cd");

		remove.minLength(s, dict);
	}
}