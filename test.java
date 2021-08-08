import java.util.*;

public class test{

    public static void main(String args[]) {
        System.out.println("hello world");

        Solution ans = new Solution();

        int res = ans.minCharacters("dabadd", "cda");

        System.out.println(res);

    }
}class Solution {
    public int minCharacters(String a, String b) {
        char maxa = 'a';
        char maxb = 'a';
        
        HashMap<Character, Integer> mapa = new HashMap<>();
        HashMap<Character, Integer> mapb = new HashMap<>();
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        
        for (char c : a.toCharArray()) {
            mapa.put(c, mapa.getOrDefault(c, 0) + 1);
            ++map1[c - 'a'];
            maxa = maxa > c ? maxa : c;
        }
        
        for (char c : b.toCharArray()) {
            mapb.put(c, mapb.getOrDefault(c, 0) + 1);
            ++map2[c - 'a'];
            maxb = maxb > c ? maxb : c;
        }
        
        // condition 1
        
        int ans = 1000000;
        int t = 0;
        int start = (int)(maxb - 'a') - 1;
        for (int i = start; i >= 0; --i) {
            t += map1[i];
        }
        ans = Math.min(t, ans);
        
        
        t = 0; 
        start = (int)(maxa - 'a') - 1;
        for (int i = start; i >= 0; --i) {
            t += map2[i];
        }
        ans = Math.min(ans, t);
        
        // condition 3
        int[] total = new int[26];
        int maxf = 0;
        for (int i = 0; i < 26; ++i) {
            total[i] = map1[i] + map2[i];
            maxf = Math.max(maxf, total[i]);
        }
        
        int cur = a.length() + b.length() - maxf;
        ans = Math.min(ans, cur);
        return ans;
    }
}