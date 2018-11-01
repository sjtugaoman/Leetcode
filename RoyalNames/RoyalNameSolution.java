import java.util.*;

public class RoyalNameSolution {
    static Map<Character, Integer> map = new HashMap<>();
    
    public RoyalNameSolution() {
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
    }

    static class myComp implements Comparator<String> {

            @Override
            public int compare(String s1, String s2) {
                    String[] o1 = s1.split("\\s");
                    String[] o2 = s2.split("\\s");
                    String name1 = o1[0], name2 = o2[0];
                    int num1 = convert(o1[1]), num2 = convert(o2[1]);
                    return name1.equals(name2) ? num1 - num2 : name1.compareTo(name2);
            }
            
    }
    
    private static int convert(String roman) {
            if (roman == null || roman.length() == 0) return 0;
            int n = roman.length();
            int prev = map.get(roman.charAt(n - 1));
            int res = prev;
            for (int i = n - 2; i >= 0; i--) {
                    int curr = map.get(roman.charAt(i));
                    if (prev > curr) res -= curr;
                    else res += curr;
                    prev = curr;
            }
            return res;
    } 
    
    public static String[] rayalName(String[] strs) {
            Arrays.sort(strs, new myComp());
            return strs;  
    }
    public static void main(String[] args) {
            String[] names = {"Albert II",
                                              "Polo IV",
                                              "Alexander V",
                                              "Elizabeth XXV", 
                                              "Albert XL",
                                              "Polo XLVI",
                                              "William IX",
                                              "Edward XXXIX",
                                              "Elizabeth XIX"};
            RoyalNameSolution solution = new RoyalNameSolution();
            String[] res = solution.rayalName(names);
            for (String s : res) System.out.println(s);
    }

}