import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        int[] map1 = new int[26]; // pattern -> word
        int[] map2 = new int[26]; // word -> pattern

        Arrays.fill(map1, -1);
        Arrays.fill(map2, -1);

        for (int i = 0; i < pattern.length(); i++) {
            int p = pattern.charAt(i) - 'a';
            int w = word.charAt(i) - 'a';

            // Check pattern -> word mapping
            if (map1[p] == -1) {
                map1[p] = w;
            } else if (map1[p] != w) {
                return false;
            }

            // Check word -> pattern mapping
            if (map2[w] == -1) {
                map2[w] = p;
            } else if (map2[w] != p) {
                return false;
            }
        }

        return true;
    }
}