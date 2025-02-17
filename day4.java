import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketMap = Map.of(')', '(', '}', '{', ']', '[');

        for (char ch : s.toCharArray()) {
            if (bracketMap.containsValue(ch)) { // If it's an opening bracket
                stack.push(ch);
            } else if (bracketMap.containsKey(ch)) { // If it's a closing bracket
                if (stack.isEmpty() || stack.pop() != bracketMap.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // Stack should be empty if valid
    }
}
