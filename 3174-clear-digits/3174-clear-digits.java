class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (!stack.isEmpty() && !Character.isDigit(stack.peek())) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString(); 
    }
}