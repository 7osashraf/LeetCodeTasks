public class LongestPlaindromicSubstring{
    public String longestPalindrome(String s) {
        int start = 0, end = 0;

        for(int i = 0; i < s.length(); i++){
            // Expand around a single character (odd-length palindrome)
            int len1 = expandAroundCenter(s, i, i);

            // Expand around two characters (even-length palindrome)
            int len2 = expandAroundCenter(s, i, i + 1);

            // Find the maximum of the two lengths
            int len = Math.max(len1, len2);

            // Update the start and end indices if a longer palindrome is found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }

        return s.substring(start, end + 1);
        
    }

    private int expandAroundCenter(String s, int left, int right) {
        // Expand while the characters at left and right are the same
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPlaindromicSubstring solution = new LongestPlaindromicSubstring();
        
        // Example test cases
        System.out.println(solution.longestPalindrome("babad"));  // Output: "bab" or "aba"
        System.out.println(solution.longestPalindrome("cbbd"));   // Output: "bb"
    }

    


}