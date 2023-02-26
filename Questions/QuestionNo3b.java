//Define a function called matches(input, pattern) that takes two strings as input and returns a boolean value indicating whether input matches pattern according to certain rules.
//Initialize variables inputIndex, patternIndex, inputLength, and patternLength to 0, and set inputLength to the length of the input string and patternLength to the length of the pattern string.
//While inputIndex is less than inputLength and patternIndex is less than patternLength, do the following:
//Get the current character at index patternIndex in the pattern string and store it in a variable called currentChar.
//If currentChar is '@', then increment patternIndex. If patternIndex is equal to patternLength, return true since the '@' character is at the end of the pattern, so it matches the rest of the input.
//Get the next character at index patternIndex in the pattern string and store it in a variable called nextChar.
//Find the first occurrence of nextChar in the input string starting at index inputIndex. If there is no such occurrence, return false since the pattern cannot match the input.
//Set inputIndex to the index of the first occurrence of nextChar in the input string.
//Increment both inputIndex and patternIndex.
//If currentChar is '#' or the character at index inputIndex in the input string matches currentChar, then increment both inputIndex and patternIndex.
//Otherwise, return false since the current character in the pattern does not match the corresponding character in the input.
//If inputIndex is equal to inputLength and patternIndex is equal to patternLength, return true, since the input matches the pattern. Otherwise, return false.

public class QuestionNo3b {
    public static boolean matches(String input, String pattern) {
        int inputIndex = 0;
        int patternIndex = 0;
        int inputLength = input.length();
        int patternLength = pattern.length();
        while (inputIndex < inputLength && patternIndex < patternLength) {
            char currentChar = pattern.charAt(patternIndex);
            if (currentChar == '@') {
                patternIndex++;
                if (patternIndex == patternLength) {
                    return true; // The '@' character is at the end of the pattern, so it matches the rest of the input
                }
                char nextChar = pattern.charAt(patternIndex);
                while (inputIndex < inputLength && input.charAt(inputIndex) != nextChar) {
                    inputIndex++;
                }
                if (inputIndex == inputLength) {
                    return false; // Couldn't find the next character after '@' in the input
                }
            } else if (currentChar == '#') {
                inputIndex++;
                patternIndex++;
            } else if (input.charAt(inputIndex) == currentChar) {
                inputIndex++;
                patternIndex++;
            } else {
                return false; // The current character in the pattern does not match the corresponding character in the input
            }
        }
        return (inputIndex == inputLength && patternIndex == patternLength);
    }

    public static void main(String[] args) {
        String input = "tt";
        String pattern = "@";
        boolean isMatch = matches(input, pattern);
        System.out.println(isMatch);

        String input2 = "ta";
        String pattern2 = "t";
        boolean isMatch2 = matches(input2, pattern2);
        System.out.println(isMatch2);

        String input3 = "ta";
        String pattern3 = "t#";
        boolean isMatch3 = matches(input3, pattern3);
        System.out.println(isMatch3);
    }
}
