public class LongestSubstringProblem {
    public int lengthOfLongestSubstring(String s) {
        // Array to track the last seen index of each character (ASCII has 256 characters)
        int[] lastSeen = new int[256];
        // Initialize all elements to -1, indicating no character has been seen yet
        for (int i = 0; i < 256; i++) {
            lastSeen[i] = -1;
        }

        int maxLength = 0;
        int start = 0; // Start of the sliding window

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character has been seen and is within the current window
            if (lastSeen[currentChar] >= start) {
                // Move start to the next position after the last occurrence of currentChar
                start = lastSeen[currentChar] + 1;
            }

            // Update the last seen index of the current character
            lastSeen[currentChar] = end;

            // Calculate the current window length and update maxLength if it's larger
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringProblem solution = new LongestSubstringProblem();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // Output: 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // Output: 3
    }
}
