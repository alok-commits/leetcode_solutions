class Solution {
    public String clearDigits(String s) {
        StringBuilder result = new StringBuilder();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else {
                deque.addLast(ch);
            }
        }
        
        for (char ch : deque) {
            result.append(ch);
        }
        
        return result.toString();
    }
}