class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        java.util.Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i]) && !seen.contains(words[i])) {
                    result.add(words[i]);
                    seen.add(words[i]);  
                    break; 
                }
            }
        }
        return result;
    }
}