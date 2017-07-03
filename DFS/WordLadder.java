import java.util.*;

public class WordLadder {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
        List<List<String>> result = new ArrayList<>();
        if (start.equals(end)) {
            ArrayList<String> transformation = new ArrayList<>();
            transformation.add(start);
            transformation.add(end);
            result.add(transformation);
        }
        if (dict == null || dict.size() == 0) {
            return result;
        }
        dict.add(start);
        dict.add(end);
        Map<String, List<String>> preWords = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        List<String> path = new ArrayList<>();
        
        bfsUtil(start, result, preWords, distance, dict);
        dfsUtil(end, start, path, preWords, distance, result);
        return result;
    }
    
    private void bfsUtil(String start, List<List<String>> result, 
                            Map<String, List<String>> preWords, Map<String, Integer> distance, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        for (String word : dict) {
            preWords.put(word, new ArrayList<String>());
        }
        
        while (!queue.isEmpty()) {
            String head = queue.poll();
            //System.out.println("In the while loop and the queue is not empty!");
            for (String next : expand(head, dict)) {
                System.out.println("in bfs, Head is: " + head + " next is: " + next);
                preWords.get(next).add(head);
                if (!distance.containsKey(next)) {
                    //System.out.println("next word is: " + next);
                    distance.put(next, distance.get(head) + 1);
                    queue.offer(next);
                    //System.out.println("Pushing onto queue: " + next);
                }
            }
        }
        // for (String word : distance.keySet()) {
        //     System.out.println("word in distance's keyset: " + word);

        // }
    }
    
    private void dfsUtil(String curr, String start, List<String> path, 
                        Map<String, List<String>> preWords, 
                        Map<String, Integer> distance, 
                        List<List<String>> result) {
        path.add(curr);
        if (curr.equals(start)) {
            //System.out.println("curr is: " + curr);

            Collections.reverse(path);
            result.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String pre : preWords.get(curr)) {
                System.out.println("in dfs and pre in prewords of " + curr + " is " + pre);
                if (distance.containsKey(pre) && distance.get(pre) + 1 == distance.get(curr)) {
                    dfsUtil(pre, start, path, preWords, distance, result);
                }
            }
        }
        path.remove(path.size() - 1);
    }
    
    private List<String> expand(String head, Set<String> dict) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < head.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char[] chars = head.toCharArray();
                //System.out.println("c is: " + c + " chars[i] is " + chars[i]); 
                if (c != chars[i]) {
                    //System.out.println("The chars are different!");
                    chars[i] = c;  
                    String newWord = new String(chars);
                    if (dict.contains(newWord)) {
                        result.add(newWord);
                        //System.out.println("expandsion is: " + newWord);
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        WordLadder ladder  = new WordLadder();
        String A = "hit";
        String B = "cog";
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        List<List<String>> result = ladder.findLadders(A, B, dict);
        for (List<String> list : result) {
            for (String word : list) {
            System.out.println(word);
            }
        }
    }
}