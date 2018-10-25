public class solution {
    //"This is a String"   =>  "sihT si a gnirtS"
    public static String reverseSentence(String s) {
        StringBuilder sb = new StringBuilder();
        String[] sa = s.split(" ");
        //["This", "is", "a", "String"]
        for(int i = 0; i < sa.length; i++) {
            StringBuilder temp = new StringBuilder(sa[i]);
            sb.append(temp.reverse()).append(" ");
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        String testExample = "This is a String";
        System.out.println(reverseSentence(testExample));
    }
/*
    String reverseEachWord(String w) {
        int len = w.length();
        char[] c = w.toCharArray();
        int s = 0, e = len - 1;
        while(s < e) {
            char temp = c[s];
            c[s] = c[e];
            c[e] = temp;
        }
        return new String(c);
    } 
    */
}


//email address