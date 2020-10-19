package Medium;/*
*
* Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Learnings:
Char is unsigned type in java. UTF-8 chars are in range of 0-2^8 .. UTF-16 would be using 2 bytes, 16 bits
*/

public class LongestSubString {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int[] reverseIndex = new int[256];
        for (int i=0;i<reverseIndex.length;i++) {
            reverseIndex[i] = -1;
        }

        char[] inputData = s.toCharArray();
        int maxLen = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (int i=0; i< s.length(); i++) {
            char curr = inputData[i];
            int lastOccurence = reverseIndex[curr];

            if (lastOccurence != -1 && lastOccurence >= startIndex) {
                int len = endIndex - startIndex + 1;
                if (len > maxLen) {
                    maxLen = len;
                }

                startIndex = lastOccurence+1;
            }

            reverseIndex[curr] = i;
            endIndex = i;
        }

        if ((endIndex - startIndex + 1) > maxLen) {
            maxLen = endIndex - startIndex + 1;
        }

        return  maxLen;
    }

}
