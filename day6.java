import java.util.Arrays;

class Solution {
    public int countWords(String[] words1, String[] words2) {
        Arrays.sort(words1);
        Arrays.sort(words2);
        
        int i = 0, j = 0, count = 0;
        
        while (i < words1.length && j < words2.length) {
            // Skip duplicates in words1
            if (i > 0 && words1[i].equals(words1[i - 1])) {
                i++;
                continue;
            }
            
            // Skip duplicates in words2
            if (j > 0 && words2[j].equals(words2[j - 1])) {
                j++;
                continue;
            }
            
            if (words1[i].equals(words2[j])) {
                // Check if word appears exactly once in both
                boolean uniqueInWords1 = (i == words1.length - 1 || !words1[i].equals(words1[i + 1])) &&
                                         (i == 0 || !words1[i].equals(words1[i - 1]));
                boolean uniqueInWords2 = (j == words2.length - 1 || !words2[j].equals(words2[j + 1])) &&
                                         (j == 0 || !words2[j].equals(words2[j - 1]));

                if (uniqueInWords1 && uniqueInWords2) {
                    count++;
                }
                i++;
                j++;
            } else if (words1[i].compareTo(words2[j]) < 0) {
                i++;
            } else {
                j++;
            }
        }
        
        return count;
    }
}
