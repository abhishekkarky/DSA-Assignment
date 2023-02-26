/*b)	You are given an array of different words and target words.
Each character of a word represents a different digit ranging from 0 to 9,
and no two character are linked to same digit. If the sum of the numbers represented by each word
on the array equals the sum the number represented by the targeted word, return true; otherwise,
return false. Note: Provided list of words and targeted word is in the form of equation
Input: words = ["SIX","SEVEN","SEVEN"], result = "TWENTY"
Output: true
Explanation:
 s=6
 I=5
X=0,
E=8,
V=7,
N=2,
T=1,
W=3,
Y=4
SIX +SEVEN + SEVEN = TWENTY
650 + 68782 + 68782 = 138214
*/


//The isSolvable method takes an array of strings words and a string result as input. It first creates a set of all unique characters in words and result, and initializes an array charCount to store the sum of each character's values across all words and the result.
//Then, it uses backtracking to assign a digit to each character in charSet such that the sum of the values of each word equals the value of the result. The backtracking function backtracking uses a used array to keep track of which digits have been used, and a nonLeadingZero array to ensure that no character is assigned a leading zero. It returns true if a solution is found and false otherwise.
//Finally, in the main method, an instance of the WordandTarget class is created, and isSolvable is called with a test input. The output of isSolvable is printed to the console.

import java.util.HashSet;
import java.util.Set;


class WordandTarget {
    private static final int[] POW_10 = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000};
    public boolean isSolvable(String[] words, String result) {
        Set<Character> charSet = new HashSet<>();
        int[] charCount = new int[91];
        boolean[] nonLeadingZero = new boolean[91]; // ASCII of A..Z chars are in range 65..90
        for (String word : words) {
            char[] cs = word.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (i == 0 && cs.length > 1) nonLeadingZero[cs[i]] = true;
                charSet.add(cs[i]);
                charCount[cs[i]] += POW_10[cs.length - i - 1]; // charCount is calculated by units
            }
        }
        char[] cs = result.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (i == 0 && cs.length > 1) nonLeadingZero[cs[i]] = true;
            charSet.add(cs[i]);
            charCount[cs[i]] -= POW_10[cs.length - i - 1]; // charCount is calculated by units
        }
        boolean[] used = new boolean[10];
        char[] charList = new char[charSet.size()];
        int i = 0;
        for (char c : charSet) charList[i++] = c;
        return backtracking(used, charList, nonLeadingZero, 0, 0, charCount);
    }

    private boolean backtracking(boolean[] used, char[] charList, boolean[] nonLeadingZero, int step, int diff, int[] charCount) {
        if (step == charList.length) return diff == 0; // difference between sum of words and result equal to 0
        for (int d = 0; d <= 9; d++) { // each character is decoded as one digit (0 - 9).
            char c = charList[step];
            if (!used[d] // each different characters must map to different digits
                    && (d > 0 || !nonLeadingZero[c])) {  // decoded as one number without leading zeros.
                used[d] = true;
                if (backtracking(used, charList, nonLeadingZero, step + 1, diff + charCount[c] * d, charCount)) return true;
                used[d] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordandTarget solutions = new WordandTarget();
        String[] words = {"SIX","SEVEN","SEVEN"};
        String result = "TWENTY";
        Boolean answer = solutions.isSolvable(words,result);
        System.out.println(answer);
    }
}