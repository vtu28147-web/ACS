import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        int n = names.length;
        
        // Create pairs of height and name
        Integer[] index = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        
        // Sort indices based on heights in descending order
        Arrays.sort(index, (a, b) -> heights[b] - heights[a]);
        
        // Store names in sorted order
        String[] result = new String[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = names[index[i]];
        }
        
        return result;
    }
}