import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class AlienOrder {
    public static String alienOrderSolution(String[] words) {
       //Very typical graph and topological sort
       //corner case
       if(words == null || words.length == 0) return "";

       HashMap<Character, HashSet<Character>> map = new HashMap<>();
       int count = 0;
       int[] indegree = new int[26];
       StringBuilder result = new StringBuilder();

       //find out the quantity of different letters in words
       for(String word: words) {
           for(char c: word.toCharArray()) {
               if(indegree[c - 'a'] == 0) {
                   count++;
                   indegree[c - 'a'] = 1;
               }
           }
       }

       //Draw the graph
       for(int i = 0; i < words.length - 1; i++) {
           char[] curr = words[i].toCharArray();
           char[] next = words[i + 1].toCharArray();
           int length = Math.min(curr.length, next.length);
           for(int j = 0; j < length; j++) {
               if(curr[j] != next[j]) {
                   if(!map.containsKey(curr[j])) {
                       map.put(curr[j], new HashSet<>());
                   }
                   if(map.get(curr[j]).add(next[j])) {
                       indegree[next[j] - 'a']++; 
                   }
                   break;
               }
           }
       }

       //BFS
       Queue<Character> queue = new LinkedList<>();
       for(int i = 0; i < 26; i++) {
           if(indegree[i] == 1) {
               queue.offer((char) ('a' + i));
           }
       }
       while(!queue.isEmpty()) {
           char cur = queue.poll();
           result.append(cur);
           if(map.containsKey(cur)) {
               for(char after: map.get(cur)) {
                   if(--indegree[after - 'a'] == 1) {
                       queue.offer(after);
                   }
               }
           }
       }
       return result.length() == count ? result.toString() : "";
    }

    public static void main(String[] args) {
        String[] words = {
            "z",
            "x",
            "z"
        };
          
        System.out.println(alienOrderSolution(words));
    }
}