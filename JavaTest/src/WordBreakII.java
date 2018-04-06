import java.util.*;
public class WordBreakII {
    public void dfs(ArrayList<String> result, StringBuilder curResult, String s, int end, boolean[][] flag) {

        if (end < 0) {
            result.add(new String(curResult));
            return;
        }
        for (int i = end; i >= 0; i--) {
            String next = s.substring(i, end+1);
            if (flag[i][end] != true) continue;
            StringBuilder sb = new StringBuilder(curResult);
            if (sb.length() > 0)
                sb.insert(0," ");
            sb.insert(0, next);
            dfs(result, sb, s, i-1, flag);
        }
    }
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> resultArrayList = new ArrayList<>();
        boolean flag[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (dict.contains(s.substring(i, j + 1))) {
                    flag[i][j] = true;
                } else {
                    flag[i][j] = false;
                }
            }
        }
        // dfs
        dfs(resultArrayList, new StringBuilder(), s, s.length()-1, flag);
        return resultArrayList;
    }
    public static void main(String args[]) {
        WordBreakII main = new WordBreakII();
        Set<String> dict = new HashSet<>();
        dict.add("a");
        main.wordBreak("a", dict);
    }
}