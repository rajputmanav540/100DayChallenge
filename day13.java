class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1"; // Base case
        
        String result = "1"; // Start with the first sequence
        
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;
            
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++; // Increase count if same character repeats
                } else {
                    next.append(count).append(result.charAt(j - 1)); // Append count and character
                    count = 1; // Reset count
                }
            }
            next.append(count).append(result.charAt(result.length() - 1)); // Append last group
            
            result = next.toString(); // Update result for the next iteration
        }
        
        return result;
    }
}
